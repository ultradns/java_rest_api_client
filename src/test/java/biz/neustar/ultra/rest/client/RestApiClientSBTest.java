/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.client;

import biz.neustar.ultra.rest.client.exception.UltraClientException;
import biz.neustar.ultra.rest.constants.TaskStatusCode;
import biz.neustar.ultra.rest.constants.UltraRestErrorConstant;
import biz.neustar.ultra.rest.constants.UltraRestSharedConstant;
import biz.neustar.ultra.rest.dto.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class RestApiClientSBTest {

    private static final Logger LOG = LoggerFactory.getLogger(RestApiClientSBTest.class);
    private static final int MAX_PAGE_SIZE = 1000;

    private static final String USER_NAME = System.getProperty("rest.username");
    private static final String PASSWORD = System.getProperty("rest.password");
    private static final String URL = System.getProperty("rest.url");

    private static final RestApiClient REST_API_CLIENT = RestApiClient.buildRestApiClientWithUidPwd(USER_NAME, PASSWORD,
            URL, null);

//    private RRSet makeTestRrsetWithSBPool(String zoneName, String ownerName, List<String> rdata) {
//        RRSet rrSetWithSBPool = new RRSet(zoneName, ownerName, "A (1)", 300, rdata, null);
//        Map<String, Object> profile = Maps.newHashMap();
//        List<SBTCRDataInfo> rdataInfo = Lists.newArrayList();
//        SBTCRDataInfo sbRdataInfo = new SBTCRDataInfo();
//        sbRdataInfo.setFailOverDelay(25);
//        sbRdataInfo.setPriority(1);
//        sbRdataInfo.setRunProbes(true);
//        sbRdataInfo.setState(UltraRestSharedConstant.RecordState.NORMAL);
//        sbRdataInfo.setThreshold(1);
//        rdataInfo.add(sbRdataInfo);
//        profile.put("@context", UltraRestSharedConstant.ProfileType.SB_POOL.getContext());
//        profile.put("rdataInfo", rdataInfo);
//        biz.neustar.ultra.rest.dto.BackupRecord backupRecord = new biz.neustar.ultra.rest.dto.BackupRecord();
//        backupRecord.setRdata("failOverRdata");
//        backupRecord.setFailoverDelay(1);
//        List<biz.neustar.ultra.rest.dto.BackupRecord> backupRecords = Lists.newArrayList(backupRecord);
//        profile.put("backupRecords", backupRecords);
//        profile.put("maxActive", 3);
//        profile.put("maxServed", 2);
//        rrSetWithSBPool.setProfile(profile);
//
//        return rrSetWithSBPool;
//
//    }

    @Test
    public void testSB1() throws IOException {
        String zoneName = System.currentTimeMillis() + "foo.invalid.";

        AccountList accountList = REST_API_CLIENT.getAccountDetails();
        assertNotNull(accountList);
        String accountName = accountList.getAccounts().get(0).getAccountName();
        assertNotNull(accountName);
        LOG.debug("accountName = " + accountName);

        String result = REST_API_CLIENT.createPrimaryZone(accountName, zoneName);
        assertNotNull(result);
        LOG.debug("result = " + result);

        ZoneOutInfo zone = REST_API_CLIENT.getZoneMetadata(zoneName);
        assertNotNull(zone);
        LOG.debug("zone = " + zone);

        String ownerName = "foo";

        List<String> rdata = Lists.newArrayList();
        rdata.add("2.3.5.8");

        RRSet rrSetWithSBPool = new RRSet(zoneName, ownerName, "A (1)", 300, rdata, null);
        Map<String, Object> profile = Maps.newHashMap();
        List<SBTCRDataInfo> rdataInfo = Lists.newArrayList();
        SBTCRDataInfo sbRdataInfo = new SBTCRDataInfo();
        sbRdataInfo.setFailOverDelay(25);
        sbRdataInfo.setPriority(1);
        sbRdataInfo.setRunProbes(true);
        sbRdataInfo.setState(UltraRestSharedConstant.RecordState.NORMAL);
        sbRdataInfo.setThreshold(1);
        rdataInfo.add(sbRdataInfo);
        profile.put("@context", UltraRestSharedConstant.ProfileType.SB_POOL.getContext());
        profile.put("rdataInfo", rdataInfo);
        biz.neustar.ultra.rest.dto.BackupRecord backupRecord = new biz.neustar.ultra.rest.dto.BackupRecord();
        backupRecord.setRdata("3.5.8.13");
        backupRecord.setFailoverDelay(1);
        List<biz.neustar.ultra.rest.dto.BackupRecord> backupRecords = Lists.newArrayList(backupRecord);
        profile.put("backupRecords", backupRecords);
        profile.put("maxActive", 1);
        profile.put("maxServed", 1);
        rrSetWithSBPool.setProfile(profile);

        // create SB pool
        result = REST_API_CLIENT.createRRSet(zoneName, "A", "foo", rrSetWithSBPool);
        assertNotNull(result);
        LOG.debug("result = " + result);
        RRSetList rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        LOG.debug("rrsets = " + rrsets);
        assertNotNull(rrsets.getRrSets());
        assertNotNull(rrsets.getRrSets().get(0));
        assertNotNull(rrsets.getRrSets().get(0).getProfile());
        assertEquals(UltraRestSharedConstant.ProfileType.SB_POOL.getContext(),
                rrsets.getRrSets().get(0).getProfile().get("@context"));
        assertEquals("ROUND_ROBIN",
                rrsets.getRrSets().get(0).getProfile().get("order"));

        rrSetWithSBPool = rrsets.getRrSets().get(0);
        rrSetWithSBPool.getProfile().put("order", "FIXED");
        // update SB pool
        result = REST_API_CLIENT.updateRRSet(zoneName, "A", "foo", rrSetWithSBPool);
        assertNotNull(result);
        LOG.debug("result = " + result);
        rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        LOG.debug("rrsets = " + rrsets);
        assertNotNull(rrsets.getRrSets());
        assertNotNull(rrsets.getRrSets().get(0));
        assertNotNull(rrsets.getRrSets().get(0).getProfile());
        assertEquals("FIXED",
                rrsets.getRrSets().get(0).getProfile().get("order"));

        // TODO: provide full examples of probes etc CRUD
//        Map<String, Object> details = Maps.newHashMap();
//        List<TransactionInfo> transactions = Lists.newArrayList();
//        TransactionInfo transactionInfo = new TransactionInfo();
//        transactions.add(transactionInfo);
//        details.put("transactions", transactions);
//        // add a probe
//        result = REST_API_CLIENT.createProbe(zoneName, "foo", null,
//                UltraRestSharedConstant.ProbeType.HTTP, UltraRestSharedConstant.ProbeInterval.FIFTEEN_MINUTES,
//                Lists.newArrayList("NEW_YORK", "DALLAS"), 2, details);
//        assertNotNull(result);
//        LOG.debug("result = " + result);

        REST_API_CLIENT.deleteRRSet(zoneName, "A", "foo");
        LOG.debug("foo." + zoneName + " deleted");
        try {
            REST_API_CLIENT.getRRSetsByType(zoneName, "A", null, 0, MAX_PAGE_SIZE,
                    UltraRestSharedConstant.RRListSortType.OWNER, false);
            fail("Expecting an exception");
        } catch (UltraClientException e) {
            assertEquals(404, e.getStatus());
            assertFalse(e.getErrors().isEmpty());
            assertEquals(1, e.getErrors().size());
            assertEquals(UltraRestErrorConstant.DATA_NOT_FOUND.getErrorCode(), e.getErrors().get(0).getErrorCode());
            assertEquals(UltraRestErrorConstant.DATA_NOT_FOUND.getErrorMessage(), e.getErrors().get(0).getErrorMessage());
        }

        REST_API_CLIENT.deleteZone(zoneName);
    }

    @Test
    @Ignore
    public void testSB2() throws IOException {
        String zoneName = "geopoolmappingtm.com.";
        String ownerName = "_rest_of_world._a_1.ex12a";

        RRSetList rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", "owner:" + ownerName, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        LOG.debug("rrsets = " + rrsets);
        assertNotNull(rrsets.getRrSets());
        assertNotNull(rrsets.getRrSets().get(0));
        assertNotNull(rrsets.getRrSets().get(0).getProfile());
        assertEquals(UltraRestSharedConstant.ProfileType.SB_POOL.getContext(),
                rrsets.getRrSets().get(0).getProfile().get("@context"));

        RRSet rrSetWithSBPool = rrsets.getRrSets().get(0);
        rrSetWithSBPool.getProfile().put("order", "FIXED");
        // update SB pool
        String result = REST_API_CLIENT.updateRRSet(zoneName, "A", ownerName, rrSetWithSBPool);
        assertNotNull(result);
        LOG.debug("result = " + result);
        rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", "owner:" + ownerName, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        LOG.debug("rrsets = " + rrsets);
        assertNotNull(rrsets.getRrSets());
        assertNotNull(rrsets.getRrSets().get(0));
        assertNotNull(rrsets.getRrSets().get(0).getProfile());
        assertEquals("FIXED",
                rrsets.getRrSets().get(0).getProfile().get("order"));

        ProbeInfoList probes = REST_API_CLIENT.getProbes(zoneName, ownerName, null);
        assertNotNull(probes);
        ProbeInfo probe = probes.getProbes().get(0);
        probe.setInterval(UltraRestSharedConstant.ProbeInterval.FIFTEEN_MINUTES);
        result = REST_API_CLIENT.updateProbe(zoneName, ownerName, probe);
        assertNotNull(result);
        LOG.debug("result = " + result);
        probes = REST_API_CLIENT.getProbes(zoneName, ownerName, null);
        assertNotNull(probes);

//        SBTCNotificationList notifications = REST_API_CLIENT.getNotifications(zoneName, ownerName, null, "rajender.aindla@team.neustar");
//        assertNotNull(notifications);
//        SBTCNotification notification = notifications.getNotifications().get(0);
//        notification.setEmail("vitaliy.pavlyuk@team.neustar");
//        result = REST_API_CLIENT.updateNotification(zoneName, ownerName, "rajender.aindla@team.neustar", notification);
//        assertNotNull(result);
//        LOG.debug("result = " + result);
//        notifications = REST_API_CLIENT.getNotifications(zoneName, ownerName, null, null);
//        assertNotNull(notifications);

        REST_API_CLIENT.deleteNotification(zoneName, ownerName, "vitaliy.pavlyuk@team.neustar");
    }

}

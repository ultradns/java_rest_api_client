/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.client;

import biz.neustar.ultra.rest.client.exception.UltraClientException;
import biz.neustar.ultra.rest.constants.UltraRestErrorConstant;
import biz.neustar.ultra.rest.constants.UltraRestSharedConstant;
import biz.neustar.ultra.rest.dto.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RestApiClientSBTest {

    private static final Logger LOG = LoggerFactory.getLogger(RestApiClientSBTest.class);
    private static final int MAX_PAGE_SIZE = 1000;

    private static final String USER_NAME = System.getProperty("rest.username");
    private static final String PASSWORD = System.getProperty("rest.password");
    private static final String URL = System.getProperty("rest.url");

    private static final RestApiClient REST_API_CLIENT = RestApiClient.buildRestApiClientWithUidPwd(USER_NAME, PASSWORD,
            URL, null);

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
        result = REST_API_CLIENT.createRRSet(zoneName, rrSetWithSBPool);
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
        result = REST_API_CLIENT.updateRRSet(zoneName, rrSetWithSBPool);
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

        Map<String, Object> details = Maps.newHashMap();
        List<TransactionInfo> transactions = Lists.newArrayList();
        ProbeStatus connect = new ProbeStatus(10, 15, 20);
        ProbeStatus avgConnect = new ProbeStatus(40, 50, 60);
        ProbeStatus run = new ProbeStatus(70, 80, 90);
        ProbeStatus avgRun = new ProbeStatus(11, 22, 33);
        ProbeSearchString searchString = new ProbeSearchString("warning", "critical", "fail");
        HttpLimitInfo limits = new HttpLimitInfo(connect, avgConnect, run, avgRun, searchString);
        TransactionInfo transactionInfo = new TransactionInfo(UltraRestSharedConstant.ProbeHttpMethod.GET,
                "http://blah.com", "", limits, true);
        transactions.add(transactionInfo);
        details.put("transactions", transactions);
        // add a probe
        ProbeInfo probeInfo = new ProbeInfo(null, null,
                UltraRestSharedConstant.ProbeType.HTTP, UltraRestSharedConstant.ProbeInterval.FIFTEEN_MINUTES,
                Lists.newArrayList("NEW_YORK", "DALLAS"), 2, details);
        result = REST_API_CLIENT.createProbe(zoneName, "foo", probeInfo);
        assertNotNull(result);
        LOG.debug("result = " + result);

        ProbeInfoList probeInfoList = REST_API_CLIENT.getProbes(zoneName, "foo", null);
        assertNotNull(probeInfoList);
        assertEquals(1, probeInfoList.getProbes().size());
        ProbeInfo probe1 = probeInfoList.getProbes().get(0);
        assertEquals(UltraRestSharedConstant.ProbeInterval.FIFTEEN_MINUTES, probe1.getInterval());
        probe1.setInterval(UltraRestSharedConstant.ProbeInterval.ONE_MINUTE);
        result = REST_API_CLIENT.updateProbe(zoneName, "foo", probe1);
        assertNotNull(result);
        LOG.debug("result = " + result);
        probeInfoList = REST_API_CLIENT.getProbes(zoneName, "foo", null);
        assertNotNull(probeInfoList);
        assertEquals(1, probeInfoList.getProbes().size());
        probe1 = probeInfoList.getProbes().get(0);
        assertEquals(UltraRestSharedConstant.ProbeInterval.ONE_MINUTE, probe1.getInterval());
        REST_API_CLIENT.deleteProbe(zoneName, "foo", probe1.getId());
        try {
            REST_API_CLIENT.getProbes(zoneName, "foo", null);
            fail("Expected failure here");
        } catch (UltraClientException e) {
            assertEquals(404, e.getStatus());
        } catch (Throwable t) {
            fail("Expected different exception");
        }

        // TODO: provide full examples of notification etc CRUD

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
}

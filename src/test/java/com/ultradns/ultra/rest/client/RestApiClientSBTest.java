/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.client;

import com.ultradns.ultra.rest.client.exception.UltraClientException;
import com.ultradns.ultra.rest.constants.UltraRestErrorConstant;
import com.ultradns.ultra.rest.constants.UltraRestSharedConstant;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ultradns.ultra.rest.dto.AccountList;
import com.ultradns.ultra.rest.dto.BackupRecord;
import com.ultradns.ultra.rest.dto.HttpLimitInfo;
import com.ultradns.ultra.rest.dto.ProbeInfo;
import com.ultradns.ultra.rest.dto.ProbeInfoList;
import com.ultradns.ultra.rest.dto.ProbeSearchString;
import com.ultradns.ultra.rest.dto.ProbeStatus;
import com.ultradns.ultra.rest.dto.RRSet;
import com.ultradns.ultra.rest.dto.RRSetList;
import com.ultradns.ultra.rest.dto.SBTCRDataInfo;
import com.ultradns.ultra.rest.dto.TransactionInfo;
import com.ultradns.ultra.rest.dto.ZoneOutInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RestApiClientSBTest extends AbstractBaseRestApiClientTest {

    private static final Logger LOG = LoggerFactory.getLogger(RestApiClientSBTest.class);

    private String zoneName;
    private String accountName;

    @Before
    public void setup() throws IOException {
        zoneName = getRandomZoneName();

        AccountList accountList = REST_API_CLIENT.getAccountDetails();
        assertNotNull(accountList);
        accountName = accountList.getAccounts().get(0).getAccountName();
        assertNotNull(accountName);
        LOG.debug("accountName = " + accountName);

        String result = REST_API_CLIENT.createPrimaryZone(accountName, zoneName);
        assertNotNull(result);
        LOG.debug("result = " + result);
    }

    @After
    public void cleanup() throws IOException {
        try {
            REST_API_CLIENT.deleteZone(zoneName);
        } catch (UltraClientException e) {
            // do nothing
        }
    }

    @Test
    public void testSB1() throws IOException {
        ZoneOutInfo zone = REST_API_CLIENT.getZoneMetadata(zoneName);
        assertNotNull(zone);
        LOG.debug("zone = " + zone);

        String ownerName = "foo";

        // create SB pool

        List<String> rdata = Lists.newArrayList();
        rdata.add("1.1.2.3");
        rdata.add("1.2.3.5");
        rdata.add("2.3.5.8");

        RRSet rrSetWithSBPool = new RRSet(zoneName, ownerName, "A (1)", 300, rdata, null);
        Map<String, Object> profile = Maps.newHashMap();

        // rdata & rdataInfo must be of the same size!
        List<SBTCRDataInfo> rdataInfo = Lists.newArrayList();
        SBTCRDataInfo sbRdataInfo1 = new SBTCRDataInfo();
        sbRdataInfo1.setFailOverDelay(25);
        sbRdataInfo1.setPriority(1);
        sbRdataInfo1.setRunProbes(true);
        sbRdataInfo1.setState(UltraRestSharedConstant.RecordState.NORMAL);
        sbRdataInfo1.setThreshold(1);
        rdataInfo.add(sbRdataInfo1);
        SBTCRDataInfo sbRdataInfo2 = new SBTCRDataInfo();
        sbRdataInfo2.setFailOverDelay(25);
        sbRdataInfo2.setPriority(2);
        sbRdataInfo2.setRunProbes(true);
        sbRdataInfo2.setState(UltraRestSharedConstant.RecordState.NORMAL);
        sbRdataInfo2.setThreshold(1);
        rdataInfo.add(sbRdataInfo2);
        SBTCRDataInfo sbRdataInfo3 = new SBTCRDataInfo();
        sbRdataInfo3.setFailOverDelay(25);
        sbRdataInfo3.setPriority(3);
        sbRdataInfo3.setRunProbes(true);
        sbRdataInfo3.setState(UltraRestSharedConstant.RecordState.NORMAL);
        sbRdataInfo3.setThreshold(1);
        rdataInfo.add(sbRdataInfo3);
        profile.put("@context", UltraRestSharedConstant.ProfileType.SB_POOL.getContext());
        profile.put("rdataInfo", rdataInfo);
        BackupRecord backupRecord = new BackupRecord();
        backupRecord.setRdata("3.5.8.13");
        backupRecord.setFailoverDelay(1);
        List<BackupRecord> backupRecords = Lists.newArrayList(backupRecord);
        profile.put("backupRecords", backupRecords);
        profile.put("maxActive", 3);
        profile.put("maxServed", 3);
        rrSetWithSBPool.setProfile(profile);

        String result = REST_API_CLIENT.createRRSet(zoneName, rrSetWithSBPool);
        assertNotNull(result);
        LOG.debug("result = " + result);

        // read back the newly created pool

        RRSetList rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        LOG.debug("rrsets = " + rrsets);
        assertNotNull(rrsets.getRrSets());
        assertNotNull(rrsets.getRrSets().get(0));
        assertEquals(3, rrsets.getRrSets().get(0).getRdata().size());
        assertNotNull(rrsets.getRrSets().get(0).getProfile());
        assertEquals(UltraRestSharedConstant.ProfileType.SB_POOL.getContext(),
                rrsets.getRrSets().get(0).getProfile().get("@context"));
        assertEquals("ROUND_ROBIN",
                rrsets.getRrSets().get(0).getProfile().get("order"));
        assertEquals(3, ((List<SBTCRDataInfo>) rrsets.getRrSets().get(0).getProfile().get("rdataInfo")).size());

        // update SB pool. For example, let's say we have to change order to FIXED and remove the record with 1.2.3.5

        rrSetWithSBPool = rrsets.getRrSets().get(0);
        rrSetWithSBPool.getProfile().put("order", "FIXED");

        rdata = rrSetWithSBPool.getRdata();
        rdataInfo = (List<SBTCRDataInfo>) rrSetWithSBPool.getProfile().get("rdataInfo");
        assertTrue(rdata.size() == rdataInfo.size());
        // find the index to delete; then delete from both lists
        int indexToDeleteAt = -1;
        for (int i = 0; i < rdata.size(); i++) {
            if ("1.2.3.5".equals(rdata.get(i))) {
                indexToDeleteAt = i;
                break;
            }
        }
        assertTrue(indexToDeleteAt != -1);
        if (indexToDeleteAt > -1) {
            rdata.remove(indexToDeleteAt);
            rdataInfo.remove(indexToDeleteAt);
        }
        assertTrue(rdata.size() == rdataInfo.size());

        result = REST_API_CLIENT.updateRRSet(zoneName, rrSetWithSBPool);
        assertNotNull(result);
        LOG.debug("result = " + result);
        rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        LOG.debug("rrsets = " + rrsets);
        assertNotNull(rrsets.getRrSets());
        assertNotNull(rrsets.getRrSets().get(0));
        assertEquals(2, rrsets.getRrSets().get(0).getRdata().size());
        assertNotNull(rrsets.getRrSets().get(0).getProfile());
        assertEquals("FIXED",
                rrsets.getRrSets().get(0).getProfile().get("order"));
        assertEquals(2, ((List<SBTCRDataInfo>) rrsets.getRrSets().get(0).getProfile().get("rdataInfo")).size());

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
        Assert.assertEquals(UltraRestSharedConstant.ProbeInterval.FIFTEEN_MINUTES, probe1.getInterval());
        probe1.setInterval(UltraRestSharedConstant.ProbeInterval.ONE_MINUTE);
        result = REST_API_CLIENT.updateProbe(zoneName, "foo", probe1);
        assertNotNull(result);
        LOG.debug("result = " + result);
        probeInfoList = REST_API_CLIENT.getProbes(zoneName, "foo", null);
        assertNotNull(probeInfoList);
        assertEquals(1, probeInfoList.getProbes().size());
        probe1 = probeInfoList.getProbes().get(0);
        Assert.assertEquals(UltraRestSharedConstant.ProbeInterval.ONE_MINUTE, probe1.getInterval());
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
            Assert.assertEquals(UltraRestErrorConstant.DATA_NOT_FOUND.getErrorCode(), e.getErrors().get(0).getErrorCode());
            Assert.assertEquals(UltraRestErrorConstant.DATA_NOT_FOUND.getErrorMessage(), e.getErrors().get(0).getErrorMessage());
        }

        REST_API_CLIENT.deleteZone(zoneName);
    }
}

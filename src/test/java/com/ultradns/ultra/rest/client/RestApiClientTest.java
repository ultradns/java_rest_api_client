/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.client;

import com.ultradns.ultra.rest.client.exception.UltraClientException;
import com.ultradns.ultra.rest.client.testutil.TaskUtil;
import com.ultradns.ultra.rest.constants.UltraRestErrorConstant;
import com.ultradns.ultra.rest.constants.UltraRestSharedConstant;
import com.ultradns.ultra.rest.constants.ZoneType;
import com.ultradns.ultra.rest.dto.AccountList;
import com.ultradns.ultra.rest.dto.BatchRequest;
import com.ultradns.ultra.rest.dto.BatchResponse;
import com.ultradns.ultra.rest.dto.NameServer;
import com.ultradns.ultra.rest.dto.NameServerIpList;
import com.ultradns.ultra.rest.dto.PrimaryNameServers;
import com.ultradns.ultra.rest.dto.RRSet;
import com.ultradns.ultra.rest.dto.RRSetList;
import com.ultradns.ultra.rest.dto.SecondaryZoneInfo;
import com.ultradns.ultra.rest.dto.Status;
import com.ultradns.ultra.rest.dto.Version;
import com.ultradns.ultra.rest.dto.WebForward;
import com.ultradns.ultra.rest.dto.WebForwardList;
import com.ultradns.ultra.rest.dto.ZoneInfoList;
import com.ultradns.ultra.rest.dto.ZoneOutInfo;
import com.ultradns.ultra.rest.dto.ZoneProperties;
import com.google.common.collect.Lists;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class RestApiClientTest extends AbstractBaseRestApiClientTest {

    private static final Logger LOG = LoggerFactory.getLogger(RestApiClientTest.class);
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
    public void testPrimaryZoneBasicOperations() throws IOException {
        // Get the version of REST API server
        Version outVersion = REST_API_CLIENT.getVersion();
        Assert.assertNotNull(outVersion.getVersion());
        LOG.debug("outVersion = " + outVersion.getVersion());

        // Get the status of REST API server
        Status outStatus = REST_API_CLIENT.getStatus();
        assertEquals("Good", outStatus.getMessage());
        LOG.debug("outStatus = " + outStatus.getMessage());

        AccountList accountList = REST_API_CLIENT.getAccountDetails();
        assertNotNull(accountList);
        accountName = accountList.getAccounts().get(0).getAccountName();
        assertNotNull(accountName);
        LOG.debug("accountName = " + accountName);

        ZoneOutInfo zone = REST_API_CLIENT.getZoneMetadata(zoneName);
        assertNotNull(zone);
        LOG.debug("zone = " + zone);

        ZoneInfoList allZones = REST_API_CLIENT.getZonesOfAccount(accountName, "name:" + zoneName, 0, 5,
                UltraRestSharedConstant.ZoneListSortType.NAME, true);
        assertNotNull(allZones);
        String firstZoneName = allZones.getZones().get(0).getProperties().getName();
        LOG.debug("firstZoneName = " + firstZoneName);

        RRSetList rrsets = REST_API_CLIENT.getRRSets(firstZoneName, null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        LOG.debug("rrsets = " + rrsets);
        String result = REST_API_CLIENT.createRRSet(firstZoneName, "A", "foo", 300, Arrays.asList("1.2.3.4"));
        assertNotNull(result);
        LOG.debug("result = " + result);
        rrsets = REST_API_CLIENT.getRRSetsByType(firstZoneName, "A", null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        LOG.debug("rrsets = " + rrsets);

        result = REST_API_CLIENT.updateRRSet(firstZoneName, "A", "foo", 100, Arrays.asList("10.20.30.40"));
        assertNotNull(result);
        LOG.debug("result = " + result);
        rrsets = REST_API_CLIENT.getRRSets(firstZoneName, null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        LOG.debug("rrsets = " + rrsets);
        rrsets = REST_API_CLIENT.getRRSetsByType(firstZoneName, "A", null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        LOG.debug("rrsets = " + rrsets);

        REST_API_CLIENT.deleteRRSet(firstZoneName, "A", "foo");
        LOG.debug("foo." + firstZoneName + " deleted");
        rrsets = REST_API_CLIENT.getRRSets(firstZoneName, null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        LOG.debug("rrsets = " + rrsets);

        try {
            REST_API_CLIENT.getRRSetsByType(firstZoneName, "A", null, 0, MAX_PAGE_SIZE,
                    UltraRestSharedConstant.RRListSortType.OWNER, false);
            fail("Expecting an exception");
        } catch (UltraClientException e) {
            assertEquals(404, e.getStatus());
            assertFalse(e.getErrors().isEmpty());
            assertEquals(1, e.getErrors().size());
            Assert.assertEquals(UltraRestErrorConstant.DATA_NOT_FOUND.getErrorCode(), e.getErrors().get(0).getErrorCode());
            assertEquals(UltraRestErrorConstant.DATA_NOT_FOUND.getErrorMessage(),
                    e.getErrors().get(0).getErrorMessage());
        }

        REST_API_CLIENT.deleteZone(zoneName);
    }

    @Test
    public void testSecondaryZoneBasicOperations() throws IOException, InterruptedException {
        // Test data
        String zoneName = "secondarya" + (1 + (new Random()).nextInt(18)) + ".com";

        // Secondary zone primary name server info
        String ip1 = "e2e-bind-useast1a01-01.dev.ultradns.net";
        String tsigKey1 = null;
        String tsigKeyValue1 = null;
        String tsigAlgorithm1 = null;
        String notificationEmailAddress = "foo@bar.com";

        NameServer nameServerIp1 = new NameServer(ip1, tsigKey1, tsigKeyValue1, tsigAlgorithm1);
        NameServer nameServerIp2 = null;
        NameServer nameServerIp3 = null;
        NameServerIpList nameServerIpList = new NameServerIpList(nameServerIp1, nameServerIp2, nameServerIp3);

        // Create the secondary zone
        String taskId = REST_API_CLIENT.createSecondaryZone(accountName, zoneName, nameServerIpList,
                notificationEmailAddress);
        assertNotNull(taskId);

        // Check the secondary zone creation task is finished successfully
        TaskUtil.checkTaskCompletedSuccessfully(REST_API_CLIENT, 10, 10, taskId);

        ZoneOutInfo zone = REST_API_CLIENT.getZoneMetadata(zoneName);
        assertNotNull(zone);

        // Update the secondary zone
        String result = REST_API_CLIENT.updateSecondaryZone(zoneName, nameServerIpList, notificationEmailAddress);
        assertNotNull(result);

        ZoneInfoList allZones = REST_API_CLIENT.getZonesOfAccount(accountName, "name:" + zoneName, 0, 5,
                UltraRestSharedConstant.ZoneListSortType.NAME, true);
        assertNotNull(allZones);
        String firstZoneName = allZones.getZones().get(0).getProperties().getName();

        REST_API_CLIENT.deleteZone(zoneName);
    }

    @Test
    public void testSecondaryZoneCreationWithAllowUnresponsiveNS() throws IOException, InterruptedException {
        // Test data
        String zoneName = "secondarya" + (1 + (new Random()).nextInt(18)) + ".com";
        ZoneProperties zoneProperties = new ZoneProperties(zoneName, accountName, ZoneType.SECONDARY, null, null, null);

        // Secondary zone primary name server info
        String ip1 = "e2e-bind-useast1a01-01.dev.ultradns.net";
        String tsigKey1 = null;
        String tsigKeyValue1 = null;
        String tsigAlgorithm1 = null;
        String notificationEmailAddress = "foo@bar.com";
        boolean isAllowUnresponsiveNS = true;

        NameServer nameServerIp1 = new NameServer(ip1, tsigKey1, tsigKeyValue1, tsigAlgorithm1);
        NameServer nameServerIp2 = null;
        NameServer nameServerIp3 = null;
        NameServerIpList nameServerIpList = new NameServerIpList(nameServerIp1, nameServerIp2, nameServerIp3);

        SecondaryZoneInfo secondaryZoneInfo = new SecondaryZoneInfo(new PrimaryNameServers(nameServerIpList));
        secondaryZoneInfo.setNotificationEmailAddress(notificationEmailAddress);
        secondaryZoneInfo.setAllowUnresponsiveNS(isAllowUnresponsiveNS);

        // Create the secondary zone
        String taskId = REST_API_CLIENT.createSecondaryZone(zoneProperties, secondaryZoneInfo);
        assertNotNull(taskId);

        // Check the secondary zone creation task is finished successfully
        TaskUtil.checkTaskCompletedSuccessfully(REST_API_CLIENT, 10, 10, taskId);

        ZoneOutInfo zone = REST_API_CLIENT.getZoneMetadata(zoneName);
        assertNotNull(zone);

        REST_API_CLIENT.deleteZone(zoneName);
    }

    @Test
    public void testBasicWebForwardOperations() throws IOException {
        // Create a web forward under the zone from foo.zone -> bar.invalid
        WebForward webForward = new WebForward();
        String requestTo = "foo." + zoneName + "/*";
        webForward.setRequestTo(requestTo);
        webForward.setDefaultRedirectTo("https://bar.invalid");
        webForward.setDefaultForwardType(WebForward.RedirectType.HTTP_301_REDIRECT);
        webForward.setRelativeForwardType(WebForward.RelativeForward.PARAMETER_AND_PATH);
        WebForward returnedWebForward = REST_API_CLIENT.createWebForward(zoneName, webForward);
        assertNotNull(returnedWebForward);
        assertNotNull(returnedWebForward.getGuid());

        // Get the list of web forwards
        WebForwardList returnedWebForwardList = REST_API_CLIENT.getWebForwardList(zoneName, "name:foo", 0,
                MAX_PAGE_SIZE, UltraRestSharedConstant.WFListSortFields.REQUEST_TO, false);
        assertNotNull(returnedWebForwardList);
        assertNotNull(returnedWebForwardList.getWebForwards());
        assertEquals(1, returnedWebForwardList.getWebForwards().size());

        // Update a web forward redirect url from bar.zone -> new-bar.zone
        String guid = returnedWebForwardList.getWebForwards().get(0).getGuid();
        String newRedirect = "https://new-bar.invalid";
        webForward = new WebForward();
        webForward.setRequestTo(requestTo);
        webForward.setDefaultRedirectTo(newRedirect);
        webForward.setDefaultForwardType(WebForward.RedirectType.HTTP_301_REDIRECT);
        webForward.setRelativeForwardType(WebForward.RelativeForward.PARAMETER_AND_PATH);
        String status = REST_API_CLIENT.updateWebForward(zoneName, guid, webForward);
        assertNotNull(status);

        // Confirm that the web forward was updated successfully
        returnedWebForwardList = REST_API_CLIENT.getWebForwardList(zoneName, "name:new-bar", 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.WFListSortFields.REQUEST_TO, false);
        assertNotNull(returnedWebForwardList);
        assertNotNull(returnedWebForwardList.getWebForwards());
        assertEquals(1, returnedWebForwardList.getWebForwards().size());

        // Delete the web forward
        REST_API_CLIENT.deleteWebForward(zoneName, returnedWebForwardList.getWebForwards().get(0).getGuid());
    }

    @Test
    public void testAddARecordsInBatch() throws IOException {
        // Add multiple A records in a Batch
        List<BatchRequest> batchRequests = Lists.newArrayList(
                new BatchRequest(BatchRequest.Method.POST, "/v2/zones/" + zoneName + "/rrsets/A/a",
                        new RRSet(null, null, null, 86400, Lists.newArrayList("1.1.1.1"), null)),
                new BatchRequest(BatchRequest.Method.POST, "/v2/zones/" + zoneName + "/rrsets/A/b",
                        new RRSet(null, null, null, 86400, Lists.newArrayList("2.2.2.2"), null)),
                new BatchRequest(BatchRequest.Method.POST, "/v2/zones/" + zoneName + "/rrsets/A/c",
                        new RRSet(null, null, null, 86400, Lists.newArrayList("3.3.3.3"), null)));

        List<BatchResponse> batchResponses = REST_API_CLIENT.batchOperation(batchRequests);
        assertNotNull(batchResponses);
        assertEquals(3, batchResponses.size());
        assertEquals(HttpStatus.SC_CREATED, batchResponses.get(0).getStatus());
        assertEquals(HttpStatus.SC_CREATED, batchResponses.get(1).getStatus());
        assertEquals(HttpStatus.SC_CREATED, batchResponses.get(2).getStatus());

        RRSetList rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", "owner:a." + zoneName, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertEquals(1, rrsets.getResultInfo().getReturnedCount());

        rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", "owner:b." + zoneName, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertEquals(1, rrsets.getResultInfo().getReturnedCount());

        rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", "owner:c." + zoneName, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertEquals(1, rrsets.getResultInfo().getReturnedCount());
    }

    @Test
    public void testAddARecordsInBatchAsync() throws IOException, InterruptedException {
        // Add multiple A records in a Batch
        List<BatchRequest> batchRequests = Lists.newArrayList(
                new BatchRequest(BatchRequest.Method.POST, "/v2/zones/" + zoneName + "/rrsets/A/a",
                        new RRSet(null, null, null, 86400, Lists.newArrayList("1.1.1.1"), null)),
                new BatchRequest(BatchRequest.Method.POST, "/v2/zones/" + zoneName + "/rrsets/A/b",
                        new RRSet(null, null, null, 86400, Lists.newArrayList("2.2.2.2"), null)),
                new BatchRequest(BatchRequest.Method.POST, "/v2/zones/" + zoneName + "/rrsets/A/c",
                        new RRSet(null, null, null, 86400, Lists.newArrayList("3.3.3.3"), null)));

        String taskId = REST_API_CLIENT.asyncBatchOperation(batchRequests);
        assertNotNull(taskId);

        // Check the secondary zone creation task is finished successfully
        TaskUtil.checkTaskCompletedSuccessfully(REST_API_CLIENT, 10, 10, taskId);

        // Verify that the records were created successfully
        RRSetList rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", "owner:a." + zoneName, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertEquals(1, rrsets.getResultInfo().getReturnedCount());

        rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", "owner:b." + zoneName, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertEquals(1, rrsets.getResultInfo().getReturnedCount());

        rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", "owner:c." + zoneName, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertEquals(1, rrsets.getResultInfo().getReturnedCount());
    }
}

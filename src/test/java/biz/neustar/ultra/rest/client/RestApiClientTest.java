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
import biz.neustar.ultra.rest.dto.AccountList;
import biz.neustar.ultra.rest.dto.NameServer;
import biz.neustar.ultra.rest.dto.NameServerIpList;
import biz.neustar.ultra.rest.dto.RRSetList;
import biz.neustar.ultra.rest.dto.Status;
import biz.neustar.ultra.rest.dto.TaskStatusInfo;
import biz.neustar.ultra.rest.dto.Version;
import biz.neustar.ultra.rest.dto.WebForward;
import biz.neustar.ultra.rest.dto.WebForwardList;
import biz.neustar.ultra.rest.dto.ZoneInfoList;
import biz.neustar.ultra.rest.dto.ZoneOutInfo;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RestApiClientTest {

    private static final Logger LOG = LoggerFactory.getLogger(RestApiClientTest.class);
    private static final int MAX_PAGE_SIZE = 1000;

    private static final String USER_NAME = System.getProperty("rest.username");
    private static final String PASSWORD = System.getProperty("rest.password");
    private static final String URL = System.getProperty("rest.url");

    private static final RestApiClient REST_API_CLIENT = RestApiClient.buildRestApiClientWithUidPwd(USER_NAME, PASSWORD,
            URL, null);

    @Test
    public void testPrimaryZoneBasicOperations() throws IOException {
        String zoneName = System.currentTimeMillis() + "foo.invalid.";

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
        String accountName = accountList.getAccounts().get(0).getAccountName();
        assertNotNull(accountName);
        LOG.debug("accountName = " + accountName);

        String result = REST_API_CLIENT.createPrimaryZone(accountName, zoneName);
        assertNotNull(result);
        LOG.debug("result = " + result);

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
        result = REST_API_CLIENT.createRRSet(firstZoneName, "A", "foo", 300, Arrays.asList("1.2.3.4"));
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
            assertEquals(UltraRestErrorConstant.DATA_NOT_FOUND.getErrorCode(), e.getErrors().get(0).getErrorCode());
            assertEquals(UltraRestErrorConstant.DATA_NOT_FOUND.getErrorMessage(), e.getErrors().get(0).getErrorMessage());
        }

        REST_API_CLIENT.deleteZone(zoneName);
    }

    @Test
    public void testSecondaryZoneBasicOperations() throws IOException, InterruptedException {
        // Test data
        String zoneName = "secondarya" + (1 + (new Random()).nextInt(18)) + ".com";

        // Secondary zone primary name server info
        String ip1 = "107.21.211.150";
        String tsigKey1 = null;
        String tsigKeyValue1 = null;
        String tsigAlgorithm1 = null;
        String notificationEmailAddress = "foo@bar.com";

        AccountList accountList = REST_API_CLIENT.getAccountDetails();
        assertNotNull(accountList);
        String accountName = accountList.getAccounts().get(0).getAccountName();
        assertNotNull(accountName);

        NameServer nameServerIp1 = new NameServer(ip1, tsigKey1, tsigKeyValue1, tsigAlgorithm1);
        NameServer nameServerIp2 = null;
        NameServer nameServerIp3 = null;
        NameServerIpList nameServerIpList = new NameServerIpList(nameServerIp1, nameServerIp2, nameServerIp3);

        // Create the secondary zone
        String taskId = REST_API_CLIENT.createSecondaryZone(accountName, zoneName, nameServerIpList,
                notificationEmailAddress);
        assertNotNull(taskId);

        // Check the secondary zone creation task is finished successfully
        checkTaskCompletedSuccessfully(10, 10, taskId);

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

    /**
     * Check if the task is completed with expected status.
     *
     * @param maxRetryCount     The max retry count.
     * @param intervalInSeconds The interval in seconds.
     * @param taskId            The task Id to check.
     */
    private void checkTaskCompletedSuccessfully(final int maxRetryCount, final int intervalInSeconds, String taskId)
            throws InterruptedException, IOException {
        LOG.info("Checking for task to finish with status as '{}' for task Id '{}'. ", TaskStatusCode.COMPLETE.name(),
                taskId);
        TaskStatusInfo taskStatusInfo = REST_API_CLIENT.getTaskStatus(taskId);
        int pollCount = 0;
        while ((TaskStatusCode.PENDING == taskStatusInfo.getCode()
                || TaskStatusCode.IN_PROCESS == taskStatusInfo.getCode()) && pollCount != maxRetryCount) {
            pollCount++;
            LOG.info("Fetching task status for task Id '{}' with retry {} out of {}. ", taskId, pollCount,
                    maxRetryCount);
            Thread.sleep(TimeUnit.SECONDS.toMillis(intervalInSeconds));
            taskStatusInfo = REST_API_CLIENT.getTaskStatus(taskId);
        }
        String taskStatus = taskStatusInfo.getCode().toString();
        assertTrue(String.format("For task Id '%s', expected status is '%s, but got '%s'.", taskId,
                TaskStatusCode.COMPLETE.name(), taskStatus),
                TaskStatusCode.COMPLETE.name().equalsIgnoreCase(taskStatus));
    }

    @Test
    public void testBasicWebForwardOperations() throws IOException {
        String zoneName = System.currentTimeMillis() + "foo.invalid.";

        // Create a primary zone for testing
        AccountList accountList = REST_API_CLIENT.getAccountDetails();
        assertNotNull(accountList);
        String accountName = accountList.getAccounts().get(0).getAccountName();
        assertNotNull(accountName);
        LOG.debug("accountName = " + accountName);

        String result = REST_API_CLIENT.createPrimaryZone(accountName, zoneName);
        assertNotNull(result);
        LOG.debug("result = " + result);

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

        // Delete the test zone
        REST_API_CLIENT.deleteZone(zoneName);
    }
}

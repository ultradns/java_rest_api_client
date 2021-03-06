/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.client;

import biz.neustar.ultra.rest.client.exception.UltraClientException;
import biz.neustar.ultra.rest.client.testutil.TaskUtil;
import biz.neustar.ultra.rest.dto.AccountList;
import biz.neustar.ultra.rest.dto.NameServer;
import biz.neustar.ultra.rest.dto.NameServerIpList;
import biz.neustar.ultra.rest.dto.ZoneInfoList;
import biz.neustar.ultra.rest.dto.ZoneOutInfo;
import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class RestApiClientBasicSecondaryTest extends AbstractBaseRestApiClientTest {

    private static final Logger LOG = LoggerFactory.getLogger(RestApiClientBasicSecondaryTest.class);
    private List<String> zoneNames;
    private String accountName;

    @Before
    public void setup() throws IOException {
        zoneNames = Lists.newArrayList();

        AccountList accountList = REST_API_CLIENT.getAccountDetails();
        assertNotNull(accountList);
        accountName = accountList.getAccounts().get(0).getAccountName();
        assertNotNull(accountName);
        LOG.debug("accountName = " + accountName);
    }

    @After
    public void cleanup() throws IOException {
        try {
            for (String zoneName : zoneNames) {
                REST_API_CLIENT.deleteZone(zoneName);
            }
        } catch (UltraClientException e) {
            // do nothing
        }
    }

    private void createSecondaryZone(String zoneName) throws IOException, InterruptedException {
        // Secondary zone primary name server info
        String ip1 = "107.21.211.150";
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

        zoneNames.add(zoneName);
    }

    @Test
    public void testCursorBasedListBasicSecondaryZones() throws IOException, InterruptedException {
        Assume.assumeTrue("true".equalsIgnoreCase(System.getProperty("test.basic.secondary")));

        // Test data - create multiple secondary zones
        int noOfSecZones = 6;
        for (int index = 1; index <= noOfSecZones; index++) {
            String zoneName = "secondarya" + index + ".com";
            createSecondaryZone(zoneName);
        }

        // Input parameters
        String q = null;
        String cursor = null;
        int limit = 5;

        // List the first set of secondary basic zones
        ZoneInfoList zoneInfoList = REST_API_CLIENT.getZoneListByCursor(q, cursor, limit);
        assertNotNull(zoneInfoList);
        assertNotNull(zoneInfoList.getZones());
        assertEquals(5, zoneInfoList.getZones().size());
        assertNotNull(zoneInfoList.getCursorInfo());
        assertNotNull(zoneInfoList.getCursorInfo().getNext());
        assertNull(zoneInfoList.getCursorInfo().getPrevious());

        // Fetch the next set of zones using cursor from previous response
        cursor = zoneInfoList.getCursorInfo().getNext();
        zoneInfoList = REST_API_CLIENT.getZoneListByCursor(q, cursor, limit);
        assertNotNull(zoneInfoList);
        assertNotNull(zoneInfoList.getZones());
        assertEquals(1, zoneInfoList.getZones().size());
        assertNotNull(zoneInfoList.getCursorInfo());
        assertNotNull(zoneInfoList.getCursorInfo().getPrevious());
        assertNull(zoneInfoList.getCursorInfo().getNext());

        // Fetch the previous set of zones using cursor from response
        cursor = zoneInfoList.getCursorInfo().getPrevious();
        zoneInfoList = REST_API_CLIENT.getZoneListByCursor(q, cursor, limit);
        assertNotNull(zoneInfoList);
        assertNotNull(zoneInfoList.getZones());
        assertEquals(5, zoneInfoList.getZones().size());
        assertNotNull(zoneInfoList.getCursorInfo());
        assertNotNull(zoneInfoList.getCursorInfo().getNext());
        assertNull(zoneInfoList.getCursorInfo().getPrevious());
    }
}

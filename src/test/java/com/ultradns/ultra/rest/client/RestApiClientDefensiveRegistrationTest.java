package com.ultradns.ultra.rest.client;

import com.ultradns.ultra.rest.client.exception.UltraClientException;
import com.ultradns.ultra.rest.client.testutil.TaskUtil;
import com.ultradns.ultra.rest.constants.ZoneType;
import com.ultradns.ultra.rest.dto.AccountList;
import com.ultradns.ultra.rest.dto.NameServer;
import com.ultradns.ultra.rest.dto.NameServerIpList;
import com.ultradns.ultra.rest.dto.Status;
import com.ultradns.ultra.rest.dto.ZoneOutInfo;
import com.ultradns.ultra.rest.dto.ZoneProperties;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class RestApiClientDefensiveRegistrationTest extends AbstractBaseRestApiClientTest {

    private static final Logger LOG = LoggerFactory.getLogger(RestApiClientDefensiveRegistrationTest.class);
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
    public void testDefensiveRegistration() throws IOException, InterruptedException {
        Assume.assumeTrue("true".equalsIgnoreCase(System.getProperty("test.defensive.registration")));

        zoneName = "secondarya" + (1 + (new Random()).nextInt(18)) + ".com";

        // Defensive registration: Create the secondary zone in suspended state
        ZoneProperties zoneProperties = new ZoneProperties(zoneName, accountName, ZoneType.SECONDARY, null, null,
                ZoneProperties.ZoneStatus.SUSPENDED, null);
        String taskId = REST_API_CLIENT.createSecondaryZone(zoneProperties, null);
        assertNotNull(taskId);

        // Check the secondary zone creation task is finished successfully
        TaskUtil.checkTaskCompletedSuccessfully(REST_API_CLIENT, 10, 10, taskId);

        // Verify that zone is created in the system in suspend state
        ZoneOutInfo zoneOutInfo = REST_API_CLIENT.getZoneMetadata(zoneName);
        assertNotNull(zoneOutInfo);
        assertNotNull(zoneOutInfo.getProperties());
        assertEquals(ZoneProperties.ZoneStatus.SUSPENDED, zoneOutInfo.getProperties().getStatus());

        // Activate the suspended zone; update the NS first
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

        REST_API_CLIENT.updateSecondaryZone(zoneName, nameServerIpList, notificationEmailAddress);

        // Unsuspend the zone to make it active in the system
        Status status = REST_API_CLIENT.unsuspendZone(zoneName);
        assertEquals(Status.SUCCESSFUL, status);

        // Verify that zone is status is updated to active
        zoneOutInfo = REST_API_CLIENT.getZoneMetadata(zoneName);
        assertNotNull(zoneOutInfo);
        assertNotNull(zoneOutInfo.getProperties());
        assertEquals(ZoneProperties.ZoneStatus.ACTIVE, zoneOutInfo.getProperties().getStatus());
    }
}

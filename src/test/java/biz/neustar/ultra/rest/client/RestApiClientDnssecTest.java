package biz.neustar.ultra.rest.client;

import biz.neustar.ultra.rest.client.exception.UltraClientException;
import biz.neustar.ultra.rest.client.testutil.TaskUtil;
import biz.neustar.ultra.rest.dto.AccountList;
import biz.neustar.ultra.rest.dto.DnsSecInfo;
import biz.neustar.ultra.rest.dto.Status;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/*
 * User: kbhandar
 * Date: 10/24/19
 *
 * Copyright 2019 Neustar, Inc. All rights reserved.
 * Neustar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of Neustar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class RestApiClientDnssecTest extends AbstractBaseRestApiClientTest {
    private static final Logger LOG = LoggerFactory.getLogger(RestApiClientDnssecTest.class);

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
    public void dnssecOperations() throws IOException, InterruptedException {
        // Sign the zone
        String result = REST_API_CLIENT.signZone(zoneName);
        assertNotNull(result);
        LOG.debug("result = " + result);

        if (!result.contains(Status.SUCCESSFUL.getMessage())) {
            // Check the task is finished successfully
            TaskUtil.checkTaskCompletedSuccessfully(REST_API_CLIENT, 10, 10, result);
        }

        // Get the dnssec info of the signed zone
        DnsSecInfo dnsSecInfo = REST_API_CLIENT.getDnsSecInfo(zoneName);
        assertNotNull(dnsSecInfo);
        LOG.debug("DnsSecInfo = " + dnsSecInfo);

        // Unsign the signed zone
        result = REST_API_CLIENT.unsignZone(zoneName);
        LOG.debug("result = " + result);

        if (result != null) {
            // Check the task is finished successfully
            TaskUtil.checkTaskCompletedSuccessfully(REST_API_CLIENT, 10, 10, result);
        }
    }
}

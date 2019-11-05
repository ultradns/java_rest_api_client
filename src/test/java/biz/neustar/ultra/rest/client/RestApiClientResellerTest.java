package biz.neustar.ultra.rest.client;

import biz.neustar.ultra.rest.client.exception.UltraClientException;
import biz.neustar.ultra.rest.constants.UltraRestSharedConstant;
import biz.neustar.ultra.rest.dto.AccountList;
import biz.neustar.ultra.rest.dto.ZoneInfoList;
import biz.neustar.ultra.rest.dto.ZoneOutInfo;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/*
 * User: kbhandar
 * Date: 11/5/19
 *
 * Copyright 2019 Neustar, Inc. All rights reserved.
 * Neustar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of Neustar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class RestApiClientResellerTest extends AbstractBaseRestApiClientTest {

    private static final Logger LOG = LoggerFactory.getLogger(RestApiClientResellerTest.class);
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
    public void testBasicResellerOperations() throws IOException {
        Assume.assumeTrue("true".equalsIgnoreCase(System.getProperty("test.reseller")));

        // Get the list of sub-accounts
        AccountList subAccountList = REST_API_CLIENT.listSubAccounts(null, 0, 100, false);
        assertNotNull(subAccountList);
        String subAccountName = subAccountList.getAccounts().get(0).getAccountName();
        assertNotNull(subAccountName);
        LOG.debug("accountName = " + subAccountName);

        // Get the RestApiClient to access a sub-account resources.
        LOG.debug("Getting the RestApiClient to access the resournces of sub-account:  " + subAccountName);
        RestApiClient subAccountRestApiClient = REST_API_CLIENT.buildRestApiClientForSubAccountAccess(subAccountName);
        assertNotNull(subAccountRestApiClient);

        // Create a zone in the sub-account using sub-Account RestApiClient
        String result = subAccountRestApiClient.createPrimaryZone(subAccountName, zoneName);
        assertNotNull(result);
        LOG.debug("result = " + result);

        // Verify that the zone in the sub-account is created
        ZoneOutInfo zone = subAccountRestApiClient.getZoneMetadata(zoneName);
        assertNotNull(zone);
        LOG.debug("zone = " + zone);

        // List the Reseller's sub-accounts zones. Make sure to use Reseller's RestApiClient
        ZoneInfoList allZones = REST_API_CLIENT.listSubAccountsZones("name:" + zoneName, 0, 5,
                UltraRestSharedConstant.ZoneListSortType.NAME, true);
        assertNotNull(allZones);
        String firstZoneName = allZones.getZones().get(0).getProperties().getName();
        LOG.debug("firstZoneName = " + firstZoneName);

        // Reseller's RestApiClient cannot access sub-account's zone directly
        try {
            REST_API_CLIENT.getRRSets(firstZoneName, null, 0, MAX_PAGE_SIZE,
                    UltraRestSharedConstant.RRListSortType.OWNER, false);
            fail("Expecting an exception");
        } catch (UltraClientException e) {
            assertEquals(HttpStatus.SC_FORBIDDEN, e.getStatus());
        }

        // Delete the sub-account zone created
        subAccountRestApiClient.deleteZone(zoneName);
    }
}

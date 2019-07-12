/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.client;

import biz.neustar.ultra.rest.constants.UltraRestSharedConstant;
import biz.neustar.ultra.rest.dto.AccountList;
import biz.neustar.ultra.rest.dto.RRSetList;
import biz.neustar.ultra.rest.dto.Status;
import biz.neustar.ultra.rest.dto.Version;
import biz.neustar.ultra.rest.dto.ZoneInfoList;
import biz.neustar.ultra.rest.dto.ZoneOutInfo;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RestApiClientTest {
    private static final int MAX_PAGE_SIZE = 1000;

    @Test
    public void testAllMethodsOnActualEnvt() throws IOException {
        String username = System.getProperty("rest.username");
        String password = System.getProperty("rest.password");
        String url = System.getProperty("rest.url");

        String zoneName = System.currentTimeMillis() + "foo.invalid.";

        RestApiClient restApiClient = RestApiClient.buildRestApiClientWithUidPwd(username, password, url, null);

        // Get the version of REST API server
        Version outVersion = restApiClient.getVersion();
        Assert.assertNotNull(outVersion.getVersion());
        System.out.println("outVersion = " + outVersion.getVersion());

        // Get the status of REST API server
        Status outStatus = restApiClient.getStatus();
        assertEquals("Good", outStatus.getMessage());
        System.out.println("outStatus = " + outStatus.getMessage());

        AccountList accountList = restApiClient.getAccountDetails();
        assertNotNull(accountList);
        String accountName = accountList.getAccounts().get(0).getAccountName();
        assertNotNull(accountName);
        System.out.println("accountName = " + accountName);

        String result = restApiClient.createPrimaryZone(accountName, zoneName);
        assertNotNull(result);
        System.out.println("result = " + result);

        ZoneOutInfo zone = restApiClient.getZoneMetadata(zoneName);
        assertNotNull(zone);
        System.out.println("zone = " + zone);

        ZoneInfoList allZones = restApiClient.getZonesOfAccount(accountName, "name:" + zoneName, 0, 5,
                UltraRestSharedConstant.ZoneListSortType.NAME, true);
        assertNotNull(allZones);
        String firstZoneName = allZones.getZones().get(0).getProperties().getName();
        System.out.println("firstZoneName = " + firstZoneName);

        RRSetList rrsets = restApiClient.getRRSets(firstZoneName, null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        System.out.println("rrsets = " + rrsets);
        result = restApiClient.createRRSet(firstZoneName, "A", "foo", 300, Arrays.asList("1.2.3.4"));
        assertNotNull(result);
        System.out.println("result = " + result);
        rrsets = restApiClient.getRRSetsByType(firstZoneName, "A", null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        System.out.println("rrsets = " + rrsets);

        result = restApiClient.updateRRSet(firstZoneName, "A", "foo", 100, Arrays.asList("10.20.30.40"));
        assertNotNull(result);
        System.out.println("result = " + result);
        rrsets = restApiClient.getRRSets(firstZoneName, null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        System.out.println("rrsets = " + rrsets);
        rrsets = restApiClient.getRRSetsByType(firstZoneName, "A", null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        System.out.println("rrsets = " + rrsets);

        restApiClient.deleteRRSet(firstZoneName, "A", "foo");
        System.out.println("foo." + firstZoneName + " deleted");
        rrsets = restApiClient.getRRSets(firstZoneName, null, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        System.out.println("rrsets = " + rrsets);

        try {
            restApiClient.getRRSetsByType(firstZoneName, "A", null, 0, MAX_PAGE_SIZE,
                    UltraRestSharedConstant.RRListSortType.OWNER, false);
            fail("Expecting an exception");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("Status: 404"));
        }

        restApiClient.deleteZone(zoneName);
        System.out.println("foo.invalid. deleted");
    }
}

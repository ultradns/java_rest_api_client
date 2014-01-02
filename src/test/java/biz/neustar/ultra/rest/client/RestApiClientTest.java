/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
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


public class RestApiClientTest {
    @Test
	public void testAllMethodsOnActualEnvt() throws IOException {
        /*
        c = ultra_rest_client.RestApiClient(sys.argv[1], sys.argv[2])
        */
        RestApiClient restApiClient = RestApiClient.buildRestApiClientWithUidPwd("teamrest", "Teamrest1", "http://restapi-useast1b01-01.qa.ultradns.net:8080/", null);

        // Get the version of REST API server
        /*
        print c.version()
         */
        Version outVersion = restApiClient.getVersion();
        Assert.assertNotNull(outVersion.getVersion());
        System.out.println("outVersion = " + outVersion.getVersion());

        // Get the status of REST API server
        /*
        print c.status()
         */
        Status outStatus = restApiClient.getStatus();
        assertEquals("Good", outStatus.getMessage());
        System.out.println("outStatus = " + outStatus.getMessage());

        /*
        account_details = c.get_account_details()
        account_name = account_details[u'list'][0][u'accountName']
        print account_name
         */
        AccountList accountList = restApiClient.getAccountDetails();
        assertNotNull(accountList);
        String accountName = accountList.getAccounts().get(0).getAccountName();
        assertNotNull(accountName);
        System.out.println("accountName = " + accountName);

        /*
        print c.create_primary_zone(account_name, "foo.invalid.")
        print c.get_zone_metadata("foo.invalid.")
        print c.delete_zone("foo.invalid.")
         */
        String result = restApiClient.createPrimaryZone(accountName, "foo.invalid.");
        assertNotNull(result);
        System.out.println("result = " + result);

        ZoneOutInfo zone = restApiClient.getZoneMetadata("foo.invalid.");
        assertNotNull(zone);
        System.out.println("zone = " + zone);

        restApiClient.deleteZone("foo.invalid.");
        System.out.println("foo.invalid. deleted");

        /*
        all_zones = c.get_zones_of_account(account_name, offset=0, limit=5)
        first_zone_name = all_zones[u'list'][0][u'properties'][u'name']
        print first_zone_name
        */
        ZoneInfoList allZones = restApiClient.getZonesOfAccount(accountName, null, 0, 5, UltraRestSharedConstant.ZoneListSortType.NAME, true);
        assertNotNull(allZones);
        String firstZoneName = allZones.getZones().get(0).getProperties().getName();
        System.out.println("firstZoneName = " + firstZoneName);

        /*
        print c.get_rrsets(first_zone_name)
        print c.create_rrset(first_zone_name, "A", "foo", 300, "1.2.3.4")
        print c.get_rrsets(first_zone_name)
        print c.get_rrsets_by_type(first_zone_name, "A")
        */
        RRSetList rrsets = restApiClient.getRRSets(firstZoneName, null, 0, Integer.MAX_VALUE, UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        System.out.println("rrsets = " + rrsets);
        result = restApiClient.createRRSet(firstZoneName, "A", "foo", 300, Arrays.asList("1.2.3.4"));
        assertNotNull(result);
        System.out.println("result = " + result);
        rrsets = restApiClient.getRRSetsByType(firstZoneName, "A", null, 0, Integer.MAX_VALUE, UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        System.out.println("rrsets = " + rrsets);

        /*
        print c.edit_rrset(first_zone_name, "A", "foo", 100, ["10.20.30.40"])
        print c.get_rrsets(first_zone_name)
        print c.get_rrsets_by_type(first_zone_name, "A")
        */
        result = restApiClient.updateRRSet(firstZoneName, "A", "foo", 100, Arrays.asList("10.20.30.40"));
        assertNotNull(result);
        System.out.println("result = " + result);
        rrsets = restApiClient.getRRSets(firstZoneName, null, 0, Integer.MAX_VALUE, UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        System.out.println("rrsets = " + rrsets);
        rrsets = restApiClient.getRRSetsByType(firstZoneName, "A", null, 0, Integer.MAX_VALUE, UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        System.out.println("rrsets = " + rrsets);


        /*
        print c.delete_rrset(first_zone_name, "A", "foo")
        print c.get_rrsets(first_zone_name)
        print c.get_rrsets_by_type(first_zone_name, "A")
         */
        restApiClient.deleteRRSet(firstZoneName, "A", "foo");
        System.out.println("foo."+firstZoneName+" deleted");
        rrsets = restApiClient.getRRSets(firstZoneName, null, 0, Integer.MAX_VALUE, UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        System.out.println("rrsets = " + rrsets);
        rrsets = restApiClient.getRRSetsByType(firstZoneName, "A", null, 0, Integer.MAX_VALUE, UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        System.out.println("rrsets = " + rrsets);
	}
}

/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import biz.neustar.ultra.rest.constants.ZoneType;
import biz.neustar.ultra.rest.dto.AccountList;
import biz.neustar.ultra.rest.dto.RRSetList;
import biz.neustar.ultra.rest.dto.ZoneInfoList;
import biz.neustar.ultra.rest.dto.ZoneOutInfo;


public class RestApiClientTest {
	
	private RestApiClient restApiClient;
    private String tokenFileName;
    private String userPassFile;

	
	@Before
	public void setup() {
		restApiClient = Mockito.mock(RestApiClient.class);
	}
	

	@Test
	public void testGetZonesOfAccount() throws IOException {
		restApiClient.deleteZone("zoneName");
	}
	
	// TODO - Need to replace this test with the one using Mockito
	@Test
	public void testAllMethodsOnActualEnvt() throws IOException {
		// Do not fail the test if the server is down or not-reachable
        this.userPassFile= "/Users/npartang/Projects/java_rest_api_client/rest_user.txt";
        this.tokenFileName = "/Users/npartang/Projects/java_rest_api_client/rest_tokens.txt";
		try {
			restApiClient = new RestApiClient( "http://restapi-useast1b01-01.qa.ultradns.net:8080/", this.userPassFile, this.tokenFileName);
		} catch(Exception e) {
			return;
		}
		String accountName = "selautomation10";
		String zoneName = "narayantest48.biz.";
		

		// Create a primary zone
		restApiClient.createPrimaryZone(accountName, zoneName);
        System.out.println("after primary creation");

        // Get zone metadata for the primary zone created as part of test
        ZoneOutInfo zoneOutInfo = restApiClient.getZoneMetadata(zoneName);
        Assert.assertNotNull(zoneOutInfo);
        Assert.assertNotNull(zoneOutInfo.getProperties());
        Assert.assertEquals(zoneName, zoneOutInfo.getProperties().getName());
        Assert.assertEquals(ZoneType.PRIMARY, zoneOutInfo.getProperties().getType());



		// List the zones for account passing the primary zone created as part of test
		String offset = "0";
		String limit = ""+Integer.MAX_VALUE;
		String reverse = "true";
		ZoneInfoList outZoneInfoList = restApiClient.getZonesOfAccount(accountName,  "zone_type:PRIMARY", offset, limit, "NAME", reverse);

		Assert.assertNotNull(outZoneInfoList);
		Assert.assertNotNull(outZoneInfoList.getResultInfo());
		//Assert.assertEquals(8, outZoneInfoList.getResultInfo().getReturnedCount());
		Assert.assertNotNull(outZoneInfoList.getList());
		Assert.assertNotNull(outZoneInfoList.getList().get(0));
		Assert.assertNotNull(outZoneInfoList.getList().get(0).getProperties());
		//Assert.assertEquals(zoneName, outZoneInfoList.getList().get(0).getProperties().getName());
		Assert.assertEquals(ZoneType.PRIMARY, outZoneInfoList.getList().get(0).getProperties().getType());

        // Create a new RRSet of type 'A' & the primary zone created as part of test
        List<String> rdata = Arrays.asList("12.12.12.13");
        String ownerName = "selautomation10";
        Integer ttl = new Integer(300);
        restApiClient.createRRSet(zoneName, "A", ownerName, ttl, rdata);

        // List the RRSet of type 'A' & of the primary zone created as part of test
        RRSetList rrSetList =  restApiClient.getRRSetsByType(zoneName, "A", "owner:selautomation10", offset, limit, "TYPE", reverse);
		Assert.assertNotNull(rrSetList);
		Assert.assertNotNull(rrSetList.getResultInfo());
		Assert.assertEquals(1, rrSetList.getResultInfo().getReturnedCount());
		Assert.assertNotNull(rrSetList.getRrSets());
		Assert.assertEquals(1, rrSetList.getRrSets().size());
		Assert.assertEquals("A (1)", rrSetList.getRrSets().get(0).getRrtype());
		Assert.assertEquals(ownerName+"."+zoneName, rrSetList.getRrSets().get(0).getOwnerName());
		Assert.assertEquals(rdata, rrSetList.getRrSets().get(0).getRdata());
		Assert.assertEquals(ttl, rrSetList.getRrSets().get(0).getTtl());

		// List the RRSets of the primary zone created as part of test
		rrSetList =  restApiClient.getRRSets(zoneName, "owner:selautomation10", offset, limit, "TYPE", reverse);

		// By default 2 records (NS & SOA) would be automatically created with zone creation, so they must be returned
		Assert.assertNotNull(rrSetList);
		Assert.assertNotNull(rrSetList.getResultInfo());
		//Assert.assertEquals(2, rrSetList.getResultInfo().getReturnedCount());
		Assert.assertNotNull(rrSetList.getRrSets());
		//Assert.assertEquals(2, rrSetList.getRrSets().size());
		//Assert.assertEquals("NS (2)", rrSetList.getRrSets().get(0).getRrtype());
		//Assert.assertEquals("SOA (6)", rrSetList.getRrSets().get(1).getRrtype());

		// Update the existing RRSet of type 'A' & the primary zone created as part of test
		ttl = 500;
		restApiClient.updateRRSet(zoneName, "A", ownerName, ttl, rdata);
        // List the RRSets of the primary zone created as part of test
        rrSetList =  restApiClient.getRRSets(zoneName, "owner:selautomation10", offset, limit, "TYPE", reverse);
		
		// Delete the existing RRSet of type 'A' & the primary zone created as part of test
		restApiClient.deleteRRSet(zoneName, "A", ownerName);
		
		// Delete the zone created
		restApiClient.deleteZone(zoneName);
		
		// Get the account details for user
		AccountList accountList = restApiClient.getAccountDetails();

		Assert.assertNotNull(accountList);
		Assert.assertNotNull(accountList.getList());
		Assert.assertTrue(accountList.getList().size() > 0);
		Assert.assertTrue(accountList.getList().get(0).getNumberOfUsers() > 0);

		// Get the version of REST API server
		String outVersion = restApiClient.getVersion();
		Assert.assertNotNull(outVersion);
		
		// Get the status of REST API server
		String outStatus = restApiClient.getStatus();
		Assert.assertNotNull(outStatus);

	}
}

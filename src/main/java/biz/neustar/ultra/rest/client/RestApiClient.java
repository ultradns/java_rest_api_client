package biz.neustar.ultra.rest.client;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.http.HttpStatus;

import biz.neustar.ultra.rest.constants.ZoneType;
import biz.neustar.ultra.rest.dto.AccountList;
import biz.neustar.ultra.rest.dto.CreateType;
import biz.neustar.ultra.rest.dto.PrimaryZoneInfo;
import biz.neustar.ultra.rest.dto.RRSet;
import biz.neustar.ultra.rest.dto.RRSetList;
import biz.neustar.ultra.rest.dto.TokenResponse;
import biz.neustar.ultra.rest.dto.Zone;
import biz.neustar.ultra.rest.dto.ZoneList;
import biz.neustar.ultra.rest.dto.ZoneOutInfo;
import biz.neustar.ultra.rest.dto.ZoneProperties;
import biz.neustar.ultra.rest.main.ClientData;
import biz.neustar.ultra.rest.main.UltraRestClient;
import biz.neustar.ultra.rest.util.JsonUtils;

import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * Copyright 2012-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar
 * logo and related names and logos are registered trademarks, service marks or
 * tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */

public class RestApiClient {
	private UltraRestClient ultraRestClient;

	private final String baseUrl;

	// TODO - For later use
	private String refreshToken;

	/**
	 * Initialize an REST API client.
	 * 
	 * @param userName
	 *            - The user name
	 * @param password
	 *            - The user's password
	 * @param url
	 *            - Url of the remote server
	 */
	public RestApiClient(String userName, String password, String url) {
		this.baseUrl = url;
		ultraRestClient = UltraRestClient.createRestClientBasicAuth(url,
				userName, password);
		authorize(userName, password);
	}

	/**
	 * Authorize user.
	 * 
	 * @param userName
	 * @param password
	 */
	private void authorize(String userName, String password) {
		MultivaluedMap<String, String> form = new MultivaluedMapImpl();
		form.add("username", userName);
		form.add("password", password);
		form.add("grant_type", "password");
		ClientData clientData = ultraRestClient.post("v1/authorization/token",
				form);
		// Use the returned token to setup an oauth client
		if (HttpStatus.SC_OK == clientData.getStatus()) {
			try {
				TokenResponse tokenResponse = JsonUtils.jsonToObject(
						clientData.getBody(), TokenResponse.class);
				// TODO - Need to check if we need to call
				// createRestClientOAuth. Currently a similar implementation is
				// present in BaseCucumberMethods.
				ultraRestClient = UltraRestClient.createRestClientOAuth(
						baseUrl, tokenResponse.getAccessToken());
				refreshToken = tokenResponse.getRefreshToken();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Create a primary zone.
	 * 
	 * @param accountName
	 *            - The account that the zone will be created under. The user
	 *            must have write access for zones in that account
	 * @param zoneName
	 *            - The name of the zone. The trailing . is optional. The zone
	 *            name must not be in use by anyone
	 * @return - Status message
	 * @throws IOException
	 *             - {@link IOException}
	 */
	public String createPrimaryZone(String accountName, String zoneName)
			throws IOException {

		ZoneProperties zoneProperties = new ZoneProperties(zoneName,
				accountName, ZoneType.PRIMARY, null, null, null);
		PrimaryZoneInfo primaryZoneInfo = new PrimaryZoneInfo(null,
				CreateType.NEW, null, null, null);
		Zone zone = new Zone(zoneProperties, primaryZoneInfo, null, null);
		String url = "v1/zones/";
		ClientData clientData = ultraRestClient.post(url,
				JsonUtils.objectToJson(zone));
		if (clientData.getStatus() == HttpStatus.SC_CREATED) {
			return clientData.getBody();
		}
		// TODO - Need to check how to handle the errors
		throw new RuntimeException("Failed : HTTP error code : "
				+ clientData.getStatus() + "Error : " + clientData.getBody());
	}

	/**
	 * List zones for account.
	 * 
	 * @param accountName
	 *            - One of the user's accounts. The user must have read access
	 *            for zone in that account
	 * @param q
	 *            - The search parameters, in a hash. Valid keys are: 
	 *            	name - substring match of the zone name 
	 *            	zone_type - one of : PRIMARY/SECONDARY/ALIAS
	 * @param offset
	 *            - The position in the list for the first returned element(0
	 *            based)
	 * @param limit
	 *            - The maximum number of zones to be returned
	 * @param sort
	 *            - The sort column used to order the list. Valid values for the
	 *            sort field are: NAME/ACCOUNT_NAME/RECORD_COUNT/ZONE_TYPE
	 * @param reverse
	 *            - Whether the list is ascending(false) or descending(true).
	 *            Defaults to true
	 * @return - {@link ZoneList}
	 * @throws IOException
	 *             - {@link IOException}
	 */
	public ZoneList getZonesOfAccount(String accountName, String q,
			String offset, String limit, String sort, String reverse)
			throws IOException {
		MultivaluedMap<String, String> queryParams = buildQueryParams(q,
				offset, limit, sort, reverse);
		String url = "v1/accounts/" + accountName + "/zones";
		ClientData clientData = ultraRestClient.get(url, queryParams);
		if (clientData.getStatus() == HttpStatus.SC_OK) {
			return JsonUtils.jsonToObject(clientData.getBody(), ZoneList.class);
		}
		// TODO - Need to check how to handle the errors
		throw new RuntimeException("Status: " + clientData.getStatus()
				+ ", Description: " + clientData.getBody());
	}

	/**
	 * Get zone metadata.
	 * 
	 * @param zoneName
	 *            - The name of the zone. The user must have read access to the
	 *            zone.
	 * @return - {@link ZoneOutInfo}
	 * @throws IOException
	 *             - {@link IOException}
	 */
	public ZoneOutInfo getZoneMetadata(String zoneName) throws IOException {
		String url = "v1/zones/" + zoneName;
		ClientData clientData = ultraRestClient.get(url);
		if (clientData.getStatus() == HttpStatus.SC_OK) {
			return JsonUtils.jsonToObject(clientData.getBody(),
					ZoneOutInfo.class);
		}
		// TODO - Need to check how to handle the errors
		throw new RuntimeException("Failed : HTTP error code : "
				+ clientData.getStatus() + "Error : " + clientData.getBody());
	}

	/**
	 * Delete a zone.
	 * 
	 * @param zoneName
	 *            - The name of the zone
	 */
	public void deleteZone(String zoneName) {
		String url = "v1/zones/" + zoneName;
		ClientData clientData = ultraRestClient.delete(url);
		if (clientData.getStatus() != HttpStatus.SC_NO_CONTENT) {
			// TODO - Need to check how to handle the errors
			throw new RuntimeException("Failed : HTTP error code : "
					+ clientData.getStatus() + "Error : "
					+ clientData.getBody());
		}
	}

	/**
	 * Returns the list of RRSets in the specified zone.
	 * 
	 * @param zoneName
	 *            - The name of the zone. The user must have read access to the
	 *            zone.
	 * @param q
	 *            - The search parameters, in a hash. Valid keys are: 
	 *            	ttl - must match the TTL for the rrset 
	 *            	owner - substring match of the owner name 
	 *            	value - substring match of the first BIND field value
	 * @param offset
	 *            - The position in the list for the first returned element(0
	 *            based)
	 * @param limit
	 *            - The maximum number of zones to be returned.
	 * @param sort
	 *            - The sort column used to order the list. Valid values for the
	 *            sort field are: OWNER/TTL/TYPE
	 * @param reverse
	 *            - Whether the list is ascending(false) or descending(true).
	 *            Defaults to true
	 * @return - {@link RRSetList}
	 * @throws IOException
	 *             - {@link IOException}
	 */
	public RRSetList getRRSets(String zoneName, String q, String offset,
			String limit, String sort, String reverse) throws IOException {
		MultivaluedMap<String, String> queryParams = buildQueryParams(q,
				offset, limit, sort, reverse);

		String url = "v1/zones/" + zoneName + "/rrsets";
		ClientData clientData = ultraRestClient.post(url, queryParams);
		if (clientData.getStatus() == HttpStatus.SC_OK) {
			return JsonUtils
					.jsonToObject(clientData.getBody(), RRSetList.class);
		}
		// TODO - Need to check how to handle the errors
		throw new RuntimeException("Failed : HTTP code : "
				+ clientData.getStatus() + " Error : " + clientData.getBody());
	}

	/**
	 * Returns the list of RRSets in the specified zone of the specified type.
	 * 
	 * @param zoneName
	 *            - The name of the zone.
	 * @param recordType
	 *            - The type of the RRSets. This can be numeric (1) or if a
	 *            well-known name is defined for the type (A), you can use it
	 *            instead.
	 * @param q
	 *            - The search parameters, in a hash. Valid keys are: 
	 *            	ttl - must match the TTL for the rrset 
	 *            	owner - substring match of the owner name 
	 *            	value - substring match of the first BIND field value
	 * @param offset
	 *            - The position in the list for the first returned element(0
	 *            based)
	 * @param limit
	 *            - The maximum number of zones to be returned.
	 * @param sort
	 *            - The sort column used to order the list. Valid values for the
	 *            sort field are: OWNER/TTL/TYPE
	 * @param reverse
	 *            - Whether the list is ascending(false) or descending(true).
	 *            Defaults to true
	 * @return - {@link RRSetList}
	 * @throws IOException
	 *             - {@link IOException}
	 */
	public RRSetList getRRSetsByType(String zoneName, String recordType,
			String q, String offset, String limit, String sort, String reverse)
			throws IOException {
		MultivaluedMap<String, String> queryParams = buildQueryParams(q,
				offset, limit, sort, reverse);

		String url = "v1/zones/" + zoneName + "/rrsets/" + recordType;
		ClientData clientData = ultraRestClient.post(url, queryParams);
		if (clientData.getStatus() == HttpStatus.SC_OK) {
			return JsonUtils
					.jsonToObject(clientData.getBody(), RRSetList.class);
		}
		// TODO - Need to check how to handle the errors
		throw new RuntimeException("Failed : HTTP code : "
				+ clientData.getStatus() + " Error : " + clientData.getBody());
	}

	/**
	 * Creates a new RRSet in the specified zone.
	 * 
	 * @param zoneName
	 *            - The zone that contains the RRSet.The trailing dot is
	 *            optional.
	 * @param recordType
	 *            - The type of the RRSet.This can be numeric (1) or if a
	 *            well-known name is defined for the type (A), you can use it
	 *            instead.
	 * @param ownerName
	 *            - The owner name for the RRSet. If no trailing dot is
	 *            supplied, the owner_name is assumed to be relative (foo). If a
	 *            trailing dot is supplied, the owner name is assumed to be
	 *            absolute (foo.zonename.com.)
	 * @param ttl
	 *            - The updated TTL value for the RRSet.
	 * @param rdata
	 *            - The updated BIND data for the RRSet as a string. If there is
	 *            a single resource record in the RRSet, you can pass in the
	 *            single string or an array with a single element. If there are
	 *            multiple resource records in this RRSet, pass in a list of
	 *            strings.
	 * @return - Status message
	 * @throws IOException
	 *             - {@link IOException}
	 */
	public String createRRSet(String zoneName, String recordType,
			String ownerName, Integer ttl, List<String> rdata)
			throws IOException {

		RRSet rrSet = new RRSet(zoneName, ownerName, "default", 0L, recordType,
				ttl, rdata, null);

		String url = "v1/zones/" + zoneName + "/rrsets/" + recordType + "/"
				+ ownerName;
		ClientData clientData = ultraRestClient.post(url,
				JsonUtils.objectToJson(rrSet));
		if (clientData.getStatus() == HttpStatus.SC_CREATED) {
			return clientData.getBody();
		}
		// TODO - Need to check how to handle the errors
		throw new RuntimeException("Failed : HTTP error code : "
				+ clientData.getStatus() + " Error : " + clientData.getBody());
	}

	/**
	 * Updates an existing RRSet in the specified zone.
	 * 
	 * @param zoneName
	 *            - The zone that contains the RRSet.The trailing dot is
	 *            optional.
	 * @param recordType
	 *            - The type of the RRSet.This can be numeric (1) or if a
	 *            well-known name is defined for the type (A), you can use it
	 *            instead.
	 * @param ownerName
	 *            - The owner name for the RRSet. If no trailing dot is
	 *            supplied, the owner_name is assumed to be relative (foo). If a
	 *            trailing dot is supplied, the owner name is assumed to be
	 *            absolute (foo.zonename.com.)
	 * @param ttl
	 *            - The updated TTL value for the RRSet.
	 * @param rdata
	 *            - The updated BIND data for the RRSet as a string. If there is
	 *            a single resource record in the RRSet, you can pass in the
	 *            single string or an array with a single element. If there are
	 *            multiple resource records in this RRSet, pass in a list of
	 *            strings.
	 * @return - Status message
	 * @throws IOException
	 *             - {@link IOException}
	 */
	public String updateRRSet(String zoneName, String recordType,
			String ownerName, Integer ttl, List<String> rdata)
			throws IOException {

		RRSet rrSet = new RRSet(zoneName, ownerName, "default", 0L, recordType,
				ttl, rdata, null);

		String url = "v1/zones/" + zoneName + "/rrsets/" + recordType + "/"
				+ ownerName + "/default";
		ClientData clientData = ultraRestClient.post(url,
				JsonUtils.objectToJson(rrSet));
		if (clientData.getStatus() == HttpStatus.SC_OK) {
			return clientData.getBody();
		}
		// TODO - Need to check how to handle the errors
		throw new RuntimeException("Failed : HTTP error code : "
				+ clientData.getStatus() + " Error : " + clientData.getBody());
	}

	/**
	 * Delete an RRSet.
	 * 
	 * @param zoneName
	 *            - The zone containing the RRSet to be deleted. The trailing
	 *            dot is optional.
	 * @param recordType
	 *            - The type of the RRSet.This can be numeric (1) or if a
	 *            well-known name is defined for the type (A), you can use it
	 *            instead.
	 * @param ownerName
	 *            - The owner name for the RRSet. If no trailing dot is
	 *            supplied, the owner_name is assumed to be relative (foo). If a
	 *            trailing dot is supplied, the owner name is assumed to be
	 *            absolute (foo.zonename.com.)
	 */
	public void deleteRRSet(String zoneName, String recordType, String ownerName) {
		String url = "v1/zones/" + zoneName + "/rrsets/" + recordType + "/"
				+ ownerName;
		ClientData clientData = ultraRestClient.delete(url);
		if (clientData.getStatus() != HttpStatus.SC_NO_CONTENT) {
			// TODO - Need to check how to handle the errors
			throw new RuntimeException("Failed : HTTP error code : "
					+ clientData.getStatus() + "Error : "
					+ clientData.getBody());
		}
	}

	/**
	 * Get account details for user.
	 * 
	 * @return - {@link AccountList}
	 * @throws IOException
	 *             - {@link IOException}
	 */
	public AccountList getAccountDetails() throws IOException {
		String url = "v1/accounts";
		ClientData clientData = ultraRestClient.get(url);
		if (clientData.getStatus() == HttpStatus.SC_OK) {
			return JsonUtils.jsonToObject(clientData.getBody(),
					AccountList.class);
		}
		// TODO - Need to check how to handle the errors
		throw new RuntimeException("Failed : HTTP error code : "
				+ clientData.getStatus() + "Error : " + clientData.getBody());
	}

	/**
	 * Get version of REST API server.
	 * 
	 * @return - The version of REST API server
	 */
	public String getVersion() {
		return ultraRestClient.get("v1/version").getBody();
	}

	/**
	 * Get status of REST API server.
	 * 
	 * @return - The status of REST API server
	 */
	public String getStatus() {
		ClientData clientData = ultraRestClient.get("v1/status");
		return clientData.getBody();
	}

	private MultivaluedMap<String, String> buildQueryParams(String q,
			String offset, String limit, String sort, String reverse) {
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("q", q);
		queryParams.add("offset", offset);
		queryParams.add("limit", limit);
		queryParams.add("sort", sort);
		queryParams.add("reverse", reverse);

		return queryParams;
	}
}

package biz.neustar.ultra.rest.client;

import biz.neustar.ultra.rest.client.util.JsonUtils;
import biz.neustar.ultra.rest.constants.CreateType;
import biz.neustar.ultra.rest.constants.RRListSortType;
import biz.neustar.ultra.rest.constants.ZoneListSortType;
import biz.neustar.ultra.rest.constants.ZoneType;
import biz.neustar.ultra.rest.dto.AccountList;
import biz.neustar.ultra.rest.dto.PrimaryZoneInfo;
import biz.neustar.ultra.rest.dto.RRSet;
import biz.neustar.ultra.rest.dto.RRSetList;
import biz.neustar.ultra.rest.dto.Status;
import biz.neustar.ultra.rest.dto.Version;
import biz.neustar.ultra.rest.dto.Zone;
import biz.neustar.ultra.rest.dto.ZoneInfoList;
import biz.neustar.ultra.rest.dto.ZoneOutInfo;
import biz.neustar.ultra.rest.dto.ZoneProperties;
import biz.neustar.ultra.rest.main.ClientData;
import biz.neustar.ultra.rest.main.UltraRestClient;
import biz.neustar.ultra.rest.main.UltraRestClientFactory;
import biz.neustar.ultra.rest.main.auth.OAuth;
import com.google.common.base.Strings;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.List;

/**
 * Copyright 2012-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar
 * logo and related names and logos are registered trademarks, service marks or
 * tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */

public class RestApiClient {
    private final static Logger LOG = LoggerFactory.getLogger(RestApiClient.class);

    private final UltraRestClient ultraRestClient;

    public static RestApiClient buildRestApiClientWithTokens(String accessToken, String refreshToken, String url, OAuth.Callback callback) {
        return new RestApiClient(
                UltraRestClientFactory.createRestClientOAuthTokensCallback(url, accessToken,
                refreshToken, "/v1/authorization/token",callback));
    }

    public static RestApiClient buildRestApiClientWithUidPwd(String username, String password, String url, OAuth.Callback callback) {
        return new RestApiClient(
                UltraRestClientFactory.createRestClientOAuthUserPwdCallback(url, username,
                        password, "/v1/authorization/token", callback));
    }

    private RestApiClient(UltraRestClient ultraRestClient) {
        this.ultraRestClient = ultraRestClient;
    }

    public RestApiClient(String userName, String password, String url) {
		ultraRestClient = UltraRestClientFactory.createRestClientOAuthUserPwd(url,
                userName, password, "/v1/authorization/token");
	}

    public RestApiClient(String userName, String password, String url, OAuth.Callback callback) {
        ultraRestClient = UltraRestClientFactory.createRestClientOAuthUserPwdCallback(url,
                userName, password, "/v1/authorization/token", callback);
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
        ClientData clientData = ultraRestClient.post(url, JsonUtils.objectToJson(zone));
        checkClientData(clientData);
        return clientData.getBody();
	}

    private void checkClientData(ClientData clientData) {
        if(clientData.getStatus() >= 400) {
            throw new RuntimeException("Status: " + clientData.getStatus()
                    + ", Description: " + clientData.getBody());
        }
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
	 * @return - {@link ZoneInfoList}
	 * @throws IOException
	 *             - {@link IOException}
	 */
	public ZoneInfoList getZonesOfAccount(String accountName, String q,
			int offset, int limit, ZoneListSortType sort, boolean reverse)
			throws IOException {
		MultivaluedMap<String, String> queryParams = buildQueryParams(q,
				offset, limit, sort, reverse);
		String url = "v1/accounts/" + accountName + "/zones";
        ClientData clientData = ultraRestClient.get(url, queryParams);
        checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), ZoneInfoList.class);
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
        checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), ZoneOutInfo.class);
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
        checkClientData(clientData);
        System.out.println(clientData.getStatus());
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
	public RRSetList getRRSets(String zoneName, String q, int offset,
			int limit, RRListSortType sort, boolean reverse) throws IOException {
		MultivaluedMap<String, String> queryParams = buildQueryParams(q,
                offset, limit, sort, reverse);

		String url = "v1/zones/" + zoneName + "/rrsets";
		ClientData clientData = ultraRestClient.get(url, queryParams);
        checkClientData(clientData);
        return JsonUtils
                .jsonToObject(clientData.getBody(), RRSetList.class);
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
			String q, int offset, int limit, RRListSortType sort, boolean reverse)
			throws IOException {
		MultivaluedMap<String, String> queryParams = buildQueryParams(q,
				offset, limit, sort, reverse);

		String url = "v1/zones/" + zoneName + "/rrsets/" + recordType;
		ClientData clientData = ultraRestClient.get(url, queryParams);
        checkClientData(clientData);
        return JsonUtils
                .jsonToObject(clientData.getBody(), RRSetList.class);
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
        checkClientData(clientData);
        return clientData.getBody();
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
		ClientData clientData = ultraRestClient.put(url,
				JsonUtils.objectToJson(rrSet));
        checkClientData(clientData);
        return clientData.getBody();
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
        checkClientData(clientData);
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
        checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(),
                AccountList.class);
	}

	/**
	 * Get version of REST API server.
	 * 
	 * @return - The version of REST API server
	 */
	public Version getVersion() throws IOException {
        ClientData clientData = ultraRestClient.get("v1/version");
        checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), Version.class);
	}

	/**
	 * Get status of REST API server.
	 * 
	 * @return - The status of REST API server
	 */
	public Status getStatus() throws IOException {
		ClientData clientData = ultraRestClient.get("v1/status");
        checkClientData(clientData);
		return JsonUtils.jsonToObject(clientData.getBody(), Status.class);
	}

	private MultivaluedMap<String, String> buildQueryParams(String q,
			int offset, int limit, Enum sort, boolean reverse) {
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		if (!Strings.isNullOrEmpty(q)) {
			queryParams.add("q", q);
		}
		queryParams.add("offset", Integer.toString(offset,10));
		queryParams.add("limit", Integer.toString(limit,10));
		queryParams.add("sort", sort.toString());
		queryParams.add("reverse", Boolean.toString(reverse));

		return queryParams;
	}
}

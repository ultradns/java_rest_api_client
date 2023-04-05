package com.ultradns.ultra.rest.client;

import com.ultradns.ultra.rest.client.util.JsonUtils;
import com.ultradns.ultra.rest.constants.UltraRestSharedConstant;
import com.ultradns.ultra.rest.constants.ZoneType;
import com.ultradns.ultra.rest.dto.AccountList;
import com.ultradns.ultra.rest.dto.AlertDataList;
import com.ultradns.ultra.rest.dto.BatchRequest;
import com.ultradns.ultra.rest.dto.BatchResponse;
import com.ultradns.ultra.rest.dto.CreateType;
import com.ultradns.ultra.rest.dto.DnsSecInfo;
import com.ultradns.ultra.rest.dto.NameServerIpList;
import com.ultradns.ultra.rest.dto.PrimaryNameServers;
import com.ultradns.ultra.rest.dto.PrimaryZoneInfo;
import com.ultradns.ultra.rest.dto.ProbeInfo;
import com.ultradns.ultra.rest.dto.ProbeInfoList;
import com.ultradns.ultra.rest.dto.RRSet;
import com.ultradns.ultra.rest.dto.RRSetList;
import com.ultradns.ultra.rest.dto.SBTCNotification;
import com.ultradns.ultra.rest.dto.SBTCNotificationList;
import com.ultradns.ultra.rest.dto.SecondaryZoneInfo;
import com.ultradns.ultra.rest.dto.Status;
import com.ultradns.ultra.rest.dto.TaskStatusInfo;
import com.ultradns.ultra.rest.dto.TokenResponse;
import com.ultradns.ultra.rest.dto.Version;
import com.ultradns.ultra.rest.dto.WebForward;
import com.ultradns.ultra.rest.dto.WebForwardList;
import com.ultradns.ultra.rest.dto.Zone;
import com.ultradns.ultra.rest.dto.ZoneInfoList;
import com.ultradns.ultra.rest.dto.ZoneOutInfo;
import com.ultradns.ultra.rest.dto.ZoneProperties;
import com.ultradns.ultra.rest.main.ClientData;
import com.ultradns.ultra.rest.main.UltraRestClient;
import com.ultradns.ultra.rest.main.UltraRestClientFactory;
import com.ultradns.ultra.rest.main.auth.OAuth;
import com.ultradns.ultra.rest.main.auth.PasswordAuth;
import com.google.common.base.Strings;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.ultradns.ultra.rest.client.exception.UltraClientErrors;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

/**
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */

@SuppressWarnings({
                          "PMD.TooManyMethods",
                          "PMD.ExcessivePublicCount"
                  })
public class RestApiClient {
    public static final String ACCOUNTS = "accounts";
    public static final String VERSION = "version";
    public static final String STATUS = "status";
    public static final String ACCOUNTS1 = "accounts/";
    private static final String ZONES = "zones/";
    private static final String RRSETS = "/rrsets/";
    private static final String TYPEA = "A";
    private static final String PROBES = "/probes";
    private static final String ALERTS = "/alerts";
    private static final String NOTIFICATIONS = "/notifications/";
    private static final String AUTHORIZATION_TOKEN = "/authorization/token";
    private static final String TASK = "/tasks/";
    private static final String WEB_FORWARDS = "/webforwards";
    private static final String UNSUSPEND = "/unsuspend";
    private static final String BATCH = "batch";
    private static final String SUB_ACCOUNTS = "subaccounts/";
    private static final String TOKEN = "/token";
    private static final String DNSSEC = "/dnssec";
    private static final String V3 = "/v3/";

    private static final int BASE_10_RADIX = 10;

    private final UltraRestClient ultraRestClient;

    private RestApiClient(UltraRestClient ultraRestClient) {
        this.ultraRestClient = ultraRestClient;
    }

    public RestApiClient(String userName, String password, String url) {
        ultraRestClient = UltraRestClientFactory.createRestClientOAuthUserPwd(url, userName, password,
                AUTHORIZATION_TOKEN);
    }

    public RestApiClient(String userName, String password, String url, OAuth.Callback callback) {
        ultraRestClient = UltraRestClientFactory.createRestClientOAuthUserPwdCallback(url, userName, password,
                AUTHORIZATION_TOKEN, callback);
    }

    public static RestApiClient buildRestApiClientWithTokens(String accessToken, String refreshToken, String url,
            OAuth.Callback callback) {
        return new RestApiClient(
                UltraRestClientFactory.createRestClientOAuthTokensCallback(url, accessToken, refreshToken,
                        AUTHORIZATION_TOKEN, callback));
    }

    public static RestApiClient buildRestApiClientWithUidPwd(String username, String password, String url,
            OAuth.Callback callback) {
        return new RestApiClient(UltraRestClientFactory.createRestClientOAuthUserPwdCallback(url, username, password,
                AUTHORIZATION_TOKEN, callback));
    }

    public static RestApiClient buildRestApiClientWithUidPwd(String username, String url,
            PasswordAuth.Callback callback) {
        return new RestApiClient(
                UltraRestClientFactory.createRestClientPasswordAuthUserPwd(url, username, AUTHORIZATION_TOKEN,
                        callback));
    }

    /**
     * Create a primary zone.
     *
     * @param accountName - The account that the zone will be created under. The user must have write access for zones
     *                    in that account
     * @param zoneName    - The name of the zone. The trailing . is optional. The zone name must not be in use by
     *                    anyone
     * @return - Status message
     * @throws IOException - {@link IOException}
     */
    public String createPrimaryZone(String accountName, String zoneName) throws IOException {

        ZoneProperties zoneProperties = new ZoneProperties(zoneName, accountName, ZoneType.PRIMARY, null, null, null);
        PrimaryZoneInfo primaryZoneInfo = new PrimaryZoneInfo(null, CreateType.NEW, null, null, null, null, null, null);
        Zone zone = new Zone(zoneProperties, primaryZoneInfo, null, null);
        String url = ZONES;
        ClientData clientData = ultraRestClient.post(url, JsonUtils.objectToJson(zone));
        UltraClientErrors.checkClientData(clientData);
        return clientData.getBody();
    }

    /**
     * Create a secondary zone.
     *
     * @param accountName              - The account that the zone will be created under. The user must have write
     *                                 access for zones in that account
     * @param zoneName                 - The name of the zone. The trailing . is optional. The zone name must not be in
     *                                 use by anyone
     * @param nameServerIpList         - The primary name servers of the source zone for the secondary zone.
     * @param notificationEmailAddress - The Notification Email for a secondary zone.
     * @return - The task id of the secondary zone creation request
     * @throws IOException - {@link IOException}
     */
    public String createSecondaryZone(String accountName, String zoneName, NameServerIpList nameServerIpList,
            String notificationEmailAddress) throws IOException {
        ZoneProperties zoneProperties = new ZoneProperties(zoneName, accountName, ZoneType.SECONDARY, null, null, null);

        SecondaryZoneInfo secondaryZoneInfo = new SecondaryZoneInfo(new PrimaryNameServers(nameServerIpList));
        secondaryZoneInfo.setNotificationEmailAddress(notificationEmailAddress);

        return createSecondaryZone(zoneProperties, secondaryZoneInfo);
    }

    /**
     * Create a secondary zone.
     *
     * @param zoneProperties    - {@link ZoneProperties}
     * @param secondaryZoneInfo - {@link SecondaryZoneInfo}
     * @return - The task id of the secondary zone creation request
     * @throws IOException - {@link IOException}
     */
    public String createSecondaryZone(ZoneProperties zoneProperties, SecondaryZoneInfo secondaryZoneInfo)
            throws IOException {
        Zone zone = new Zone(zoneProperties, null, secondaryZoneInfo, null);
        String url = ZONES;
        ClientData clientData = ultraRestClient.post(url, JsonUtils.objectToJson(zone));
        UltraClientErrors.checkClientData(clientData);
        return clientData.getHeaders().getFirst(UltraRestSharedConstant.X_TASK_ID.getValue());
    }

    /**
     * Update a secondary zone.
     *
     * @param zoneName                 - The name of the zone. The trailing . is optional. The zone name must not be in
     *                                 use by anyone
     * @param nameServerIpList         - The primary name servers of the source zone for the secondary zone.
     * @param notificationEmailAddress - The Notification Email for a secondary zone.
     * @return - Status message
     * @throws IOException - {@link IOException}
     */
    public String updateSecondaryZone(String zoneName, NameServerIpList nameServerIpList,
            String notificationEmailAddress) throws IOException {

        SecondaryZoneInfo secondaryZoneInfo = new SecondaryZoneInfo(new PrimaryNameServers(nameServerIpList));
        secondaryZoneInfo.setNotificationEmailAddress(notificationEmailAddress);
        Zone zone = new Zone(null, null, secondaryZoneInfo, null);
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue());
        ClientData clientData = ultraRestClient.put(url, JsonUtils.objectToJson(zone));
        UltraClientErrors.checkClientData(clientData);
        return clientData.getBody();
    }

    /**
     * Get the task status.
     *
     * @param taskId - The task id.
     * @return - The task status of the provided task id.
     * @throws IOException - {@link IOException}
     */
    public TaskStatusInfo getTaskStatus(String taskId) throws IOException {
        String url = TASK + taskId;
        ClientData clientData = ultraRestClient.get(url);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), TaskStatusInfo.class);
    }

    /**
     * List zones for account.
     *
     * Please use getZoneListByCursor instead
     *
     * @param accountName - One of the user's accounts. The user must have read access for zone in that account
     * @param q           - The search parameters, in a hash. Valid keys are: name - substring match of the zone name
     *                    zone_type - one of : PRIMARY/SECONDARY/ALIAS
     * @param offset      - The position in the list for the first returned element(0 based)
     * @param limit       - The maximum number of zones to be returned
     * @param sort        - The sort column used to order the list. Valid values for the sort field are:
     *                    NAME/ACCOUNT_NAME/RECORD_COUNT/ZONE_TYPE
     * @param reverse     - Whether the list is ascending(false) or descending(true). Defaults to true
     * @return - {@link ZoneInfoList}
     * @throws IOException - {@link IOException}
     */
    @Deprecated
    public ZoneInfoList getZonesOfAccount(String accountName, String q, int offset, int limit,
            UltraRestSharedConstant.ZoneListSortType sort, boolean reverse) throws IOException {
        String q2 = q;
        if (!Strings.isNullOrEmpty(accountName)) {
            String accountCond = "account_name:"
                    + URLEncoder.encode(accountName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue())
                    .replaceAll("\\+", "%20");
            q2 = Strings.isNullOrEmpty(q2) ? accountCond : (q2 + " " + accountCond);
        }
        MultivaluedMap<String, String> queryParams = buildQueryParams(q2, offset, limit, sort, reverse);
        String url = "/zones";
        ClientData clientData = ultraRestClient.get(url, queryParams);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), ZoneInfoList.class);
    }

    /**
     * List zones using cursor.
     *
     * @param q      - name – The name of the zone to return (allows for partial string matches)
     * @param cursor - Returned after the initial List Zones request. Use with the cursorInfo details for fetching the
     *               next or previous page(s).
     * @param limit  - The maximum number of rows requested. If not provided, the default value is 100.
     * @return - {@link ZoneInfoList}
     * @throws IOException - {@link IOException}
     */
    public ZoneInfoList getZoneListByCursor(String q, String cursor, int limit) throws IOException {
        MultivaluedMap<String, String> queryParams = buildQueryParams(q, null, limit, null, null, cursor);
        String url = V3 + ZONES;
        ClientData clientData = ultraRestClient.get(url, queryParams);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), ZoneInfoList.class);
    }

    /**
     * Get zone metadata.
     *
     * @param zoneName - The name of the zone. The user must have read access to the zone.
     * @return - {@link ZoneOutInfo}
     * @throws IOException - {@link IOException}
     */
    public ZoneOutInfo getZoneMetadata(String zoneName) throws IOException {
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue());
        ClientData clientData = ultraRestClient.get(url);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), ZoneOutInfo.class);
    }

    /**
     * Unsuspend a zone.
     *
     * @param zoneName - The name of the zone
     */
    public Status unsuspendZone(String zoneName) throws IOException {
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + UNSUSPEND;
        ClientData clientData = ultraRestClient.post(url);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), Status.class);
    }

    /**
     * Delete a zone.
     *
     * @param zoneName - The name of the zone
     */
    public void deleteZone(String zoneName) throws IOException {
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue());
        ClientData clientData = ultraRestClient.delete(url);
        UltraClientErrors.checkClientData(clientData);
        System.out.println(clientData.getStatus());
    }

    /**
     * Returns the list of RRSets in the specified zone.
     *
     * @param zoneName - The name of the zone. The user must have read access to the zone.
     * @param q        - The search parameters, in a hash. Valid keys are: ttl - must match the TTL for the rrset owner
     *                 - substring match of the owner name value - substring match of the first BIND field value
     * @param offset   - The position in the list for the first returned element(0 based)
     * @param limit    - The maximum number of zones to be returned.
     * @param sort     - The sort column used to order the list. Valid values for the sort field are: OWNER/TTL/TYPE
     * @param reverse  - Whether the list is ascending(false) or descending(true). Defaults to true
     * @return - {@link RRSetList}
     * @throws IOException - {@link IOException}
     */
    public RRSetList getRRSets(String zoneName, String q, int offset, int limit,
            UltraRestSharedConstant.RRListSortType sort, boolean reverse) throws IOException {
        MultivaluedMap<String, String> queryParams = buildQueryParams(q, offset, limit, sort, reverse);

        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + "/rrsets";
        ClientData clientData = ultraRestClient.get(url, queryParams);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), RRSetList.class);
    }

    /**
     * Returns the list of RRSets in the specified zone of the specified type.
     *
     * @param zoneName   - The name of the zone.
     * @param recordType - The type of the RRSets. This can be numeric (1) or if a well-known name is defined for the
     *                   type (A), you can use it instead.
     * @param q          - The search parameters, in a hash. Valid keys are: ttl - must match the TTL for the rrset
     *                   owner - substring match of the owner name value - substring match of the first BIND field
     *                   value
     * @param offset     - The position in the list for the first returned element(0 based)
     * @param limit      - The maximum number of zones to be returned.
     * @param sort       - The sort column used to order the list. Valid values for the sort field are: OWNER/TTL/TYPE
     * @param reverse    - Whether the list is ascending(false) or descending(true). Defaults to true
     * @return - {@link RRSetList}
     * @throws IOException - {@link IOException}
     */
    public RRSetList getRRSetsByType(String zoneName, String recordType, String q, int offset, int limit,
            UltraRestSharedConstant.RRListSortType sort, boolean reverse) throws IOException {
        MultivaluedMap<String, String> queryParams = buildQueryParams(q, offset, limit, sort, reverse);

        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + RRSETS
                + recordType;
        ClientData clientData = ultraRestClient.get(url, queryParams);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), RRSetList.class);
    }

    /**
     * Creates a new RRSet in the specified zone.
     *
     * @param zoneName   - The zone that contains the RRSet.The trailing dot is optional.
     * @param recordType - The type of the RRSet.This can be numeric (1) or if a well-known name is defined for the type
     *                   (A), you can use it instead.
     * @param ownerName  - The owner name for the RRSet. If no trailing dot is supplied, the owner_name is assumed to be
     *                   relative (foo). If a trailing dot is supplied, the owner name is assumed to be absolute
     *                   (foo.zonename.com.)
     * @param ttl        - The updated TTL value for the RRSet.
     * @param rdata      - The updated BIND data for the RRSet as a string. If there is a single resource record in the
     *                   RRSet, you can pass in the single string or an array with a single element. If there are
     *                   multiple resource records in this RRSet, pass in a list of strings.
     * @return - Status message
     * @throws IOException - {@link IOException}
     */
    public String createRRSet(String zoneName, String recordType, String ownerName, Integer ttl, List<String> rdata)
            throws IOException {

        RRSet rrSet = new RRSet(zoneName, ownerName, recordType, ttl, rdata, null);
        return createRRSet(zoneName, rrSet);
    }

    /**
     * Creates a new RRSet in the specified zone.
     *
     *
     * @param zoneName
     * @param zoneName   - The zone that contains the RRSet.The trailing dot is optional.
     * @param rrSet      - rrSet to be created.
     * @return - Status message
     * @throws IOException - {@link IOException}
     */
    public String createRRSet(String zoneName, RRSet rrSet)
            throws IOException {

        String type = rrSet.getRrtype().replaceFirst(" *\\(\\d+\\)", "");
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue())
                + RRSETS
                + type + "/" + rrSet.getOwnerName();
        ClientData clientData = ultraRestClient.post(url, JsonUtils.objectToJson(rrSet));
        UltraClientErrors.checkClientData(clientData);
        return clientData.getBody();
    }

    /**
     * Updates an existing RRSet in the specified zone.
     *
     * @param zoneName   - The zone that contains the RRSet.The trailing dot is optional.
     * @param recordType - The type of the RRSet.This can be numeric (1) or if a well-known name is defined for the type
     *                   (A), you can use it instead.
     * @param ownerName  - The owner name for the RRSet. If no trailing dot is supplied, the owner_name is assumed to be
     *                   relative (foo). If a trailing dot is supplied, the owner name is assumed to be absolute
     *                   (foo.zonename.com.)
     * @param ttl        - The updated TTL value for the RRSet.
     * @param rdata      - The updated BIND data for the RRSet as a string. If there is a single resource record in the
     *                   RRSet, you can pass in the single string or an array with a single element. If there are
     *                   multiple resource records in this RRSet, pass in a list of strings.
     * @return - Status message
     * @throws IOException - {@link IOException}
     */
    public String updateRRSet(String zoneName, String recordType, String ownerName, Integer ttl, List<String> rdata)
            throws IOException {

        RRSet rrSet = new RRSet(zoneName, ownerName, recordType, ttl, rdata, null);
        return updateRRSet(zoneName, rrSet);
    }

    /**
     * Updates an existing RRSet in the specified zone.
     *
     *
     * @param zoneName
     * @param zoneName   - The zone that contains the RRSet.The trailing dot is optional.
     * @param rrSet      - rrSet to be created.
     * @return - Status message
     * @throws IOException - {@link IOException}
     */
    public String updateRRSet(String zoneName, RRSet rrSet)
            throws IOException {

        String type = rrSet.getRrtype().replaceFirst(" *\\(\\d+\\)", "");
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue())
                + RRSETS
                + type + "/" + rrSet.getOwnerName();
        ClientData clientData = ultraRestClient.put(url, JsonUtils.objectToJson(rrSet));
        UltraClientErrors.checkClientData(clientData);
        return clientData.getBody();
    }

    /**
     * Delete an RRSet.
     *
     * @param zoneName   - The zone containing the RRSet to be deleted. The trailing dot is optional.
     * @param recordType - The type of the RRSet.This can be numeric (1) or if a well-known name is defined for the type
     *                   (A), you can use it instead.
     * @param ownerName  - The owner name for the RRSet. If no trailing dot is supplied, the owner_name is assumed to be
     *                   relative (foo). If a trailing dot is supplied, the owner name is assumed to be absolute
     *                   (foo.zonename.com.)
     */
    public void deleteRRSet(String zoneName, String recordType, String ownerName) throws IOException {
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + RRSETS
                + recordType + "/" + ownerName;
        ClientData clientData = ultraRestClient.delete(url);
        UltraClientErrors.checkClientData(clientData);
    }

    /**
     * Returns the list of ProbeInfo for the specified zone and owner.
     *
     * @param zoneName  - The name of the zone. The user must have read access to the zone.
     * @param ownerName  - The owner name for the RRSet. If no trailing dot is supplied, the owner_name is assumed to be
     *                   relative (foo). If a trailing dot is supplied, the owner name is assumed to be absolute
     *                   (foo.zonename.com.)
     * @param q        - may contain (space separated if both) type:TYPE and poolRecord:POOL_RECORD,
     *                 where TYPE is one of RECORD, POOL, or ALL (default, unless poolRecord is specified),
     *                 and POOL_RECORD is the IPv4 or CNAME as a FQDN for the pool record.
     *                 If poolRecord is specified, type of RECORD is assumed
     * @return - {@link ProbeInfoList}
     * @throws IOException - {@link IOException}
     */
    public ProbeInfoList getProbes(String zoneName, String ownerName, String q) throws IOException {
        MultivaluedMap<String, String> queryParams = buildQueryParams(q, null, null, null, null);
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + RRSETS
                + TYPEA + "/" + ownerName + PROBES;
        ClientData clientData = ultraRestClient.get(url, queryParams);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), ProbeInfoList.class);
    }

    /**
     * Creates a new probe in the specified zone and owner.
     *
     * @param zoneName   - The zone that contains the RRSet. The trailing dot is optional.
     * @param ownerName  - The owner name for the RRSet. If no trailing dot is supplied, the owner_name is assumed to be
     *                   relative (foo). If a trailing dot is supplied, the owner name is assumed to be absolute
     *                   (foo.zonename.com.)
     * @param probeInfo  - The probe info object.
     * probeInfo/poolRecord - The pool record associated with this probe. Pass null/empty for a pool-level probe.
     * probeInfo/type       - PING, FTP, TCP, SMTP, SMTP_SEND, or DNS.
     * probeInfo/interval   - HALF_MINUTE, ONE_MINUTE, TWO_MINUTES, FIVE_MINUTES (default), TEN_MINUTES, or
     *                   FIFTEEN_MINUTES.
     * probeInfo/agents     - See UltraDNS REST API User Guide for valid names.
     * probeInfo/threshold  - Number of agents that must agree for a probe state to be changed. From 1 to the number of
     *                   agents specified
     * probeInfo/details    - Map of the type-specific fields for a probe. See UltraDNS REST API User Guide for fields.
     * @return           - The id for this probe.
     * @throws IOException - {@link IOException}
     */
    public String createProbe(String zoneName, String ownerName, ProbeInfo probeInfo)
            throws IOException {
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + RRSETS
                + TYPEA + "/" + ownerName + PROBES;
        ClientData clientData = ultraRestClient.post(url, JsonUtils.objectToJson(probeInfo));
        UltraClientErrors.checkClientData(clientData);
        return clientData.getBody();
    }

    /**
     * Updates a probe with provided ID in the specified zone and owner.
     *
     * @param zoneName   - The zone that contains the RRSet. The trailing dot is optional.
     * @param ownerName  - The owner name for the RRSet. If no trailing dot is supplied, the owner_name is assumed to be
     *                   relative (foo). If a trailing dot is supplied, the owner name is assumed to be absolute
     *                   (foo.zonename.com.)
     * @param probeInfo - The probe. ID must be equal to target probe GUID
     * probeInfo/guid       - GUID of the probe.
     * probeInfo/type       - PING, FTP, TCP, SMTP, SMTP_SEND, or DNS.
     * probeInfo/interval   - HALF_MINUTE, ONE_MINUTE, TWO_MINUTES, FIVE_MINUTES (default), TEN_MINUTES, or
     *                   FIFTEEN_MINUTES.
     * probeInfo/agents     - See UltraDNS REST API User Guide for valid names.
     * probeInfo/threshold  - Number of agents that must agree for a probe state to be changed. From 1 to the number of
     *                   agents specified
     * probeInfo/details    - Map of the type-specific fields for a probe. See UltraDNS REST API User Guide for fields.
     * @return           - Status message
     * @throws IOException - {@link IOException}
     */
    public String updateProbe(String zoneName, String ownerName, ProbeInfo probeInfo)
            throws IOException {
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + RRSETS
                + TYPEA + "/" + ownerName + PROBES + "/"
                + URLEncoder.encode(probeInfo.getId(), UltraRestSharedConstant.UTF_8_CHAR_SET.getValue());
        ClientData clientData = ultraRestClient.put(url, JsonUtils.objectToJson(probeInfo));
        UltraClientErrors.checkClientData(clientData);
        return clientData.getBody();
    }

    /**
     * Deletes a probe with provided ID in the specified zone and owner.
     *
     * @param zoneName   - The zone that contains the RRSet. The trailing dot is optional.
     * @param ownerName  - The owner name for the RRSet. If no trailing dot is supplied, the owner_name is assumed to be
     *                   relative (foo). If a trailing dot is supplied, the owner name is assumed to be absolute
     *                   (foo.zonename.com.)
     * @param guid       - GUID of the probe.
     * @throws IOException - {@link IOException}
     */
    public void deleteProbe(String zoneName, String ownerName, String guid)
            throws IOException {
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + RRSETS
                + TYPEA + "/" + ownerName + PROBES + "/"
                + URLEncoder.encode(guid, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue());
        ClientData clientData = ultraRestClient.delete(url);
        UltraClientErrors.checkClientData(clientData);
        System.out.println(clientData.getStatus());
    }

    /**
     * Returns the list of AlertData for the specified zone and owner.
     *
     * @param zoneName  - The name of the zone. The user must have read access to the zone.
     * @param ownerName  - The owner name for the RRSet. If no trailing dot is supplied, the owner_name is assumed to be
     *                   relative (foo). If a trailing dot is supplied, the owner name is assumed to be absolute
     *                   (foo.zonename.com.)
     * @param q        - may contain status:STATUS,
     *                 where STATUS is one of WARNING, CRITICAL, or FAIL
     * @return - {@link AlertDataList}
     * @throws IOException - {@link IOException}
     */
    public AlertDataList getProbeAlerts(String zoneName, String ownerName, String q, int offset, int limit,
                                        UltraRestSharedConstant.ProbeAlertSort sort, boolean reverse)
            throws IOException {
        MultivaluedMap<String, String> queryParams = buildQueryParams(q, offset, limit, sort, reverse);
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + RRSETS
                + TYPEA + "/" + ownerName + ALERTS;
        ClientData clientData = ultraRestClient.get(url, queryParams);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), AlertDataList.class);
    }

    /**
     * Returns the list of SBTCNotification for the specified zone and owner.
     *
     * @param zoneName  - The name of the zone. The user must have read access to the zone.
     * @param ownerName  - The owner name for the RRSet. If no trailing dot is supplied, the owner_name is assumed to be
     *                   relative (foo). If a trailing dot is supplied, the owner name is assumed to be absolute
     *                   (foo.zonename.com.)
     * @param poolRecord - If not null, will only provide notifications associated with the given pool record.
     * @param email      - If not null, will only provide notifications associated with the given email.
     * @return - {@link SBTCNotificationList}
     * @throws IOException - {@link IOException}
     */
    public SBTCNotificationList getNotifications(String zoneName, String ownerName, String poolRecord, String email)
            throws IOException {
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + RRSETS
                + TYPEA + "/" + ownerName + NOTIFICATIONS;
        if (email != null) {
            url += URLEncoder.encode(email, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue());
        }
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        if (poolRecord != null) {
            queryParams.add("poolRecord", poolRecord);
        }
        ClientData clientData = ultraRestClient.get(url, queryParams);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), SBTCNotificationList.class);
    }

    /**
     * Creates new SBTCNotification in the specified zone and owner.
     *
     * @param zoneName   - The zone that contains the RRSet. The trailing dot is optional.
     * @param ownerName  - The owner name for the RRSet. If no trailing dot is supplied, the owner_name is assumed to be
     *                   relative (foo). If a trailing dot is supplied, the owner name is assumed to be absolute
     *                   (foo.zonename.com.)
     * @param email      - The notification email.
     * @param notification  - The notification object.
     * @return - Status message
     * @throws IOException - {@link IOException}
     */
    public String createNotification(String zoneName, String ownerName, String email, SBTCNotification notification)
            throws IOException {
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + RRSETS
                + TYPEA + "/" + ownerName + NOTIFICATIONS
                + URLEncoder.encode(email, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue());
        ClientData clientData = ultraRestClient.post(url, JsonUtils.objectToJson(notification));
        UltraClientErrors.checkClientData(clientData);
        return clientData.getBody();
    }

    /**
     * Updates a probe with provided ID in the specified zone and owner.
     *
     * @param zoneName   - The zone that contains the RRSet. The trailing dot is optional.
     * @param ownerName  - The owner name for the RRSet. If no trailing dot is supplied, the owner_name is assumed to be
     *                   relative (foo). If a trailing dot is supplied, the owner name is assumed to be absolute
     *                   (foo.zonename.com.)
     * @param email      - The notification email.
     * @param notification  - The notification object.
     * @return           - Status message
     * @throws IOException - {@link IOException}
     */
    public String updateNotification(String zoneName, String ownerName, String email, SBTCNotification notification)
            throws IOException {
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + RRSETS
                + TYPEA + "/" + ownerName + NOTIFICATIONS
                + URLEncoder.encode(email, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue());
        ClientData clientData = ultraRestClient.put(url, JsonUtils.objectToJson(notification));
        UltraClientErrors.checkClientData(clientData);
        return clientData.getBody();
    }

    /**
     * Deletes a notification with provided email in the specified zone and owner.
     *
     * @param zoneName   - The zone that contains the RRSet. The trailing dot is optional.
     * @param ownerName  - The owner name for the RRSet. If no trailing dot is supplied, the owner_name is assumed to be
     *                   relative (foo). If a trailing dot is supplied, the owner name is assumed to be absolute
     *                   (foo.zonename.com.)
     * @param email       - The notification email.
     * @throws IOException - {@link IOException}
     */
    public void deleteNotification(String zoneName, String ownerName, String email)
            throws IOException {
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + RRSETS
                + TYPEA + "/" + ownerName + NOTIFICATIONS
                + URLEncoder.encode(email, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue());
        ClientData clientData = ultraRestClient.delete(url);
        UltraClientErrors.checkClientData(clientData);
        System.out.println(clientData.getStatus());
    }

    /**
     * Get account details for user.
     *
     * @return - {@link AccountList}
     * @throws IOException - {@link IOException}
     */
    public AccountList getAccountDetails() throws IOException {
        String url = ACCOUNTS;
        ClientData clientData = ultraRestClient.get(url);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), AccountList.class);
    }

    /**
     * Get version of REST API server.
     *
     * @return - The version of REST API server
     */
    public Version getVersion() throws IOException {
        ClientData clientData = ultraRestClient.get(VERSION);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), Version.class);
    }

    /**
     * Get status of REST API server.
     *
     * @return - The status of REST API server
     */
    public Status getStatus() throws IOException {
        ClientData clientData = ultraRestClient.get(STATUS);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), Status.class);
    }

    private MultivaluedMap<String, String> buildQueryParams(String q, Integer offset, Integer limit, Enum sort,
            Boolean reverse) {
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        if (!Strings.isNullOrEmpty(q)) {
            queryParams.add("q", q);
        }
        Optional.ofNullable(offset).ifPresent(o -> queryParams.add("offset", Integer.toString(o, BASE_10_RADIX)));
        Optional.ofNullable(limit).ifPresent(l -> queryParams.add("limit", Integer.toString(l, BASE_10_RADIX)));
        Optional.ofNullable(sort).ifPresent(s -> queryParams.add("sort", sort.toString()));
        Optional.ofNullable(reverse).ifPresent(r -> queryParams.add("reverse", Boolean.toString(reverse)));

        return queryParams;
    }

    private MultivaluedMap<String, String> buildQueryParams(String q, Integer offset, Integer limit, Enum sort,
            Boolean reverse, String cursor) {
        MultivaluedMap<String, String> queryParams = buildQueryParams(q, offset, limit, sort, reverse);
        Optional.ofNullable(cursor).ifPresent(c -> queryParams.add("cursor", cursor));

        return queryParams;
    }

    /**
     * Create a web forward.
     *
     * @param zoneName   - The name of the zone. The trailing . is optional.
     * @param webForward - The {@link WebForward} details.
     * @return - The created {@link WebForward}
     * @throws IOException - {@link IOException}
     */
    public WebForward createWebForward(@NotNull final String zoneName, @NotNull WebForward webForward)
            throws IOException {
        String url =
                ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + WEB_FORWARDS;
        ClientData clientData = ultraRestClient.post(url, JsonUtils.objectToJson(webForward));
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), WebForward.class);
    }

    /**
     * Get the list of web forwards.
     *
     * @param zoneName   - The name of the zone. The trailing . is optional.
     * @param q          - The search parameters. Valid keys are:
     *                      type - Valid values include:
     *                          o Framed
     *                          o HTTP_301_REDIRECT
     *                          o HTTP_302_REDIRECT
     *                          o HTTP_303_REDIRECT
     *                          o HTTP_307_REDIRECT
     *                          o Advanced
     *                       advanced - Valid values include true and false.
     *                       name – any string, will map to anything in either the host or the target.
     * @param offset     - The position in the list for the first returned element(0 based)
     * @param limit      - The maximum number of rows to be returned.
     * @param sort       - The sort column used to order the list. Valid values for the sort field are:
     *                      REQUEST_TO (this is the default)
     *                      REDIRECT_TO
     *                      TYPE
     *                      DOMAIN
     *                      ADVANCED
     * @param reverse    - Whether the list is ascending(false) or descending(true). Defaults to true
     * @throws IOException - {@link IOException}
     */
    public WebForwardList getWebForwardList(@NotNull final String zoneName, String q, int offset, int limit,
                                            UltraRestSharedConstant.WFListSortFields sort, boolean reverse)
            throws IOException {
        MultivaluedMap<String, String> queryParams = buildQueryParams(q, offset, limit, sort, reverse);
        String url =
                ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + WEB_FORWARDS;
        ClientData clientData = ultraRestClient.get(url, queryParams);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), WebForwardList.class);
    }

    /**
     * Update a web forward.
     *
     * @param zoneName   - The name of the zone. The trailing . is optional.
     * @param guid       - The System-generated unique identifier for this object.
     * @param webForward - The {@link WebForward} details.
     * @return - The created {@link WebForward}
     * @throws IOException - {@link IOException}
     */
    public String updateWebForward(@NotNull final String zoneName, @NotNull String guid, @NotNull WebForward webForward)
            throws IOException {
        String url =
                ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + WEB_FORWARDS
                        + "/" + guid;
        ClientData clientData = ultraRestClient.put(url, JsonUtils.objectToJson(webForward));
        UltraClientErrors.checkClientData(clientData);
        return clientData.getBody();
    }

    /**
     * Delete a web forward.
     *
     * @param zoneName - The name of the zone. The trailing . is optional.
     * @param guid     - The System-generated unique identifier for this object.
     * @throws IOException - {@link IOException}
     */
    public void deleteWebForward(@NotNull final String zoneName, @NotNull String guid) throws IOException {
        String url =
                ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + WEB_FORWARDS
                        + "/" + guid;
        ClientData clientData = ultraRestClient.delete(url);
        UltraClientErrors.checkClientData(clientData);
    }

    /**
     * Perform a Batch operation.
     *
     * @param batchRequests - The list of batch requests. Make sure the URIs are properly encoded as per Ultra REST API
     *                      standards, for example the spaces are replaced with '%20' etc.
     * @return - The {@link BatchResponse} list
     */
    public List<BatchResponse> batchOperation(@NotNull List<BatchRequest> batchRequests) throws IOException {
        String url = BATCH;
        ClientData clientData = ultraRestClient.post(url, JsonUtils.objectToJson(batchRequests));
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToList(clientData.getBody(), BatchResponse.class);
    }

    /**
     * Perform a Batch operation asynchronously.
     *
     * @param batchRequests - The list of batch requests. Make sure the URIs are properly encoded as per Ultra REST API
     *                      standards, for example the spaces are replaced with '%20' etc.
     * @return - The task id of the created background task
     */
    public String asyncBatchOperation(@NotNull List<BatchRequest> batchRequests) throws IOException {
        String url = BATCH;
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("async", "true");
        ClientData clientData = ultraRestClient.post(url, queryParams, JsonUtils.objectToJson(batchRequests));
        UltraClientErrors.checkClientData(clientData);
        return clientData.getHeaders().getFirst(UltraRestSharedConstant.X_TASK_ID.getValue());
    }

    /**
     * Build the {@link RestApiClient} for a Reseller's sub-account.
     *
     * @param subAccountName - The sub-account name to access.
     * @return - The {@link RestApiClient} to access the sub-account resources.
     */
    public RestApiClient buildRestApiClientForSubAccountAccess(@NotNull String subAccountName) throws IOException {
        String url = SUB_ACCOUNTS + URLEncoder.encode(subAccountName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue())
                .replaceAll("\\+", "%20") + TOKEN;
        ClientData clientData = ultraRestClient.retryablePost(url);
        UltraClientErrors.checkClientData(clientData);
        TokenResponse subAccountTokenResponse = JsonUtils.jsonToObject(clientData.getBody(), TokenResponse.class);
        return buildRestApiClientWithTokens(subAccountTokenResponse.getAccessToken(), null,
                this.ultraRestClient.getBaseUrl(), null);
    }

    /**
     * List zones of Reseller's sub-accounts.
     *
     * @param q           - The search parameters, in a hash. Valid keys are:
     *                      o account_name – will only return results that match the provided sub account accountName.
     *                        For account names that include spaces in them, replace the space with "%20".
     *                      o match - Valid values for match include: o name o zone_type o zone_status
     *                            o dnssec_status o Account_name (only sub account names)
     * @param offset      - The position in the list for the first returned element(0 based)
     * @param limit       - The maximum number of zones to be returned
     * @param sort        - The sort column used to order the list. Valid values for the sort field are:
     *                      NAME/ACCOUNT_NAME/ZONE_TYPE
     * @param reverse     - Whether the list is ascending(false) or descending(true). Defaults to true
     * @return - {@link ZoneInfoList}
     * @throws IOException - {@link IOException}
     */
    public ZoneInfoList listSubAccountsZones(String q, int offset, int limit,
            UltraRestSharedConstant.ZoneListSortType sort, boolean reverse) throws IOException {
        MultivaluedMap<String, String> queryParams = buildQueryParams(q, offset, limit, sort, reverse);
        String url = SUB_ACCOUNTS + "/zones";
        ClientData clientData = ultraRestClient.get(url, queryParams);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), ZoneInfoList.class);
    }

    /**
     * List the basic information of Reseller's sub-accounts.
     *
     * @param q           - The search parameters, in a hash. Valid keys are:
     *                      o account_name – will only return results that match the provided accountName. For account
     *                       names that include spaces in them, replace the space with "%20".
     *                      o match - Valid values for match include: o ANYWHERE o EXACT o START o END
     * @param offset      - The position in the list for the first returned element(0 based)
     * @param limit       - The maximum number of zones to be returned
     * @param reverse     - Whether the list is ascending(false) or descending(true). Defaults to true
     * @return - {@link AccountList}
     * @throws IOException - {@link IOException}
     */
    public AccountList listSubAccounts(String q, int offset, int limit, boolean reverse) throws IOException {
        MultivaluedMap<String, String> queryParams = buildQueryParams(q, offset, limit, null, reverse);
        String url = SUB_ACCOUNTS;
        ClientData clientData = ultraRestClient.get(url, queryParams);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), AccountList.class);
    }

    /**
     * Sign a zone.
     *
     * @param zoneName - The name of the zone. The trailing . is optional.
     * @return - Either the task id of the created background task or the status message.
     * @throws IOException - {@link IOException}
     */
    public String signZone(@NotNull final String zoneName) throws IOException {

        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + DNSSEC;
        ClientData clientData = ultraRestClient.post(url);
        UltraClientErrors.checkClientData(clientData);
        return Optional.ofNullable(
                clientData.getHeaders().getFirst(UltraRestSharedConstant.X_TASK_ID.getValue()))
                .orElse(clientData.getBody());
    }

    /**
     * Unsign a zone.
     *
     * @param zoneName - The name of the zone. The trailing . is optional.
     * @return - Either the task id of the created background task or the status message.
     * @throws IOException - {@link IOException}
     */
    public String unsignZone(@NotNull final String zoneName) throws IOException {
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + DNSSEC;
        ClientData clientData = ultraRestClient.delete(url);
        return Optional.ofNullable(
                clientData.getHeaders().getFirst(UltraRestSharedConstant.X_TASK_ID.getValue()))
                .orElse(clientData.getBody());
    }

    /**
     * Re-sign a zone.
     *
     * @param zoneName - The name of the zone. The trailing . is optional.
     * @return - Either the task id of the created background task or the status message.
     * @throws IOException - {@link IOException}
     */
    public String reSignZone(@NotNull final String zoneName) throws IOException {

        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + DNSSEC;
        ClientData clientData = ultraRestClient.put(url, null);
        UltraClientErrors.checkClientData(clientData);
        return Optional.ofNullable(
                clientData.getHeaders().getFirst(UltraRestSharedConstant.X_TASK_ID.getValue()))
                .orElse(clientData.getBody());
    }

    /**
     * Get DnsSec info of a signed zone.
     *
     * @param zoneName - The name of the zone. The trailing . is optional.
     * @return - {@link DnsSecInfo}
     * @throws IOException - {@link IOException}
     */
    public DnsSecInfo getDnsSecInfo(@NotNull final String zoneName) throws IOException {
        String url = ZONES + URLEncoder.encode(zoneName, UltraRestSharedConstant.UTF_8_CHAR_SET.getValue()) + DNSSEC;
        ClientData clientData = ultraRestClient.get(url);
        UltraClientErrors.checkClientData(clientData);
        return JsonUtils.jsonToObject(clientData.getBody(), DnsSecInfo.class);
    }
}

/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.constants;

/**
 * Ultra rest shared constant.
 *
 * @author nupadhyay
 */
@SuppressWarnings("PMD.GodClass")
public enum UltraRestSharedConstant {
    /**
     * header key while returning the task id in HTTP header.
     */
    X_NEUSTAR_TASK_ID("X-Task-Id"),
    /**
     * Zone type in query string.
     */
    ZONE_TYPE_IN_QUERY_STRING("zone_type"),
    SPACE(" "),
    /**
     * Constant for resource records.
     */
    RR_SETS("rrsets"),
    /**
     * Constant for total count.
     */
    TOTAL_COUNT("totalCount"),
    /**
     * Constant for colon.
     */
    COLON(":"),
    /**
     * Constant for TTL string.
     */
    TTL("ttl"),
    /**
     * Constant for owner string.
     */
    OWNER("owner"),
    /**
     * Constant for value string.
     */
    VALUE("value"),
    /**
     * Constant for value string.
     */
    SKIP_SOA("skipSOA"),
    /**
     * Constant for code string.
     */
    CODE("code"),
    /**
     * Constant for hasData string.
     */
    HAS_DATA("hasData"),
    /**
     * Constant for description.
     */
    DESCRIPTION("description"),
    /**
     * Constant for double quote.
     */
    DOUBLE_QUOTE("\""),
    /**
     * Constant for comma.
     */
    COMMA(","),
    /**
     * Zone name constant.
     */
    ZONE_NAME("zoneName"),
    /**
     * Account name constant.
     */
    ACCOUNT_NAME("accountName"),

    /**
     * Account name query param constant.
     */
    ACCOUNT_NAME_QUERY_PARAM("account_name"),
    /**
     * Bind file type.
     */
    BIND_FILE_TYPE("bind"),
    /**
     * UTF Character encoding.
     */
    UTF_8_CHAR_SET("UTF-8"),
    /**
     * Query separator.
     */
    QUERY_SEPARATOR(":"),
    /**
     * Web forward type.
     */
    WEB_FORWARD_TYPE("type"),
    /**
     * Web forward advanced flag.
     */
    WEB_FORWARD_QUERY_ADVANCED("advanced"),

    /**
     * Mapping key for address in query parameter.
     */
    EMAIL_ADDRESS("address"),
    /**
     * For RRSet listing option.
     */
    KIND("kind"),
    /**
     * For match type, can be START, END, ANYWHERE, EXACT, default is ANYWHERE.
     */
    MATCH("match"),
    /**
     * For Error.
     */
    ERROR("ERROR"),
    /**
     * For ok.
     */
    OK("OK"),
    /**
     * For RRSet Profile Context.
     */
    PROFILE_CONTEXT("@context"),
    /**
     * For RRSet Profile order.
     */
    PROFILE_ORDER("order"),
    /**
     * For RRSet Profile description.
     */
    PROFILE_DESCRIPTION("description"),

    STATUS("status"),

    /**
     * For ECS flag.
     */
    DIR_POOL_IGNORE_ECS("ignoreECS"),
    /**
     * For Directional Pool conflict resolve.
     */
    DIR_POOL_CONFLICT_RESOLVE("conflictResolve"),
    /**
     * For Directional Pool record data info.
     */
    DIR_POOL_RDATA_INFO("rdataInfo"),

    DIR_POOL_ALL_NC("allNonConfigured"),

    DIR_POOL_GEO_INFO("geoInfo"),

    NAME("name"),

    DIR_POOL_IS_ACCOUNT_LEVEL("isAccountLevel"),

    DIR_POOL_IS_EXISTING_GROUP_FROM_POOL("isIsExistingGroupFromPool"),

    DIR_POOL_CODES("codes"),

    DIR_POOL_IP_INFO("ipInfo"),

    DIR_POOL_IPS("ips"),

    DIR_POOL_START("start"),

    DIR_POOL_END("end"),

    DIR_POOL_CIDR("cidr"),

    DIR_POOL_ADDRESS("address"),

    DIR_POOL_RDATA_INFO_TYPE("type"),

    /**
     * For Directional Pool no response.
     */
    DIR_POOL_NO_RESPONSE("noResponse"),
    NAME_IN_QUERY_STRING("name"),
    //Field names related to SLB Pool profile
    SLB_PROFILE_ORDER("responseMethod"),
    SLB_PROFILE_BACKUP_RECORD("allFailRecord"),
    SLB_PROFILE_MONITOR("monitor"),
    // This and regionFailureSensitivity as same purpose. When users pass value, it is called
    // regionFailureSensitivity. What ZGS gets is regionThreshold.
    SLB_PROFILE_REGION_THRESHOLD("regionThreshold"),
    SLB_PROFILE_REGION_FAILURE_SENSITIVITY("regionFailureSensitivity"),
    SLB_PROFILE_SERVING_PREFERENCE("servingPreference"),

    SF_POOL_DESCRIPTION("poolDescription"),
    SF_POOL_LIVE_RECORD_DESCRIPTION("liveRecordDescription"),
    SF_POOL_LIVE_RECORD_STATE("liveRecordState"),
    SF_POOL_BACKUP_RECORD("backupRecord"),
    SF_POOL_MONITOR("monitor"),
    SF_POOL_REGION_THRESHOLD("regionFailureSensitivity"),

    AR_OR_SLB_PROFILE_RDATA_INFO("rdataInfo"),
    AR_PROFILE_BACKUP_DATA_RECORDS("backupRecords"),
    AR_CONF_RESPONSE_METHOD("responseMethod"),
    AR_CONF_MAX_ACTIVE("maxActive"),
    AR_CONF_MAX_RESPONSE("maxResponse"),
    AR_CONF_FAILOVER_ENABLED("failoverEnabled"),
    AR_CONF_PROBING_ENABLED("probingEnabled"),
    AR_POOL_CONFIGURATION("configuration"),

    SBTCPOOL_RUN_PROBES("runProbes"),
    SBTCPOOL_ACT_ON_PROBES("actOnProbes"),
    SBPOOL_ORDER("order"),
    SBPOOL_MAX_ACTIVE("maxActive"),
    SBPOOL_MAX_SERVED("maxServed"),
    SBTCPOOL_RDATA_INFO("rdataInfo"),

    SBPOOL_BACKUP_DATA_RECORDS("backupRecords"),
    TCPOOL_BACKUP_DATA_RECORD("backupRecord"),
    ALL("ALL"),
    TCPOOL_MAX_TO_LB("maxToLB"),
    SUCCESSFUL("Successful"),
    PENDING("Pending"),
    ZONE_STATUS("zone_status"),
    DNSSEC_STATUS("dnssec_status"),

    AR_DEFAULT_CONFIGURATION_NAME("Default"),

    PROP_REPORTER_SERVICE_LOCATION("ultra.reporter.service.location"),
    PROP_REPORTER_REST_CLIENT_RECEIVED_TIMEOUT("ultra.reporter.service.rest.web.client.received.timeout"),

    PROP_VSA_SERVICE_LOCATION("ultra.vsa.service.location"),

    /**
     * Constants for ZBR service.
     */
    PROP_ZBR_SERVICE_LOCATION("ultra.zbr.service.location"),
    PROP_ZBR_REST_CLIENT_CONNECT_TIMEOUT("ultra.zbr.service.rest.web.client.connect.timeout"),
    PROP_ZBR_REST_CLIENT_READ_TIMEOUT("ultra.zbr.service.rest.web.client.read.timeout"),
    /**
     * Constant for double colon.
     */
    DBL_COLON("::"),
    /**
     * Constant for filter for Reporter Task API.
     */
    FILTER("filter"),
    /**
     * Constant for link header next link.
     */
    NEXT("next"),
    /**
     * Constant for link header prev link.
     */
    PREVIOUS("previous"),
    /**
     * Constant for link header limit for records.
     */
    LIMIT("Limit"),
    /**
     * Constant for link header record count in response.
     */
    RESULTS("Results"),
    /**
     * Constant for Link in header.
     */
    Link("Link"),
    /**
     * Application id to be used supplied to token service.
     */
    JAVA_UI("JAVA_UI"),

    /**
     * Constant for zone search type(for ZBR).
     */
    SEARCH_TYPE_IN_QUERY_STRING("_search_type"),

    /**
     * Constant for parameter to return internal fields in RRSets response. It can accept comma separated multiple
     * fields.<BR> Like 'ACCOUNTID' for account ID, 'ZONEID' for zone ID and 'ACCOUNTID,ZONEID' for both.
     */
    FETCH_INTERNAL_FIELDS("_fetch_internal_fields"),

    /**
     * Client ID for ZBR.
     */
    ZBR("ZBR");

    public static final int MAX_RECORD_COUNT_IN_SLB_POOL = 5;
    /**
     * Task create "action" parameter string.
     */
    public static final String TASK_CREATE_ACTION_STRING = "action";
    private static final String NORTH_AMERICA_EAST2 = "North America East";
    private static final String NORTH_AMERICA_WEST2 = "North America West";
    private static final String NORTH_AMERICA_CENTRAL2 = "North America Central";
    private static final String EUROPE_EAST2 = "Europe East";
    /**
     * Value.
     */
    private final String value;

    /**
     * Parameterized constructor.
     *
     * @param value - constant value
     */
    UltraRestSharedConstant(String value) {
        this.value = value;
    }

    /**
     * To get value.
     *
     * @return - String value.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Sort options for listing zones.
     */
    public enum ZoneListSortType {
        NAME(1),
        ZONE_TYPE(2),
        ACCOUNT_NAME(3);

        private int value;

        ZoneListSortType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    /**
     * Sort constant for RR list.
     */
    public enum RRListSortType {
        OWNER("lname"),
        TTL("ttl"),
        TYPE("type"),
        VALUE("info1");
        /**
         * Value.
         */
        private final String value;

        RRListSortType(String value) {
            this.value = value;
        }

        /**
         * Get value.
         *
         * @return - int
         */
        public String getValue() {
            return this.value;
        }
    }

    /**
     * Sort fields for web forward listing.
     */
    public enum WFListSortFields {
        REQUEST_TO(1),
        REDIRECT_TO(2),
        TYPE(3),
        DOMAIN(4),
        ADVANCED(5);
        private final int value;

        WFListSortFields(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum MailSortField {
        FROM_HOST_NAME(5),
        FROM_USER_NAME(6);
        private final int value;

        MailSortField(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum EventSortField {
        START("datestart"),
        END("datenext");
        private final String value;

        EventSortField(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum ProfileType {
        NONE(""),
        RD_POOL("http://schemas.ultradns.com/RDPool.jsonschema"),
        SF_POOL("http://schemas.ultradns.com/SFPool.jsonschema"),
        DIR_POOL("http://schemas.ultradns.com/DirPool.jsonschema"),
        SB_POOL("http://schemas.ultradns.com/SBPool.jsonschema"),
        TC_POOL("http://schemas.ultradns.com/TCPool.jsonschema"),
        AR_POOL("http://schemas.ultradns.com/ARPool.jsonschema"),
        SLB_POOL("http://schemas.ultradns.com/SLBPool.jsonschema");

        private final String context;

        ProfileType(String context) {
            this.context = context;
        }

        public String getContext() {
            return context;
        }
    }

    /**
     * The order the records will be returned in.
     */
    public enum RDProfileOrder {
        FIXED("FX"),
        RANDOM("RD"),
        ROUND_ROBIN("RR");
        private String value;

        /**
         * Constructor.
         */
        RDProfileOrder(String value) {
            this.value = value;
        }

        /**
         * Get order.
         *
         * @param string - Order in String
         * @return - {@link RDProfileOrder}
         */
        public static RDProfileOrder getOrder(String string) {
            RDProfileOrder[] orders = RDProfileOrder.values();
            for (RDProfileOrder order : orders) {
                if (order.getValue().equals(string)) {
                    return order;
                }
            }

            throw new IllegalArgumentException();
        }

        /**
         * Get order.
         *
         * @param string - Order in String
         * @return - {@link RDProfileOrder}
         */
        public static RDProfileOrder getOrderByValue(String string) {
            RDProfileOrder[] orders = RDProfileOrder.values();
            for (RDProfileOrder order : orders) {
                if (order.name().equals(string)) {
                    return order;
                }
            }

            throw new IllegalArgumentException();
        }

        /**
         * Get value.
         */
        public String getValue() {
            return this.value;
        }
    }

    public enum ProbeHttpMethod {
        GET,
        POST
    }

    public enum ProbeType {
        HTTP("HTTP"),
        PING("ping"),
        FTP("FTP"),
        TCP("TCP"),
        SMTP("SMTP Availability"),
        SMTP_SEND("SMTP Send Mail"),
        DNS("DNS");
        private String value;

        ProbeType(String value) {
            this.value = value;
        }

        public static ProbeType findBy(String value) {
            ProbeType[] enums = ProbeType.values();
            for (ProbeType type : enums) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum ProbeInterval {
        HALF_MINUTE(30),
        ONE_MINUTE(1),
        TWO_MINUTES(2),
        FIVE_MINUTES(5),
        TEN_MINUTES(10),
        FIFTEEN_MINUTES(15);
        private int interval;

        ProbeInterval(int interval) {
            this.interval = interval;
        }

        public static ProbeInterval findBy(int interval) {
            ProbeInterval[] enums = ProbeInterval.values();
            for (ProbeInterval probeInterval : enums) {
                if (probeInterval.getInterval() == interval) {
                    return probeInterval;
                }
            }
            throw new IllegalArgumentException("Unknown Probe Interval: " + interval);
        }

        public int getInterval() {
            return this.interval;
        }
    }

    public enum ProbeAgent {
        NEW_YORK("New York", NORTH_AMERICA_EAST2),
        PALO_ALTO("Palo Alto", NORTH_AMERICA_WEST2),
        AMSTERDAM("Amsterdam", EUROPE_EAST2),
        DALLAS("Dallas", NORTH_AMERICA_CENTRAL2),
        NORTH_AMERICA_EAST(NORTH_AMERICA_EAST2, NORTH_AMERICA_EAST2),
        NORTH_AMERICA_WEST(NORTH_AMERICA_WEST2, NORTH_AMERICA_WEST2),
        NORTH_AMERICA_CENTRAL(NORTH_AMERICA_CENTRAL2, NORTH_AMERICA_CENTRAL2),
        EUROPE_EAST(EUROPE_EAST2, EUROPE_EAST2),
        EUROPE_WEST("Europe West", "Europe West"),
        SOUTH_AMERICA("South America", "South America"),
        ASIA("Asia", "Asia"),
        CHINA("China", "China"),
        USEAST("USEast", NORTH_AMERICA_EAST2),
        USWEST("USWest", NORTH_AMERICA_WEST2),
        EUWEST("EUWest", EUROPE_EAST2),
        USCENTRAL("USCentral", NORTH_AMERICA_CENTRAL2);

        private String agent;
        private String newAgentName;

        ProbeAgent(String oldAgent, String newAgentName) {
            this.agent = oldAgent;
            this.newAgentName = newAgentName;
        }

        public static String correctProbeAgentName(String agent) {
            //not using valueOf because I don't want to throw an exception.
            for (ProbeAgent probeAgent : values()) {
                if (probeAgent.name().equalsIgnoreCase(agent)) {
                    return probeAgent.getProbeAgent();
                }
            }
            //just return what was passed in
            return agent;
        }

        public static String convertProbeAgentNameToNewAgent(String oldAgent) {
            for (ProbeAgent probeAgent : values()) {
                if (probeAgent.getProbeAgent().equalsIgnoreCase(oldAgent)) {
                    return probeAgent.getNewAgentName();
                }
            }
            //just return what was passed in
            return oldAgent;
        }

        public static String convertProbeAgentNameToExternal(String internalAgent, SiteBackerNetwork networkName) {
            //not using valueOf because I don't want to throw an exception.
            for (ProbeAgent probeAgent : values()) {
                if (probeAgent.getProbeAgent().equalsIgnoreCase(internalAgent)) {
                    switch (probeAgent) {
                    case NORTH_AMERICA_EAST:
                        return getEastAgentName(networkName);
                    case NORTH_AMERICA_WEST:
                        return getWestAgentName(networkName);
                    case NORTH_AMERICA_CENTRAL:
                        return getCentralAgentName(networkName);
                    case EUROPE_EAST:
                        return getEuropeAgentName(networkName);
                    default:
                        return probeAgent.name();
                    }
                }
            }
            //just return what was passed in
            return internalAgent;
        }

        /**
         * Get Appropriate Agent for Europe.
         *
         * @param networkName the name of the sitebacker network customer belongs to.
         * @return Europe site corresponding to the network name.
         */
        private static String getEuropeAgentName(SiteBackerNetwork networkName) {
            return SiteBackerNetwork.PRIMARY.equals(networkName)
                    ? ProbeAgent.AMSTERDAM.name()
                    : ProbeAgent.EUWEST.getProbeAgent();
        }

        /**
         * Get Appropriate Agent for Central.
         *
         * @param networkName the name of the sitebacker network customer belongs to.
         * @return North America Central site corresponding to the network name.
         */
        private static String getCentralAgentName(SiteBackerNetwork networkName) {
            return SiteBackerNetwork.PRIMARY.equals(networkName)
                    ? ProbeAgent.DALLAS.name()
                    : ProbeAgent.USCENTRAL.getProbeAgent();
        }

        /**
         * Get Appropriate Agent for West.
         *
         * @param networkName the name of the sitebacker network customer belongs to.
         * @return North America West site corresponding to the network name.
         */
        private static String getWestAgentName(SiteBackerNetwork networkName) {
            return SiteBackerNetwork.PRIMARY.equals(networkName)
                    ? ProbeAgent.PALO_ALTO.name()
                    : ProbeAgent.USWEST.getProbeAgent();
        }

        /**
         * Get Appropriate Agent for East.
         *
         * @param networkName the name of the sitebacker network customer belongs to.
         * @return North America East site corresponding to the network name.
         */
        private static String getEastAgentName(SiteBackerNetwork networkName) {
            return SiteBackerNetwork.PRIMARY.equals(networkName)
                    ? ProbeAgent.NEW_YORK.name()
                    : ProbeAgent.USEAST.getProbeAgent();
        }

        public static ProbeAgent findBy(String agent) {
            ProbeAgent[] enums = ProbeAgent.values();
            for (ProbeAgent type : enums) {
                if (type.getProbeAgent().equals(agent)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown Probe Agent: " + agent);
        }

        private String getNewAgentName() {
            return this.newAgentName;
        }

        public String getProbeAgent() {
            return this.agent;
        }
    }

    public enum Order {
        FIXED("FX"),
        RANDOM("RD"),
        ROUND_ROBIN("RR");

        private final String value;

        Order(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

    }

    public enum RecordState {
        NORMAL(0),
        ACTIVE(1),
        INACTIVE(2);
        private final int val;

        RecordState(int val) {
            this.val = val;
        }

        public static RecordState fromVal(int val) {
            for (RecordState state : values()) {
                if (state.getVal() == val) {
                    return state;
                }
            }
            throw new IllegalArgumentException("Unknown state value: " + val);
        }

        public int getVal() {
            return val;
        }
    }

    public enum PassiveMode {
        ENABLED,
        DISABLED
    }

    public enum EventType {
        NORMAL("Normal", "NORMAL"),
        ACTIVE("ForceActive-NoTest", "Force Active-No Test"),
        ACTIVE_TEST("ForceActive-Test", "Force Active-Test"),
        INACTIVE("ForceFail-NoTest", "Force Fail-No Test"),
        INACTIVE_TEST("ForceFail-Test", "Force Fail-Test");

        private final String getValue;
        private final String postValue;

        EventType(String getValue, String postValue) {
            this.getValue = getValue;
            this.postValue = postValue;
        }

        public static EventType findByGetValue(String getValue) {
            EventType[] enums = EventType.values();
            for (EventType type : enums) {
                if (type.getGetValue().equals(getValue)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown event type: " + getValue);
        }

        public String getGetValue() {
            return this.getValue;
        }

        public String getPostValue() {
            return this.postValue;
        }
    }

    public enum EventRepeat {
        DAILY(TimeConstants.SECONDS_IN_DAY),
        WEEKLY(TimeConstants.DAYS_IN_WEEK * TimeConstants.SECONDS_IN_DAY),
        FORTNIGHTLY(TimeConstants.DAYS_IN_FORTNIGHT * TimeConstants.SECONDS_IN_DAY),
        MONTHLY(TimeConstants.DAYS_IN_MONTH * TimeConstants.SECONDS_IN_DAY);

        private final int value;

        EventRepeat(int value) {
            this.value = value;
        }

        public static EventRepeat findBy(long value) {
            EventRepeat[] enums = EventRepeat.values();
            for (EventRepeat repeat : enums) {
                if (repeat.getValue() == value) {
                    return repeat;
                }
            }
            return null;
        }

        public int getValue() {
            return value;
        }
    }

    public enum EventNotify {
        NEVER(0),
        ERROR(1),
        ALWAYS(2);

        private final int value;

        EventNotify(int value) {
            this.value = value;
        }

        public static EventNotify findBy(int value) {
            EventNotify[] enums = EventNotify.values();
            for (EventNotify notify : enums) {
                if (notify.getValue() == value) {
                    return notify;
                }
            }
            return null;
        }

        public int getValue() {
            return value;
        }
    }

    public enum EventCategory {
        PROBE,
        RECORD,
        SCHEDULED
    }

    public enum AlertDataStatus {
        ACTIVE(1),
        INACTIVE(0);

        private final Integer value;

        AlertDataStatus(Integer value) {
            this.value = value;
        }

        public static Integer getIntegerValue(String statusStr) {
            for (AlertDataStatus status : AlertDataStatus.values()) {
                if (statusStr.equals(status.name())) {
                    return status.getValue();
                }
            }
            return null;
        }

        public static AlertDataStatus findBy(String value) {
            for (AlertDataStatus status : AlertDataStatus.values()) {
                if (status.getValue().toString().equals(value)) {
                    return status;
                }
            }
            return null;
        }

        public Integer getValue() {
            return this.value;
        }
    }

    public enum ProbeAlertSort {
        POOL_RECORD(2),
        PROBE_TYPE(3),
        PROBE_STATUS(1),
        ALERT_DATE(6),
        STATUS(4);
        private final int value;

        ProbeAlertSort(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    /**
     * Constant for JSON Patch operation.
     */
    public enum JsonPatchOps {
        ADD("add"),
        REPLACE("replace"),
        REMOVE("remove"),
        MOVE("move"),
        TEST("test");
        private String value;

        JsonPatchOps(String value) {
            this.value = value;
        }

        public static JsonPatchOps findByValue(String operation) {
            for (JsonPatchOps op : JsonPatchOps.values()) {
                if (op.getValue().equals(operation)) {
                    return op;
                }
            }
            return null;
        }

        public String getValue() {
            return this.value;
        }
    }

    /**
     * Constants for JSON patch operation attributes.
     */
    public enum JsonPatchAttributes {
        OP("op"),
        PATH("path"),
        VALUE("value"),
        FROM("from");
        private String value;

        JsonPatchAttributes(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    /**
     * For zone status.
     */
    public enum ZoneStatusInSearch {
        ACTIVE(0),
        ALL(1),
        SUSPENDED(2);
        private Integer value;

        ZoneStatusInSearch(Integer value) {
            this.value = value;
        }

        public static ZoneStatusInSearch valueOf(Integer value) {
            for (ZoneStatusInSearch zoneStatus : ZoneStatusInSearch.values()) {
                if (value.equals(zoneStatus.value)) {
                    return zoneStatus;
                }
            }
            throw new IllegalArgumentException();
        }

        public Integer getValue() {
            return this.value;
        }
    }

    public enum DNSSecKeyType {
        KSK(0x101),
        ZSK(0x100);

        private int flag;

        DNSSecKeyType(int flag) {
            this.flag = flag;
        }

        /**
         * The DNSKEY flag field.
         */
        public int flag() {
            return flag;
        }
    }

    public enum DnsSecStatus {
        UNKNOWN("U"),
        FUTURE("N"),
        CURRENT("A"),
        EXPIRED("P");

        private String value;

        DnsSecStatus(String value) {
            this.value = value;

        }

        public static DnsSecStatus getDnsSecStatus(final String str) {
            for (DnsSecStatus status : DnsSecStatus.values()) {
                if (str != null && str.equals(status.getValue())) {
                    return status;
                }
            }
            throw new IllegalArgumentException();
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum DnssecType {
        NONE(0),
        NSEC(1),
        NSEC3(2),
        NSEC3_OPT_OUT(3),
        NSEC_ON_THE_FLY(4);

        private Integer value;

        DnssecType(Integer value) {
            this.value = value;
        }

        public Integer toInt() {
            return value;
        }
    }

    public enum CreateAutoPtr {
        ENABLED,
        DISABLED
    }

    public enum SiteBackerNetwork {
        PRIMARY,
        SECONDARY
    }
}

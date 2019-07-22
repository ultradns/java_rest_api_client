package biz.neustar.ultra.rest.dto;

import biz.neustar.ultra.rest.constants.TTLConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

import java.util.HashMap;
import java.util.Map;

/**
 * TTL DTO.
 */
@JsonInclude(Include.NON_NULL)
public class TTL {

    /**
     * Type of the TTL.
     */
    private TTLRecords type;

    /**
     * Default Value of TTL.
     */
    private Integer defaultValue;

    /**
     * Minimum Value of TTL.
     */
    private Integer min;

    /**
     * Maximum Value of TTL.
     */
    private Integer max;

    /**
     * Parameterized constructor.
     *
     * @param type
     * @param defaultValue
     * @param min
     * @param max
     */
    public TTL(TTLRecords type, Integer defaultValue, Integer min, Integer max) {
        super();
        this.type = type;
        this.defaultValue = defaultValue;
        this.min = min;
        this.max = max;
    }

    public TTL() {
        super();
    }

    /**
     * Get TTL.
     *
     * @return
     */
    public TTLRecords getType() {
        return type;
    }

    public void setType(TTLRecords type) {
        this.type = type;
    }

    public Integer getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Integer defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getType(), getDefaultValue(), getMin(), getMax());
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof TTL)) {
            return false;
        }
        final TTL other = (TTL) obj;
        isEqual = Objects.equal(getType(), other.getType()) && Objects.equal(getDefaultValue(), other.getDefaultValue())
                && Objects.equal(getMin(), other.getMin()) && Objects.equal(getMax(), other.getMax());
        return isEqual;
    }

    @Override
    public String toString() {

        return "TTL [type=" + type + ", defaultValue=" + defaultValue + ", min=" + min + ", max=" + max + "]";
    }

    public enum TTLRecords {
        SOA_REFRESH(3, "SOA_REFRESH (Refresh field in SOA)"),
        SOA_RETRY(4, "SOA_RETRY (Retry field in SOA)"),
        SOA_EXPIRE(5, "SOA_EXPIRE (Expire field in SOA)"),
        SOA_MIN_CACHE(6, "SOA_MIN_CACHE (Min Cache field in SOA)"),
        A(8, "A"),
        AAAA(9, "AAAA"),
        CNAME(11, "CNAME"),
        ANY(13, "ANY (All resource records)"),
        HINFO(15, "HINFO"),
        MX(19, "MX"),
        SBTC(20, "SBTC (Sitebacker and Traffic Controller pools)"),
        NAPTR(21, "NAPTR"),
        NS(22, "NS"),
        PTR(23, "PTR"),
        RP(24, "RP"),
        SOA(25, "SOA"),
        SRV(26, "SRV"),
        TXT(27, "TXT"),
        SPF(28, "SPF"),
        CAA(30, "CAA"),
        TLSA(31, "TLSA"),
        SSHFP(44, "SSHFP");

        // TTL Id -> Name map
        private static final Map<Integer, TTLRecords> TTL_RECORDS = new HashMap<Integer, TTLRecords>();
        // TTL Value -> Name map
        private static final Map<String, TTLRecords> TTL_VALUE = new HashMap<String, TTLRecords>();

        static {

            TTL_VALUE.put(TTLConstants.SOA_REFRESH, TTLRecords.SOA_REFRESH);

            TTL_VALUE.put(TTLConstants.SOA_REFRESH, TTLRecords.SOA_REFRESH);
            TTL_VALUE.put(TTLConstants.SOA_RETRY, TTLRecords.SOA_RETRY);
            TTL_VALUE.put(TTLConstants.SOA_EXPIRE, TTLRecords.SOA_EXPIRE);
            TTL_VALUE.put(TTLConstants.SOA_MIN_CACHE, TTLRecords.SOA_MIN_CACHE);
            TTL_VALUE.put(TTLConstants.A_IPV4_HOST_TTL, TTLRecords.A);
            TTL_VALUE.put(TTLConstants.AAAA_IPV6_HOST_TTL, TTLRecords.AAAA);
            TTL_VALUE.put(TTLConstants.CNAME_ALIAS_TTL, TTLRecords.CNAME);

            TTL_VALUE.put(TTLConstants.GLOBAL_ALL_RECORDS_TTL, TTLRecords.ANY);

            TTL_VALUE.put(TTLConstants.HINFO_HARDWARE_INFO_TTL, TTLRecords.HINFO);
            TTL_VALUE.put(TTLConstants.MX_MAIL_EXCHANGE_TTL, TTLRecords.MX);

            TTL_VALUE.put(TTLConstants.LOAD_BALANCING_TTL, TTLRecords.SBTC);

            TTL_VALUE.put(TTLConstants.NAPTR_NAMING_AUTHORITY_POINTER_TTL, TTLRecords.NAPTR);
            TTL_VALUE.put(TTLConstants.NS_NAMESERVER_TTL, TTLRecords.NS);
            TTL_VALUE.put(TTLConstants.PTR_POINTER_TTL, TTLRecords.PTR);
            TTL_VALUE.put(TTLConstants.RP_RESPONSIBLE_PERSON_TTL, TTLRecords.RP);
            TTL_VALUE.put(TTLConstants.SOA_TTL, TTLRecords.SOA);
            TTL_VALUE.put(TTLConstants.SRV_SERVICE_LOCATOR_TTL, TTLRecords.SRV);
            TTL_VALUE.put(TTLConstants.TXT_TEXT_TTL, TTLRecords.TXT);
            TTL_VALUE.put(TTLConstants.SPF_SENDER_POLICY_FRAMEWORK_TTL, TTLRecords.SPF);
            TTL_VALUE.put(TTLConstants.GLOBAL_ALL_RECORDS_TTL, TTLRecords.ANY);
            TTL_VALUE.put(TTLConstants.HINFO_HARDWARE_INFO_TTL, TTLRecords.HINFO);
            TTL_VALUE.put(TTLConstants.MX_MAIL_EXCHANGE_TTL, TTLRecords.MX);
            TTL_VALUE.put(TTLConstants.LOAD_BALANCING_TTL, TTLRecords.SBTC);
            TTL_VALUE.put(TTLConstants.NAPTR_NAMING_AUTHORITY_POINTER_TTL, TTLRecords.NAPTR);
            TTL_VALUE.put(TTLConstants.NS_NAMESERVER_TTL, TTLRecords.NS);
            TTL_VALUE.put(TTLConstants.PTR_POINTER_TTL, TTLRecords.PTR);
            TTL_VALUE.put(TTLConstants.RP_RESPONSIBLE_PERSON_TTL, TTLRecords.RP);
            TTL_VALUE.put(TTLConstants.SOA_TTL, TTLRecords.SOA);
            TTL_VALUE.put(TTLConstants.SRV_SERVICE_LOCATOR_TTL, TTLRecords.SRV);
            TTL_VALUE.put(TTLConstants.TXT_TEXT_TTL, TTLRecords.TXT);
            TTL_VALUE.put(TTLConstants.SPF_SENDER_POLICY_FRAMEWORK_TTL, TTLRecords.SPF);
            TTL_VALUE.put(TTLConstants.CAA_TTL, TTLRecords.CAA);
            TTL_VALUE.put(TTLConstants.TLSA_TTL, TTLRecords.TLSA);
            TTL_VALUE.put(TTLConstants.SSHFP_TTL, TTLRecords.SSHFP);
        }

        // Populate TTL Records -> name lookup map
        static {
            // Loop ttls
            for (TTLRecords ttl : values()) {
                // Populate TTL Record -> name map
                TTL_RECORDS.put(ttl.getTtlID(), ttl);
            }
        }

        private int ttlID;
        private String ttlName;

        TTLRecords(int ttlID, String ttlName) {
            this.ttlID = ttlID;
            this.ttlName = ttlName;
        }

        public static TTLRecords getTtlRecordById(int id) {
            if (TTL_RECORDS.containsKey(id)) {
                return TTL_RECORDS.get(id);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public static TTLRecords getTtlValueByValueKey(String value) {

            if (TTL_VALUE.containsKey(value)) {
                return TTL_VALUE.get(value);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public static Map<Integer, TTLRecords> getTtlRecords() {
            return TTL_RECORDS;
        }

        public static Map<String, TTLRecords> getTtlValue() {
            return TTL_VALUE;
        }

        /**
         * Return TTL name.
         * <p>
         * Returns TTL name.
         *
         * @return the ttlName
         */
        public String getTtlName() {
            return ttlName;
        }

        /**
         * Return TTL ID.
         *
         * @return the ttlID
         */
        public int getTtlID() {
            return ttlID;
        }

    }
}

package biz.neustar.ultra.rest.constants;

public final class TTLConstants {
    public static final String GLOBAL_ALL_RECORDS_TTL = "Global (All Records) TTL";
    public static final String LOAD_BALANCING_TTL = "Monitored Load Balancing TTL";
    public static final String A_IPV4_HOST_TTL = "A (IPv4 Host) TTL";
    public static final String AAAA_IPV6_HOST_TTL = "AAAA (IPv6 Host) TTL";
    public static final String CNAME_ALIAS_TTL = "CNAME (Alias) TTL";
    public static final String MX_MAIL_EXCHANGE_TTL = "MX (Mail Exchange) TTL";
    public static final String TXT_TEXT_TTL = "TXT (Text) TTL";
    public static final String SPF_SENDER_POLICY_FRAMEWORK_TTL = "SPF (Sender Policy Framework) TTL";
    public static final String SRV_SERVICE_LOCATOR_TTL = "SRV (Service Locator) TTL";
    public static final String NS_NAMESERVER_TTL = "NS (Nameserver) TTL";
    public static final String PTR_POINTER_TTL = "PTR (Pointer) TTL";
    public static final String RP_RESPONSIBLE_PERSON_TTL = "RP (Responsible Person) TTL";
    public static final String HINFO_HARDWARE_INFO_TTL = "HINFO (Host Info) TTL";
    public static final String NAPTR_NAMING_AUTHORITY_POINTER_TTL = "NAPTR (Naming Authority Pointer) TTL";
    public static final String SOA_REFRESH = "SOA (Start of Authority) Refresh";
    public static final String SOA_RETRY = "SOA (Start of Authority) Retry";
    public static final String SOA_EXPIRE = "SOA (Start of Authority) Expire";
    public static final String SOA_MIN_CACHE = "SOA (Start of Authority) Min Cache";
    public static final String SOA_TTL = "SOA (Start of Authority) TTL";
    public static final String CAA_TTL = "CAA (Certification Authority Authorization) TTL";
    public static final String TLSA_TTL = "TLSA (Transport Layer Security Association) TTL";
    public static final String SSHFP_TTL = "SSHFP (Secure Shell Fingerprint) TTL";

    private TTLConstants() {
    }
}

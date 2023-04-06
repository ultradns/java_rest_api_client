package com.ultradns.ultra.rest.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum SecurityGroupEntryType.
 */
public enum SecurityGroupEntryType {

    ACCOUNT(2, null, "Account"),
    DOMAIN_SERVICES(40, ACCOUNT, "Domain Services"),
    ZONE(3, DOMAIN_SERVICES, "Domain"),
    RESOURCE_RECORDS(4, ZONE, "Resource Records"),
    A(25, RESOURCE_RECORDS, "A Record"),
    AAAA(26, RESOURCE_RECORDS, "AAAA Record"),
    CNAME(27, RESOURCE_RECORDS, "CNAME Record"),
    DIR_POOL(50, RESOURCE_RECORDS, "Directional Pool"),
    HINFO(33, RESOURCE_RECORDS, "HINFO Record"),
    MX(35, RESOURCE_RECORDS, "MX Record"),
    NAPTR(34, RESOURCE_RECORDS, "NAPTR Record"),
    NS(30, RESOURCE_RECORDS, "NS Record"),
    PTR(31, RESOURCE_RECORDS, "PTR Record"),
    RP(32, RESOURCE_RECORDS, "RP Record"),
    RD_POOL(52, RESOURCE_RECORDS, "RD Pool"),
    SB_POOL(23, RESOURCE_RECORDS, "SB Pool"),
    SRV(29, RESOURCE_RECORDS, "SRV Record"),
    TC_POOL(53, RESOURCE_RECORDS, "TC Pool"),
    TXT(28, RESOURCE_RECORDS, "TXT Record"),
    WEB_FORWARD(18, ZONE, "Web Forward"),
    MAIL_FORWARD(19, ZONE, "Mail Forward"),
    REPORTS(9, ACCOUNT, "Reports"),
    ACCOUNTS_PERMISSIONS(36, ACCOUNT, "Accounts & Permissions"),
    ACCOUNT_PREFERENCES(37, ACCOUNTS_PERMISSIONS, "Account Preferences"),
    BILLING(38, ACCOUNTS_PERMISSIONS, "Billing"),
    SERVICE_PACKAGE(11, ACCOUNTS_PERMISSIONS, "Service Package"),
    CAA(72, RESOURCE_RECORDS, "CAA Record"),
    TLSA(73, RESOURCE_RECORDS, "TLSA Record"),
    APEXALIAS(75, RESOURCE_RECORDS, "APEX Record"),
    SSHFP(84, RESOURCE_RECORDS, "SSHFP Record"),
    DS(85, RESOURCE_RECORDS, "DS Record");

    // Asset Type -> Name map
    private static final Map<Integer, SecurityGroupEntryType> ASSET_TYPES = new HashMap<>();

    // Populate asset type -> name lookup map
    static {
        // Loop assets
        for (SecurityGroupEntryType lAsset : values()) {
            // Populate Asset type -> name map
            ASSET_TYPES.put(lAsset.getAssetTypeID(), lAsset);
        }
    }

    private int assetTypeID;
    private SecurityGroupEntryType assetParentType;
    private String name;

    SecurityGroupEntryType(int assetTypeID, SecurityGroupEntryType assetParentType, String name) {
        this.assetTypeID = assetTypeID;
        this.assetParentType = assetParentType;
        this.name = name;
    }

    public static SecurityGroupEntryType getAssetTypeById(int id) {
        if (ASSET_TYPES.containsKey(id)) {
            return ASSET_TYPES.get(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Map<Integer, SecurityGroupEntryType> getAssetTypes() {
        return ASSET_TYPES;
    }

    public int getAssetTypeID() {
        return assetTypeID;
    }

    public String getName() {
        return name;
    }

    public SecurityGroupEntryType getAssetParentType() {
        return assetParentType;
    }
}


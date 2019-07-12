package biz.neustar.ultra.rest.constants;

import java.util.HashMap;
import java.util.Map;

public enum SecurityExceptionAssetType {
    //Do not add any more values in it unless we are extending the asset type for
    //which get all exceptions for an object is supported.

    // Asset ID
    ZONE(3, "ACCOUNT", "Domain"),
    DIR_POOL(50, Constants.RESOURCE_RECORD, "Directional Pool Record"),
    WEB_FORWARD(18, "ZONE", "Web Forward"),
    MAIL_FORWARD(19, "ZONE", "Mail Forward"),
    TC_POOL(53, Constants.RESOURCE_RECORD, "TC Pool Record"),
    RD_POOL(52, Constants.RESOURCE_RECORD, "RD Pool Record"),
    A(25, Constants.RESOURCE_RECORD, "A Record"),
    AAAA(26, Constants.RESOURCE_RECORD, "AAAA Record"),
    CNAME(27, Constants.RESOURCE_RECORD, "CNAME Record"),
    TXT(28, Constants.RESOURCE_RECORD, "TXT Record"),
    SRV(29, Constants.RESOURCE_RECORD, "SRV Record"),
    NS(30, Constants.RESOURCE_RECORD, "NS Record"),
    PTR(31, Constants.RESOURCE_RECORD, "PTR Record"),
    RP(32, Constants.RESOURCE_RECORD, "RP Record"),
    HINFO(33, Constants.RESOURCE_RECORD, "HINFO Record"),
    NAPTR(34, Constants.RESOURCE_RECORD, "NAPTR Record"),
    MX(35, Constants.RESOURCE_RECORD, "MX Record"),
    SB_POOL(23, Constants.RESOURCE_RECORD, "SB Pool Record"),
    CAA(72, Constants.RESOURCE_RECORD, "CAA Record"),
    TLSA(73, Constants.RESOURCE_RECORD, "TLSA Record"),
    APEXALIAS(75, Constants.RESOURCE_RECORD, "APEX Record"),
    SSHFP(84, Constants.RESOURCE_RECORD, "SSHFP Record"),
    DS(85, Constants.RESOURCE_RECORD, "DS Record");


    // Asset Type -> Name map
    private static final Map<Integer, SecurityExceptionAssetType> ASSET_TYPES = new HashMap<>();

    // Populate asset type -> name lookup map
    static {
        // Loop assets
        for (SecurityExceptionAssetType lAsset : values()) {
            // Populate Asset type -> name map
            ASSET_TYPES.put(lAsset.getAssetTypeID(), lAsset);
        }
    }

    private int assetTypeID;
    private String assetParentType;
    private String name;

    SecurityExceptionAssetType(int assetTypeID, String assetParentType, String name) {
        this.assetTypeID = assetTypeID;
        this.assetParentType = assetParentType;
        this.name = name;
    }

    public static SecurityExceptionAssetType getAssetTypeById(int id) {
        if (ASSET_TYPES.containsKey(id)) {
            return ASSET_TYPES.get(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Map<Integer, SecurityExceptionAssetType> getAssetTypes() {
        return ASSET_TYPES;
    }

    public int getAssetTypeID() {
        return assetTypeID;
    }

    public String getName() {
        return name;
    }

    public String getAssetParentType() {
        return assetParentType;
    }
}

final class Constants {

    public static final String RESOURCE_RECORD = "RESOURCE_RECORD";

    private Constants() {
        //Do not instantiate any thing.
    }

}

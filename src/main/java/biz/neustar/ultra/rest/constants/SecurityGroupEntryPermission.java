package biz.neustar.ultra.rest.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum SecurityGroupEntryPermission.
 */
public enum SecurityGroupEntryPermission {

    /**
     * The none.
     */
    NONE(0, "None"),

    /**
     * The read.
     */
    READ(1, "Read"),

    /**
     * The write.
     */
    WRITE(3, "Write"),

    /**
     * The create.
     */
    CREATE(7, "Create"),

    /**
     * The delete.
     */
    DELETE(15, "Delete"),

    /**
     * The inherit.
     */
    INHERIT(-1, "Inherit"),

    /**
     * The grant.
     */
    GRANT(31, "Grant");

    // Security Levels -> Name map
    private static final Map<Integer, SecurityGroupEntryPermission> SECURITY_PERMISSIONS = new HashMap<>();

    // Populate Security Levels -> name lookup map
    static {
        // Loop Security Levels
        for (SecurityGroupEntryPermission permission : values()) {
            // Populate Security Level -> name map
            SECURITY_PERMISSIONS.put(permission.getSecurityLevelId(), permission);
        }
    }

    private int securityLevelId;
    private String securityLevelName;

    SecurityGroupEntryPermission(int securityLevelId, String securityLevelName) {
        this.securityLevelId = securityLevelId;
        this.securityLevelName = securityLevelName;
    }

    public static SecurityGroupEntryPermission getSecurityLevelById(int id) {
        if (SECURITY_PERMISSIONS.containsKey(id)) {
            return SECURITY_PERMISSIONS.get(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getSecurityLevelId() {
        return securityLevelId;
    }

    public String getSecurityLevelName() {
        return securityLevelName;
    }
}

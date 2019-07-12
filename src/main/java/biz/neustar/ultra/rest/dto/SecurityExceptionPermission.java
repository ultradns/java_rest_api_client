package biz.neustar.ultra.rest.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum SecurityExceptionPermission.
 */
public enum SecurityExceptionPermission {

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
    DELETE(15, "Delete");

    // Security Levels -> Name map
    private static final Map<Integer, SecurityExceptionPermission> SECURITY_PERMISSIONS = new HashMap<>();

    // Populate Security Levels -> name lookup map
    static {
        // Loop Security Levels
        for (SecurityExceptionPermission permission : values()) {
            // Populate Security Level -> name map
            SECURITY_PERMISSIONS.put(permission.getSecurityLevelId(), permission);
        }
    }

    private int securityLevelId;
    private String securityLevelName;

    SecurityExceptionPermission(int securityLevelId, String securityLevelName) {
        this.securityLevelId = securityLevelId;
        this.securityLevelName = securityLevelName;
    }

    SecurityExceptionPermission() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    public static SecurityExceptionPermission getSecurityLevelById(int id) {
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

package com.ultradns.ultra.rest.dto;

public enum ZoneSecurityType {
    NONE(0),
    NSEC(1),
    NSEC3(2),
    NSEC3_OPT_OUT(3);

    private final int value;

    ZoneSecurityType(final int newValue) {
        value = newValue;
    }

    public static ZoneSecurityType getValue(short securityType) {
        for (ZoneSecurityType zoneSecurityType : ZoneSecurityType.values()) {
            if (zoneSecurityType.value == securityType) {
                return zoneSecurityType;
            }
        }
        return NONE;
    }

    public int getValue() {
        return value;
    }
}

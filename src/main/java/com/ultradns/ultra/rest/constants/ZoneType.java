package com.ultradns.ultra.rest.constants;

/*
 * User: jbodner
 * Date: 7/1/13
 * Time: 6:58 PM
 *
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public enum ZoneType {
    PRIMARY((short) 1),
    SECONDARY((short) 2),
    ALIAS((short) 3);
    private final short value;

    ZoneType(final short newValue) {
        value = newValue;
    }

    public static ZoneType getValue(short zoneValue) {
        for (ZoneType zoneType : ZoneType.values()) {
            if (zoneType.value == zoneValue) {
                return zoneType;
            }
        }
        return null;
    }

    public short getValue() {
        return value;
    }
}

package biz.neustar.ultra.rest.constants;

/*
 * User: jbodner
 * Date: 7/1/13
 * Time: 6:58 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public enum ZoneType {
    PRIMARY((short) 1), SECONDARY((short) 2), ALIAS((short) 3);
    private final short value;

    private ZoneType(final short newValue) {
        value = newValue;
    }

    public short getValue() {
        return value;
    }

    public static ZoneType getValue(short zoneValue) {
        for (ZoneType zoneType : ZoneType.values()) {
            if (zoneType.value == zoneValue) {
                return zoneType;
            }
        }
        return null;
    }
}

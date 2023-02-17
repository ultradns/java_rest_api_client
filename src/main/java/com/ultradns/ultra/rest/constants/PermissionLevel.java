package com.ultradns.ultra.rest.constants;

/*
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara
 * logo and related names and logos are registered trademarks, service marks or
 * tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */

public enum PermissionLevel implements java.io.Serializable {

    /**
     * The none.
     */
    NONE(0),

    /**
     * The read.
     */
    READ(1),

    /**
     * The write.
     */
    WRITE(3),

    /**
     * The create.
     */
    CREATE(7),

    /**
     * The delete.
     */
    DELETE(15),

    /**
     * The inherit.
     */
    INHERIT(-1),

    /**
     * The grant.
     */
    GRANT(31);

    private int bit;

    /**
     * Parameterized constructor for PermissionLevel.
     *
     * @param newValue
     *            - New value of bit
     */
    PermissionLevel(int newValue) {
        bit = newValue;
    }

    /**
     * Get bit.
     *
     * @return int - Bit
     */
    public int getBit() {
        return bit;
    }

    public static PermissionLevel getValue(int bitValue) {
        for (PermissionLevel permissionLevel : PermissionLevel.values()) {
            if (permissionLevel.bit == bitValue) {
                return permissionLevel;
            }
        }
        return null;
    }
}

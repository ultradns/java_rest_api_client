/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.constants;

/**
 * ListProbeType.
 */
public enum ListProbeType {

    ALL("all"),
    RECORD("record"),
    POOL("global");

    private final String value;

    ListProbeType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.constants;

/**
 * ListProbeType.
 *
 * @author kushalraj.bhandari
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

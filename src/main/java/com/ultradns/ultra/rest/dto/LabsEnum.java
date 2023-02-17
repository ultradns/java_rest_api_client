/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

public enum LabsEnum {

    AGARI("AGARI"),
    PCAP("PCAP"),
    UNKNOWN("__UNKNOWN__");

    private String labId;

    LabsEnum(String labId) {
        this.labId = labId;
    }

    public static LabsEnum get(String labId) {
        for (LabsEnum le : values()) {
            if (le.labId.equals(labId)) {
                return le;
            }
        }
        return UNKNOWN;
    }

    public String getLabId() {
        return labId;
    }
}

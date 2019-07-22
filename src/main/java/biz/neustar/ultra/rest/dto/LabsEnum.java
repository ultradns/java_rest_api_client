/*
 * Copyright 2000-2015 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

/*
 * @author vpavlyuk
 * @date 2/12/2015
 * @time 3:28 PM
 */
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

package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.UltraRestSharedConstant;

/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class ZoneDnssecType {

    private UltraRestSharedConstant.DnssecType dnssecType;

    public ZoneDnssecType() {
        dnssecType = UltraRestSharedConstant.DnssecType.NONE;
    }

    public ZoneDnssecType(UltraRestSharedConstant.DnssecType dnssecType) {
        this.dnssecType = dnssecType;
    }

    public UltraRestSharedConstant.DnssecType getDnssecType() {
        return dnssecType;
    }

    public void setDnssecType(UltraRestSharedConstant.DnssecType dnssecType) {
        this.dnssecType = dnssecType;
    }
}

/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;

import java.util.List;

/**
 * Restrict IP List.
 *
 */
@JsonInclude(Include.NON_NULL)
public class RestrictIPList {

    /**
     * RestrictIP list.
     */
    private List<RestrictIP> restrictIP;

    /**
     * Empty Constructor.
     */
    public RestrictIPList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param restrictIP - restrictIP.
     */
    public RestrictIPList(List<RestrictIP> restrictIP) {
        super();
        this.restrictIP = restrictIP;
    }

    /**
     * Get the restrictIP list.
     *
     * @return the restrictIP
     */
    public List<RestrictIP> getRestrictIP() {
        return restrictIP;
    }

    /**
     * Set the restrictIP list.
     *
     * @param restrictIP the restrictIP to set
     */
    public void setRestrictIP(List<RestrictIP> restrictIP) {
        this.restrictIP = restrictIP;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("restrictIPList", getRestrictIP()).toString();
    }
}

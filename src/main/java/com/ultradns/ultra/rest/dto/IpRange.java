/**
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class represents DTO to hold IP ranges. The start IP should be less than or equal to end IP and both IPs should
 * belong to same IP family (IPv4 or IPv6).
 */
@JsonInclude(Include.NON_NULL)
public class IpRange {
    /**
     * The start IP.
     */
    private String startIp;

    /**
     * The end IP.
     */
    private String endIp;

    /**
     * Default constructor.
     */
    public IpRange() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param startIp The start IP.
     * @param endIp   The end IP.
     */
    public IpRange(final String startIp, final String endIp) {
        this.startIp = startIp;
        this.endIp = endIp;
    }

    /**
     * This method returns the start IP of network.
     *
     * @return the startIp
     */
    public final String getStartIp() {
        return startIp;
    }

    /**
     * This method sets the start IP of network.
     *
     * @param startIp the startIp to set
     */
    public final void setStartIp(final String startIp) {
        this.startIp = startIp;
    }

    /**
     * This method returns end IP of network.
     *
     * @return the endIp
     */
    public final String getEndIp() {
        return endIp;
    }

    /**
     * This method sets end IP of the network.
     *
     * @param endIp the endIp to set
     */
    public final void setEndIp(final String endIp) {
        this.endIp = endIp;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getStartIp(), getEndIp());
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof IpRange) {
            IpRange that = (IpRange) object;
            return Objects.equal(getStartIp(), that.getStartIp()) && Objects.equal(getEndIp(), that.getEndIp());
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("startIp", getStartIp()).add("endIp", getEndIp()).toString();
    }

}

/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */

package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Secondary zone info.
 *
 * @author nupadhyay
 */
@JsonInclude(Include.NON_NULL)
public class SecondaryZoneInfo {

    /**
     * Primary name servers.
     */
    private PrimaryNameServers primaryNameServers;

    /**
     * The notification email Id.
     */
    private String notificationEmailAddress;

    /**
     * The allow unresponsive NS.
     */
    private Boolean allowUnresponsiveNS;

    /**
     * Secondary zone info.
     */
    public SecondaryZoneInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param primaryNameServers
     */
    public SecondaryZoneInfo(PrimaryNameServers primaryNameServers) {
        super();
        this.primaryNameServers = primaryNameServers;
    }

    /**
     * Set primary name servers.
     *
     * @return the primaryNameServers
     */
    public final PrimaryNameServers getPrimaryNameServers() {
        return primaryNameServers;
    }

    /**
     * Get primary name servers.
     *
     * @param primaryNameServers the primaryNameServers to set
     */
    public final void setPrimaryNameServers(PrimaryNameServers primaryNameServers) {
        this.primaryNameServers = primaryNameServers;
    }

    /**
     * This method returns notification email address for secondary zone.
     *
     * @return the notificationEmailAddress
     */
    public String getNotificationEmailAddress() {
        return notificationEmailAddress;
    }

    /**
     * This method sets notification email address for secondary zone.
     *
     * @param notificationEmailAddress the notificationEmailAddress to set
     */
    public void setNotificationEmailAddress(String notificationEmailAddress) {
        this.notificationEmailAddress = notificationEmailAddress;
    }

    /**
     * Checks if is allow unresponsive NS.
     *
     * @return true, if is allow unresponsive NS
     */
    public Boolean isAllowUnresponsiveNS() {
        return allowUnresponsiveNS;
    }

    /**
     * Sets the allow unresponsive NS.
     *
     * @param allowUnresponsiveNS the new allow unresponsive NS
     */
    public void setAllowUnresponsiveNS(Boolean allowUnresponsiveNS) {
        this.allowUnresponsiveNS = allowUnresponsiveNS;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("primaryNameServers", getPrimaryNameServers())
                .add("notificationEmailAddress", notificationEmailAddress)
                .add("allowUnresponsiveNS", allowUnresponsiveNS)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(primaryNameServers, notificationEmailAddress, allowUnresponsiveNS);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SecondaryZoneInfo)) {
            return false;
        }
        SecondaryZoneInfo that = (SecondaryZoneInfo) object;
        return Objects.equal(this.primaryNameServers, that.primaryNameServers) && Objects.equal(
                this.notificationEmailAddress, that.notificationEmailAddress) && Objects.equal(this.allowUnresponsiveNS,
                that.allowUnresponsiveNS);
    }

}

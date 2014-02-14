/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
 
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

/**
 * Secondary zone info.
 * @author nupadhyay
 *
 */
@JsonInclude(Include.NON_NULL)
public class SecondaryZoneInfo {


    /**
     * Secondary zone info.
     */
    public SecondaryZoneInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     * @param primaryNameServers
     */
    public SecondaryZoneInfo(PrimaryNameServers primaryNameServers) {
        super();
        this.primaryNameServers = primaryNameServers;
    }

    /**
     * Primary name servers. 
     */
    private PrimaryNameServers primaryNameServers;

    /**
     * The notification email Id.
     */
    private String notificationEmailAddress;

    /**
     * Set primary name servers.
     * @return the primaryNameServers
     */
    public final PrimaryNameServers getPrimaryNameServers() {
        return primaryNameServers;
    }
    /**
     * Get primary name servers.
     * @param primaryNameServers the primaryNameServers to set
     */
    public final void setPrimaryNameServers(PrimaryNameServers primaryNameServers) {
        this.primaryNameServers = primaryNameServers;
    }
    
    
    /**
     * This method returns notification email address for secondary zone.
     * @return the notificationEmailAddress
     */
    public String getNotificationEmailAddress() {
        return notificationEmailAddress;
    }

    /**
     * This method sets notification email address for secondary zone.
     * @param notificationEmailAddress the notificationEmailAddress to set
     */
    public void setNotificationEmailAddress(String notificationEmailAddress) {
        this.notificationEmailAddress = notificationEmailAddress;
    }


    @Override
    public final String toString() {
        return Objects.toStringHelper(this)
                .add("primaryNameServers", getPrimaryNameServers())
                .add("notificationEmailAddress", notificationEmailAddress).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(primaryNameServers, notificationEmailAddress);
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SecondaryZoneInfo)) {
            return false;
        }
        SecondaryZoneInfo that = (SecondaryZoneInfo) object;
        return Objects.equal(this.primaryNameServers, that.primaryNameServers)
                && Objects.equal(this.notificationEmailAddress,
                        that.notificationEmailAddress);
    }

}

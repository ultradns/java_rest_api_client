/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import biz.neustar.ultra.rest.constants.ZoneType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;


/**
 * Zone properties.
 * @author nupadhyay
 *
 */
@JsonInclude(Include.NON_NULL)
public class ZoneProperties {
    /**
     * Empty constructor.
     */
    public ZoneProperties() {
        super();
    }

    /**
     * Parameterized constructor.
     * @param name - Name
     * @param accountName - Account Name.
     * @param type - Type
     * @param zoneId - Zone ID.
     * @param dnssecStatus - DNS Sec Status
     * @param owner - Owner
     */
    public ZoneProperties(String name, String accountName, ZoneType type,
                          String zoneId, String dnssecStatus, String owner) {
        super();
        this.name = name;
        this.accountName = accountName;
        this.type = type;
        this.zoneId = zoneId;
        this.dnssecStatus = dnssecStatus;
        this.owner = owner;
    }

    /**
     * Zone name.
     */
    private String name;
    /**
     * Account name.
     */
    private String accountName;

    /**
     * Zone type. 
     */
    private ZoneType type;

    /**
     * Zone Id. 
     */
    private String zoneId;
    /**
     * DNS Security Status. 
     */
    private String dnssecStatus;

    /**
     * Owner Name. 
     */
    private String owner;

    /**
     * Resource record count. 
     */
    private long resourceRecordCount;

    /**
     * Last modified date time in ISO 8601 format. 
     */
    private String lastModifiedDateTime;

    /**
     * Get Name.
     * @return the name
     */
    public final String getName() {
        return name;
    }
    /**
     * Set name.
     * @param name the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }
    /**
     * Get Account Name.
     * @return the accountName
     */
    public final String getAccountName() {
        return accountName;
    }
    /**
     * St account name.
     * @param accountName the accountName to set
     */
    public final void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    /**
     * Get type.
     * @return the type
     */
    public final ZoneType getType() {
        return type;
    }
    /**
     * Set type.
     * @param type the type to set
     */
    public final void setType(ZoneType type) {
        this.type = type;
    }

    /**
     * get Zone id.
     * @return the zoneId
     */
    public final String getZoneId() {
        return zoneId;
    }
    /**
     * Set zone id.
     * @param zoneId the zoneId to set
     */
    public final void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }
    /**
     * Get dns sec status.
     * @return the dnssecStatus
     */
    public final String getDnssecStatus() {
        return dnssecStatus;
    }
    /**
     * Set dns sec status.
     * @param dnssecStatus the dnssecStatus to set
     */
    public final void setDnssecStatus(String dnssecStatus) {
        this.dnssecStatus = dnssecStatus;
    }

    /**
     * Get owner.
     * @return the owner.
     */
    public final String getOwner() {
        return owner;
    }
    /**
     * Set owner.
     * @param owner the owner to set
     */
    public final void setOwner(String owner) {
        this.owner = owner;
    }
    /**
     * Get the resourceRecordCount.
     * @return the resourceRecordCount
     */
    public long getResourceRecordCount() {
        return resourceRecordCount;
    }

    /**
     * Set the resourceRecordCount.
     * @param resourceRecordCount the resourceRecordCount to set
     */
    public void setResourceRecordCount(long resourceRecordCount) {
        this.resourceRecordCount = resourceRecordCount;
    }

    /**
     * Get the lastModifiedDateTime.
     * @return the lastModifiedDateTime
     */
    public String getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    /**
     * Set the lastModifiedDateTime.
     * @param lastModifiedDateTime the lastModifiedDateTime to set
     */
    public void setLastModifiedDateTime(String lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return Objects.toStringHelper(this).add("name", getName())
                .add("accountName", getAccountName())
                .add("type", getType()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getName(), getAccountName(), getType());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof ZoneProperties)) {
            return false;
        }
        final ZoneProperties other = (ZoneProperties) obj;
        isEqual =  Objects.equal(getName(), other.getName())
                && Objects.equal(getAccountName(), other.getAccountName())
                && Objects.equal(getType(), other.getType());
        return isEqual;
    }
}

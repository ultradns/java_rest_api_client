/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.ZoneType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Zone properties.
 *
 * @author nupadhyay
 */
@JsonInclude(Include.NON_NULL)
public class ZoneProperties {

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
    @JsonIgnore
    private String zoneId;
    /**
     * DNS Security Status.
     */
    private String dnssecStatus;

    /**
     * Zone Status.
     */
    private ZoneStatus status;

    /**
     * Owner Name.
     */
    private String owner;

    /**
     * Resource record count.
     */
    private Long resourceRecordCount;

    /**
     * Last modified date time in ISO 8601 format.
     */
    private String lastModifiedDateTime;

    /**
     * Empty constructor.
     */
    public ZoneProperties() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param name         - Name
     * @param accountName  - Account Name.
     * @param type         - Type
     * @param zoneId       - Zone ID.
     * @param dnssecStatus - DNS Sec Status
     * @param owner        - Owner
     */
    public ZoneProperties(String name, String accountName, ZoneType type, String zoneId, String dnssecStatus,
            String owner) {
        super();
        this.name = name;
        this.accountName = accountName;
        this.type = type;
        this.zoneId = zoneId;
        this.dnssecStatus = dnssecStatus;
        this.owner = owner;
    }

    /**
     * Parameterized constructor.
     *
     * @param name         - Name
     * @param accountName  - Account Name.
     * @param type         - Type
     * @param zoneId       - Zone ID.
     * @param dnssecStatus - DNS Sec Status
     * @param status       - status
     * @param owner        - Owner
     */
    public ZoneProperties(String name, String accountName, ZoneType type, String zoneId, String dnssecStatus,
            ZoneStatus status, String owner) {
        super();
        this.name = name;
        this.accountName = accountName;
        this.type = type;
        this.zoneId = zoneId;
        this.dnssecStatus = dnssecStatus;
        this.status = status;
        this.owner = owner;
    }

    /**
     * Get Name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Set name.
     *
     * @param name the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * Get Account Name.
     *
     * @return the accountName
     */
    public final String getAccountName() {
        return accountName;
    }

    /**
     * St account name.
     *
     * @param accountName the accountName to set
     */
    public final void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Get type.
     *
     * @return the type
     */
    public final ZoneType getType() {
        return type;
    }

    /**
     * Set type.
     *
     * @param type the type to set
     */
    public final void setType(ZoneType type) {
        this.type = type;
    }

    /**
     * get Zone id.
     *
     * @return the zoneId
     */
    public final String getZoneId() {
        return zoneId;
    }

    /**
     * Set zone id.
     *
     * @param zoneId the zoneId to set
     */
    public final void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    /**
     * Get dns sec status.
     *
     * @return the dnssecStatus
     */
    public final String getDnssecStatus() {
        return dnssecStatus;
    }

    /**
     * Set dns sec status.
     *
     * @param dnssecStatus the dnssecStatus to set
     */
    public final void setDnssecStatus(String dnssecStatus) {
        this.dnssecStatus = dnssecStatus;
    }

    /**
     * Get owner.
     *
     * @return the owner.
     */
    public final String getOwner() {
        return owner;
    }

    /**
     * Set owner.
     *
     * @param owner the owner to set
     */
    public final void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Get the resourceRecordCount.
     *
     * @return the resourceRecordCount
     */
    public Long getResourceRecordCount() {
        return resourceRecordCount;
    }

    /**
     * Set the resourceRecordCount.
     *
     * @param resourceRecordCount the resourceRecordCount to set
     */
    public void setResourceRecordCount(Long resourceRecordCount) {
        this.resourceRecordCount = resourceRecordCount;
    }

    /**
     * Get the lastModifiedDateTime.
     *
     * @return the lastModifiedDateTime
     */
    public String getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    /**
     * Set the lastModifiedDateTime.
     *
     * @param lastModifiedDateTime the lastModifiedDateTime to set
     */
    public void setLastModifiedDateTime(String lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    /**
     * Get zone status.
     *
     * @return the status
     */
    public ZoneStatus getStatus() {
        return status;
    }

    /**
     * Set zone status.
     *
     * @param status the status to set
     */
    public void setStatus(ZoneStatus status) {
        this.status = status;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", getName())
                .add("accountName", getAccountName())
                .add("type", getType())
                .add("status", getStatus())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getName(), getAccountName(), getType(), getStatus());
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
        isEqual = Objects.equal(getName(), other.getName()) && Objects.equal(getAccountName(), other.getAccountName())
                && Objects.equal(getType(), other.getType()) && Objects.equal(getStatus(), other.getStatus());
        return isEqual;
    }

    /**
     * For zone status.
     */
    public enum ZoneStatus {
        SUSPENDED(1),
        ACTIVE(0);
        private Integer value;

        ZoneStatus(Integer value) {
            this.value = value;
        }

        public static ZoneStatus valueOf(Integer value) {
            for (ZoneStatus zoneStatus : ZoneStatus.values()) {
                if (value.equals(zoneStatus.value)) {
                    return zoneStatus;
                }
            }
            return null;
        }
    }
}

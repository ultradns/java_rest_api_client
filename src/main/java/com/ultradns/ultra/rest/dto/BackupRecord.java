/*
 * User: nupadhyay
 * Date: Apr 7, 2014
 * Time: 11:17:15 AM
 *
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Backup record. To specify the record to be served if all other records fail
 */
@JsonInclude(Include.NON_NULL)
public class BackupRecord {

    /**
     * The IPv4 address or CNAME for the backup record.
     */
    private String rdata;

    /**
     * Specifies the time, from 0-30 minutes, that SiteBacker waits after
     * <p>
     * detecting that the pool record has failed before activating primary records.
     */
    private Integer failoverDelay;
    /**
     * The record type for the backup record.
     */
    private String type;

    /**
     * Alive (available to serve) or dead?
     */
    private Boolean availableToServe;

    public BackupRecord() {
        super();
    }

    public BackupRecord(String rdata, Integer failoverDelay) {
        super();
        this.rdata = rdata;
        this.failoverDelay = failoverDelay;
    }

    /**
     * To get this{@link #rdata}.
     *
     * @return the rdata
     */
    public String getRdata() {
        return rdata;
    }

    /**
     * To set this{@link #rdata}.
     *
     * @param rdata the rdata to set
     */
    public void setRdata(String rdata) {
        this.rdata = rdata;
    }

    /**
     * To get this{@link #failoverDelay}.
     *
     * @return the failoverDelay
     */
    public Integer getFailoverDelay() {
        return failoverDelay;
    }

    /**
     * To set this{@link #failoverDelay}.
     *
     * @param failoverDelay the failoverDelay to set
     */
    public void setFailoverDelay(Integer failoverDelay) {
        this.failoverDelay = failoverDelay;
    }

    /**
     * Get record type.
     *
     * @return type the record type
     */
    public String getType() {
        return type;
    }

    /**
     * Set record type.
     *
     * @param type type the record type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get availableToServe.
     *
     * @return availableToServe the availableToServe value
     */
    public Boolean isAvailableToServe() {
        return availableToServe;
    }

    /**
     * Set availableToServe.
     *
     * @param availableToServe the availableToServe value to set
     */
    public void setAvailableToServe(Boolean availableToServe) {
        this.availableToServe = availableToServe;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("failoverDelay", getFailoverDelay())
                .add("rdata", getRdata())
                .add("type", getType())
                .add("availableToServe", isAvailableToServe())
                .toString();

    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getFailoverDelay(), getRdata(), getType(), isAvailableToServe());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof BackupRecord)) {
            return false;
        }
        final BackupRecord other = (BackupRecord) obj;
        isEqual = Objects.equal(getFailoverDelay(), other.getFailoverDelay())
                && Objects.equal(getRdata(), other.getRdata()) && Objects.equal(getType(), other.getType())
                && Objects.equal(isAvailableToServe(), other.isAvailableToServe());
        return isEqual;
    }

}

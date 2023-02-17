/*
 * User: nupadhyay
 * Date: Aug 20, 2014
 * Time: 5:50:15 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.sql.Timestamp;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsSecInfo {

    /**
     * The status.
     */
    private String status;

    /**
     * The policy.
     */
    private DnsSecPolicy policy;

    /**
     * The keys.
     */
    private List<DnsSecKey> keys;

    /**
     * The last modified date time.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Timestamp lastModifiedDateTime;

    /**
     * The last modified zone date time.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Timestamp lastModifiedZoneDateTime;

    /**
     * The resign needed.
     */
    private boolean resignNeeded;

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the policy.
     *
     * @return the policy
     */
    public DnsSecPolicy getPolicy() {
        return policy;
    }

    /**
     * Sets the policy.
     *
     * @param policy the new policy
     */
    public void setPolicy(DnsSecPolicy policy) {
        this.policy = policy;
    }

    /**
     * Gets the keys.
     *
     * @return the keys
     */
    public List<DnsSecKey> getKeys() {
        return keys;
    }

    /**
     * Sets the keys.
     *
     * @param keys the new keys
     */
    public void setKeys(List<DnsSecKey> keys) {
        this.keys = keys;
    }

    /**
     * Gets the last modified date time.
     *
     * @return the last modified date time
     */
    public Timestamp getLastModifiedDateTime() {
        if (lastModifiedDateTime != null) {
            return (Timestamp) lastModifiedDateTime.clone();
        } else {
            return null;
        }
    }

    public void setLastModifiedDateTime(Timestamp lastModifiedDateTime) {
        this.lastModifiedDateTime = new Timestamp(lastModifiedDateTime.getTime());
    }

    /**
     * Gets the last modified zone date time.
     *
     * @return the last modified zone date time
     */
    public Timestamp getLastModifiedZoneDateTime() {
        if (lastModifiedZoneDateTime != null) {
            return (Timestamp) lastModifiedZoneDateTime.clone();
        } else {
            return null;
        }
    }

    /**
     * Sets the last modified zone date time.
     *
     * @param lastModifiedZoneDateTime the new last modified zone date time
     */
    public void setLastModifiedZoneDateTime(Timestamp lastModifiedZoneDateTime) {
        this.lastModifiedZoneDateTime = new Timestamp(lastModifiedZoneDateTime.getTime());
    }

    /**
     * Gets the resign needed.
     *
     * @return the resign needed
     */
    public boolean getResignNeeded() {
        return resignNeeded;
    }

    /**
     * Sets the resign needed.
     *
     * @param resignNeeded the new resign needed
     */
    public void setResignNeeded(boolean resignNeeded) {
        this.resignNeeded = resignNeeded;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("status", getStatus())
                .add("lastModifiedDateTime", getLastModifiedDateTime())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getStatus());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof DnsSecInfo)) {
            return false;
        }
        final DnsSecInfo other = (DnsSecInfo) obj;
        isEqual = Objects.equal(getStatus(), other.getStatus()) && Objects.equal(getLastModifiedDateTime(),
                other.getLastModifiedDateTime());
        return isEqual;
    }

}

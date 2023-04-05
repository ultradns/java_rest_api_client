/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * SBTC Notification.
 */
public class SBTCNotification {
    /**
     * The list of pool record settings for this email address.
     */
    private final List<RecordNotificationInfo> poolRecords;

    /**
     * The email address being notified.
     */
    private String email;

    public SBTCNotification() {
        poolRecords = Lists.newLinkedList();
    }

    public SBTCNotification(String email) {
        super();
        this.email = email;
        poolRecords = Lists.newLinkedList();
    }

    public void add(RecordNotificationInfo poolRecord) {
        poolRecords.add(poolRecord);
    }

    public List<RecordNotificationInfo> getPoolRecords() {
        return poolRecords;
    }

    public void setPoolRecords(List<RecordNotificationInfo> poolRecords) {
        this.poolRecords.addAll(poolRecords);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof SBTCNotification)) {
            return false;
        }
        final SBTCNotification other = (SBTCNotification) obj;
        isEqual = Objects.equal(getEmail(), other.getEmail());
        return isEqual;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("email", getEmail()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getEmail());
    }

}

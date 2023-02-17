/*
 * User: nupadhyay
 * Date: Apr 1, 2014
 * Time: 6:33:30 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import java.util.Objects;

/**
 * SBTCNotification Info representing a Pool SBTCNotification.
 */
public class RecordNotificationInfo {
    /**
     * The pool record.
     */
    private String poolRecord;
    private SBTCNotificationInfo notification;

    public RecordNotificationInfo() {
        super();
    }

    public RecordNotificationInfo(String poolRecord, SBTCNotificationInfo notificationInfo) {
        this.poolRecord = poolRecord;
        this.notification = notificationInfo;

    }

    public String getPoolRecord() {
        return poolRecord;
    }

    public void setPoolRecord(String poolRecord) {
        this.poolRecord = poolRecord;
    }

    public SBTCNotificationInfo getNotification() {
        return notification;
    }

    public void setNotification(SBTCNotificationInfo notification) {
        this.notification = notification;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof RecordNotificationInfo)) {
            return false;
        }
        final RecordNotificationInfo other = (RecordNotificationInfo) obj;
        isEqual = Objects.equals(getPoolRecord(), other.getPoolRecord())
                && Objects.equals(getNotification(), other.getNotification());
        return isEqual;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getPoolRecord(), getNotification());
    }
}

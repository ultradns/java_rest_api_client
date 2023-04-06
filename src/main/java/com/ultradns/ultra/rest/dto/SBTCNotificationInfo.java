package com.ultradns.ultra.rest.dto;

import java.util.Objects;

/**
 * Notification info.
 */
public class SBTCNotificationInfo {

    /**
     * Indicates whether to notify on probe events.
     */
    private boolean probe;
    /**
     * Indicates whether to notify on record events.
     */
    private boolean record;
    /**
     * Indicates whether to notify on scheduled events.
     */
    private boolean scheduled;

    public SBTCNotificationInfo() {
        // empty constructor
    }

    public SBTCNotificationInfo(boolean probe, boolean record, boolean scheduled) {
        this.probe = probe;
        this.record = record;
        this.scheduled = scheduled;
    }

    public boolean isProbe() {
        return probe;
    }

    public void setProbe(boolean probe) {
        this.probe = probe;
    }

    public boolean isRecord() {
        return record;
    }

    public void setRecord(boolean record) {
        this.record = record;
    }

    public boolean isScheduled() {
        return scheduled;
    }

    public void setScheduled(boolean scheduled) {
        this.scheduled = scheduled;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof SBTCNotificationInfo)) {
            return false;
        }
        final SBTCNotificationInfo other = (SBTCNotificationInfo) obj;
        isEqual = Objects.equals(isProbe(), other.isProbe()) && Objects.equals(isRecord(), other.isRecord())
                && Objects.equals(isScheduled(), other.isScheduled());
        return isEqual;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hash(isProbe(), isRecord(), isScheduled());
    }
}

/**
 *
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.AllowedRecordForcedState;
import com.ultradns.ultra.rest.constants.RegionFailureSensitivity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Simple Failover Pool Profile Dto.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleFailoverPoolProfile implements Profile {

    /**
     * An optional description of the SF pool.
     */
    private String poolDescription;

    private String liveRecordDescription;

    // default for SF pool is NOT_FORCED
    private AllowedRecordForcedState liveRecordState;

    @Valid
    private FailoverRecord backupRecord;

    @NotNull(message = "SF_POOL_MONITOR_REQUIRED")
    @Valid
    private Monitor monitor;

    @NotNull(message = "SF_POOL_REGION_FAILURE_SENSITIVITY_REQUIRED")
    private RegionFailureSensitivity regionFailureSensitivity;

    private String status;

    /**
     * Empty constructor.
     */
    public SimpleFailoverPoolProfile() {
        super();
    }

    public String getPoolDescription() {
        return poolDescription;
    }

    public void setPoolDescription(String poolDescription) {
        this.poolDescription = poolDescription;
    }

    public String getLiveRecordDescription() {
        return liveRecordDescription;
    }

    public void setLiveRecordDescription(String liveRecordDescription) {
        this.liveRecordDescription = liveRecordDescription;
    }

    public String getLiveRecordStateValue() {
        return liveRecordState.name();
    }

    public AllowedRecordForcedState getLiveRecordState() {
        return liveRecordState;
    }

    public void setLiveRecordState(AllowedRecordForcedState liveRecordState) {
        this.liveRecordState = liveRecordState;
    }

    public FailoverRecord getBackupRecord() {
        return backupRecord;
    }

    public void setBackupRecord(FailoverRecord backupRecord) {
        this.backupRecord = backupRecord;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public RegionFailureSensitivity getRegionFailureSensitivity() {
        return regionFailureSensitivity;
    }

    public void setRegionFailureSensitivity(RegionFailureSensitivity regionFailureSensitivity) {
        this.regionFailureSensitivity = regionFailureSensitivity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
                .add("poolDescription", getPoolDescription())
                .add("liveRecordDescription", getLiveRecordDescription())
                .add("liveRecordState", getLiveRecordState())
                .add("backRecord", getBackupRecord())
                .add("monitor", getMonitor())
                .add("regionFailureSensitivity", getRegionFailureSensitivity())
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
        return Objects.hashCode(getPoolDescription(), getLiveRecordDescription(), getLiveRecordState(),
                getBackupRecord(), getMonitor(), getRegionFailureSensitivity(), getStatus());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof SimpleFailoverPoolProfile)) {
            return false;
        }
        final SimpleFailoverPoolProfile other = (SimpleFailoverPoolProfile) obj;
        return Objects.equal(getPoolDescription(), other.getPoolDescription()) && Objects.equal(
                getLiveRecordDescription(), other.getLiveRecordDescription()) && Objects.equal(getLiveRecordState(),
                other.getLiveRecordState()) && Objects.equal(getBackupRecord(), other.getBackupRecord())
                && Objects.equal(getMonitor(), other.getMonitor()) && Objects.equal(getRegionFailureSensitivity(),
                other.getRegionFailureSensitivity()) && Objects.equal(getStatus(), other.getStatus());
    }
}

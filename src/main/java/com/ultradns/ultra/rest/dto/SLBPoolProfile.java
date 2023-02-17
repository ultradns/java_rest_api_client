/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.RegionFailureSensitivity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * SLB Pool profile info.
 */
@JsonInclude(Include.NON_NULL)
public class SLBPoolProfile implements Profile {

    /**
     * An optional description of the MRD pool.
     */
    private String description;

    /**
     * The data to describe the pool records.
     */
    private List<SLBPoolRDataInfo> rdataInfo = Lists.newLinkedList();

    /**
     * {@link ResponseMethod}.
     */
    @NotNull(message = "SLB_POOL_RESPONSE_METHOD_REQUIRED")
    private ResponseMethod responseMethod;

    /**
     * Information for the backup record.
     */
    @NotNull(message = "SLB_POOL_BACKUP_RECORD_REQUIRED")
    private SimpleLoadBalancingAllFailRecord allFailRecord;
    /**
     * Information for the monitor.
     */
    @NotNull(message = "SLB_POOL_MONITOR_REQUIRED")
    private Monitor monitor;

    /**
     * Specifies the sensitivity to the number of regions that need to fail for the backup record to be made active.
     */
    @NotNull(message = "SLB_POOL_REGION_FAILURE_SENSITIVITY_REQUIRED")
    private RegionFailureSensitivity regionFailureSensitivity;

    @NotNull(message = "SLB_POOL_SERVING_PREFERENCE_REQUIRED")
    private ServingPreference servingPreference;

    private Status status;

    public SLBPoolProfile() {
        super();
    }

    public SLBPoolProfile(String description, List<SLBPoolRDataInfo> rdataInfo, ResponseMethod responseMethod,
            SimpleLoadBalancingAllFailRecord allFailRecord, Monitor monitor,
            RegionFailureSensitivity regionFailureSensitivity, ServingPreference servingPreference, Status status) {
        super();
        this.description = description;
        this.rdataInfo = rdataInfo;
        this.responseMethod = responseMethod;
        this.allFailRecord = allFailRecord;
        this.monitor = monitor;
        this.regionFailureSensitivity = regionFailureSensitivity;
        this.servingPreference = servingPreference;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SLBPoolRDataInfo> getRDataInfo() {
        return rdataInfo;
    }

    public void setRDataInfo(List<SLBPoolRDataInfo> arg0) {
        this.rdataInfo = arg0;
    }

    public ResponseMethod getResponseMethod() {
        return responseMethod;
    }

    public void setResponseMethod(ResponseMethod responseMethod) {
        this.responseMethod = responseMethod;
    }

    public SimpleLoadBalancingAllFailRecord getAllFailRecord() {
        return allFailRecord;
    }

    public void setAllFailRecord(SimpleLoadBalancingAllFailRecord allFailRecord) {
        this.allFailRecord = allFailRecord;
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

    public ServingPreference getServingPreference() {
        return servingPreference;
    }

    public void setServingPreference(ServingPreference servingPreference) {
        this.servingPreference = servingPreference;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SLBPoolProfile [description=" + description + ", rdataInfo=" + rdataInfo + ", responseMethod="
                + responseMethod + ", allFailRecord=" + allFailRecord + ", monitor=" + monitor
                + ", regionFailureSensitivity=" + regionFailureSensitivity + ", servingPreference=" + servingPreference
                + ", status=" + status + "]";
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getAllFailRecord(), getDescription(), getMonitor(), getResponseMethod(), getRDataInfo(),
                getRegionFailureSensitivity(), getServingPreference(), getStatus());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof SLBPoolProfile)) {
            return false;
        }
        final SLBPoolProfile other = (SLBPoolProfile) obj;
        return Objects.equal(getDescription(), other.getDescription()) && Objects.equal(getAllFailRecord(),
                other.getAllFailRecord()) && Objects.equal(getDescription(), other.getDescription()) && Objects.equal(
                getMonitor(), other.getMonitor()) && Objects.equal(getResponseMethod(), other.getResponseMethod())
                && Objects.equal(getRDataInfo(), other.getRDataInfo()) && Objects.equal(getRegionFailureSensitivity(),
                other.getRegionFailureSensitivity()) && Objects.equal(getServingPreference(),
                other.getServingPreference()) && Objects.equal(getStatus(), other.getStatus());
    }

    public enum Status {
        OK,
        //Live record is being served
        WARNING,
        //
        CRITICAL,
        //
        FAIL // Backup record is being served due to the monitor detecting a failure
    }

    /**
     * The order that the records in the MRD pool should be returned.
     */
    public enum ResponseMethod {
        PRIORITY_HUNT,
        RANDOM,
        ROUND_ROBIN
    }

    public enum ServingPreference {
        AUTO_SELECT,
        //Automatically fail back or fail over
        SERVE_PRIMARY,
        //Serve Primary as part of Manual Fail back
        SERVE_ALL_FAIL //Serve AllFail as part of Manual Fail back
    }

}

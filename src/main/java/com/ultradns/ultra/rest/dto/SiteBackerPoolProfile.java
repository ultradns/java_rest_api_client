/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.PoolProbeStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.ultradns.ultra.rest.constants.UltraRestSharedConstant;

import java.util.List;

/**
 * Site backer pool profile.
 */
@JsonInclude(Include.NON_NULL)
public class SiteBackerPoolProfile implements Profile {

    /**
     * An optional description of the SiteBacker pool.
     */
    private String description;
    /**
     * Indicates whether or not the probes are run for this pool.
     */
    private Boolean runProbes;
    /**
     * Indicates whether or not pool records will be enabled and disabled when probes are run.
     */
    private Boolean actOnProbes;
    /**
     * Indicates the order of the records returned by the resolver for the SiteBacker pool. Valid values are FIXED,
     * RANDOM, and ROUND_ROBIN.
     */
    private UltraRestSharedConstant.Order order;
    /**
     * Specifies the maximum number of active servers in a pool and determines when SiteBacker takes backup servers
     * offline.
     */
    private Integer maxActive;
    /**
     * Determines the number of record answers for each query. This is typically All Active records or a subset of Max
     * Active .
     */
    private Integer maxServed;
    /**
     * Pool status.
     */
    private PoolProbeStatus status;
    /**
     * One entry for each entry in rdata. Metadata for each rdata.
     */
    private List<SBTCRDataInfo> rdataInfo = Lists.newLinkedList();
    /**
     * Specify the records to be served if all other records fail.
     */
    private List<BackupRecord> backupRecords = Lists.newLinkedList();

    @JsonIgnore
    private List<ProbeInfo> probes;

    @JsonIgnore
    private List<SBTCEventInfo> events;

    @JsonIgnore
    private List<SBTCNotification> notifications;

    public SiteBackerPoolProfile() {
        super();
    }

    public SiteBackerPoolProfile(String description, Boolean runProbes, Boolean actOnProbes,
                                 UltraRestSharedConstant.Order order, Integer maxActive, Integer maxServed,
                                 List<SBTCRDataInfo> rdataInfo, List<BackupRecord> backupRecords) {
        super();
        this.description = description;
        this.runProbes = runProbes;
        this.actOnProbes = actOnProbes;
        this.order = order;
        this.maxActive = maxActive;
        this.maxServed = maxServed;
        this.rdataInfo = rdataInfo;
        this.backupRecords = backupRecords;
    }

    /**
     * To get description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * To set description.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * To get this{@link #runProbes}.
     *
     * @return the runProbes
     */
    public Boolean isRunProbes() {
        return runProbes;
    }

    /**
     * To set this{@link #runProbes}.
     *
     * @param runProbes the runProbes to set
     */
    public void setRunProbes(Boolean runProbes) {
        this.runProbes = runProbes;
    }

    /**
     * To get this{@link #actOnProbes}.
     *
     * @return the actOnProbes
     */
    public Boolean isActOnProbes() {
        return actOnProbes;
    }

    /**
     * To set this{@link #actOnProbes}.
     *
     * @param actOnProbes the actOnProbes to set
     */
    public void setActOnProbes(Boolean actOnProbes) {
        this.actOnProbes = actOnProbes;
    }

    /**
     * To get this{@link #order}.
     *
     * @return the order
     */
    public UltraRestSharedConstant.Order getOrder() {
        return order;
    }

    /**
     * To set this{@link #order}.
     *
     * @param order the order to set
     */
    public void setOrder(UltraRestSharedConstant.Order order) {
        this.order = order;
    }

    /**
     * To get this{@link #maxActive}.
     *
     * @return the maxActive
     */
    public Integer getMaxActive() {
        return maxActive;
    }

    /**
     * To set this{@link #maxActive}.
     *
     * @param maxActive the maxActive to set
     */
    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    /**
     * To get this{@link #maxServed}.
     *
     * @return the maxServed
     */
    public Integer getMaxServed() {
        return maxServed;
    }

    /**
     * To set this{@link #maxServed}.
     *
     * @param maxServed the maxServed to set
     */
    public void setMaxServed(Integer maxServed) {
        this.maxServed = maxServed;
    }

    public PoolProbeStatus getStatus() {
        return status;
    }

    public void setStatus(PoolProbeStatus status) {
        this.status = status;
    }

    /**
     * To get this{@link #rdataInfo}.
     *
     * @return the rdataInfo
     */
    public List<SBTCRDataInfo> getRdataInfo() {
        return rdataInfo;
    }

    /**
     * To set this{@link #rdataInfo}.
     *
     * @param rdataInfo the rdataInfo to set
     */
    public void setRdataInfo(List<SBTCRDataInfo> rdataInfo) {
        this.rdataInfo = rdataInfo;
    }

    /**
     * To get this{@link #backupRecords}.
     *
     * @return the backupRecords
     */
    public List<BackupRecord> getBackupRecords() {
        return backupRecords;
    }

    /**
     * To set this{@link #backupRecords}.
     *
     * @param backupRecords the backupRecords to set
     */
    public void setBackupRecords(List<BackupRecord> backupRecords) {
        this.backupRecords = backupRecords;
    }

    public List<ProbeInfo> getProbes() {
        return probes;
    }

    public void setProbes(List<ProbeInfo> probes) {
        this.probes = probes;
    }

    public List<SBTCEventInfo> getEvents() {
        return events;
    }

    public void setEvents(List<SBTCEventInfo> events) {
        this.events = events;
    }

    public List<SBTCNotification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<SBTCNotification> notifications) {
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("description", description)
                .add("runProbes", runProbes)
                .add("actOnProbes", actOnProbes)
                .add("order", order)
                .add("maxActive", maxActive)
                .add("maxServed", maxServed)
                .add("status", status)
                .add("rdataInfo", rdataInfo)
                .add("backupRecords", backupRecords)
                .toString();
    }

    public void setDefaultValues() {
        if (runProbes == null) {
            runProbes = true;
        }
        if (actOnProbes == null) {
            actOnProbes = true;
        }
        if (order == null) {
            order = UltraRestSharedConstant.Order.ROUND_ROBIN;
        }
        if (maxActive == null) {
            maxActive = 1;
        }
        if (maxServed == null) {
            maxServed = maxActive;
        }
        status = MoreObjects.firstNonNull(status, PoolProbeStatus.OK);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SiteBackerPoolProfile that = (SiteBackerPoolProfile) o;
        return Objects.equal(description, that.description) && Objects.equal(runProbes, that.runProbes)
                && Objects.equal(actOnProbes, that.actOnProbes) && Objects.equal(order, that.order)
                && Objects.equal(maxActive, that.maxActive) && Objects.equal(maxServed, that.maxServed)
                && status == that.status && Objects.equal(rdataInfo, that.rdataInfo)
                && Objects.equal(backupRecords, that.backupRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(description, runProbes, actOnProbes, order, maxActive, maxServed, status, rdataInfo,
                backupRecords);
    }
}

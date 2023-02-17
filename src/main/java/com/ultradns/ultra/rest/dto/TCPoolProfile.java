/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.PoolProbeStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Traffic Controller Pool Profile.
 *
 * @author kushalraj.bhandari
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TCPoolProfile implements Profile {

    private String description;
    private Boolean runProbes;
    private Boolean actOnProbes;
    private Integer maxToLB;
    private PoolProbeStatus status;
    private List<SBTCRDataInfo> rdataInfo = Lists.newLinkedList();
    private BackupRecord backupRecord;

    @JsonIgnore
    private List<ProbeInfo> probes;

    @JsonIgnore
    private List<SBTCEventInfo> events;

    @JsonIgnore
    private List<SBTCNotification> notifications;

    public TCPoolProfile() {
        super();
    }

    public TCPoolProfile(String description, Boolean runProbes, Boolean actOnProbes, Integer maxToLB,
            PoolProbeStatus status, List<SBTCRDataInfo> rdataInfo, BackupRecord backupRecord) {
        super();
        this.description = description;
        this.runProbes = runProbes;
        this.actOnProbes = actOnProbes;
        this.maxToLB = maxToLB;
        this.status = status;
        this.rdataInfo = rdataInfo;
        this.backupRecord = backupRecord;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public final Boolean isRunProbes() {
        return runProbes;
    }

    public final void setRunProbes(Boolean runProbes) {
        this.runProbes = runProbes;
    }

    public final Boolean isActOnProbes() {
        return actOnProbes;
    }

    public final void setActOnProbes(Boolean actOnProbes) {
        this.actOnProbes = actOnProbes;
    }

    public final Integer getMaxToLB() {
        return maxToLB;
    }

    public final void setMaxToLB(Integer maxToLB) {
        this.maxToLB = maxToLB;
    }

    public PoolProbeStatus getStatus() {
        return status;
    }

    public void setStatus(PoolProbeStatus status) {
        this.status = status;
    }

    public final List<SBTCRDataInfo> getRdataInfo() {
        return rdataInfo;
    }

    public final void setRdataInfo(List<SBTCRDataInfo> rdataInfo) {
        this.rdataInfo = rdataInfo;
    }

    public final BackupRecord getBackupRecord() {
        return backupRecord;
    }

    public final void setBackupRecord(BackupRecord backupRecord) {
        this.backupRecord = backupRecord;
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

    public void setDefaultValues() {
        if (runProbes == null) {
            runProbes = true;
        }
        if (actOnProbes == null) {
            actOnProbes = true;
        }
        if (maxToLB == null) {
            maxToLB = 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TCPoolProfile that = (TCPoolProfile) o;
        return Objects.equal(description, that.description) && Objects.equal(runProbes, that.runProbes)
                && Objects.equal(actOnProbes, that.actOnProbes) && Objects.equal(maxToLB, that.maxToLB)
                && status == that.status && Objects.equal(rdataInfo, that.rdataInfo) && Objects.equal(backupRecord,
                that.backupRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(description, runProbes, actOnProbes, maxToLB, status, rdataInfo, backupRecord);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("description", description)
                .add("runProbes", runProbes)
                .add("actOnProbes", actOnProbes)
                .add("maxToLB", maxToLB)
                .add("status", status)
                .add("rdataInfo", rdataInfo)
                .add("backupRecord", backupRecord)
                .toString();
    }
}

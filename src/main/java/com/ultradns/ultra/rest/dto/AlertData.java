/*
 * User: nupadhyay
 * Date: Apr 14, 2014
 * Time: 2:02:45 PM
 *
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.PoolProbeStatus;
import com.ultradns.ultra.rest.constants.UltraRestSharedConstant.AlertDataStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Alert data.
 */
@JsonInclude(Include.NON_NULL)
public class AlertData {

    /**
     * The pool record that triggered the alert.
     */
    private String poolRecord;
    /**
     * The name of the probe type.
     */
    private String probeType;
    /**
     * The status determined by the probe.
     */
    private PoolProbeStatus probeStatus;
    /**
     * The date the alert occurred.
     */
    private String alertDate;
    /**
     * Flag to indicate if failover occurred.
     */
    private boolean failoverOccurred;

    /**
     * The ownerName of the pool that alerted.
     */
    private String ownerName;
    /**
     * Status of the probe.
     */
    private AlertDataStatus status;

    public AlertData() {
        super();
    }

    public AlertData(String poolRecord, String probeType, PoolProbeStatus probeStatus, String alertDate,
            boolean failoverOccurred, String ownerName, AlertDataStatus status) {
        super();
        this.poolRecord = poolRecord;
        this.probeType = probeType;
        this.probeStatus = probeStatus;
        this.alertDate = alertDate;
        this.failoverOccurred = failoverOccurred;
        this.ownerName = ownerName;
        this.status = status;
    }

    public String getPoolRecord() {
        return poolRecord;
    }

    public void setPoolRecord(String poolRecord) {
        this.poolRecord = poolRecord;
    }

    public String getProbeType() {
        return probeType;
    }

    public void setProbeType(String probeType) {
        this.probeType = probeType;
    }

    public PoolProbeStatus getProbeStatus() {
        return probeStatus;
    }

    public void setProbeStatus(PoolProbeStatus probeStatus) {
        this.probeStatus = probeStatus;
    }

    public String getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(String alertDate) {
        this.alertDate = alertDate;
    }

    public boolean isFailoverOccurred() {
        return failoverOccurred;
    }

    public void setFailoverOccurred(boolean failoverOccurred) {
        this.failoverOccurred = failoverOccurred;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public AlertDataStatus getStatus() {
        return status;
    }

    public void setStatus(AlertDataStatus status) {
        this.status = status;
    }
}

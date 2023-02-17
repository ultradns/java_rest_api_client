/*
 * User: nupadhyay
 * Date: Apr 2, 2014
 * Time: 1:38:57 PM
 *
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Ping limit info.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PingLimitInfo {

    private ProbeStatus lossPercent;
    private ProbeStatus total;
    private ProbeStatus average;
    private ProbeStatus run;
    private ProbeStatus avgRun;

    public PingLimitInfo() {
        super();
    }

    public PingLimitInfo(ProbeStatus lossPercent, ProbeStatus total, ProbeStatus average, ProbeStatus run,
            ProbeStatus avgRun) {
        super();
        this.lossPercent = lossPercent;
        this.total = total;
        this.average = average;
        this.run = run;
        this.avgRun = avgRun;
    }

    public ProbeStatus getLossPercent() {
        return lossPercent;
    }

    public void setLossPercent(ProbeStatus lossPercent) {
        this.lossPercent = lossPercent;
    }

    public ProbeStatus getTotal() {
        return total;
    }

    public void setTotal(ProbeStatus total) {
        this.total = total;
    }

    public ProbeStatus getAverage() {
        return average;
    }

    public void setAverage(ProbeStatus average) {
        this.average = average;
    }

    public ProbeStatus getRun() {
        return run;
    }

    public void setRun(ProbeStatus run) {
        this.run = run;
    }

    public ProbeStatus getAvgRun() {
        return avgRun;
    }

    public void setAvgRun(ProbeStatus avgRun) {
        this.avgRun = avgRun;
    }

}

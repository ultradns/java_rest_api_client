/*
 * User: nupadhyay
 * Date: Apr 2, 2014
 * Time: 1:56:40 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * SMTP Limit Info.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SMTPLimitInfo {
    /**
     * How long the probe stays connected to the resource to trigger a warning/critical/fail.
     */
    private ProbeStatus connect;
    /**
     * Mean connect time over the five most recent probes run on each agent to trigger a warning/critical/fail.
     */
    private ProbeStatus avgConnect;
    /**
     * How long the probe should run to trigger a warning/critical/fail.
     */
    private ProbeStatus run;
    /**
     * Mean run time over the five most recent probes run on each agent to trigger a warning/critical/fail.
     */
    private ProbeStatus avgRun;

    public SMTPLimitInfo() {
        super();
    }

    public SMTPLimitInfo(ProbeStatus connect, ProbeStatus avgConnect, ProbeStatus run, ProbeStatus avgRun) {
        super();
        this.connect = connect;
        this.avgConnect = avgConnect;
        this.run = run;
        this.avgRun = avgRun;
    }

    public ProbeStatus getConnect() {
        return connect;
    }

    public void setConnect(ProbeStatus connect) {
        this.connect = connect;
    }

    public ProbeStatus getAvgConnect() {
        return avgConnect;
    }

    public void setAvgConnect(ProbeStatus avgConnect) {
        this.avgConnect = avgConnect;
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

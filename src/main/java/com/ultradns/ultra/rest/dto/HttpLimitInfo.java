/*
 * User: nupadhyay
 * Date: Apr 2, 2014
 * Time: 1:26:58 PM
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
 * Http Limit Info.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpLimitInfo {

    /**
     * How long the probe stays connected to the resource to trigger warning/critical/fail.
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
     * Mean run time over the five most recent probes run on each agent to trigger a  warning/critical/fail.
     */
    private ProbeStatus avgRun;
    /**
     * If blank, the HTTP probe verifies that the server responds to the request with a successful HTTP response
     * (normally a 200 status code).
     */
    private ProbeSearchString searchString;

    public HttpLimitInfo() {
        super();
    }

    public HttpLimitInfo(ProbeStatus connect, ProbeStatus avgConnect, ProbeStatus run, ProbeStatus avgRun,
            ProbeSearchString searchString) {
        super();
        this.connect = connect;
        this.avgConnect = avgConnect;
        this.run = run;
        this.avgRun = avgRun;
        this.searchString = searchString;
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

    public ProbeSearchString getSearchString() {
        return searchString;
    }

    public void setSearchString(ProbeSearchString searchString) {
        this.searchString = searchString;
    }

}

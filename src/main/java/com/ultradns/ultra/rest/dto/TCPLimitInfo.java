/*
 * User: nupadhyay
 * Date: Apr 2, 2014
 * Time: 1:49:18 PM
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
 * TCP Limit info.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TCPLimitInfo {

    /**
     * How long the probe stays connected to the resource to trigger a warning/fail/critical.
     */
    private ProbeStatus connect;
    /**
     * Mean connect time over the five most recent probes run on each agent to trigger a warning/fail/critical.
     */
    private ProbeStatus avgConnect;

    public TCPLimitInfo() {
        super();
    }

    public TCPLimitInfo(ProbeStatus connect, ProbeStatus avgConnect) {
        super();
        this.connect = connect;
        this.avgConnect = avgConnect;
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

}

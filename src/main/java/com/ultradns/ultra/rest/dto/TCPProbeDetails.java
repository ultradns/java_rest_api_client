/*
 * User: nupadhyay
 * Date: Apr 1, 2014
 * Time: 1:33:16 PM
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
 * TCP Probe Details.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TCPProbeDetails implements ProbeDetails {

    /**
     * Port to connect to.
     */
    private Integer port;
    /**
     * Provides a control mechanism that allows the web administrators to stop the TCP port on the control system.
     */
    private String controlIP;
    /**
     * {@link TCPLimitInfo}.
     */
    private TCPLimitInfo limits;

    public TCPProbeDetails() {
        super();
    }

    public TCPProbeDetails(Integer port, String controlIP, TCPLimitInfo limits) {
        super();
        this.port = port;
        this.controlIP = controlIP;
        this.limits = limits;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getControlIP() {
        return controlIP;
    }

    public void setControlIP(String controlIP) {
        this.controlIP = controlIP;
    }

    public TCPLimitInfo getLimits() {
        return limits;
    }

    public void setLimits(TCPLimitInfo limits) {
        this.limits = limits;
    }

    public void setDefaultValue() {
        // ControlIP set as null while not providing when create and while GET
        // the same probe we will get NPE. so we need to set default value as
        // empty
        if (controlIP == null) {
            controlIP = "";
        }
    }
}

/*
 * User: nupadhyay

 * Date: Apr 2, 2014
 * Time: 1:54:12 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.DefaultPorts;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * SMTP Probe Details.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SMTPProbeDetails implements ProbeDetails {

    /**
     * Port to connect to.
     */
    private Integer port;
    /**
     * {@link SMTPLimitInfo}.
     */
    private SMTPLimitInfo limits;

    public SMTPProbeDetails() {
        super();
    }

    public SMTPProbeDetails(Integer port, SMTPLimitInfo limits) {
        super();
        this.port = port;
        this.limits = limits;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public SMTPLimitInfo getLimits() {
        return limits;
    }

    public void setLimits(SMTPLimitInfo limits) {
        this.limits = limits;
    }

    public void setDefaultValue() {
        if (port == null) {
            port = DefaultPorts.SMTP;
        }
    }
}

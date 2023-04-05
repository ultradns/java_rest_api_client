/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.DefaultPorts;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * SMTP Send Probe Details.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SMTPSendProbeDetails implements ProbeDetails {

    /**
     * Port to connect to.
     */
    private Integer port;

    /**
     * Email address from which to send message.
     */
    private String from;
    /**
     * Email address to which the message should be sent.
     */
    private String to;
    /**
     * Email message body.
     */
    private String message;
    /**
     * {@link SMTPSendLimitInfo}.
     */
    private SMTPSendLimitInfo limits;

    public SMTPSendProbeDetails() {
        super();
    }

    public SMTPSendProbeDetails(Integer port, String from, String to, String message, SMTPSendLimitInfo limits) {
        super();
        this.port = port;
        this.from = from;
        this.to = to;
        this.message = message;
        this.limits = limits;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SMTPSendLimitInfo getLimits() {
        return limits;
    }

    public void setLimits(SMTPSendLimitInfo limits) {
        this.limits = limits;
    }

    public void setDefaultValue() {
        if (port == null) {
            port = DefaultPorts.SMTP;
        }
        // If message send as null when create we will get NPE when GET, so we need to set default value as empty.
        if (message == null) {
            message = "";
        }
    }
}

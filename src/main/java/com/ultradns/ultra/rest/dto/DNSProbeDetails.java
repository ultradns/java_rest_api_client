/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.DefaultPorts;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * DNS Probe Details.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNSProbeDetails implements ProbeDetails {

    /**
     * Port that should be used for DNS lookup.
     */
    private Integer port;
    /**
     * Indicates whether or not the probe should use TCP only, or first UDP then TCP.
     */
    private Boolean tcpOnly;

    /**
     * Select which kind of record should be checked for.
     * <p>
     * Valid values are NULL, AXFR, or any Resource Record Type.
     */
    private String type;
    /**
     * Selects the name that should be queried.
     */
    private String ownerName;
    /**
     * {@link DNSLimitInfo}.
     */
    private DNSLimitInfo limits;

    public DNSProbeDetails() {
        super();
    }

    public DNSProbeDetails(Integer port, Boolean tcpOnly, String type, String ownerName, DNSLimitInfo limits) {
        super();
        this.port = port;
        this.tcpOnly = tcpOnly;
        this.type = type;
        this.ownerName = ownerName;
        this.limits = limits;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Boolean isTcpOnly() {
        return tcpOnly;
    }

    public void setTcpOnly(Boolean tcpOnly) {
        this.tcpOnly = tcpOnly;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public DNSLimitInfo getLimits() {
        return limits;
    }

    public void setLimits(DNSLimitInfo limits) {
        this.limits = limits;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDefaultValue() {
        if (port == null) {
            port = DefaultPorts.DNS;
        }

        if (tcpOnly == null) {
            tcpOnly = Boolean.FALSE;
        }

        if (ownerName == null) {
            ownerName = "";
        }

        if (limits == null) {
            limits = new DNSLimitInfo();
        }

        limits.setDefaultValue();

        if (type == null) {
            type = "NULL";
        }

    }
}

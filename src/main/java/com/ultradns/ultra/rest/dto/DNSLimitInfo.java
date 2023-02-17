/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * DNS Limit Info.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNSLimitInfo {

    /**
     * How long the probe should run to trigger a warning/critical/fail.
     */
    private ProbeStatus run;
    /**
     * Mean run time over the five most recent probes run on each agent to trigger a warning/critical/fail.
     */
    private ProbeStatus avgRun;
    /**
     * Match exactly records with single field responses (that is, A, CNAME, DNAME, NS, MB, MD, MF, MG, MR, PTR) to
     * trigger a warning.
     */
    private ProbeSearchString response;

    public DNSLimitInfo() {
        super();
    }

    public DNSLimitInfo(ProbeStatus run, ProbeStatus avgRun, ProbeSearchString response) {
        super();
        this.run = run;
        this.avgRun = avgRun;
        this.response = response;
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

    public ProbeSearchString getResponse() {
        return response;
    }

    public void setResponse(ProbeSearchString response) {
        this.response = response;
    }

    public void setDefaultValue() {
        if (response == null) {
            response = new ProbeSearchString();
        }

        response.setDefaultValue();
    }
}

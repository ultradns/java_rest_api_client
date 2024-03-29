/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Probe status.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProbeStatus {

    private Integer warning;
    private Integer critical;
    private Integer fail;

    public ProbeStatus() {
        super();
    }

    public ProbeStatus(Integer warning, Integer critical, Integer fail) {
        super();
        this.warning = warning;
        this.critical = critical;
        this.fail = fail;
    }

    public Integer getWarning() {
        return warning;
    }

    public void setWarning(Integer warning) {
        this.warning = warning;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Integer getFail() {
        return fail;
    }

    public void setFail(Integer fail) {
        this.fail = fail;
    }

}

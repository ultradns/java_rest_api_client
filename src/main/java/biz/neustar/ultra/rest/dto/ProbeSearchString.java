/*
 * User: nupadhyay
 * Date: Apr 9, 2014
 * Time: 7:01:10 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Probe Search String.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProbeSearchString {

    private String warning;
    private String critical;
    private String fail;

    public ProbeSearchString() {
        super();
    }

    public ProbeSearchString(String warning, String critical, String fail) {
        super();
        this.warning = warning;
        this.critical = critical;
        this.fail = fail;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getFail() {
        return fail;
    }

    public void setFail(String fail) {
        this.fail = fail;
    }

    public void setDefaultValue() {
        if (warning == null) {
            warning = "";
        }

        if (critical == null) {
            critical = "";
        }

        if (fail == null) {
            fail = "";
        }
    }
}

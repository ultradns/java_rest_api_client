/*
 * User: nupadhyay
 * Date: Apr 2, 2014
 * Time: 1:46:26 PM
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
 * FTP Limit Info.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FTPLimitInfo {

    private ProbeStatus connect;
    private ProbeStatus avgConnect;
    private ProbeStatus run;
    private ProbeStatus avgRun;
    private ProbeSearchString searchString;

    public FTPLimitInfo() {
        super();
    }

    public FTPLimitInfo(ProbeStatus connect, ProbeStatus avgConnect, ProbeStatus run, ProbeStatus avgRun,
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

    public void setDefaultValue() {
        if (searchString == null) {
            searchString = new ProbeSearchString();
        }

        searchString.setDefaultValue();
    }

}

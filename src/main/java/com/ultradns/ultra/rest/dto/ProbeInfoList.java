/*
 * User: nupadhyay
 * Date: Apr 3, 2014
 * Time: 1:44:06 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import java.util.List;

/**
 * Probe info list.
 */
public class ProbeInfoList {

    private List<ProbeInfo> probes;
    private QueryInfo queryInfo;
    private ResultInfo resultInfo;

    public ProbeInfoList() {
        super();
    }

    public ProbeInfoList(List<ProbeInfo> probes, QueryInfo queryInfo, ResultInfo resultInfo) {
        super();
        this.probes = probes;
        this.queryInfo = queryInfo;
        this.resultInfo = resultInfo;
    }

    public List<ProbeInfo> getProbes() {
        return probes;
    }

    public void setProbes(List<ProbeInfo> probes) {
        this.probes = probes;
    }

    public QueryInfo getQueryInfo() {
        return queryInfo;
    }

    public void setQueryInfo(QueryInfo queryInfo) {
        this.queryInfo = queryInfo;
    }

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

}

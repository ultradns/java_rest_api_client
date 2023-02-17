/*
 * User: nupadhyay
 * Date: Apr 14, 2014
 * Time: 2:11:37 PM
 *
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Alert data list.
 */
@JsonInclude(Include.NON_NULL)
public class AlertDataList {

    /**
     * The list of all alerts.
     */
    private List<AlertData> alerts = Lists.newArrayList();
    /**
     * {@link QueryInfo}.
     */
    private QueryInfo queryInfo;
    /**
     * {@link ResultInfo}.
     */
    private ResultInfo resultInfo;

    public AlertDataList() {
        super();
    }

    public AlertDataList(List<AlertData> alerts, QueryInfo queryInfo, ResultInfo resultInfo) {
        super();
        this.alerts = alerts;
        this.queryInfo = queryInfo;
        this.resultInfo = resultInfo;
    }

    public final List<AlertData> getAlerts() {
        return alerts;
    }

    public final void setAlerts(List<AlertData> alerts) {
        this.alerts = alerts;
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

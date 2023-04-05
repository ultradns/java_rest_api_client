/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * This is used to return the list of all events for a pool record.
 */
public class SBTCEventInfoList extends BaseQueryList {

    /**
     * The list of all events.
     */
    private List<SBTCEventInfo> events = Lists.newArrayList();

    public SBTCEventInfoList() {
        super();
    }

    public SBTCEventInfoList(List<SBTCEventInfo> events, QueryInfo queryInfo, ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.events = events;
    }

    public List<SBTCEventInfo> getEvents() {
        return events;
    }

    public void setEvents(List<SBTCEventInfo> events) {
        this.events = events;
    }

}

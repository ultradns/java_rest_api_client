/*
 * User: nupadhyay
 * Date: Apr 14, 2014
 * Time: 1:44:50 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

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

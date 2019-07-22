/*
 * User: nupadhyay
 * Date: Apr 1, 2014
 * Time: 6:21:53 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import biz.neustar.ultra.rest.constants.UltraRestSharedConstant.EventNotify;
import biz.neustar.ultra.rest.constants.UltraRestSharedConstant.EventRepeat;
import biz.neustar.ultra.rest.constants.UltraRestSharedConstant.EventType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Objects;

/**
 * Schedule event.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("PMD.UseNotifyAllInsteadOfNotify")
public class SBTCEventInfo {

    /**
     * The internal id for this event.
     */
    private String id;
    /**
     * The pool record associated with this event. Returned by GET, only when getting all events at the pool level.
     */
    private String poolRecord;

    /**
     * The internal id for this event. Returned by GET.
     */
    private EventType type;

    /**
     * Start date and time for the event.
     */
    private String start;
    /**
     * The date to stop triggering events.
     */
    private String end;
    /**
     * How frequently events are triggered.
     */
    private EventRepeat repeat;
    /**
     * Indicates when to notify after an event is triggered.
     */
    private EventNotify notify;

    public SBTCEventInfo() {
        super();
    }

    public SBTCEventInfo(String id, String poolRecord, EventType type, String start, String end, EventRepeat repeat,
            EventNotify notify) {
        super();
        this.id = id;
        this.poolRecord = poolRecord;
        this.type = type;
        this.start = start;
        this.end = end;
        this.repeat = repeat;
        this.notify = notify;
    }

    public String getPoolRecord() {
        return poolRecord;
    }

    public void setPoolRecord(String poolRecord) {
        this.poolRecord = poolRecord;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public EventRepeat getRepeat() {
        return repeat;
    }

    public void setRepeat(EventRepeat repeat) {
        this.repeat = repeat;
    }

    public EventNotify getNotify() {
        return notify;
    }

    public void setNotify(EventNotify notify) {
        this.notify = notify;
    }

    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof SBTCEventInfo)) {
            return false;
        }
        final SBTCEventInfo other = (SBTCEventInfo) obj;
        isEqual = Objects.equal(getId(), other.getId());
        return isEqual;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getId());
    }
}

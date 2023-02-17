package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.UltraRestSharedConstant.ProbeInterval;
import com.ultradns.ultra.rest.constants.UltraRestSharedConstant.ProbeType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/*
 * User: jbodner
 * Date: 4/18/14
 * Time: 1:38 PM
 *
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProbeInfo {
    private String id;
    private String poolRecord;
    private ProbeType type;
    private ProbeInterval interval;
    private List<String> agents;
    private Integer threshold;
    private Map<String, Object> details;

    public ProbeInfo() {
        super();
    }

    public ProbeInfo(String id, String poolRecord, ProbeType type, ProbeInterval interval, List<String> agents,
            int threshold, Map<String, Object> details) {
        this.id = id;
        this.poolRecord = poolRecord;
        this.type = type;
        this.interval = interval;
        this.agents = agents;
        this.threshold = threshold;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoolRecord() {
        return poolRecord;
    }

    public void setPoolRecord(String poolRecord) {
        this.poolRecord = poolRecord;
    }

    public ProbeType getType() {
        return type;
    }

    public void setType(ProbeType type) {
        this.type = type;
    }

    public ProbeInterval getInterval() {
        return interval;
    }

    public void setInterval(ProbeInterval interval) {
        this.interval = interval;
    }

    public List<String> getAgents() {
        return agents;
    }

    public void setAgents(List<String> agents) {
        this.agents = agents;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = MoreObjects.firstNonNull(details, Maps.<String, Object>newHashMap());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("poolRecord", getPoolRecord())
                .add("type", getType())
                .add("interval", getInterval())
                .add("agents", getAgents())
                .add("threshold", getThreshold())
                .add("details", getDetails())
                .toString();
    }

    public void setDefaultValue() {
        if (interval == null) {
            interval = ProbeInterval.FIVE_MINUTES;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProbeInfo probeInfo = (ProbeInfo) o;
        return Objects.equal(id, probeInfo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

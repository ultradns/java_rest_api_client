
/*
 * User: nupadhyay
 * Date: Apr 1, 2014
 * Time: 12:57:42 PM
 *
 * Copyright 2000-2017 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import biz.neustar.ultra.rest.constants.UltraRestSharedConstant.RecordState;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;

import java.util.Objects;

/**
 * Site backer Rdata Info.
 */
@JsonInclude(Include.NON_NULL)
public class SBTCRDataInfo {

    /**
     * The current state of the pool record. Valid values are NORMAL, ACTIVE, and INACTIVE.
     */
    private RecordState state;
    /**
     * Indicates whether or not probes are run for this pool record.
     */
    private Boolean runProbes;
    /**
     * Indicates the serving preference for this pool record.
     */
    private Integer priority;
    private Integer failoverDelay;
    private Integer threshold;
    private Integer weight;
    private Boolean availableToServe;
    /**
     * The record type for this pool record.
     */
    private String type;

    public SBTCRDataInfo() {
        super();
    }

    public SBTCRDataInfo(RecordState state, Boolean runProbes, Integer priority, Integer failoverDelay,
            Integer threshold, Integer weight, Boolean availableToServe) {
        super();
        this.state = state;
        this.runProbes = runProbes;
        this.priority = priority;
        this.failoverDelay = failoverDelay;
        this.threshold = threshold;
        this.weight = weight;
        this.availableToServe = availableToServe;
    }

    /**
     * To get this{@link #state}.
     *
     * @return the state
     */
    public RecordState getState() {
        return state;
    }

    /**
     * To set this{@link #state}.
     *
     * @param state the state to set
     */
    public void setState(RecordState state) {
        this.state = state;
    }

    /**
     * To get this{@link #runProbes}.
     *
     * @return the runProbes
     */
    public Boolean isRunProbes() {
        return runProbes;
    }

    /**
     * To set this{@link #runProbes}.
     *
     * @param runProbes the runProbes to set
     */
    public void setRunProbes(Boolean runProbes) {
        this.runProbes = runProbes;
    }

    /**
     * To get this{@link #priority}.
     *
     * @return the priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * To set this{@link #priority}.
     *
     * @param priority the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * To get this{@link #failoverDelay}.
     *
     * @return the failOverDelay
     */
    public Integer getFailoverDelay() {
        return failoverDelay;
    }

    /**
     * To set this{@link #failoverDelay}.
     *
     * @param failOverDelay the failOverDelay to set
     */
    public void setFailOverDelay(Integer failOverDelay) {
        this.failoverDelay = failOverDelay;
    }

    /**
     * To get this{@link #threshold}.
     *
     * @return the threshold
     */
    public Integer getThreshold() {
        return threshold;
    }

    /**
     * To set this{@link #threshold}.
     *
     * @param threshold the threshold to set
     */
    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    /**
     * To get this{@link #weight}.
     *
     * @return the weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * To set this{@link #weight}.
     *
     * @param weight the weight to set
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * To get this{@link #availableToServe}.
     *
     * @return the availableToServe
     */
    public Boolean isAvailableToServe() {
        return availableToServe;
    }

    /**
     * To set this{@link #availableToServe}.
     *
     * @param availableToServe the availableToServe to set
     */
    public void setAvailableToServe(Boolean availableToServe) {
        this.availableToServe = availableToServe;
    }

    /**
     * Get record type.
     *
     * @return type the record type
     */
    public String getType() {
        return type;
    }

    /**
     * Set record type.
     *
     * @param type the record type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(availableToServe, failoverDelay, priority, runProbes, state, threshold, weight, type);
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SBTCRDataInfo that = (SBTCRDataInfo) o;
        return Objects.equals(availableToServe, that.availableToServe)
                && Objects.equals(failoverDelay, that.failoverDelay) && Objects.equals(priority, that.priority)
                && Objects.equals(runProbes, that.runProbes) && Objects.equals(state, that.state)
                && Objects.equals(threshold, that.threshold) && Objects.equals(weight, that.weight)
                && Objects.equals(type, that.type);
    }


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("failoverDelay", getFailoverDelay())
                .add("priority", getPriority())
                .add("threshold", getThreshold())
                .add("weight", getWeight())
                .add("state", getState())
                .add("runProbes", isRunProbes())
                .add("availableToServe", isAvailableToServe())
                .add("type", getType())
                .toString();

    }

    public void setDefaultValues() {
        if (state == null) {
            state = RecordState.NORMAL;
        }
        if (runProbes == null) {
            runProbes = true;
        }
        if (failoverDelay == null) {
            failoverDelay = 0;
        }
        if (availableToServe == null) {
            availableToServe = true;
        }
        // Do not handle the default value of 'weight' as it is already taken care by the underlying API. Moreover, this
        // field is only valid for TC Pool, so setting the default value here will cause problem for SB Pool operation.
    }
}

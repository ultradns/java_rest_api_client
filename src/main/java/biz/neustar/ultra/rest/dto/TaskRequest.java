/**
 * Copyright 2000-2018 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.Map;

/**
 * Task request to create background task.
 *
 * @author Girish Mahajan
 */
@JsonInclude(Include.NON_NULL)
public class TaskRequest {

    /**
     * Task action.
     */
    private TaskAction action;
    /**
     * Input values key-value pair.
     */
    private Map<String, Object> param;

    /**
     * Default constructor.
     */
    public TaskRequest() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param action The task action.
     * @param param  The JSON input for zone snapshot task.
     */
    public TaskRequest(TaskAction action, Map<String, Object> param) {
        super();
        this.action = action;
        this.param = param;
    }

    /**
     * Returns task action.
     *
     * @return The task action.
     */
    public TaskAction getAction() {
        return action;
    }

    /**
     * Set the task action.
     *
     * @param action The {@link TaskAction} value.
     */
    public void setAction(TaskAction action) {
        this.action = action;
    }

    /**
     * Returns the key-value pairs of inputs.
     *
     * @return The Map of input key-value pair.
     */
    public Map<String, Object> getParam() {
        return param;
    }

    /**
     * Sets the input in key-value pair for background task.
     *
     * @param param The map of key-value pair.
     */
    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("action", getAction()).add("param", getParam()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getAction(), getParam());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof TaskRequest)) {
            return false;
        }
        final TaskRequest other = (TaskRequest) obj;
        return Objects.equal(getAction(), other.getAction()) && Objects.equal(getParam(), other.getParam());
    }

    /**
     * Task action types.
     */
    public enum TaskAction {
        ZONE_SNAPSHOT,
        MIGRATE_MDNS_ZONES
    }
}

/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.TaskStatusCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.net.URI;

/**
 * Task Status Info.
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskStatusInfo {

    /**
     * Task Id.
     */
    private String taskId;
    /**
     * Task Status Code.
     */
    private TaskStatusCode code;
    /**
     * Message.
     */
    private String message;
    /**
     * Result URI.
     */
    private URI resultUri;

    /**
     * Empty Constructor.
     */
    public TaskStatusInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param taskId    - task id
     * @param code      - task Status Code
     * @param message   - message
     * @param resultUri - resultUri
     */
    public TaskStatusInfo(String taskId, TaskStatusCode code, String message, URI resultUri) {
        super();
        this.taskId = taskId;
        this.code = code;
        this.message = message;
        this.resultUri = resultUri;
    }

    /**
     * Get the taskId.
     *
     * @return the taskId
     */
    public final String getTaskId() {
        return taskId;
    }

    /**
     * Set the taskId.
     *
     * @param taskId the taskId to set
     */
    public final void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * Get the taskStatusCode.
     *
     * @return the taskStatusCode
     */
    public final TaskStatusCode getCode() {
        return code;
    }

    /**
     * Set the taskStatusCode.
     *
     * @param taskStatusCode the taskStatusCode to set
     */
    public final void setCode(TaskStatusCode taskStatusCode) {
        this.code = taskStatusCode;
    }

    /**
     * Get the message.
     *
     * @return the message
     */
    public final String getMessage() {
        return message;
    }

    /**
     * Set the message.
     *
     * @param message the message to set
     */
    public final void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get the resultUri.
     *
     * @return the resultUri
     */
    public final URI getResultUri() {
        return resultUri;
    }

    /**
     * Set the resultUri.
     *
     * @param resultUri the resultUri to set
     */
    public final void setResultUri(URI resultUri) {
        this.resultUri = resultUri;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(taskId, code, message, resultUri);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TaskStatusInfo)) {
            return false;
        }
        TaskStatusInfo that = (TaskStatusInfo) object;
        return Objects.equal(this.taskId, that.taskId) && Objects.equal(this.code, that.code) && Objects.equal(
                this.message, that.message) && Objects.equal(this.resultUri, that.resultUri);

    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("taskId", taskId)
                .add("code", code)
                .add("message", message)
                .add("resultUri", resultUri)
                .toString();
    }

    public enum Code {
        PENDING,
        IN_PROCESS,
        COMPLETE,
        ERROR
    }

    public enum Sort {
        CODE,
        CONTENT_TYPE,
        EXTENSION,
        HAS_DATA,
        DATE
    }

}

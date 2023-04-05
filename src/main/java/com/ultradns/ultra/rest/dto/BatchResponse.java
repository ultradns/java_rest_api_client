/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Batch response.
 */
@JsonInclude(Include.NON_NULL)
public class BatchResponse {
    private int status;
    private Object response;

    public BatchResponse() {
        super();
    }

    public BatchResponse(int status, Object response) {
        super();
        this.status = status;
        this.response = response;
    }

    /**
     * Get status.
     *
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Set status.
     *
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Get response.
     *
     * @return the response
     */
    public Object getResponse() {
        return response;
    }

    /**
     * Set response.
     *
     * @param response the response to set
     */
    public void setResponse(Object response) {
        this.response = response;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("response", getResponse()).add("status", getStatus()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getResponse(), getStatus());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof BatchResponse)) {
            return false;
        }
        final BatchResponse other = (BatchResponse) obj;
        isEqual = Objects.equal(getResponse(), other.getResponse()) && Objects.equal(getStatus(), other.getStatus());
        return isEqual;
    }
}

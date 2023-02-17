/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.UltraRestErrorConstant;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.TreeMap;

/**
 * Ultra error.
 *
 */

public class UltraError {

    /**
     * Error code.
     */
    private int errorCode;
    /**
     * Error description.
     */
    private String errorMessage;

    @JsonInclude(Include.NON_EMPTY)
    private TreeMap<String, Object> errorData;

    /**
     * Empty constructor.
     */
    public UltraError() {
        super();
    }

    public UltraError(UltraRestErrorConstant errorConstant) {
        this(errorConstant.getErrorCode(), errorConstant.getErrorMessage());
    }

    /**
     * Parameterized constructor.
     *
     * @param errorCode    - Error code
     * @param errorMessage - Error message
     */
    public UltraError(int errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * Get error code.
     *
     * @return the errorCode
     */
    public final int getErrorCode() {
        return errorCode;
    }

    /**
     * Set error code.
     *
     * @param errorCode the errorCode to set
     */
    public final void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Get error message.
     *
     * @return the errorMessage
     */
    public final String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Set error message.
     *
     * @param errorMessage the errorMessage to set
     */
    public final void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public TreeMap<String, Object> getErrorData() {
        return errorData;
    }

    public void setErrorData(TreeMap<String, Object> errorData) {
        this.errorData = errorData;
    }

    public void addErrorData(String key, Object value) {
        if (errorData == null) {
            errorData = new TreeMap<>();
        }
        errorData.put(key, value);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        MoreObjects.ToStringHelper toStringHelper = MoreObjects.toStringHelper(this)
                .add("errorCode", getErrorCode())
                .add("errorMessage", getErrorMessage());
        if (getErrorData() != null && !getErrorData().isEmpty()) {
            toStringHelper.add("errordata", getErrorData());
        }
        return toStringHelper.toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getErrorCode(), getErrorMessage(), getErrorData());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof UltraError)) {
            return false;
        }
        final UltraError other = (UltraError) obj;
        isEqual = Objects.equal(getErrorCode(), other.getErrorCode()) && Objects.equal(getErrorMessage(),
                other.getErrorMessage()) && Objects.equal(getErrorData(), other.getErrorData());
        return isEqual;
    }
}

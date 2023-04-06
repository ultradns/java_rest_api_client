package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

import java.util.List;

/**
 * The Class SecurityExceptionList.
 */
@JsonInclude(Include.NON_NULL)
public class SecurityExceptionList {

    /**
     * The exceptions.
     */
    @JsonInclude(Include.NON_EMPTY)
    private List<SecurityExceptionInfo> exceptions;

    /**
     * The result info.
     */
    private ResultInfo resultInfo;

    /**
     * Instantiates a new security exception list.
     */
    public SecurityExceptionList() {
        super();
    }

    /**
     * Instantiates a new security exception list.
     *
     * @param exceptions the exceptions
     * @param resultInfo the result info
     */
    public SecurityExceptionList(List<SecurityExceptionInfo> exceptions, ResultInfo resultInfo) {
        super();
        this.exceptions = exceptions;
        this.resultInfo = resultInfo;
    }

    /**
     * Gets the exceptions.
     *
     * @return the exceptions
     */
    public List<SecurityExceptionInfo> getExceptions() {
        return exceptions;
    }

    /**
     * Sets the exceptions.
     *
     * @param exceptions the new exceptions
     */
    public void setExceptions(List<SecurityExceptionInfo> exceptions) {
        this.exceptions = exceptions;
    }

    /**
     * Gets the result info.
     *
     * @return the result info
     */
    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    /**
     * Sets the result info.
     *
     * @param resultInfo the new result info
     */
    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    @Override
    public String toString() {
        return "SecurityExceptionList [exceptions=" + exceptions + ", resultInfo=" + resultInfo + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass(), getResultInfo());
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof SecurityExceptionList)) {
            return false;
        }
        final SecurityExceptionList other = (SecurityExceptionList) obj;
        isEqual = Objects.equal(getExceptions(), other.getExceptions());
        return isEqual;
    }

}

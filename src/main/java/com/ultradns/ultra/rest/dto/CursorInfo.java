package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/*
 * User: a423099
 * Date: 12/11/19
 *
 * Copyright 2019 Neustar, Inc. All rights reserved.
 * Neustar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of Neustar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
@JsonInclude(Include.NON_NULL)
public class CursorInfo {

    private String next;

    private String previous;

    private String first;

    private String last;

    private Integer totalCount;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public CursorInfo(String next, String previous, Integer totalCount) {
        super();
        this.next = next;
        this.previous = previous;
        this.totalCount = totalCount;
    }

    public CursorInfo() {
        super();
    }

    public CursorInfo(String next, String previous, String first, String last) {
        super();
        this.next = next;
        this.previous = previous;
        this.first = first;
        this.last = last;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("next", getNext())
                .add("previous", getPrevious())
                .add("first", getFirst())
                .add("last", getLast())
                .add("totalCount", getTotalCount())
                .toString();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(getNext(), getPrevious(), getTotalCount(), getFirst(), getLast());
    }

    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof CursorInfo)) {
            return false;
        }
        final CursorInfo other = (CursorInfo) obj;
        isEqual = Objects.equal(getNext(), other.getNext())
                && Objects.equal(getPrevious(), other.getPrevious())
                && Objects.equal(getTotalCount(), other.getTotalCount())
                && Objects.equal(getFirst(), other.getFirst())
                && Objects.equal(getLast(), other.getLast());
        return isEqual;
    }
}

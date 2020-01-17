package biz.neustar.ultra.rest.dto;

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

    public CursorInfo(String next, String previous) {
        super();
        this.next = next;
        this.previous = previous;
    }

    public CursorInfo() {
        super();
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("next", getNext())
                .add("previous", getPrevious())
                .toString();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(getNext(), getPrevious());
    }

    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof CursorInfo)) {
            return false;
        }
        final CursorInfo other = (CursorInfo) obj;
        isEqual = Objects.equal(getNext(), other.getNext()) && Objects.equal(getPrevious(), other.getPrevious());
        return isEqual;
    }
}

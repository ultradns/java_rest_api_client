/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * Query Info.
 *
 * @author nupadhyay
 */
@JsonInclude(Include.NON_NULL)
public class QueryInfo implements Serializable {

    /**
     * The query used to construct the list.
     */
    private String q;
    /**
     * The sort column used to order the list.
     */
    private String sort;
    /**
     * Whether the list is ascending (false) or descending (true).
     */
    private boolean reverse;
    /**
     * The maximum number of rows requested.
     */
    private int limit;

    private String cursor;
    /**
     * Empty constructor.
     */
    public QueryInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param q       - Query String
     * @param sort    - Sort order
     * @param reverse - To reverse the sort order.
     * @param limit   - Limit
     */
    public QueryInfo(String q, String sort, boolean reverse, int limit) {
        super();
        this.q = q;
        this.sort = sort;
        this.reverse = reverse;
        this.limit = limit;
    }

    public QueryInfo(String q, String sort, boolean reverse, int limit, String cursor) {
        super();
        this.q = q;
        this.sort = sort;
        this.reverse = reverse;
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Get Query.
     *
     * @return the q
     */
    public final String getQ() {
        return q;
    }

    /**
     * Set Query.
     *
     * @param q the q to set
     */
    public final void setQ(String q) {
        this.q = q;
    }

    /**
     * Get sort.
     *
     * @return the sort
     */
    public final String getSort() {
        return sort;
    }

    /**
     * Set sort.
     *
     * @param sort the sort to set
     */
    public final void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * Get reverse.
     *
     * @return the reverse
     */
    public final boolean isReverse() {
        return reverse;
    }

    /**
     * Set reverse.
     *
     * @param reverse the reverse to set
     */
    public final void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    /**
     * Get limit.
     *
     * @return the limit
     */
    public final int getLimit() {
        return limit;
    }

    /**
     * Set limit.
     *
     * @param limit the limit to set
     */
    public final void setLimit(int limit) {
        this.limit = limit;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("q", getQ())
                .add("sort", getSort())
                .add("reverse", isReverse())
                .add("limit", getLimit())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getQ(), getSort(), isReverse(), getLimit(), getCursor());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof QueryInfo)) {
            return false;
        }
        final QueryInfo other = (QueryInfo) obj;
        isEqual = Objects.equal(getQ(), other.getQ()) && Objects.equal(getSort(), other.getSort())
                && Objects.equal(isReverse(), other.isReverse()) && Objects.equal(getLimit(), other.getLimit())
                && Objects.equal(getCursor(), other.getCursor());
        return isEqual;
    }

}

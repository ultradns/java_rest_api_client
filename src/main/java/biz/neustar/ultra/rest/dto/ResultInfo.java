/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * Result Info.
 *
 * @author nupadhyay
 */
@JsonInclude(Include.NON_NULL)
public class ResultInfo implements Serializable {

    /**
     * Count of records in the system for the specified query.
     */
    private int totalCount;
    /**
     * The position in the list for the first returned element (0 based).
     */
    private int offset;
    /**
     * The number of records returned.
     */
    private int returnedCount;

    /** The rrdata count. */
    private Integer rrdataCount;

    /**
     * Empty constructor.
     */
    public ResultInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param totalCount    - Total count.
     * @param offset        - Offset
     * @param returnedCount - Returned count.
     */
    public ResultInfo(int totalCount, int offset, int returnedCount) {
        super();
        this.totalCount = totalCount;
        this.offset = offset;
        this.returnedCount = returnedCount;
    }

    /**
     * Get total count.
     *
     * @return the totalCount
     */
    public final int getTotalCount() {
        return totalCount;
    }

    /**
     * Set total count.
     *
     * @param totalCount the totalCount to set
     */
    public final void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Get offset.
     *
     * @return the offset
     */
    public final int getOffset() {
        return offset;
    }

    /**
     * Set offset.
     *
     * @param offset the offset to set
     */
    public final void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Get Returned count.
     *
     * @return the returnedCount
     */
    public final int getReturnedCount() {
        return returnedCount;
    }

    /**
     * Set returned count.
     *
     * @param returnedCount the returnedCount to set
     */
    public final void setReturnedCount(int returnedCount) {
        this.returnedCount = returnedCount;
    }

    /**
     * Gets the rrdata count.
     *
     * @return the rrdata count
     */
    public Integer getRrdataCount() {
        return rrdataCount;
    }

    /**
     * Sets the rrdata count.
     *
     * @param rrdataCount
     *            the new rrdata count
     */
    public void setRrdataCount(Integer rrdataCount) {
        this.rrdataCount = rrdataCount;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("totalCount", getTotalCount())
                .add("offset", getOffset())
                .add("returnedCount", getReturnedCount())
                .add("rrdataCount", getRrdataCount())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getTotalCount(), getOffset(), getReturnedCount(), getRrdataCount());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof ResultInfo)) {
            return false;
        }
        final ResultInfo other = (ResultInfo) obj;
        isEqual = Objects.equal(getTotalCount(), other.getTotalCount()) && Objects.equal(getOffset(), other.getOffset())
                && Objects.equal(getReturnedCount(), other.getReturnedCount())
                && Objects.equal(getRrdataCount(), other.getRrdataCount());
        return isEqual;
    }

}

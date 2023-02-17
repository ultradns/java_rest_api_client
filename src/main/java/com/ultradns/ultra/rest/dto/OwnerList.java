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
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Owner List.
 *
 */
@JsonInclude(Include.NON_NULL)
public class OwnerList {

    /**
     * Zone name.
     */
    private String zoneName;
    /**
     * Owner list.
     */
    private List<Owner> owners = Lists.newLinkedList();
    /**
     * {@link QueryInfo}.
     */
    private QueryInfo queryInfo;
    /**
     * {@link ResultInfo}.
     */
    private ResultInfo resultInfo;

    /**
     * Empty constructor.
     */
    public OwnerList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param zoneName   - Zone Name
     * @param owners     - {@link List} of {@link Owner}
     * @param queryInfo  - {@link QueryInfo}
     * @param resultInfo - {@link ResultInfo}
     */
    public OwnerList(String zoneName, List<Owner> owners, QueryInfo queryInfo, ResultInfo resultInfo) {
        this.zoneName = zoneName;
        this.owners = owners;
        this.queryInfo = queryInfo;
        this.resultInfo = resultInfo;
    }

    /**
     * Get zone name.
     *
     * @return the zoneName
     */
    public final String getZoneName() {
        return zoneName;
    }

    /**
     * Set zone name.
     *
     * @param zoneName the zoneName to set
     */
    public final void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    /**
     * Get owners.
     *
     * @return the owners
     */
    public final List<Owner> getOwners() {
        return owners;
    }

    /**
     * Set owners.
     *
     * @param owners the owners to set
     */
    public final void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    /**
     * Get owners.
     *
     * @return the queryInfo
     */
    public final QueryInfo getQueryInfo() {
        return queryInfo;
    }

    /**
     * Set query info.
     *
     * @param queryInfo the queryInfo to set
     */
    public final void setQueryInfo(QueryInfo queryInfo) {
        this.queryInfo = queryInfo;
    }

    /**
     * Get result info.
     *
     * @return the resultInfo
     */
    public final ResultInfo getResultInfo() {
        return resultInfo;
    }

    /**
     * Set result info.
     *
     * @param resultInfo the resultInfo to set
     */
    public final void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getZoneName(), getOwners(), getQueryInfo(), getResultInfo());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof OwnerList)) {
            return false;
        }
        final OwnerList other = (OwnerList) obj;
        isEqual = Objects.equal(getOwners(), other.getOwners()) && Objects.equal(getQueryInfo(), other.getQueryInfo())
                && Objects.equal(getResultInfo(), other.getResultInfo()) && Objects.equal(getZoneName(),
                other.getZoneName());
        return isEqual;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("owners", getOwners())
                .add("queryInfo", getQueryInfo())
                .add("resultInfo", getResultInfo())
                .add("zoneName", getZoneName())
                .toString();
    }
}

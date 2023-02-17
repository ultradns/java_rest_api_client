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
import java.util.LinkedList;
import java.util.List;

/**
 * RRSetList.
 *
 * @author nupadhyay
 */
@JsonInclude(Include.NON_NULL)
public class RRSetList implements Serializable {

    /**
     * Serial version Id.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The domain name for the zone.
     */
    private String zoneName;
    /**
     * The zone id for the zone.
     */
    private String zoneId;
    /**
     * The account id.
     */
    private String accountId;
    /**
     * The list of all RRSets.
     */
    private List<RRSet> rrSets;
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
    public RRSetList() {
        super();
        this.rrSets = new LinkedList<>();
    }

    /**
     * Parameterized constructor.
     *
     * @param zoneName   The zone name.
     * @param rrSets     The RRset list.
     * @param queryInfo  The query info object.
     * @param resultInfo The result info object.
     */
    public RRSetList(String zoneName, List<RRSet> rrSets, QueryInfo queryInfo, ResultInfo resultInfo) {
        super();
        this.zoneName = zoneName;
        this.rrSets = rrSets;
        this.queryInfo = queryInfo;
        this.resultInfo = resultInfo;
        this.accountId = null;
        this.zoneId = null;
    }

    /**
     * Parameterized constructor.
     *
     * @param zoneName   The zone name.
     * @param zoneId     The zone ID.
     * @param accountId  The account ID.
     * @param rrSets     The RRSets list.
     * @param queryInfo  The query info object.
     * @param resultInfo The result info object.
     */
    public RRSetList(String zoneName, String zoneId, String accountId, List<RRSet> rrSets, QueryInfo queryInfo,
            ResultInfo resultInfo) {
        super();
        this.zoneName = zoneName;
        this.zoneId = zoneId;
        this.accountId = accountId;
        this.rrSets = rrSets;
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
     * Get RR sets.
     *
     * @return the rrSets
     */
    public final List<RRSet> getRrSets() {
        return rrSets;
    }

    /**
     * Set rrsets.
     *
     * @param rrSets the rrSets to set
     */
    public final void setRrSets(List<RRSet> rrSets) {
        this.rrSets = rrSets;
    }

    /**
     * Get query info.
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
     * @param resultInfo the resultInfo to set.
     */
    public final void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    /**
     * Returns Zone ID.
     *
     * @return ZoneID.
     */
    public final String getZoneId() {
        return zoneId;
    }

    /**
     * Set Zone ID.
     *
     * @param zoneId The Zone ID.
     */
    public final void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    /**
     * Returns account ID.
     *
     * @return account ID.
     */
    public final String getAccountId() {
        return accountId;
    }

    /**
     * Set accountID.
     *
     * @param accountId The account ID.
     */
    public final void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("zoneName", getZoneName())
                .add("zoneId", getZoneId())
                .add("accountId", getAccountId())
                .add("rrSets", getRrSets())
                .add("queryInfo", getQueryInfo())
                .add("resultInfo", getResultInfo())
                .omitNullValues()
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getZoneName(), getRrSets(), getQueryInfo(), getResultInfo(), getZoneId(),
                getAccountId());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof RRSetList)) {
            return false;
        }
        final RRSetList other = (RRSetList) obj;
        isEqual = Objects.equal(getZoneName(), other.getZoneName()) && Objects.equal(getRrSets(), other.getRrSets())
                && Objects.equal(getQueryInfo(), other.getQueryInfo()) && Objects.equal(getResultInfo(),
                other.getResultInfo()) && Objects.equal(getZoneId(), other.getZoneId()) && Objects.equal(getAccountId(),
                other.getAccountId());
        return isEqual;
    }

}

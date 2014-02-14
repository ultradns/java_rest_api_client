/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

import java.util.LinkedList;
import java.util.List;

/**
 * RRSetList.
 * @author nupadhyay
 *
 */
@JsonInclude(Include.NON_NULL)
public class RRSetList {
    
    /**
     *  The domain name for the zone. 
     */
    private String zoneName;
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
     * @param zoneName
     * @param rrSets
     * @param queryInfo
     * @param resultInfo
     */
    public RRSetList(String zoneName, List<RRSet> rrSets, QueryInfo queryInfo, ResultInfo resultInfo) {
        super();
        this.zoneName = zoneName;
        this.rrSets = rrSets;
        this.queryInfo = queryInfo;
        this.resultInfo = resultInfo;
    }
    /**
     * Get zone name.
     * @return the zoneName
     */
    public final String getZoneName() {
        return zoneName;
    }
    /**
     * Set zone name.
     * @param zoneName the zoneName to set
     */
    public final void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
    /**
     * Get RR sets.
     * @return the rrSets
     */
    public final List<RRSet> getRrSets() {
        return rrSets;
    }
    /**
     * Set rrsets.
     * @param rrSets the rrSets to set
     */
    public final void setRrSets(List<RRSet> rrSets) {
        this.rrSets = rrSets;
    }
    /**
     * Get query info.
     * @return the queryInfo
     */
    public final QueryInfo getQueryInfo() {
        return queryInfo;
    }
    /**
     * Set query info.
     * @param queryInfo the queryInfo to set
     */
    public final void setQueryInfo(QueryInfo queryInfo) {
        this.queryInfo = queryInfo;
    }
    /**
     * Get result info.
     * @return the resultInfo
     */
    public final ResultInfo getResultInfo() {
        return resultInfo;
    }
    /**
     * Set result info.
     * @param resultInfo the resultInfo to set
     */
    public final void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return Objects.toStringHelper(this).add("zoneName", getZoneName())
                .add("rrSets", getRrSets())
                .add("queryInfo", getQueryInfo())
                .add("resultInfo", getResultInfo())
                .toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getZoneName(), getRrSets(),
                getQueryInfo());
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
        isEqual = Objects.equal(getZoneName(), other.getZoneName())
                && Objects.equal(getRrSets(), other.getRrSets())
                && Objects.equal(getQueryInfo(), other.getQueryInfo())
                && Objects.equal(getResultInfo(), other.getResultInfo());
        return isEqual;
    }
    
}

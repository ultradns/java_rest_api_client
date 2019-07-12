/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Base Query List.
 *
 * @author kushalraj.bhandari
 */
@JsonInclude(Include.NON_NULL)
public class BaseQueryList {

    /**
     * Query info.
     */
    private QueryInfo queryInfo;
    /**
     * Result info.
     */
    private ResultInfo resultInfo;

    /**
     * Empty constructor.
     */
    public BaseQueryList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param queryInfo  - {@link QueryInfo}
     * @param resultInfo - {@link ResultInfo}
     */
    public BaseQueryList(QueryInfo queryInfo, ResultInfo resultInfo) {
        super();
        this.queryInfo = queryInfo;
        this.resultInfo = resultInfo;
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
     * @param resultInfo the resultInfo to set
     */
    public final void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }
}

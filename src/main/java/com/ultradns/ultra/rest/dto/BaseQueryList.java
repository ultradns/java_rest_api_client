/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

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

    private CursorInfo cursorInfo;
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
     * @param cursorInfo - {@link CursorInfo}
     */
    public BaseQueryList(QueryInfo queryInfo, ResultInfo resultInfo, CursorInfo cursorInfo) {
        super();
        this.queryInfo = queryInfo;
        this.resultInfo = resultInfo;
        this.cursorInfo = cursorInfo;
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
     * Get cursor info.
     *
     * @return the cursorInfo
     */
    public final CursorInfo getCursorInfo() {
        return cursorInfo;
    }

    /**
     * Set cursor info.
     *
     * @param cursorInfo the cursorInfo to set
     */
    public final void setCursorInfo(CursorInfo cursorInfo) {
        this.cursorInfo = cursorInfo;
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

/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Web forward list.
 */
@JsonInclude(Include.NON_NULL)
public class WebForwardList extends BaseQueryList {

    /**
     * List of WebForward.
     */
    private List<WebForward> webForwards = Lists.newLinkedList();

    /**
     * Empty constructor.
     */
    public WebForwardList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param webForwards - {@link List} of {@link WebForward}
     * @param queryInfo   - {@link QueryInfo}
     * @param resultInfo  - {@link ResultInfo}
     */
    public WebForwardList(List<WebForward> webForwards, QueryInfo queryInfo, ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.webForwards = webForwards;
    }

    public List<WebForward> getWebForwards() {
        return webForwards;
    }

    public void setWebForwards(List<WebForward> webForwards) {
        this.webForwards = webForwards;
    }
}

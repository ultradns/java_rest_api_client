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
 * Mail Forward List.
 *
 * @author kushalraj.bhandari
 */
@JsonInclude(Include.NON_NULL)
public class MailForwardList extends BaseQueryList {

    /**
     * List of MailForward.
     */
    private List<MailForward> mailForwards = Lists.newLinkedList();

    /**
     * Parameterized constructor. -
     */
    public MailForwardList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param mailForwards - List of {@link MailForward}
     * @param queryInfo    - {@link QueryInfo}
     * @param resultInfo   - {@link ResultInfo}
     */
    public MailForwardList(List<MailForward> mailForwards, QueryInfo queryInfo, ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.mailForwards = mailForwards;
    }

    public List<MailForward> getMailForwards() {
        return mailForwards;
    }

    public void setMailForwards(List<MailForward> mailForwards) {
        this.mailForwards = mailForwards;
    }
}

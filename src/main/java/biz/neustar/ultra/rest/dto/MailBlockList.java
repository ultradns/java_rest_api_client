/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Mail block list DTO.
 */
@JsonInclude(Include.NON_NULL)
public class MailBlockList extends BaseQueryList {

    /**
     * List of {@link MailBlock}.
     */
    private List<MailBlock> mailBlocks = Lists.newLinkedList();

    /**
     * Empty constructor.
     */
    public MailBlockList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param mailBlocks
     * @param queryInfo
     * @param resultInfo
     */
    public MailBlockList(List<MailBlock> mailBlocks, QueryInfo queryInfo, ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.mailBlocks = mailBlocks;
    }

    public List<MailBlock> getMailBlocks() {
        return mailBlocks;
    }

    public void setMailBlocks(List<MailBlock> mailBlocks) {
        this.mailBlocks = mailBlocks;
    }
}

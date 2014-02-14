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
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Account list DTO.
 * 
 */
@JsonInclude(Include.NON_NULL)
public class AccountList extends BaseQueryList {

    /**
     * {@link java.util.List} of {@link Account}.
     */
    private List<Account> accounts = Lists.newLinkedList();

    /**
     * Empty constructor.
     */
    public AccountList() {
        super();
    }

    public AccountList(List<Account> accounts, QueryInfo queryInfo,
                       ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}

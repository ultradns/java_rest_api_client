/**
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
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
 * Account list DTO.
 */
@JsonInclude(Include.NON_NULL)
public class AccountList extends BaseQueryList {

    /**
     * {@link List} of {@link Account}.
     */
    private List<Account> accounts = Lists.newLinkedList();

    /**
     * Empty constructor.
     */
    public AccountList() {
        super();
    }

    public AccountList(List<Account> accounts, QueryInfo queryInfo, ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("accounts", getAccounts()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getAccounts());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof AccountList)) {
            return false;
        }
        final AccountList other = (AccountList) obj;
        isEqual = Objects.equal(getAccounts(), other.getAccounts());
        return isEqual;
    }
}

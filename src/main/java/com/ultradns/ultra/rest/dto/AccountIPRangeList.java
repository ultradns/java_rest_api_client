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
 * Account list DTO.
 */
@JsonInclude(Include.NON_NULL)
public class AccountIPRangeList extends BaseQueryList {

    /**
     * {@link List} of {@link Account}.
     */
    private List<AccountIPRange> accountIPRanges = Lists.newLinkedList();

    /**
     * Empty constructor.
     */
    public AccountIPRangeList() {
        super();
    }

    public AccountIPRangeList(List<AccountIPRange> accountIPRanges, QueryInfo queryInfo, ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.accountIPRanges = accountIPRanges;
    }

    public List<AccountIPRange> getAccountIPRanges() {
        return accountIPRanges;
    }

    public void setAccountIPRanges(List<AccountIPRange> accountIPRanges) {
        this.accountIPRanges = accountIPRanges;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("accountIPRanges", getAccountIPRanges()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getAccountIPRanges());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof AccountIPRangeList)) {
            return false;
        }
        final AccountIPRangeList other = (AccountIPRangeList) obj;
        isEqual = Objects.equal(getAccountIPRanges(), other.getAccountIPRanges());
        return isEqual;
    }
}

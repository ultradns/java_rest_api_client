package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Account Level IP Group list dto.
 *
 * @author ankitm.agarwal
 */

@JsonInclude(Include.NON_NULL)
public class AccountIPGroupList extends BaseQueryList {

    private String accountName;
    /**
     * {@link List} of {@link AccountIPGroup}.
     */
    private List<AccountIPGroup> ipGroups = Lists.newLinkedList();

    /**
     * Empty constructor.
     */
    public AccountIPGroupList() {
        super();
    }

    public AccountIPGroupList(String accountName, List<AccountIPGroup> ipGroups, QueryInfo queryInfo,
            ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.accountName = accountName;
        this.ipGroups = ipGroups;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public List<AccountIPGroup> getIpGroups() {
        return ipGroups;
    }

    public void setIpGroups(List<AccountIPGroup> ipGroups) {
        this.ipGroups = ipGroups;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("accountName", getAccountName())
                .add("ipGroups", getIpGroups())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getAccountName(), getIpGroups());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof AccountIPGroupList)) {
            return false;
        }
        final AccountIPGroupList other = (AccountIPGroupList) obj;
        return Objects.equal(getAccountName(), other.getAccountName()) && Objects.equal(getIpGroups(),
                other.getIpGroups());
    }
}

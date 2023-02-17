package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Account Level Geo Group list dto.
 *
 * @author ankitm.agarwal
 */

@JsonInclude(Include.NON_NULL)
public class AccountGeoGroupList extends BaseQueryList {
    private String accountName;
    /**
     * {@link List} of {@link AccountGeoGroup}.
     */
    private List<AccountGeoGroup> geoGroups = Lists.newLinkedList();

    /**
     * Empty constructor.
     */
    public AccountGeoGroupList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param accountName         - {@link AccountGeoGroupList#accountName}
     * @param accountGeoGroupList - {@link AccountGeoGroupList#geoGroups}
     * @param queryInfo           - {@link AccountGeoGroupList#queryInfo}
     * @param resultInfo          - {@link AccountGeoGroupList#resultInfo}
     */
    public AccountGeoGroupList(String accountName, List<AccountGeoGroup> accountGeoGroupList, QueryInfo queryInfo,
            ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.accountName = accountName;
        this.geoGroups = accountGeoGroupList;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public List<AccountGeoGroup> getGeoGroups() {
        return geoGroups;
    }

    public void setGeoGroups(List<AccountGeoGroup> geoGroups) {
        this.geoGroups = geoGroups;
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
                .add("geoGroups", getGeoGroups())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getAccountName(), getGeoGroups());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof AccountGeoGroupList)) {
            return false;
        }
        final AccountGeoGroupList other = (AccountGeoGroupList) obj;
        return Objects.equal(getAccountName(), other.getAccountName()) && Objects.equal(getGeoGroups(),
                other.getGeoGroups());
    }
}

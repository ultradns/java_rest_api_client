/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * User detail list DTO.
 */
@JsonInclude(Include.NON_NULL)
public class UserInfoList extends BaseQueryList {
    /**
     * {@link List} of {@link UserInfo}.
     */
    private List<UserInfo> users = Lists.newLinkedList();

    /**
     * Default constructor.
     */
    public UserInfoList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param users      - {@link UserInfoList#list}
     * @param queryInfo  - {@link UserInfoList#queryInfo}
     * @param resultInfo - - {@link UserInfoList#resultInfo}
     */
    public UserInfoList(List<UserInfo> users, QueryInfo queryInfo, ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.users = users;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("users", getUsers()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getUsers());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof UserInfoList)) {
            return false;
        }
        final UserInfoList other = (UserInfoList) obj;
        return Objects.equal(getUsers(), other.getUsers());
    }
}

/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
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
 * User list DTO.
 */
@JsonInclude(Include.NON_NULL)
public class UserList extends BaseQueryList {
    /**
     * {@link List} of {@link User}.
     */
    private List<User> users = Lists.newLinkedList();

    /**
     * Default constructor.
     */
    public UserList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param users      - {@link UserList#list}
     * @param queryInfo  - {@link UserList#queryInfo}
     * @param resultInfo - - {@link UserList#resultInfo}
     */
    public UserList(List<User> users, QueryInfo queryInfo, ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

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
        boolean isEqual = true;
        if (!(obj instanceof UserList)) {
            return false;
        }
        final UserList other = (UserList) obj;
        isEqual = Objects.equal(getUsers(), other.getUsers());
        return isEqual;
    }
}

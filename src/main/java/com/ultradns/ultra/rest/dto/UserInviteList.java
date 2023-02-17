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

import java.util.List;

/**
 * The Class UserInviteList.
 */
@JsonInclude(Include.NON_NULL)
public class UserInviteList extends BaseQueryList {

    /** The invitations. */
    private List<UserInvite> invitations;

    /**
     * Gets the invitations.
     *
     * @return the invitations
     */
    public List<UserInvite> getInvitations() {
        return invitations;
    }

    /**
     * Sets the invitations.
     *
     * @param invitations
     *            the new invitations
     */
    public void setInvitations(List<UserInvite> users) {
        this.invitations = users;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("invitations", getInvitations()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getInvitations());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof UserInviteList)) {
            return false;
        }
        final UserInviteList other = (UserInviteList) obj;
        return Objects.equal(getInvitations(), other.getInvitations());
    }
}

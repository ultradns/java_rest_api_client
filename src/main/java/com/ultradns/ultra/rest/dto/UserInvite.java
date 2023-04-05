/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class UserInvite {

    /**
     * Name of security group for user.
     * <p>
     * Valid security group for account. Required for Invite user, ignored for
     * Re-Invite user.
     */
    private String group;

    /**
     * Whether or not the user is a standalone user.
     * <p>
     * Defaults to false. Ignored for Re-Invite user.
     */
    private boolean isStandalone;

    /**
     * Whether or not the user has api only access.
     * <p>
     * Defaults to false. Ignored for Re-Invite user.
     */
    private boolean isApiOnlyUser;

    /**
     * Email Address for new user.
     * <p>
     * Required.
     */
    private String email;

    /**
     * Default constructor.
     */
    public UserInvite() {
        this.isStandalone = false;
        this.isApiOnlyUser = false;
    }

    /**
     * Parameterized constructor.
     *
     * @param group
     *            - group
     * @param isStandalone
     *            - isStandalone
     * @param isApiOnlyUser
     *            - isApiOnlyUser
     * @param email
     *            - email
     */
    public UserInvite(String group, boolean isStandalone, boolean isApiOnlyUser, String email) {
        this.group = group;
        this.isStandalone = isStandalone;
        this.isApiOnlyUser = isApiOnlyUser;
        this.email = email;
    }

    /**
     * Get the security group for user.
     *
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * Set the security group for user.
     *
     * @param group
     *            the group to set
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Get the isStandalone value for user.
     *
     * @return the isStandalone value
     */
    public boolean getIsStandalone() {
        return isStandalone;
    }

    /**
     * Set the isStandalone value for user.
     *
     * @param isStandalone
     *            the isStandalone value to set
     */
    public void setIsStandalone(boolean isStandalone) {
        this.isStandalone = isStandalone;
    }

    /**
     * Get the isApiOnlyUser value for user.
     *
     * @return the isApiOnlyUser value
     */
    public boolean getIsApiOnlyUser() {
        return isApiOnlyUser;
    }

    /**
     * Set the isApiOnlyUser value for user.
     *
     * @param isApiOnlyUser
     *            the isApiOnlyUser value to set
     */
    public void setIsApiOnlyUser(boolean isApiOnlyUser) {
        this.isApiOnlyUser = isApiOnlyUser;
    }

    /**
     * Get the email address for the user.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address for the user.
     *
     * @param email
     *            the email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("group", this.getGroup())
                .add("isStandalone", this.getIsStandalone()).add("isApiOnlyUser", this.getIsApiOnlyUser())
                .add("email", this.getEmail()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getGroup(), getIsStandalone(), getIsApiOnlyUser(), getEmail());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof UserInvite)) {
            return false;
        }
        final UserInvite other = (UserInvite) obj;
        return Objects.equal(getGroup(), other.getGroup())
                && Objects.equal(getIsStandalone(), other.getIsStandalone())
                && Objects.equal(getIsApiOnlyUser(), other.getIsApiOnlyUser())
                && Objects.equal(getEmail(), other.getEmail());

    }
}

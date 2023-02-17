/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

/**
 * The Class UserInviteInfo.
 */
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("PMD.TooManyFields")
public class UserInviteInfo {

    /** The user name. */
    private String userName;

    /** The password. */
    private String password;

    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;

    /** The account name. */
    private String accountName;

    /** The account id. */
    private String accountId;

    /** The primary user. */
    private String primaryUser;

    /** The primary user email. */
    private String primaryUserEmail;

    /** The primary email. */
    private String primaryEmail;

    /** The invitedby. */
    private String invitedby;

    /** The invited by email. */
    private String invitedByEmail;

    /** The assigned to group. */
    private String assignedToGroup;

    /** The phone. */
    private String phone;

    /** User's mobile. */
    private String mobile;

    /** The company. */
    private String company;

    /** The address. */
    private Address address;

    /** The security preferences. */
    private SecurityPreferences securityPreferences;

    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName
     *            the new user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     *            the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName
     *            the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the account name.
     *
     * @return the account name
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the account name.
     *
     * @param accountName
     *            the new account name
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Gets the account id.
     *
     * @return the account id
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Sets the account id.
     *
     * @param accountId
     *            the new account id
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Gets the primary user.
     *
     * @return the primary user
     */
    public String getPrimaryUser() {
        return primaryUser;
    }

    /**
     * Sets the primary user.
     *
     * @param primaryUser
     *            the new primary user
     */
    public void setPrimaryUser(String primaryUser) {
        this.primaryUser = primaryUser;
    }

    /**
     * Gets the primary user email.
     *
     * @return the primary user email
     */
    public String getPrimaryUserEmail() {
        return primaryUserEmail;
    }

    /**
     * Sets the primary user email.
     *
     * @param primaryUserEmail
     *            the new primary user email
     */
    public void setPrimaryUserEmail(String primaryUserEmail) {
        this.primaryUserEmail = primaryUserEmail;
    }

    /**
     * Gets the primary email.
     *
     * @return the primary email
     */
    public String getPrimaryEmail() {
        return primaryEmail;
    }

    /**
     * Sets the primary email.
     *
     * @param primaryEmail
     *            the new primary email
     */
    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    /**
     * Gets the invitedby.
     *
     * @return the invitedby
     */
    public String getInvitedby() {
        return invitedby;
    }

    /**
     * Sets the invitedby.
     *
     * @param invitedby
     *            the new invitedby
     */
    public void setInvitedby(String invitedby) {
        this.invitedby = invitedby;
    }

    /**
     * Gets the invited by email.
     *
     * @return the invited by email
     */
    public String getInvitedByEmail() {
        return invitedByEmail;
    }

    /**
     * Sets the invited by email.
     *
     * @param invitedByEmail
     *            the new invited by email
     */
    public void setInvitedByEmail(String invitedByEmail) {
        this.invitedByEmail = invitedByEmail;
    }

    /**
     * Gets the assigned to group.
     *
     * @return the assigned to group
     */
    public String getAssignedToGroup() {
        return assignedToGroup;
    }

    /**
     * Sets the assigned to group.
     *
     * @param assignedToGroup
     *            the new assigned to group
     */
    public void setAssignedToGroup(String assignedToGroup) {
        this.assignedToGroup = assignedToGroup;
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     *
     * @param phone
     *            the new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get mobile of user.
     *
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Set mobile of user.
     *
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the company.
     *
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the company.
     *
     * @param company
     *            the new company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address
     *            the new address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets the security preferences.
     *
     * @return the security preferences
     */
    public SecurityPreferences getSecurityPreferences() {
        return securityPreferences;
    }

    /**
     * Sets the security preferences.
     *
     * @param securityPreferences
     *            the new security preferences
     */
    public void setSecurityPreferences(SecurityPreferences securityPreferences) {
        this.securityPreferences = securityPreferences;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getUserName(), getPassword(), getFirstName(), getLastName(), getAccountName(),
                getAccountId(), getPrimaryUser(), getPrimaryEmail(), getInvitedby(), getInvitedByEmail(),
                getAssignedToGroup(), getPhone(), getMobile(), getCompany(), getAddress(), getSecurityPreferences());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final UserInviteInfo other = (UserInviteInfo) obj;
        isEqual = Objects.equal(getUserName(), other.getUserName()) && Objects.equal(getPassword(), other.getPassword())
                && Objects.equal(getFirstName(), other.getFirstName())
                && Objects.equal(getLastName(), other.getLastName())
                && Objects.equal(getAccountName(), other.getAccountName())
                && Objects.equal(getAccountId(), other.getAccountId())
                && Objects.equal(getPrimaryUser(), other.getPrimaryUser())
                && Objects.equal(getPrimaryEmail(), other.getPrimaryEmail())
                && Objects.equal(getInvitedby(), other.getInvitedby())
                && Objects.equal(getInvitedByEmail(), other.getInvitedByEmail())
                && Objects.equal(getAssignedToGroup(), other.getAssignedToGroup())
                && Objects.equal(getPhone(), other.getPhone()) && Objects.equal(getMobile(), other.getMobile())
                && Objects.equal(getCompany(), other.getCompany())
                && Objects.equal(getAddress(), other.getAddress())
                && Objects.equal(getSecurityPreferences(), other.getSecurityPreferences());
        return isEqual;
    }
}

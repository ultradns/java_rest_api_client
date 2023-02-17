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

/**
 * User Detail DTO.
 */
@JsonInclude(Include.NON_NULL)
public class UserInfo extends User {
    /**
     * User's given primary email.
     */
    private String primaryEmail;
    /**
     * User's given secondary email.
     */
    private String secondaryEmail;
    /**
     * User's phone.
     */
    private String phone;
    /**
     * User's fax.
     */
    private String fax;
    /**
     * User's mobile.
     */
    private String mobile;
    /**
     * User's Company Name.
     */
    private String companyName;
    /**
     * Whether or not the user can invite user.
     */
    private Boolean canInviteUser;
    /**
     * Whether or not the password is expired.
     */
    private Boolean isPasswordExpired;

    /** The is api only user. */
    private boolean isApiOnlyUser;

    /** Auth Type for user. */
    private String authType;

    /**
     * Default contructor.
     */
    public UserInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param userName       - {@link UserInfo#userName}
     * @param firstName      - {@link UserInfo#firstName}
     * @param lastName       - {@link UserInfo#lastName}
     * @param primaryEmail   - {@link UserInfo#primaryEmail}
     * @param secondaryEmail - {@link UserInfo#secondaryEmail}
     * @param phone          - {@link UserInfo#phone}
     * @param fax            - {@link UserInfo#fax}
     * @param mobile         - {@link UserInfo#mobile}
     * @param companyName    - {@link UserInfo#companyName}
     */
    public UserInfo(String userName, String firstName, String lastName, String primaryEmail, String secondaryEmail,
            String phone, String fax, String mobile, String companyName) {
        super(userName, firstName, lastName);
        this.primaryEmail = primaryEmail;
        this.secondaryEmail = secondaryEmail;
        this.phone = phone;
        this.fax = fax;
        this.mobile = mobile;
        this.companyName = companyName;
    }

    /**
     * Get primary email of user.
     *
     * @return the primaryEmail
     */
    public String getPrimaryEmail() {
        return primaryEmail;
    }

    /**
     * Set primary email of user.
     *
     * @param primaryEmail the primary email to set
     */
    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    /**
     * Get secondary email of user.
     *
     * @return the secondaryEmail
     */
    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    /**
     * Set secondary email of user.
     *
     * @param secondaryEmail the secondary email to set
     */
    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    /**
     * Get phone number of user.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set phone of user.
     *
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get fax of user.
     *
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * Set fax of user.
     *
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
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
     * Get company name of user.
     *
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Set company name of user.
     *
     * @param companyName the company name to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Get the can invite user value.
     *
     * @return canInviteUser
     */
    public Boolean isCanInviteUser() {
        return canInviteUser;
    }

    /**
     * Set the can invite user value.
     *
     * @param canInviteUser the can invite user value.
     */
    public void setCanInviteUser(Boolean canInviteUser) {
        this.canInviteUser = canInviteUser;
    }

    /**
     * Get the password expired value.
     *
     * @return isPasswordExpired
     */
    public Boolean getIsPasswordExpired() {
        return isPasswordExpired;
    }

    /**
     * Set the password expired value.
     *
     * @param isPasswordExpired the password expired value.
     */
    public void setIsPasswordExpired(boolean isPasswordExpired) {
        this.isPasswordExpired = isPasswordExpired;
    }

    /**
     * Checks if is api only user.
     *
     * @return true, if is api only user
     */
    public boolean isApiOnlyUser() {
        return isApiOnlyUser;
    }

    /**
     * Sets the api only user.
     *
     * @param apiOnlyUser
     *            the new api only user
     */
    public void setApiOnlyUser(boolean apiOnlyUser) {
        this.isApiOnlyUser = apiOnlyUser;
    }

    /**
     * Get auth type of user.
     *
     * @return the authType
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * Set auth type of user.
     *
     * @param authType the authType to set
     */
    public void setAuthType(String authType) {
        this.authType = authType;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("userName", getUserName())
                .add("firstName", getFirstName())
                .add("lastName", getLastName())
                .add("primaryEmail", getPrimaryEmail())
                .add("secondaryEmail", getSecondaryEmail())
                .add("phone", getPhone())
                .add("fax", getFax())
                .add("mobile", getMobile())
                .add("companyName", getCompanyName())
                .add("canInviteUser", isCanInviteUser())
                .add("isPasswordExpired", getIsPasswordExpired())
                .add("isApiOnlyUser", isApiOnlyUser())
                .add("authType", getAuthType())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getUserName(), getFirstName(), getLastName(), getPrimaryEmail(), getSecondaryEmail(),
                getPhone(), getMobile(), getCompanyName(), isCanInviteUser(), getIsPasswordExpired(), isApiOnlyUser(),
                getAuthType());
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
        final UserInfo other = (UserInfo) obj;
        isEqual =
                Objects.equal(getUserName(), other.getUserName()) && Objects.equal(getFirstName(), other.getFirstName())
                        && Objects.equal(getLastName(), other.getLastName()) && Objects.equal(getPrimaryEmail(),
                        other.getPrimaryEmail()) && Objects.equal(getSecondaryEmail(), other.getSecondaryEmail())
                        && Objects.equal(getPhone(), other.getPhone()) && Objects.equal(getMobile(), other.getMobile())
                        && Objects.equal(getCompanyName(), other.getCompanyName())
                        && Objects.equal(isCanInviteUser(), other.isCanInviteUser())
                        && Objects.equal(getIsPasswordExpired(), other.getIsPasswordExpired())
                        && Objects.equal(getAuthType(), other.getAuthType());
        return isEqual;
    }
}

/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may
 * trademarks of their respective owners.
 */

package com.ultradns.ultra.rest.dto;

import com.google.common.base.MoreObjects;

import java.util.Objects;

/**
 * This class represents the attributes of a user which needs to get copied over to Ultra LDAP for SAML SSO.
 */
public class CopyUserToLDAPDetails {

    /**
     * Enum which holds user access values, api's for api only user and portal for all UI access.
     */
    public enum UserAllowedAccess {
        APIS, ULTRAPORTAL
    }

    /**
     * current udns username of the user used to access udns portal and api's.
     */
    private String currentUDNSUsername;

    /**
     * email address of the user, refers to the primary email address field in user_details.
     */
    private String primaryEmailAddress;

    /**
     * after copying the user to LDAP, his/her username in UDNS would be updated with the nameID that will be sent as
     * part of SAML assertion. for e.g; if nameID is email, username in user_details would be updated to email.
     */
    private String userNameIDValueInLDAP;

    /**
     * does this api login is automated with your api's? if so this user would not be allowed to access via SAML a nd
     * his access to UDNS would only be limited to Rest API.
     */
    private boolean isApiOnlyUser;

    /**
     * user's firstname.
     * **/
    private String firstName;

    /**
     * user's lastName.
     * **/
    private String lastName;

    public String getCurrentUDNSUsername() {
        return currentUDNSUsername;
    }

    public void setCurrentUDNSUsername(String currentUDNSUsername) {
        this.currentUDNSUsername = currentUDNSUsername;
    }

    public String getPrimaryEmailAddress() {
        return primaryEmailAddress;
    }

    public void setPrimaryEmailAddress(String primaryEmailAddress) {
        this.primaryEmailAddress = primaryEmailAddress;
    }

    public String getUserNameIDValueInLDAP() {
        return userNameIDValueInLDAP;
    }

    public void setUserNameIDValueInLDAP(String userNameIDValueInLDAP) {
        this.userNameIDValueInLDAP = userNameIDValueInLDAP;
    }

    public boolean isApiOnlyUser() {
        return isApiOnlyUser;
    }

    public void setIsApiOnlyUser(boolean apiOnlyUser) {
        isApiOnlyUser = apiOnlyUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CopyUserToLDAPDetails)) {
            return false;
        }
        CopyUserToLDAPDetails that = (CopyUserToLDAPDetails) o;
        return isApiOnlyUser() == that.isApiOnlyUser() && Objects.equals(getCurrentUDNSUsername(),
                that.getCurrentUDNSUsername()) && Objects.equals(getPrimaryEmailAddress(),
                that.getPrimaryEmailAddress()) && Objects.equals(getUserNameIDValueInLDAP(),
                that.getUserNameIDValueInLDAP()) && Objects.equals(getFirstName(),
                that.getFirstName()) && Objects.equals(getLastName(), that.getLastName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCurrentUDNSUsername(), getPrimaryEmailAddress(), getUserNameIDValueInLDAP(),
                isApiOnlyUser(), getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("currentUDNSUsername", currentUDNSUsername)
                .add("primaryEmailAddress", primaryEmailAddress)
                .add("userNameIDValueInLDAP", userNameIDValueInLDAP)
                .add("isApiOnlyUser", isApiOnlyUser)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .toString();
    }
}

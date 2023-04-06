package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.io.InputStream;

/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class SamlConfigurationData {

    /**
     * The the saml nameID field either email or a username.
     */
    private String nameID;
    /**
     * The id of the customer billing account.
     */
    private String accountID;
    /**
     * The name of the saml point of contact.
     */
    private String samlContactName;
    /**
     * The phone number of the saml point of contact.
     */
    private String samlContactPhone;
    /**
     * The email of the saml point of contact.
     */
    private String samlContactEmail;
    /**
     * The udns vanity url to send saml request to.
     */
    private String vanityUrl;
    /**
     * If customer supports idp initiated saml then the url Service Provider should send the saml request to.
     */
    private String idpInitiatedUrl;
    /**
     * The saml idp meta-data xml file.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private InputStream idpMetaData;

    /**
     * The current state of saml configuration for the customers.
     */
    private String samlStatus;

    /**
     * Flag which determines if owner is allowed dual access form portal and via saml.
     */
    private boolean allowOwnerDualAccess;

    /**
     * The saml idp meta-data xml file to string format.
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonIgnore
    private String idpMetaDataToString;

    /**
     * The EntityID is set from ForgeRock response for the customer.
     */
    private String entityId;
    /**
     * Get meta-data file.
     *
     * @return the idpMetaData
     */
    public InputStream getIdpMetaData() {
        return idpMetaData;
    }

    /**
     * Get meta-data file String format.
     *
     * @return the idpMetaDataToString
     */
    public String getIdpMetaDataToString() {
        return idpMetaDataToString;
    }

    /**
     * Set idpMetaData.
     *
     * @param idpMetaData
     */
    public void setIdpMetaData(InputStream idpMetaData) {
        this.idpMetaData = idpMetaData;
    }


    /**
     * Set idpMetaDataToString.
     *
     * @param idpMetaDataToString
     */
    public void setIdpMetaDataToString(String idpMetaDataToString) {
        this.idpMetaDataToString = idpMetaDataToString;
    }

    /**
     * Get saml nameid.
     *
     * @return the nameID
     */
    public String getNameID() {
        return nameID;
    }

    /**
     * Set nameID.
     *
     * @param nameID
     */
    public void setNameID(String nameID) {
        this.nameID = nameID;
    }

    /**
     * Get customer billing account id.
     *
     * @return accountID
     */
    public String getAccountID() {
        return accountID;
    }

    /**
     * Set accountID.
     *
     * @param accountID
     */
    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    /**
     * Get point of contact name.
     *
     * @return the samlContactName
     */
    public String getSamlContactName() {
        return samlContactName;
    }

    /**
     * Set samlContactName.
     *
     * @param samlContactName
     */
    public void setSamlContactName(String samlContactName) {
        this.samlContactName = samlContactName;
    }

    /**
     * Get point of contact phone.
     *
     * @return the samlContactPhone
     */
    public String getSamlContactPhone() {
        return samlContactPhone;
    }

    /**
     * Set samlContactPhone.
     *
     * @param samlContactPhone
     */
    public void setSamlContactPhone(String samlContactPhone) {
        this.samlContactPhone = samlContactPhone;
    }

    /**
     * Get Saml status for the account.
     *
     * @return the samlStatus
     */
    public String getSamlStatus() {
        return samlStatus;
    }

    /**
     * Set samlStatus.
     *
     * @param samlStatus
     */
    public void setSamlStatus(String samlStatus) {
        this.samlStatus = samlStatus;
    }

    /**
     * Get saml contact email.
     *
     * @return the samlContactEmail
     */
    public String getSamlContactEmail() {
        return samlContactEmail;
    }

    /**
     * Set samlContactEmail.
     *
     * @param samlContactEmail
     */
    public void setSamlContactEmail(String samlContactEmail) {
        this.samlContactEmail = samlContactEmail;
    }

    /**
     * Get udns access url.
     *
     * @return the vanityUrl
     */
    public String getVanityUrl() {
        return vanityUrl;
    }

    /**
     * Set vanityUrl.
     *
     * @param vanityUrl
     */
    public void setVanityUrl(String vanityUrl) {
        this.vanityUrl = vanityUrl;
    }

    /**
     * Get idp initiated url.
     *
     * @return the idpMetaData
     */
    public String getIdpInitiatedUrl() {
        return idpInitiatedUrl;
    }

    public void setIdpInitiatedUrl(String idpInitiatedUrl) {
        this.idpInitiatedUrl = idpInitiatedUrl;
    }

    /**
     * Get if owner is allowed dual access.
     *
     * @return the allowOwnerDualAccess
     */
    public boolean isAllowOwnerDualAccess() {
        return allowOwnerDualAccess;
    }

    /**
     * Set allowOwnerDualAccess.
     *
     * @param allowOwnerDualAccess
     */
    public void setAllowOwnerDualAccess(boolean allowOwnerDualAccess) {
        this.allowOwnerDualAccess = allowOwnerDualAccess;
    }

    /**
     * Get entityId.
     *
     * @return the entityId
     */
    public String getEntityId() {
        return entityId;
    }

    /**
     * Set entityId.
     *
     * @param entityId
     */
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual;
        if (!(obj instanceof SamlConfigurationData)) {
            return false;
        }
        final SamlConfigurationData other = (SamlConfigurationData) obj;
        isEqual = Objects.equal(getNameID(), other.getNameID())
                && Objects.equal(getAccountID(), other.getAccountID())
                && Objects.equal(getSamlContactName(), other.getSamlContactName())
                && Objects.equal(getSamlContactPhone(), other.getSamlContactPhone())
                && Objects.equal(getSamlContactEmail(), other.getSamlContactEmail())
                && Objects.equal(getVanityUrl(), other.getVanityUrl())
                && Objects.equal(getIdpInitiatedUrl(), other.getIdpInitiatedUrl())
                && Objects.equal(getIdpMetaData(), other.getIdpMetaData())
                && Objects.equal(getSamlStatus(), other.getSamlStatus())
                && Objects.equal(isAllowOwnerDualAccess(), other.isAllowOwnerDualAccess())
                && Objects.equal(getEntityId(), other.getEntityId());
        return isEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNameID(), getAccountID(), getSamlContactName(), getSamlContactPhone(),
                getSamlContactEmail(), getVanityUrl(), getIdpInitiatedUrl(), getIdpInitiatedUrl(), getIdpMetaData(),
                getSamlStatus(), isAllowOwnerDualAccess(), getEntityId());
    }

}

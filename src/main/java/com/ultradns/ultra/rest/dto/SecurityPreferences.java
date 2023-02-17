package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.util.List;

/**
 * SecurityPreferences DTO.
 *
 */
@JsonInclude(Include.NON_NULL)
public class SecurityPreferences {

    /**
     * The old password.
     */
    private String oldPassword;
    /**
     * The password.
     */
    private String password;

    /**
     * The password expiration.
     */
    private Number passwordExpiration;

    /**
     * The security question1.
     */
    private String securityQuestion1;

    /**
     * The security answer1.
     */
    private String securityAnswer1;

    /**
     * The security question2.
     */
    private String securityQuestion2;

    /**
     * The security answer2.
     */
    private String securityAnswer2;

    /**
     * The security question3.
     */
    private String securityQuestion3;

    /**
     * The security answer3.
     */
    private String securityAnswer3;

    /**
     * The restrict access ips.
     */
    @JsonInclude(Include.NON_EMPTY)
    private List<RestrictAccessIP> restrictAccessIPs;

    /**
     * The two factor authentication type.
     */
    @JsonProperty("twoFactorAuthType")
    private String twoFactorAuthType;

    /**
     * The two factor token.
     */
    @JsonProperty("twoFactorAuthToken")
    private String twoFactorAuthToken;

    /**
     * Inactive time interval.
     */
    private Number inactivityTimeout;

    /**
     * Instantiates a new security preferences.
     *
     * @param password            the password.
     * @param passwordExpiration  the password expiration.
     * @param securityQuestion1ID the security question1 ID.
     * @param securityAnswer1     the security answer1.
     * @param securityQuestion2ID the security question2 ID.
     * @param securityAnswer2     the security answer2.
     * @param securityQuestion3ID the security question3 ID.
     * @param securityAnswer3     the security answer3.
     * @param restrictAccessIPs   the restrict access IPs.
     * @param inactivityTimeout   the inactivity timeout.
     * @param twoFactorAuthType   the two factor authentication type.
     * @param twoFactorAuthToken  the two factor authentication token.
     */
    @SuppressWarnings("PMD.ExcessiveParameterList")
    public SecurityPreferences(String password, Number passwordExpiration, String securityQuestion1ID,
            String securityAnswer1, String securityQuestion2ID, String securityAnswer2, String securityQuestion3ID,
            String securityAnswer3, List<RestrictAccessIP> restrictAccessIPs, Number inactivityTimeout,
            String twoFactorAuthType, String twoFactorAuthToken) {
        super();
        this.password = password;
        this.passwordExpiration = passwordExpiration;
        this.securityQuestion1 = securityQuestion1ID;
        this.securityAnswer1 = securityAnswer1;
        this.securityQuestion2 = securityQuestion2ID;
        this.securityAnswer2 = securityAnswer2;
        this.securityQuestion3 = securityQuestion3ID;
        this.securityAnswer3 = securityAnswer3;
        this.restrictAccessIPs = restrictAccessIPs;
        this.inactivityTimeout = inactivityTimeout;
        this.twoFactorAuthType = twoFactorAuthType;
        this.twoFactorAuthToken = twoFactorAuthToken;
    }

    /**
     * Instantiates a new security preferences. Empty Constructor.
     */
    public SecurityPreferences() {
        super();
    }

    /**
     * Gets the old password.
     *
     * @return oldPassword
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * Sets the old password.
     *
     * @param oldPassword
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
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
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the password expiration.
     *
     * @return the password expiration
     */
    public Number getPasswordExpiration() {
        return passwordExpiration;
    }

    /**
     * Sets the password expiration.
     *
     * @param passwordExpiration the new password expiration
     */
    public void setPasswordExpiration(Number passwordExpiration) {
        this.passwordExpiration = passwordExpiration;
    }

    /**
     * Gets the security question1.
     *
     * @return the security question1
     */
    public String getSecurityQuestion1() {
        return securityQuestion1;
    }

    /**
     * Sets the security question1.
     *
     * @param securityQuestion1 the new security question1
     */
    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }

    /**
     * Gets the security answer1.
     *
     * @return the security answer1
     */
    public String getSecurityAnswer1() {
        return securityAnswer1;
    }

    /**
     * Sets the security answer1.
     *
     * @param securityAnswer1 the new security answer1
     */
    public void setSecurityAnswer1(String securityAnswer1) {
        this.securityAnswer1 = securityAnswer1;
    }

    /**
     * Gets the security question2 id.
     *
     * @return the security question2 id
     */
    public String getSecurityQuestion2() {
        return securityQuestion2;
    }

    /**
     * Sets the security question2.
     *
     * @param securityQuestion2 the new security question2.
     */
    public void setSecurityQuestion2(String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2;
    }

    /**
     * Gets the security answer2.
     *
     * @return the security answer2
     */
    public String getSecurityAnswer2() {
        return securityAnswer2;
    }

    /**
     * Sets the security answer2.
     *
     * @param securityAnswer2 the new security answer2
     */
    public void setSecurityAnswer2(String securityAnswer2) {
        this.securityAnswer2 = securityAnswer2;
    }

    /**
     * Gets the security question3.
     *
     * @return the security question3
     */
    public String getSecurityQuestion3() {
        return securityQuestion3;
    }

    /**
     * Sets the security question3.
     *
     * @param securityQuestion3 the new security question3
     */
    public void setSecurityQuestion3(String securityQuestion3) {
        this.securityQuestion3 = securityQuestion3;
    }

    /**
     * Gets the security answer3.
     *
     * @return the security answer3
     */
    public String getSecurityAnswer3() {
        return securityAnswer3;
    }

    /**
     * Sets the security answer3.
     *
     * @param securityAnswer3 the new security answer3
     */
    public void setSecurityAnswer3(String securityAnswer3) {
        this.securityAnswer3 = securityAnswer3;
    }

    /**
     * Gets the restrict access i ps.
     *
     * @return the restrict access i ps
     */
    public List<RestrictAccessIP> getRestrictAccessIPs() {
        return restrictAccessIPs;
    }

    /**
     * Sets the restrict access i ps.
     *
     * @param restrictAccessIPs the new restrict access i ps
     */
    public void setRestrictAccessIPs(List<RestrictAccessIP> restrictAccessIPs) {
        this.restrictAccessIPs = restrictAccessIPs;
    }

    /**
     * Get inactivity timeout.
     *
     * @return the inactivityTimeout
     */
    public Number getInactivityTimeout() {
        return inactivityTimeout;
    }

    /**
     * Set inactivity timeout.
     *
     * @param inactivityTimeout the inactivityTimeout to set
     */
    public void setInactivityTimeout(Number inactivityTimeout) {
        this.inactivityTimeout = inactivityTimeout;
    }

    /**
     * Returns two factor authentication type.
     *
     * @return twoFactorAuthType.
     */
    public String getTwoFactorAuthType() {
        return twoFactorAuthType;
    }

    /**
     * Set the two factor authentication type.
     *
     * @param twoFactorAuthType - Two factor authentication type.
     */
    public void setTwoFactorAuthType(String twoFactorAuthType) {
        this.twoFactorAuthType = twoFactorAuthType;
    }

    /**
     * Returns two factor authentication token.
     *
     * @return twoFactorAuthToken.
     */
    public String getTwoFactorAuthToken() {
        return twoFactorAuthToken;
    }

    /**
     * Set the two factor authentication token.
     *
     * @param twoFactorAuthToken - Two factor authentication token.
     */
    public void setTwoFactorAuthToken(String twoFactorAuthToken) {
        this.twoFactorAuthToken = twoFactorAuthToken;
    }

    @Override
    public String toString() {
        return "SecurityPreferences [oldPassword=" + oldPassword + ", password=" + password + ", passwordExpiration="
                + passwordExpiration + ", securityQuestion1=" + securityQuestion1 + ", securityAnswer1="
                + securityAnswer1 + ", securityQuestion2=" + securityQuestion2 + ", securityAnswer2=" + securityAnswer2
                + ", securityQuestion3=" + securityQuestion3 + ", securityAnswer3=" + securityAnswer3
                + ", restrictAccessIPs=" + restrictAccessIPs + ", restrictAccessIPs=" + inactivityTimeout
                + ", twoFactorAuthType=" + twoFactorAuthType + ", twoFactorAuthToken=" + twoFactorAuthToken + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getOldPassword(), getPassword(), getPasswordExpiration(), getRestrictAccessIPs(),
                getSecurityAnswer1(), getSecurityAnswer2(), getSecurityAnswer3(), getSecurityQuestion1(),
                getSecurityQuestion2(), getSecurityQuestion3(), getInactivityTimeout(), getTwoFactorAuthType(),
                getTwoFactorAuthToken());
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof SecurityPreferences)) {
            return false;
        }
        final SecurityPreferences other = (SecurityPreferences) obj;
        isEqual = Objects.equal(getOldPassword(), other.getOldPassword())
                && Objects.equal(getPassword(), other.getPassword())
                && Objects.equal(getPasswordExpiration(), other.getPasswordExpiration())
                && Objects.equal(getRestrictAccessIPs(), other.getRestrictAccessIPs())
                && Objects.equal(getSecurityAnswer1(), other.getSecurityAnswer1())
                && Objects.equal(getSecurityAnswer2(), other.getSecurityAnswer2())
                && Objects.equal(getSecurityAnswer3(), other.getSecurityAnswer3())
                && Objects.equal(getSecurityQuestion1(), other.getSecurityQuestion1())
                && Objects.equal(getSecurityQuestion2(), other.getSecurityQuestion2())
                && Objects.equal(getSecurityQuestion3(), other.getSecurityQuestion3())
                && Objects.equal(getInactivityTimeout(), other.getInactivityTimeout())
                && Objects.equal(getTwoFactorAuthType(), other.getTwoFactorAuthType())
                && Objects.equal(getTwoFactorAuthToken(), other.getTwoFactorAuthToken());
        return isEqual;
    }

}

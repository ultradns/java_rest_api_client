package com.ultradns.ultra.rest.dto;

/*
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the Tokens returned from an Authorization Request.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenResponse {

    /**
     * The token type.
     */
    @JsonProperty("tokenType")
    private String tokenType;

    /**
     * The refresh token.
     */
    @JsonProperty("refreshToken")
    private String refreshToken;

    /**
     * The access token.
     */
    @JsonProperty("accessToken")
    private String accessToken;

    /**
     * The expires in value.
     */
    @JsonProperty("expiresIn")
    private String expiresIn;

    @JsonProperty("username")
    private String userName;

    /**
     * The two factor authentication type.
     */
    @JsonProperty("two_factor_auth_type")
    private String twoFactorAuth;

    /**
     * Instantiates a new token response.
     */
    public TokenResponse() {
        super();
    }

    /**
     * Instantiates a new token response.
     *
     * @param accessToken   the access token.
     * @param refreshToken  the refresh token.
     * @param expiresIn     the expire in value.
     * @param tokenType     the token type.
     * @param twoFactorAuth the two factor authentication type.
     * @param userName      the user name.
     */
    public TokenResponse(String accessToken, String refreshToken, String expiresIn, String tokenType,
            String twoFactorAuth, String userName) {
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.tokenType = tokenType;
        this.twoFactorAuth = twoFactorAuth;
        this.userName = userName;
    }

    /**
     * Get the refresh token.
     *
     * @return refresh token.
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Set the refresh token.
     *
     * @param refreshToken the refresh token.
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Get the access token.
     *
     * @return access token.
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Set the access token.
     *
     * @param accessToken the access token.
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Get the expire in value.
     *
     * @return expire in value.
     */
    public String getExpiresIn() {
        return expiresIn;
    }

    /**
     * Sets the expire in value.
     *
     * @param expiresIn the expire invalue.
     */
    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * Get the token type.
     *
     * @return token type.
     */
    public String getTokenType() {
        return tokenType;
    }

    /**
     * Set the token type.
     *
     * @param tokenType the token type.
     */
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the refresh_token value.
     *
     * @return the refresh token.
     */
    @JsonProperty("refresh_token")
    public String getOauthRefreshToken() {
        return refreshToken;
    }

    /**
     * Get the access_token value.
     *
     * @return access token value.
     */
    @JsonProperty("access_token")
    public String getOauthAccessToken() {
        return accessToken;
    }

    /**
     * Get the expire in value.
     *
     * @return expire in value.
     */
    @JsonProperty("expires_in")
    public String getOauthExpiresIn() {
        return expiresIn;
    }

    /**
     * Get the token_type value.
     *
     * @return the token type value.
     */
    @JsonProperty("token_type")
    public String getOauthTokenType() {
        return tokenType;
    }

    /**
     * Get the two factor authentication value.
     *
     * @return the two factor authentication value.
     */
    public String getTwoFactorAuth() {
        return twoFactorAuth;
    }

    /**
     * Set the two factor authentication value.
     *
     * @param twoFactorAuth the two factor authentication value.
     */
    public void setTwoFactorAuth(String twoFactorAuth) {
        this.twoFactorAuth = twoFactorAuth;
    }
}

package biz.neustar.ultra.rest.dto;

/*
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the Tokens returned from an Authorization Request.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TokenResponse {
    @JsonProperty("tokenType")
    private String tokenType;

    @JsonProperty("refreshToken")
    private String refreshToken;

    @JsonProperty("accessToken")
    private String accessToken;

    @JsonProperty("expiresIn")
    private String expiresIn;


    public TokenResponse() {
        super();
    }


    public TokenResponse(String accessToken, String refreshToken, String expiresIn, String tokenType) {
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.tokenType = tokenType;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

}

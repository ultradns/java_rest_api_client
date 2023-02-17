package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.UltraRestErrorConstant;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * User: jbodner
 * Date: 12/20/13
 * Time: 12:15 AM
 *
 * Copyright 2000-2012 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class UltraAuthError extends UltraError {
    private final String error;

    public UltraAuthError(String error, UltraRestErrorConstant errorConstant) {
        super(errorConstant);
        this.error = error;
    }

    public UltraAuthError(String error, int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
        this.error = error;
    }

    public String getError() {
        return error;
    }

    @JsonProperty("error_description")
    public String getErrorDescription() {
        return getErrorCode() + ": " + getErrorMessage();
    }
}

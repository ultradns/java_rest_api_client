/*
 * User: nupadhyay
 * Date: Apr 2, 2014
 * Time: 1:21:23 PM
 *
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.UltraRestSharedConstant.ProbeHttpMethod;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Transaction info.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionInfo {

    /**
     * List of http requests sent for a single probe.
     */
    private ProbeHttpMethod method;
    /**
     * URL to probe.
     */
    private String url;
    /**
     * Data to send to URL.
     */
    private String transmittedData;
    /**
     * Indicates whether or not to follow redirects.
     */
    private HttpLimitInfo limits;
    /**
     * Determine the cutoffs for sending notification or failing the probe.
     */
    private Boolean followRedirects;

    /** The expected HTTP response for probe to be successful. */
    private String expectedResponse;

    public TransactionInfo() {
        super();
    }

    public TransactionInfo(ProbeHttpMethod method, String url, String transmittedData, HttpLimitInfo limits,
            Boolean followRedirects) {
        super();
        this.method = method;
        this.url = url;
        this.transmittedData = transmittedData;
        this.limits = limits;
        this.followRedirects = followRedirects;
    }

    public ProbeHttpMethod getMethod() {
        return method;
    }

    public void setMethod(ProbeHttpMethod method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTransmittedData() {
        return transmittedData;
    }

    public void setTransmittedData(String transmittedData) {
        this.transmittedData = transmittedData;
    }

    public HttpLimitInfo getLimits() {
        return limits;
    }

    public void setLimits(HttpLimitInfo limits) {
        this.limits = limits;
    }

    public Boolean isFollowRedirects() {
        return followRedirects;
    }

    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    public String getExpectedResponse() {
        return expectedResponse;
    }

    public void setExpectedResponse(String expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    public void setDefaultValue() {
        if (followRedirects == null) {
            followRedirects = Boolean.FALSE;
        }
    }
}

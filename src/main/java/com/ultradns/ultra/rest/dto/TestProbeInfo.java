package com.ultradns.ultra.rest.dto;

/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */

import com.ultradns.ultra.rest.constants.UltraRestSharedConstant.ProbeHttpMethod;
import com.ultradns.ultra.rest.constants.UltraRestSharedConstant.ProbeType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestProbeInfo {

    /**
     * list of hosts to probe.
     */
    private List<String> hosts;

    /**
     * probe type requested such as http.
     */
    private ProbeType type;

    /**
     * http method supported: either GET or POST.
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
     * String to be searched in HTTP response from Probe target.
     */
    private String searchString;

    /**
     * For setting Follow Redirect for probe.
     */
    private boolean followRedirect;

    public TestProbeInfo() {
        super();
    }

    public TestProbeInfo(List<String> hosts, ProbeType type, ProbeHttpMethod method, String url, String transmittedData,
            String searchString, boolean followRedirect) {

        this.hosts = hosts;
        this.type = type;
        this.method = method;
        this.url = url;
        this.transmittedData = transmittedData;
        this.searchString = searchString;
        this.setFollowRedirect(followRedirect);
    }

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    public ProbeType getType() {
        return type;
    }

    public void setType(ProbeType type) {
        this.type = type;
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

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public boolean isFollowRedirect() {
        return followRedirect;
    }

    public void setFollowRedirect(boolean followRedirect) {
        this.followRedirect = followRedirect;
    }

}

/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.DefaultPorts;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * FTP Probe Details.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FTPProbeDetails implements ProbeDetails {

    /**
     * Port to connect to.
     */
    private Integer port;
    /**
     * Whether or not to use FTP Passive mode.
     */
    private Boolean passiveMode;
    /**
     * Username for FTP service.
     */
    private String username;
    /**
     * Password for FTP service.
     */
    private String password;
    /**
     * Path to check for a file.
     */
    private String path;

    private FTPLimitInfo limits;

    public FTPProbeDetails() {
        super();
    }

    public FTPProbeDetails(Integer port, Boolean passiveMode, String username, String password, String path,
            FTPLimitInfo limits) {
        super();
        this.port = port;
        this.passiveMode = passiveMode;
        this.username = username;
        this.password = password;
        this.path = path;
        this.limits = limits;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Boolean isPassiveMode() {
        return passiveMode;
    }

    public void setPassiveMode(Boolean passiveMode) {
        this.passiveMode = passiveMode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FTPLimitInfo getLimits() {
        return limits;
    }

    public void setLimits(FTPLimitInfo limits) {
        this.limits = limits;
    }

    public void setDefaultValue() {
        if (passiveMode == null) {
            passiveMode = Boolean.FALSE;
        }

        if (port == null) {
            port = DefaultPorts.FTP;
        }

        if (limits == null) {
            limits = new FTPLimitInfo();
        }

        limits.setDefaultValue();
    }

}

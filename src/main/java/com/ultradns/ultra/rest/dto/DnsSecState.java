/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

/**
 * This class is responsible to provide data to sign and unsign background task.
 */
public class DnsSecState {

    /**
     * Zone name.
     */
    private String zoneName;
    /**
     * User name.
     */
    private String userName;
    /**
     * Client ip.
     */
    private String clientIp;

    public DnsSecState() {
        super();
    }

    public DnsSecState(String zoneName, String userName, String clientIp) {
        super();
        this.zoneName = zoneName;
        this.userName = userName;
        this.clientIp = clientIp;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

}

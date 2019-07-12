/*
 * User: nupadhyay
 * Date: Sep 10, 2014
 * Time: 5:47:17 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

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

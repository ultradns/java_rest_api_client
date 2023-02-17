/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonInclude(Include.NON_NULL)
public class NameServer {

    /**
     * IP address of a zone's name server.
     */
    private String ip;
    /**
     * The name of the TSIG key.
     */
    private String tsigKey;
    /**
     * The TSIG key's value.
     */
    private String tsigKeyValue;

    /**
     * The algorithm for tsig.
     */
    private String tsigAlgorithm;

    /**
     * Empty constructor.
     */
    public NameServer() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param ip           - IP
     * @param tsigKey      - Tsig key
     * @param tsigKeyValue - Tsig Key Value
     */
    public NameServer(String ip, String tsigKey, String tsigKeyValue) {
        super();
        this.ip = ip;
        this.tsigKey = tsigKey;
        this.tsigKeyValue = tsigKeyValue;
    }

    /**
     * Parameterized constructor.
     *
     * @param ip           - IP
     * @param tsigKey      - Tsig key
     * @param tsigKeyValue - Tsig Key Value
     * @param tsigAlgorithm - The algorithm name for tsig
     */
    public NameServer(String ip, String tsigKey, String tsigKeyValue, String tsigAlgorithm) {
        super();
        this.ip = ip;
        this.tsigKey = tsigKey;
        this.tsigKeyValue = tsigKeyValue;
        this.tsigAlgorithm = tsigAlgorithm;
    }

    /**
     * Get IP.
     *
     * @return the ip
     */
    public final String getIp() {
        return ip;
    }

    /**
     * Set Ip.
     *
     * @param ip the ip to set
     */
    public final void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Get TSIG Key.
     *
     * @return the tsigKey
     */
    public final String getTsigKey() {
        return tsigKey;
    }

    /**
     * Get TSIG Key.
     *
     * @param tsigKey the tsigKey to set
     */
    public final void setTsigKey(String tsigKey) {
        this.tsigKey = tsigKey;
    }

    /**
     * Get TSIG Key value.
     *
     * @return the tsigKeyValue
     */
    public final String getTsigKeyValue() {
        return tsigKeyValue;
    }

    /**
     * Set TSIG Key value.
     *
     * @param tsigKeyValue the tsigKeyValue to set
     */
    public final void setTsigKeyValue(String tsigKeyValue) {
        this.tsigKeyValue = tsigKeyValue;
    }

    /**
     * This method returns the algorithm name for tsig.
     *
     * @return The name of algorithm for tsig
     */
    public String getTsigAlgorithm() {
        return tsigAlgorithm;
    }

    /**
     * This method sets the algorithm name for tsig.
     *
     * @param tsigAlgorithm The name of algorithm for tsig
     */
    public void setTsigAlgorithm(String tsigAlgorithm) {
        this.tsigAlgorithm = tsigAlgorithm;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ip", getIp())
                .add("tsigKey", getTsigKey())
                .add("tsigKeyValue", getTsigKeyValue())
                .add("tsigAlgorithm", getTsigAlgorithm())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getIp(), getTsigKey(), getTsigKeyValue(), getTsigAlgorithm());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof NameServer)) {
            return false;
        }
        final NameServer other = (NameServer) obj;
        isEqual = Objects.equal(getIp(), other.getIp())
                && Objects.equal(getTsigKey(), other.getTsigKey())
                && Objects.equal(getTsigKeyValue(), other.getTsigKeyValue())
                && Objects.equal(getTsigAlgorithm(), other.getTsigAlgorithm());
        return isEqual;
    }
}

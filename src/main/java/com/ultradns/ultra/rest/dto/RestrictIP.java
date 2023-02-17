/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Restrict IP.
 *
 * @author kushalraj.bhandari
 */
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("PMD.CyclomaticComplexity") //complaining about equals and hashCode
public class RestrictIP {

    /**
     * To generate hash code.
     */
    private static final int PRIME_NUMBER = 31;
    /**
     * Start IP.
     */
    private String startIP;
    /**
     * End IP.
     */
    private String endIP;
    /**
     * The CIDR.
     */
    private String cidr;
    /**
     * The single IP for restriction.
     */
    private String singleIP;
    /**
     * Comment.
     */
    private String comment;

    /**
     * Empty Constructor.
     */
    public RestrictIP() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param startIP - Start IP
     * @param endIP   - End IP
     * @param comment - comment
     */
    public RestrictIP(String startIP, String endIP, String cidr, String singleIP, String comment) {
        super();
        this.startIP = startIP;
        this.endIP = endIP;
        this.cidr = cidr;
        this.singleIP = singleIP;
        this.comment = comment;
    }

    /**
     * Get the startIP.
     *
     * @return the startIP
     */
    public final String getStartIP() {
        return startIP;
    }

    /**
     * Set the startIP.
     *
     * @param startIP the startIP to set
     */
    public final void setStartIP(String startIP) {
        this.startIP = startIP;
    }

    /**
     * Get the endIP.
     *
     * @return the endIP
     */
    public final String getEndIP() {
        return endIP;
    }

    /**
     * Set the endIP.
     *
     * @param endIP the endIP to set
     */
    public final void setEndIP(String endIP) {
        this.endIP = endIP;
    }

    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    public String getSingleIP() {
        return singleIP;
    }

    public void setSingleIP(String singleIP) {
        this.singleIP = singleIP;
    }

    /**
     * Get the comment.
     *
     * @return the comment
     */
    public final String getComment() {
        return comment;
    }

    /**
     * Set the comment.
     *
     * @param comment the comment to set
     */
    public final void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    @SuppressWarnings("PMD") // this is auto-generated code -- don't warn on how complicated it is
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RestrictIP that = (RestrictIP) o;

        if (cidr != null ? !cidr.equals(that.cidr) : that.cidr != null) {
            return false;
        }
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) {
            return false;
        }
        if (endIP != null ? !endIP.equals(that.endIP) : that.endIP != null) {
            return false;
        }
        if (singleIP != null ? !singleIP.equals(that.singleIP) : that.singleIP != null) {
            return false;
        }
        if (startIP != null ? !startIP.equals(that.startIP) : that.startIP != null) {
            return false;
        }

        return true;
    }

    @Override
    @SuppressWarnings("PMD") // this is auto-generated code -- don't warn on how complicated it is
    public int hashCode() {
        int result = startIP != null ? startIP.hashCode() : 0;
        result = PRIME_NUMBER * result + (endIP != null ? endIP.hashCode() : 0);
        result = PRIME_NUMBER * result + (cidr != null ? cidr.hashCode() : 0);
        result = PRIME_NUMBER * result + (singleIP != null ? singleIP.hashCode() : 0);
        result = PRIME_NUMBER * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RestrictIP{" + "startIP='" + startIP + '\'' + ", endIP='" + endIP + '\'' + ", cidr='" + cidr + '\''
                + ", singleIP='" + singleIP + '\'' + ", comment='" + comment + '\'' + '}';
    }
}

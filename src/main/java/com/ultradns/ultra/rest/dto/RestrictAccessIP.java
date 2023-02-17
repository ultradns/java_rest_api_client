package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

/**
 * The Class RestrictAccessIP.
 *
 * @author yash.khatri The Class RestrictAccessIP
 */
@JsonInclude(Include.NON_NULL)
public class RestrictAccessIP {

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
     * The application.
     */
    private AccessRestrictionApplication application;

    /**
     * Instantiates a new restrict access ip. Empty Constructor
     */
    public RestrictAccessIP() {
        super();
    }

    /**
     * Instantiates a new restrict access ip. Parameterized constructor.
     *
     * @param startIP     the start ip
     * @param endIP       the end ip
     * @param cidr        the cidr
     * @param singleIP    the single ip
     * @param comment     the comment
     * @param application the application
     */
    public RestrictAccessIP(String startIP, String endIP, String cidr, String singleIP, String comment,
            AccessRestrictionApplication application) {
        super();
        this.startIP = startIP;
        this.endIP = endIP;
        this.cidr = cidr;
        this.singleIP = singleIP;
        this.comment = comment;
        this.application = application;
    }

    /**
     * Gets the start ip.
     *
     * @return the start ip
     */
    public String getStartIP() {
        return startIP;
    }

    /**
     * Sets the start ip.
     *
     * @param startIP the new start ip
     */
    public void setStartIP(String startIP) {
        this.startIP = startIP;
    }

    /**
     * Gets the end ip.
     *
     * @return the end ip
     */
    public String getEndIP() {
        return endIP;
    }

    /**
     * Sets the end ip.
     *
     * @param endIP the new end ip
     */
    public void setEndIP(String endIP) {
        this.endIP = endIP;
    }

    /**
     * Gets the cidr.
     *
     * @return the cidr
     */
    public String getCidr() {
        return cidr;
    }

    /**
     * Sets the cidr.
     *
     * @param cidr the new cidr
     */
    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    /**
     * Gets the single ip.
     *
     * @return the single ip
     */
    public String getSingleIP() {
        return singleIP;
    }

    /**
     * Sets the single ip.
     *
     * @param singleIP the new single ip
     */
    public void setSingleIP(String singleIP) {
        this.singleIP = singleIP;
    }

    /**
     * Gets the comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment.
     *
     * @param comment the new comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets the application.
     *
     * @return the application
     */
    public AccessRestrictionApplication getApplication() {
        return application;
    }

    /**
     * Sets the application.
     *
     * @param application the new application
     */
    public void setApplication(AccessRestrictionApplication application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "RestrictAccessIP [startIP=" + startIP + ", endIP=" + endIP + ", cidr=" + cidr + ", singleIP=" + singleIP
                + ", comment=" + comment + ", application=" + application + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getStartIP(), getEndIP(), getCidr(), getSingleIP(), getComment(), getApplication());
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof RestrictAccessIP)) {
            return false;
        }
        final RestrictAccessIP other = (RestrictAccessIP) obj;
        isEqual = Objects.equal(getApplication(), other.getApplication()) && Objects.equal(getCidr(), other.getCidr())
                && Objects.equal(getComment(), other.getComment()) && Objects.equal(getSingleIP(), other.getSingleIP())
                && Objects.equal(getStartIP(), other.getStartIP()) && Objects.equal(getEndIP(), other.getEndIP());
        return isEqual;
    }

}

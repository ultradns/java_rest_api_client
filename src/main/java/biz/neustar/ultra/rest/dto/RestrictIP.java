/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

/**
 * Restrict IP.
 * @author kushalraj.bhandari
 *
 */
@JsonInclude(Include.NON_NULL)
public class RestrictIP {

    /**
     * Empty Constructor.
     */
    public RestrictIP() {
        super();
    }

    /**
     * Parameterized constructor.
     * 
     * @param startIP
     *            - Start IP
     * @param endIP
     *            - End IP
     * @param tsigKey
     *            - Tsig key
     * @param tsigKeyValue
     *            - Tsig key value
     * @param comment
     *            - comment
     */
    public RestrictIP(String startIP, String endIP, String tsigKey,
                      String tsigKeyValue, String comment) {
        super();
        this.startIP = startIP;
        this.endIP = endIP;
        this.tsigKey = tsigKey;
        this.tsigKeyValue = tsigKeyValue;
        this.comment = comment;
    }

    /**
     * Start IP.
     */
    private String startIP;

    /**
     * End IP.
     */
    private String endIP;

    /**
     * Tsig key.
     */
    private String tsigKey;

    /**
     * Tsig key value.
     */
    private String tsigKeyValue;

    /**
     * Comment.
     */
    private String comment;

    /**
     * Get the startIP.
     * @return the startIP
     */
    public final String getStartIP() {
        return startIP;
    }

    /**
     * Set the startIP.
     * @param startIP
     *            the startIP to set
     */
    public final void setStartIP(String startIP) {
        this.startIP = startIP;
    }

    /**
     * Get the endIP.
     * @return the endIP
     */
    public final String getEndIP() {
        return endIP;
    }

    /**
     * Set the endIP.
     * @param endIP
     *            the endIP to set
     */
    public final void setEndIP(String endIP) {
        this.endIP = endIP;
    }

    /**
     * Get the tsigKey.
     * @return the tsigKey
     */
    public final String getTsigKey() {
        return tsigKey;
    }

    /**
     * Set the tsigKey.
     * @param tsigKey
     *            the tsigKey to set
     */
    public final void setTsigKey(String tsigKey) {
        this.tsigKey = tsigKey;
    }

    /**
     * Get the tsigKeyValue.
     * @return the tsigKeyValue
     */
    public final String getTsigKeyValue() {
        return tsigKeyValue;
    }

    /**
     * Set the tsigKeyValue.
     * @param tsigKeyValue
     *            the tsigKeyValue to set
     */
    public final void setTsigKeyValue(String tsigKeyValue) {
        this.tsigKeyValue = tsigKeyValue;
    }

    /**
     * Get the comment.
     * @return the comment
     */
    public final String getComment() {
        return comment;
    }

    /**
     * Set the comment.
     * @param comment
     *            the comment to set
     */
    public final void setComment(String comment) {
        this.comment = comment;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {

        return Objects.toStringHelper(this).add("startIP", getStartIP())
                .add("endIP", getEndIP())
                .add("tsigKey", getTsigKey())
                .add("tsigKeyValue", getTsigKeyValue())
                .add("comment", getComment()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getStartIP(), getEndIP(), getTsigKey(),
                getTsigKeyValue(), getComment());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof RestrictIP)) {
            return false;
        }
        final RestrictIP other = (RestrictIP) obj;
        isEqual = Objects.equal(getStartIP(), other.getStartIP())
                && Objects.equal(getEndIP(), other.getEndIP())
                && Objects.equal(getTsigKey(), other.getTsigKey())
                && Objects.equal(getTsigKeyValue(), other.getTsigKeyValue())
                && Objects.equal(getComment(), other.getComment());
        return isEqual;
    }
}

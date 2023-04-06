/**
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Mail block DTO.
 */
@JsonInclude(Include.NON_NULL)
public class MailBlock {

    /**
     * The email address being blocked.
     */
    private String emailAddress;

    /**
     * Empty constructor.
     */
    public MailBlock() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param emailAddress - Email Address
     */
    public MailBlock(String emailAddress) {
        super();
        this.emailAddress = emailAddress;
    }

    /**
     * Get email address.
     *
     * @return the emailAddress
     */
    public final String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set email address.
     *
     * @param emailAddress the emailAddress to set
     */
    public final void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("emailAddress", getEmailAddress()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getEmailAddress());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof MailBlock)) {
            return false;
        }
        final MailBlock other = (MailBlock) obj;
        isEqual = Objects.equal(getEmailAddress(), other.getEmailAddress());
        return isEqual;
    }
}

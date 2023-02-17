/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * MailForward DTO.
 *
 */
@JsonInclude(Include.NON_NULL)
public class MailForward {

    /**
     * The email address being forwarded.
     */
    private String emailAddress;

    /**
     * Specifies the URL to redirect.
     */
    private List<MailForwardTo> forwardList = Lists.newArrayList();

    /**
     * Empty Constructor.
     */
    public MailForward() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param emailAddress - Email Address
     * @param forwardList  - List of {@link MailForwardTo}
     */
    public MailForward(String emailAddress, List<MailForwardTo> forwardList) {
        super();
        this.emailAddress = emailAddress;
        this.forwardList = forwardList;
    }

    /**
     * Get the emailAddress.
     *
     * @return the emailAddress
     */
    public final String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set the emailAddress.
     *
     * @param emailAddress the emailAddress to set
     */
    public final void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Get the forwardList.
     *
     * @return the forwardList
     */
    public final List<MailForwardTo> getForwardList() {
        return forwardList;
    }

    /**
     * Set the forwardList.
     *
     * @param forwardList the forwardList to set
     */
    public final void setForwardList(List<MailForwardTo> forwardList) {
        this.forwardList = forwardList;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("emailAddress", emailAddress)
                .add("forwardList", forwardList)
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(emailAddress, forwardList);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof MailForward) {
            MailForward that = (MailForward) object;
            return Objects.equal(this.emailAddress, that.emailAddress) && Objects.equal(this.forwardList,
                    that.forwardList);
        }
        return false;
    }

    /**
     * An email address that is being forwarded to.
     *
     */
    public static class MailForwardTo {

        /**
         * An email address that is being forwarded to.
         */
        private String forward;

        /**
         * Empty constructor.
         */
        public MailForwardTo() {
            super();
        }

        /**
         * Parameterized constructor.
         *
         * @param forward - Forward email address
         */
        public MailForwardTo(String forward) {
            super();
            this.forward = forward;
        }

        /**
         * Get the forward.
         *
         * @return the forward
         */
        public final String getForward() {
            return forward;
        }

        /**
         * Set the forward.
         *
         * @param forward the forward to set
         */
        public final void setForward(String forward) {
            this.forward = forward;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("forward", forward).toString();
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            return Objects.hashCode(forward);
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object object) {
            if (!(object instanceof MailForwardTo)) {
                return false;
            }
            MailForwardTo that = (MailForwardTo) object;
            return Objects.equal(this.forward, that.forward);
        }
    }
}

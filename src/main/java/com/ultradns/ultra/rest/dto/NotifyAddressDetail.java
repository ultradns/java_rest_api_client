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

/**
 * This class represents DTO to hold notify address which needs to be notified on any update of a primary zone.
 */
@JsonInclude(Include.NON_NULL)
public class NotifyAddressDetail {

    /**
     * The Notify address.
     */
    private String notifyAddress;

    /**
     * The description.
     */
    private String description;

    /**
     * Default constructor.
     */
    public NotifyAddressDetail() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param notifyAddress The notify address.
     * @param description   The description.
     */
    public NotifyAddressDetail(final String notifyAddress, final String description) {
        super();
        this.notifyAddress = notifyAddress;
        this.description = description;
    }

    /**
     * This method returns the notify address.
     *
     * @return notify address
     */
    public String getNotifyAddress() {
        return notifyAddress;
    }

    /**
     * This method sets the notify address.
     *
     * @param notifyAddress The notify address.
     */
    public void setNotifyAddress(final String notifyAddress) {
        this.notifyAddress = notifyAddress;
    }

    /**
     * This method returns the description.
     *
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method sets the description.
     *
     * @param description The description.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNotifyAddress(), getDescription());
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof NotifyAddressDetail) {
            NotifyAddressDetail that = (NotifyAddressDetail) object;
            return Objects.equal(getNotifyAddress(), that.getNotifyAddress()) && Objects.equal(getDescription(),
                    that.getDescription());
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("notifyAddress", getNotifyAddress())
                .add("description", getDescription())
                .toString();
    }

}

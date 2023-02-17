/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.UltraRestSharedConstant.RDProfileOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * RDPoolProfile.java.
 *
 * @author kushalraj.bhandari
 */
public class RDPoolProfile implements Profile {

    private String description;

    private RDProfileOrder order;

    public RDPoolProfile() {
        super();
    }

    public RDPoolProfile(String description, RDProfileOrder order) {
        super();
        this.description = description;
        this.order = order;
    }

    /**
     * Get the description.
     *
     * @return the description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Set the description.
     *
     * @param description the description to set
     */
    public final void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the order.
     *
     * @return the order
     */
    public final RDProfileOrder getOrder() {
        return order;
    }

    /**
     * Set the order.
     *
     * @param order the order to set
     */
    public final void setOrder(RDProfileOrder order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("description", description).add("order", order).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(description, order);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof RDPoolProfile) {
            RDPoolProfile that = (RDPoolProfile) object;
            return Objects.equal(this.description, that.description) && Objects.equal(this.order, that.order);
        }
        return false;
    }

}

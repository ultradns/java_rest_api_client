/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Lab list DTO.
 */
@JsonInclude(Include.NON_NULL)
public class LabList extends BaseQueryList {

    /**
     * {@link List} of {@link Lab}.
     */
    private List<Lab> labs = Lists.newLinkedList();

    /**
     * Default constructor.
     */
    public LabList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param labs
     */
    public LabList(List<Lab> labs) {
        super();
        this.labs = labs;
    }

    public List<Lab> getLabs() {
        return labs;
    }

    public void setLabs(List<Lab> labs) {
        this.labs = labs;
    }

    @Override
    public String toString() {
        return "LabList{" + "labs=" + labs + "} " + super.toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getLabs());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof LabList)) {
            return false;
        }
        final LabList other = (LabList) obj;
        isEqual = Objects.equal(getLabs(), other.getLabs());
        return isEqual;
    }

}

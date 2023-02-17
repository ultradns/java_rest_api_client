/*
 * User: nupadhyay
 * Date: Oct 13, 2014
 * Time: 3:39:56 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

/**
 * This class is for internal use when applying JSON patch on rdata fields.
 */
public class RRDataInfo {

    /**
     * List of rdata fields.
     */
    private List<List<String>> rdata;

    /**
     * Default constructor.
     */
    public RRDataInfo() {
        super();
    }

    /**
     * To get RData.
     */
    public List<List<String>> getRdata() {
        return rdata;
    }

    /**
     * To set Rdata.
     */
    public void setRdata(List<List<String>> rdata) {
        this.rdata = rdata;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("rdata", getRdata()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getRdata());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof RRDataInfo)) {
            return false;
        }
        final RRDataInfo other = (RRDataInfo) obj;
        isEqual = Objects.equal(getRdata(), other.getRdata());
        return isEqual;
    }
}


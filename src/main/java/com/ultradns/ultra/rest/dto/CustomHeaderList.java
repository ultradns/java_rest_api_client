/**
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Custom header list.
 */
public class CustomHeaderList {
    /**
     * Header name list.
     */
    private List<String> names = Lists.newLinkedList();

    /**
     * Empty constructor.
     */
    public CustomHeaderList() {
        super();
    }

    /**
     * Parameterized contructor.
     *
     * @param names - Header Names
     */
    public CustomHeaderList(List<String> names) {
        super();
        this.names = names;
    }

    /**
     * Get names.
     *
     * @return the names
     */
    public final List<String> getNames() {
        return names;
    }

    /**
     * Set names.
     *
     * @param names the names to set
     */
    public final void setNames(List<String> names) {
        this.names = names;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("names", getNames()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getNames());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof CustomHeaderList)) {
            return false;
        }
        final CustomHeaderList other = (CustomHeaderList) obj;
        isEqual = Objects.equal(getNames(), other.getNames());
        return isEqual;
    }
}

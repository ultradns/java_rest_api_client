/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Alias Zone Info.
 */
@JsonInclude(Include.NON_NULL)
public class AliasZoneInfo {

    /**
     * Original zone name.
     */
    private String originalZoneName;

    /**
     * Empty constructor.
     */
    public AliasZoneInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param originalZoneName - Original Zone Name.
     */
    public AliasZoneInfo(String originalZoneName) {
        super();
        this.originalZoneName = originalZoneName;
    }

    /**
     * Get original zone name.
     *
     * @return the originalZoneName
     */
    public final String getOriginalZoneName() {
        return originalZoneName;
    }

    /**
     * Set original zone name.
     *
     * @param originalZoneName the originalZoneName to set
     */
    public final void setOriginalZoneName(String originalZoneName) {
        this.originalZoneName = originalZoneName;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("originalZoneName", getOriginalZoneName()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getOriginalZoneName());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof AliasZoneInfo)) {
            return false;
        }
        final AliasZoneInfo other = (AliasZoneInfo) obj;
        isEqual = Objects.equal(getOriginalZoneName(), other.getOriginalZoneName());
        return isEqual;
    }
}

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
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Exported zone DTO.
 */
@JsonInclude(Include.NON_NULL)
public class ExportedZone {

    private String zoneName;
    private List<RRSet> rrSets;
    private Map<String, Object> profile = Maps.newHashMap();

    public ExportedZone() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param zoneName - {@link String}
     * @param rrSets   - {@link List} of {@link RRSet}
     * @param profile  - A {@link Map}
     */
    public ExportedZone(String zoneName, List<RRSet> rrSets, Map<String, Object> profile) {
        super();
        this.zoneName = zoneName;
        this.rrSets = rrSets;
        this.profile = profile;
    }

    /**
     * Get profile.
     *
     * @return the profile
     */
    public final Map<String, Object> getProfile() {
        return profile;
    }

    /**
     * Set profile.
     *
     * @param profile the profile to set
     */
    public final void setProfile(Map<String, Object> profile) {
        this.profile = profile;
    }

    /**
     * Get RR sets.
     *
     * @return the rrSets
     */
    public final List<RRSet> getRrSets() {
        return rrSets;
    }

    /**
     * Set RR sets.
     *
     * @param rrSets the rrSets to set
     */
    public final void setRrSets(List<RRSet> rrSets) {
        this.rrSets = rrSets;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("zoneName", getZoneName())
                .add("rrSets", getRrSets())
                .add("profile", getProfile())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getZoneName(), getRrSets(), getProfile());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof ExportedZone)) {
            return false;
        }
        final ExportedZone other = (ExportedZone) obj;
        return Objects.equal(getZoneName(), other.getZoneName()) && Objects.equal(getRrSets(), other.getRrSets())
                && Objects.equal(getProfile(), other.getProfile());
    }

    /**
     * Zone profile.
     */
    public enum ZoneProfile {
        PRIMARY("http://schemas.ultradns.com/PrimaryZone.jsonschema"),
        ALIAS("http://schemas.ultradns.com/AliasZone.jsonschema");

        private String value;

        ZoneProfile(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }
}



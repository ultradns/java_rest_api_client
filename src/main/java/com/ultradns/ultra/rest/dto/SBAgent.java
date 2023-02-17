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
 * SB Agent Dto.
 *
 */
@JsonInclude(Include.NON_NULL)
public class SBAgent {

    /**
     * SB Agent ID.
     */
    private String id;

    /**
     * SB Agent secondary ID.
     */
    private String secondaryId;

    /**
     * SB Agent name.
     */
    private String name;

    /**
     * SB Agent sponsor ID (network ID).
     */
    private String sponsorId;

    /**
     * SB Agent description.
     */
    private String description;

    /**
     * SB Agent status.
     */
    private Boolean active;

    /**
     * SB Agent region ID.
     */
    private String regionId;

    /**
     * SB Agent location.
     */
    private String location;

    /**
     * Empty constructor.
     */
    public SBAgent() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecondaryId() {
        return secondaryId;
    }

    public void setSecondaryId(String secondaryId) {
        this.secondaryId = secondaryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(String sponsorId) {
        this.sponsorId = sponsorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", this.getId())
                .add("secondaryId", this.getSecondaryId())
                .add("name", this.getName())
                .add("sponsorId", this.getSponsorId())
                .add("description", this.getDescription())
                .add("active", this.getActive())
                .add("regionId", this.getRegionId())
                .add("location", this.getLocation())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(this.getName(), this.getLocation(), this.getDescription());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof SBAgent)) {
            return false;
        }
        final SBAgent other = (SBAgent) obj;
        return Objects.equal(this.getName(), other.getName())
                && Objects.equal(this.getLocation(), other.getLocation())
                && Objects.equal(this.getDescription(), other.getDescription());
    }

}

/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * UltraDNS Lab DTO.
 */
@JsonInclude(Include.NON_NULL)
public class Lab {

    /**
     * Lab's GUID.
     */
    private String guid;

    /**
     * Lab's name in UltraDNS system.
     */
    private String name;

    /**
     * Lab's description.
     */
    private String description;

    /**
     * Lab's image/logo URL.
     */
    private String imageUrl;

    /**
     * Whether the lab is enabled for the current account.
     */
    private Boolean enabled;

    /**
     * URI path where the lab is accessed.
     */
    private String path;

    /**
     * Default contructor.
     */
    public Lab() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param guid
     * @param name
     * @param description
     * @param imageUrl
     * @param enabled
     * @param path
     */
    public Lab(String guid, String name, String description, String imageUrl, Boolean enabled, String path) {
        super();
        this.guid = guid;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.enabled = enabled;
        this.path = path;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.MoreObjects#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("guid", getGuid())
                .add("name", getName())
                .add("description", getDescription())
                .add("imageUrl", getImageUrl())
                .add("enabled", getEnabled())
                .add("path", getPath())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getGuid(), getName(), getDescription(), getImageUrl(), getEnabled(), getPath());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof Lab)) {
            return false;
        }
        final Lab other = (Lab) obj;
        isEqual =
                Objects.equal(getGuid(), other.getGuid()) && Objects.equal(getName(), other.getName()) && Objects.equal(
                        getDescription(), other.getDescription()) && Objects.equal(getImageUrl(), other.getImageUrl())
                        && Objects.equal(getEnabled(), other.getEnabled()) && Objects.equal(getPath(), other.getPath());

        return isEqual;
    }
}

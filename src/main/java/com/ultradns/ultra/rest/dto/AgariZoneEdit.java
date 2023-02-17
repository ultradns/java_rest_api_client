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
 * Agari Zone Edit Dto.
 *
 */
@JsonInclude(Include.NON_NULL)
public class AgariZoneEdit {

    /**
     * Zone name.
     */
    private String name;

    /**
     * Agari Zone Status.
     */
    private Boolean enable;

    /**
     * Empty constructor.
     */
    public AgariZoneEdit() {
        super();
    }

    public AgariZoneEdit(String name, Boolean enable) {
        this.name = name;
        this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", this.getName()).add("enable", this.getEnable()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(this.getName(), this.getEnable());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof AgariZoneEdit)) {
            return false;
        }
        final AgariZoneEdit other = (AgariZoneEdit) obj;
        return Objects.equal(this.getName(), other.getName()) && Objects.equal(this.getEnable(), other.getEnable());
    }

}

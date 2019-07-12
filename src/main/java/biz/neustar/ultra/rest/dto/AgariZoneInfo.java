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
 * Agari Zone Info Dto.
 *
 * @author vpavlyuk
 */
@JsonInclude(Include.NON_NULL)
public class AgariZoneInfo {

    /**
     * Zone name.
     */
    private String name;

    /**
     * Agari Zone Status.
     */
    private AgariZoneStatus status;

    /**
     * Empty constructor.
     */
    public AgariZoneInfo() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AgariZoneStatus getStatus() {
        return status;
    }

    public void setStatus(AgariZoneStatus status) {
        this.status = status;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", this.getName()).add("status", this.getStatus()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(this.getName(), this.getStatus());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof AgariZoneInfo)) {
            return false;
        }
        final AgariZoneInfo other = (AgariZoneInfo) obj;
        return Objects.equal(this.getName(), other.getName()) && Objects.equal(this.getStatus(), other.getStatus());
    }

}

/**
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * RestZoneWrapper.
 */
@JsonInclude(Include.NON_NULL)
public class RestZoneWrapper implements Serializable {

    /**
     * Serial number.
     */
    private static final long serialVersionUID = 7438404914175367470L;

    /**
     * The domain name of the apex of the zone.
     */
    private String zoneName;

    /**
     * The list of all RRSets.
     */
    private List<RRSet> rrSets;

    /**
     * List of WebForward.
     */
    private List<WebForward> webForwards = Lists.newLinkedList();

    /**
     * Empty Constructor.
     */
    public RestZoneWrapper() {
        super();
    }

    public RestZoneWrapper(String zoneName, List<RRSet> rrSets, List<WebForward> webForwards) {
        super();
        this.zoneName = zoneName;
        this.rrSets = rrSets;
        this.webForwards = webForwards;
    }

    /**
     * Get Zone Name.
     * @return the zoneName
     */
    public String getZoneName() {
        return zoneName;
    }

    /**
     * Set Zone Name.
     * @param zoneName the zoneName to set
     */
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    /**
     * Get RRSet List.
     * @return the rrSets
     */
    public List<RRSet> getRrSets() {
        return rrSets;
    }

    /**
     * Set RRSet list.
     * @param rrSets the rrSets to set
     */
    public void setRrSets(List<RRSet> rrSets) {
        this.rrSets = rrSets;
    }

    /**
     * Get List of web forwards.
     * @return the webForwards
     */
    public List<WebForward> getWebForwards() {
        return webForwards;
    }

    /**
     * Set List of web forwards.
     * @param webForwards the webForwards to set
     */
    public void setWebForwards(List<WebForward> webForwards) {
        this.webForwards = webForwards;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getZoneName(), getRrSets(), getWebForwards());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof RestZoneWrapper)) {
            return false;
        }
        final RestZoneWrapper other = (RestZoneWrapper) obj;
        return Objects.equal(getZoneName(), other.getZoneName()) && Objects.equal(getRrSets(), other.getRrSets())
                        && Objects.equal(getWebForwards(), other.getWebForwards());
    }

}

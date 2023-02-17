/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class UsageLimits {

    /**
     * Usage limit for querying sitebacker records.
     */
    private Long sitebackerRecords;

    /**
     * Usage limit for querying zones.
     */
    private Long zones;

    /**
     * Usage limit for querying resource records.
     */
    private Long records;

    /**
     * Usage limit for any DNS query.
     */
    private Long queries;

    /**
     * Usage limit for querying web forwards.
     */
    private Long webForwards;

    /**
     * Usage limit for querying mail forwards.
     */
    private Long mailForwards;

    /**
     * Usage limit for querying traffic controller records.
     */
    private Long trafficControllerRecords;

    /**
     * Usage limit for querying directional pools.
     */
    private Long directionalPools;

    /**
     * Default constructor.
     */
    public UsageLimits() {
        super();
    }

    /**
     * Parameterised constructor.
     * @param sitebackerRecords - sitebackerRecords
     * @param zones - zones
     * @param records - records
     * @param queries - queries
     * @param webForwards - webForwards
     * @param mailForwards - mailForwards
     * @param trafficControllerRecords - trafficControllerRecords
     * @param directionalPools - directionalPools
     */
    public UsageLimits(Long sitebackerRecords, Long zones, Long records, Long queries, Long webForwards,
            Long mailForwards, Long trafficControllerRecords, Long directionalPools) {
        super();
        this.sitebackerRecords = sitebackerRecords;
        this.zones = zones;
        this.records = records;
        this.queries = queries;
        this.webForwards = webForwards;
        this.mailForwards = mailForwards;
        this.trafficControllerRecords = trafficControllerRecords;
        this.directionalPools = directionalPools;
    }

    public Long getSitebackerRecords() {
        return sitebackerRecords;
    }

    public void setSitebackerRecords(Long sitebackerRecords) {
        this.sitebackerRecords = sitebackerRecords;
    }

    public Long getZones() {
        return zones;
    }

    public void setZones(Long zones) {
        this.zones = zones;
    }

    public Long getRecords() {
        return records;
    }

    public void setRecords(Long records) {
        this.records = records;
    }

    public Long getQueries() {
        return queries;
    }

    public void setQueries(Long queries) {
        this.queries = queries;
    }

    public Long getWebForwards() {
        return webForwards;
    }

    public void setWebForwards(Long webForwards) {
        this.webForwards = webForwards;
    }

    public Long getMailForwards() {
        return mailForwards;
    }

    public void setMailForwards(Long mailForwards) {
        this.mailForwards = mailForwards;
    }

    public Long getTrafficControllerRecords() {
        return trafficControllerRecords;
    }

    public void setTrafficControllerRecords(Long trafficControllerRecords) {
        this.trafficControllerRecords = trafficControllerRecords;
    }

    public Long getDirectionalPools() {
        return directionalPools;
    }

    public void setDirectionalPools(Long directionalPools) {
        this.directionalPools = directionalPools;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("directionslPools", getDirectionalPools())
                .add("mailForwards", getMailForwards())
                .add("queries", getQueries())
                .add("records", getRecords())
                .add("sitebackerRecords", getSitebackerRecords())
                .add("trafficControllerRecords", getTrafficControllerRecords())
                .add("webForwards", getWebForwards())
                .add("zones", getZones())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getSitebackerRecords(), getZones(), getDirectionalPools(), getMailForwards(),
                getQueries(), getRecords(), getTrafficControllerRecords(), getWebForwards());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof UsageLimits)) {
            return false;
        }
        final UsageLimits other = (UsageLimits) obj;
        return Objects.equals(getSitebackerRecords(), other.getSitebackerRecords())
                && Objects.equals(getZones(), other.getZones())
                && Objects.equals(getDirectionalPools(), other.getDirectionalPools())
                && Objects.equals(getMailForwards(), other.getMailForwards())
                && Objects.equals(getQueries(), other.getQueries())
                && Objects.equals(getRecords(), other.getRecords())
                && Objects.equals(getTrafficControllerRecords(), other.getTrafficControllerRecords())
                && Objects.equals(getWebForwards(), other.getWebForwards());

    }
}

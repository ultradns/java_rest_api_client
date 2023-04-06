package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * RData info.
 */
@JsonInclude(Include.NON_NULL)
public class RDataInfo {

    /**
     * Indicates whether or not the associated rdata is used for all non-configured geographical regions and ip ranges.
     */
    private boolean allNonConfigured;
    /**
     * {@link GeoInfo}.
     */
    private GeoInfo geoInfo;
    /**
     * {@link IpInfo}.
     */
    private IpInfo ipInfo;
    /**
     * {@link Integer}.
     */
    private Integer ttl;

    /**
     * {@link String}.
     */
    private String type;

    /**
     * Empty constructor.
     */
    public RDataInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param allNonConfigured - {@link RDataInfo#allNonConfigured}
     * @param geoInfo          - - {@link RDataInfo#geoInfo}
     * @param ipInfo           - - {@link RDataInfo#ipInfo}
     * @Param ttl - {@link RDataInfo#ttl}
     */
    public RDataInfo(boolean allNonConfigured, GeoInfo geoInfo, IpInfo ipInfo, Integer ttl) {
        super();
        this.allNonConfigured = allNonConfigured;
        this.geoInfo = geoInfo;
        this.ipInfo = ipInfo;
        this.ttl = ttl;
    }

    /**
     * Get all non configured.
     *
     * @return the allNonConfigured
     */
    public final boolean isAllNonConfigured() {
        return allNonConfigured;
    }

    /**
     * Set all non configured.
     *
     * @param allNonConfigured the allNonConfigured to set
     */
    public final void setAllNonConfigured(boolean allNonConfigured) {
        this.allNonConfigured = allNonConfigured;
    }

    /**
     * Get geo info.
     *
     * @return the geoInfo
     */
    public final GeoInfo getGeoInfo() {
        return geoInfo;
    }

    /**
     * Set geo info.
     *
     * @param geoInfo the geoInfo to set
     */
    public final void setGeoInfo(GeoInfo geoInfo) {
        this.geoInfo = geoInfo;
    }

    /**
     * Get ip info.
     *
     * @return the ipInfo
     */
    public final IpInfo getIpInfo() {
        return ipInfo;
    }

    /**
     * Set ip info.
     *
     * @param ipInfo the ipInfo to set
     */
    public final void setIpInfo(IpInfo ipInfo) {
        this.ipInfo = ipInfo;
    }

    /**
     * Get record level ttl.
     *
     * @return the record level ttl
     */
    public final Integer getTtl() {
        return ttl;
    }

    /**
     * Set record level ttl.
     *
     * @param ttl the record level ttl to set
     */
    public final void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    /**
     * Get record type.
     *
     * @return the record type
     */
    public final String getType() {
        return type;
    }

    /**
     * Set record type.
     *
     * @param type the record type to set
     */
    public final void setType(String type) {
        this.type = type;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("geoInfo", getGeoInfo())
                .add("ipInfo", getIpInfo())
                .add("allNonConfigured", isAllNonConfigured())
                .add("ttl", getTtl())
                .add("type", getType())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getGeoInfo(), getIpInfo(), isAllNonConfigured(), getTtl(), getType());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof RDataInfo)) {
            return false;
        }
        final RDataInfo other = (RDataInfo) obj;
        isEqual = Objects.equal(getGeoInfo(), other.getGeoInfo()) && Objects.equal(getIpInfo(), other.getIpInfo())
                && Objects.equal(isAllNonConfigured(), other.isAllNonConfigured()) && Objects.equal(getTtl(),
                other.getTtl()) && Objects.equal(getType(), other.getType());
        return isEqual;
    }
}

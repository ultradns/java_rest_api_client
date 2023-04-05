/**
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.ZoneType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Zone Dto.
 *
 */
@JsonInclude(Include.NON_NULL)
public class Zone {

    private ZoneProperties properties;

    private PrimaryZoneInfo primaryCreateInfo;

    private SecondaryZoneInfo secondaryCreateInfo;

    private AliasZoneInfo aliasCreateInfo;

    private ZoneProperties zoneProperties;

    private PrimaryZoneInfo primaryZoneInfo;

    private SecondaryZoneInfo secondaryZoneInfo;

    private AliasZoneInfo aliasZoneInfo;

    private ZoneType targetZoneType;

    /**
     * Empty constructor.
     */
    public Zone() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param properties          - ZoneProperties
     * @param primaryCreateInfo   - Primary zone info
     * @param secondaryCreateInfo - Secondary zone info
     * @param aliasCreateInfo     - Alias zone info
     */
    public Zone(ZoneProperties properties, PrimaryZoneInfo primaryCreateInfo, SecondaryZoneInfo secondaryCreateInfo,
            AliasZoneInfo aliasCreateInfo) {
        super();
        this.properties = properties;
        this.primaryCreateInfo = primaryCreateInfo;
        this.secondaryCreateInfo = secondaryCreateInfo;
        this.aliasCreateInfo = aliasCreateInfo;
        this.zoneProperties = properties;
        this.primaryZoneInfo = primaryCreateInfo;
        this.secondaryZoneInfo = secondaryCreateInfo;
        this.aliasZoneInfo = aliasCreateInfo;
    }

    /**
     * To instantiate zone object.
     *
     * @return - {@link Zone}
     */
    public static Zone getZoneInstance() {
        Zone zone = new Zone();
        zone.setProperties(new ZoneProperties());
        PrimaryZoneInfo primaryZoneInfo = new PrimaryZoneInfo();
        primaryZoneInfo.setNameServer(new NameServer());
        zone.setPrimaryCreateInfo(primaryZoneInfo);
        zone.setPrimaryZoneInfo(primaryZoneInfo);
        zone.setAliasCreateInfo(new AliasZoneInfo());
        zone.setAliasZoneInfo(new AliasZoneInfo());
        return zone;
    }

    public final ZoneProperties getProperties() {
        return properties;
    }

    public final void setProperties(ZoneProperties properties) {
        this.properties = properties;
    }

    public final PrimaryZoneInfo getPrimaryCreateInfo() {
        return primaryCreateInfo;
    }

    public final void setPrimaryCreateInfo(PrimaryZoneInfo primaryCreateInfo) {
        this.primaryCreateInfo = primaryCreateInfo;
    }

    /**
     * Get secondary zone info.
     *
     * @return the secondaryZoneInfo
     */
    public final SecondaryZoneInfo getSecondaryCreateInfo() {
        return secondaryCreateInfo;
    }

    /**
     * Set secondary zone.
     *
     * @param secondaryCreateInfo the secondaryZoneInfo to set
     */
    public final void setSecondaryCreateInfo(SecondaryZoneInfo secondaryCreateInfo) {
        this.secondaryCreateInfo = secondaryCreateInfo;
    }

    /**
     * Get alias zone info.
     *
     * @return the aliasZoneInfo
     */
    public final AliasZoneInfo getAliasCreateInfo() {
        return aliasCreateInfo;
    }

    /**
     * Set alias zone info.
     *
     * @param aliasCreateInfo the aliasZoneInfo to set
     */
    public final void setAliasCreateInfo(AliasZoneInfo aliasCreateInfo) {
        this.aliasCreateInfo = aliasCreateInfo;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("properties", getProperties())
                .add("primaryCreateInfo", getPrimaryCreateInfo())
                .add("secondaryCreateInfo", getSecondaryCreateInfo())
                .add("aliasCreateInfo", getAliasCreateInfo())
                .add("targetZoneType", getTargetZoneType())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getProperties());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof Zone)) {
            return false;
        }
        final Zone other = (Zone) obj;
        return Objects.equal(getProperties(), other.getProperties());
    }

    public final ZoneProperties getZoneProperties() {
        return zoneProperties;
    }

    public final void setZoneProperties(ZoneProperties zoneProperties) {
        this.zoneProperties = zoneProperties;
    }

    public final PrimaryZoneInfo getPrimaryZoneInfo() {
        return primaryZoneInfo;
    }

    public final void setPrimaryZoneInfo(PrimaryZoneInfo primaryZoneInfo) {
        this.primaryZoneInfo = primaryZoneInfo;
    }

    public final SecondaryZoneInfo getSecondaryZoneInfo() {
        return secondaryZoneInfo;
    }

    public final void setSecondaryZoneInfo(SecondaryZoneInfo secondaryZoneInfo) {
        this.secondaryZoneInfo = secondaryZoneInfo;
    }

    public final AliasZoneInfo getAliasZoneInfo() {
        return aliasZoneInfo;
    }

    public final void setAliasZoneInfo(AliasZoneInfo aliasZoneInfo) {
        this.aliasZoneInfo = aliasZoneInfo;
    }

    public ZoneType getTargetZoneType() {
        return targetZoneType;
    }

    public void setTargetZoneType(ZoneType targetZoneType) {
        this.targetZoneType = targetZoneType;
    }
}

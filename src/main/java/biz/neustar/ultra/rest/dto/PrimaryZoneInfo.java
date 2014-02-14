/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import biz.neustar.ultra.rest.constants.CreateType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

import java.util.List;

/**
 * Primary Zone Info.
 * @author nupadhyay
 *
 */
@JsonInclude(Include.NON_NULL)
public class PrimaryZoneInfo {

    /**
     *  Empty constructor.
     */
    public PrimaryZoneInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     * @param forceImport - Force import.
     * @param createType - {@link biz.neustar.ultra.rest.constants.CreateType}.
     * @param nameServer - Name server.
     * @param restrictIPList -  list of {@link biz.neustar.ultra.rest.dto.RestrictIP}.
     */
    public PrimaryZoneInfo(Boolean forceImport, CreateType createType,
                           NameServer nameServer,
                           List<RestrictIP> restrictIPList, String originalZoneName) {
        super();
        this.forceImport = forceImport;
        this.createType = createType;
        this.nameServer = nameServer;
        this.restrictIPList = restrictIPList;
        this.originalZoneName = originalZoneName;
    }

    /**
     * Whether or not to move existing rows from existing zones that should be placed into this new zone. 
     * true == move, false == leave in existing zone
     */
    private Boolean forceImport;
    /**
     * Indicates how we are creating a primary zone.
     */
    private CreateType createType;

    /**
     * Name server.
     */
    private NameServer nameServer;

    /**
     * The name of the zone being copied or aliased.
     */
    private String originalZoneName;

    /**
     * Restrict IP List.
     */
    private List<RestrictIP> restrictIPList;

    /**
     * Get the restrictIPList.
     * @return the restrictIPList
     */
    public final List<RestrictIP> getRestrictIPList() {
        return restrictIPList;
    }

    /**
     * Set the restrictIPList.
     * @param restrictIPList the restrictIPList to set
     */
    public final void setRestrictIPList(List<RestrictIP> restrictIPList) {
        this.restrictIPList = restrictIPList;
    }

    /**
     * Is force import.
     * @return the forceImport
     */
    public final Boolean isForceImport() {
        return forceImport;
    }

    /**
     * Set Force import.
     * @param forceImport the forceImport to set
     */
    public final void setForceImport(Boolean forceImport) {
        this.forceImport = forceImport;
    }

    /**
     * Get create type.
     * @return the createType
     */
    public final CreateType getCreateType() {
        return createType;
    }

    /**
     * Set create type.
     * @param createType the createType to set
     */
    public final void setCreateType(CreateType createType) {
        this.createType = createType;
    }

    /**
     * Get name server.
     * @return the nameServer
     */
    public final NameServer getNameServer() {
        return nameServer;
    }

    /**
     * Set name server.
     * @param nameServer the nameServer to set
     */
    public final void setNameServer(NameServer nameServer) {
        this.nameServer = nameServer;
    }

    /**
     * Get original zone name.
     * @return the originalZoneName
     */
    public final String getOriginalZoneName() {
        return originalZoneName;
    }
    

    /**
     * Set original zone name.
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
        return Objects.toStringHelper(this).add("forceImport", isForceImport())
                .add("createType", getCreateType())
                .add("nameServer", getNameServer())
                .add("restrictIPList", getRestrictIPList())
                .add("originalZoneName", getOriginalZoneName()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(isForceImport(), getCreateType(),
                getNameServer(), getRestrictIPList(), getOriginalZoneName());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof PrimaryZoneInfo)) {
            return false;
        }
        final PrimaryZoneInfo other = (PrimaryZoneInfo) obj;
        isEqual = Objects.equal(isForceImport(), other.isForceImport())
                && Objects.equal(getCreateType(), other.getCreateType())
                && Objects.equal(getNameServer(), other.getNameServer())
                && Objects.equal(getRestrictIPList(), other.getRestrictIPList())
                && Objects.equal(getOriginalZoneName(), other.getOriginalZoneName());
        return isEqual;
    }
}

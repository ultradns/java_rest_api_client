/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

/**
 * Primary Zone Info.
 *
 * @author nupadhyay
 */
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("PMD.CyclomaticComplexity") //complaining about equals and hashCode
public class PrimaryZoneInfo {

    /**
     * To generate hash code.
     */
    private static final int PRIME_NUMBER = 31;

    /**
     * Whether or not to move existing rows from existing zones that should be placed into this new zone. true == move,
     * false == leave in existing zone
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
     * The TSIG associated with transfer.
     */
    private Tsig tsig;

    /**
     * The notify addresses for zone change notification.
     */
    private List<NotifyAddressDetail> notifyAddresses;

    /**
     * The inherit field decides the account level transfer acl attributes to be inherited.
     */
    private String inherit;

    /**
     * Empty constructor.
     */
    public PrimaryZoneInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param forceImport      - Force import.
     * @param createType       - {@link biz.neustar.ultra.rest.dto.CreateType}.
     * @param nameServer       - Name server.
     * @param restrictIPList   -  list of {@link biz.neustar.ultra.rest.dto.RestrictIP}.
     * @param tsig             the tsig
     * @param notifyAddresses  the notify addresses
     * @param originalZoneName the original zone name
     * @param inherit          - inherit The account level Transfer ACL attributes to be inherited.
     */
    public PrimaryZoneInfo(Boolean forceImport, CreateType createType, NameServer nameServer,
            List<RestrictIP> restrictIPList, Tsig tsig, List<NotifyAddressDetail> notifyAddresses,
            String originalZoneName, String inherit) {
        super();
        this.forceImport = forceImport;
        this.createType = createType;
        this.nameServer = nameServer;
        this.restrictIPList = restrictIPList;
        this.tsig = tsig;
        this.notifyAddresses = notifyAddresses;
        this.originalZoneName = originalZoneName;
        this.inherit = inherit;
    }

    /**
     * Get the inherit to set the account level transfer acl attributes.
     *
     * @return the inherit containing account level transfer acl attributes.
     */
    public String getInherit() {
        return inherit;
    }

    /**
     * Sets the inherit to set the account level transfer acl attributes.
     *
     * @param inherit ,the account level transfer acl attributes to be inherited
     */
    public void setInherit(String inherit) {
        this.inherit = inherit;
    }

    /**
     * Get the restrictIPList.
     *
     * @return the restrictIPList
     */
    public final List<RestrictIP> getRestrictIPList() {
        return restrictIPList;
    }

    /**
     * Set the restrictIPList.
     *
     * @param restrictIPList the restrictIPList to set
     */
    public final void setRestrictIPList(List<RestrictIP> restrictIPList) {
        this.restrictIPList = restrictIPList;
    }

    /**
     * Is force import.
     *
     * @return the forceImport
     */
    public final Boolean isForceImport() {
        return forceImport;
    }

    /**
     * Set Force import.
     *
     * @param forceImport the forceImport to set
     */
    public final void setForceImport(Boolean forceImport) {
        this.forceImport = forceImport;
    }

    /**
     * Get create type.
     *
     * @return the createType
     */
    public final CreateType getCreateType() {
        return createType;
    }

    /**
     * Set create type.
     *
     * @param createType the createType to set
     */
    public final void setCreateType(CreateType createType) {
        this.createType = createType;
    }

    /**
     * Get name server.
     *
     * @return the nameServer
     */
    public final NameServer getNameServer() {
        return nameServer;
    }

    /**
     * Set name server.
     *
     * @param nameServer the nameServer to set
     */
    public final void setNameServer(NameServer nameServer) {
        this.nameServer = nameServer;
    }

    /**
     * Get original zone name.
     *
     * @return the originalZoneName
     */
    public final String getOriginalZoneName() {
        return originalZoneName;
    }

    /**
     * Set original zone name.
     *
     * @param originalZoneName the originalZoneName to set
     */
    public final void setOriginalZoneName(String originalZoneName) {
        this.originalZoneName = originalZoneName;
    }

    public Tsig getTsig() {
        return tsig;
    }

    public void setTsig(Tsig tsig) {
        this.tsig = tsig;
    }

    public List<NotifyAddressDetail> getNotifyAddresses() {
        return notifyAddresses;
    }

    public void setNotifyAddresses(List<NotifyAddressDetail> notifyAddresses) {
        this.notifyAddresses = notifyAddresses;
    }

    @Override
    @SuppressWarnings("PMD") // this is auto-generated code -- don't warn on how complicated it is
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PrimaryZoneInfo that = (PrimaryZoneInfo) o;

        if (createType != that.createType) {
            return false;
        }
        if (forceImport != null ? !forceImport.equals(that.forceImport) : that.forceImport != null) {
            return false;
        }
        if (nameServer != null ? !nameServer.equals(that.nameServer) : that.nameServer != null) {
            return false;
        }
        if (notifyAddresses != null ? !notifyAddresses.equals(that.notifyAddresses) : that.notifyAddresses != null) {
            return false;
        }
        if (originalZoneName != null
                ? !originalZoneName.equals(that.originalZoneName)
                : that.originalZoneName != null) {
            return false;
        }
        if (restrictIPList != null ? !restrictIPList.equals(that.restrictIPList) : that.restrictIPList != null) {
            return false;
        }
        if (tsig != null ? !tsig.equals(that.tsig) : that.tsig != null) {
            return false;
        }

        if (inherit != null ? !inherit.equals(that.inherit) : that.inherit != null) {
            return false;
        }

        return true;
    }

    @Override
    @SuppressWarnings("PMD") // this is auto-generated code -- don't warn on how complicated it is
    public int hashCode() {
        int result = forceImport != null ? forceImport.hashCode() : 0;
        result = PRIME_NUMBER * result + (createType != null ? createType.hashCode() : 0);
        result = PRIME_NUMBER * result + (nameServer != null ? nameServer.hashCode() : 0);
        result = PRIME_NUMBER * result + (originalZoneName != null ? originalZoneName.hashCode() : 0);
        result = PRIME_NUMBER * result + (restrictIPList != null ? restrictIPList.hashCode() : 0);
        result = PRIME_NUMBER * result + (tsig != null ? tsig.hashCode() : 0);
        result = PRIME_NUMBER * result + (notifyAddresses != null ? notifyAddresses.hashCode() : 0);
        result = PRIME_NUMBER * result + (inherit != null ? inherit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PrimaryZoneInfo{" + "forceImport=" + forceImport + ", createType=" + createType + ", nameServer="
                + nameServer + ", originalZoneName='" + originalZoneName + '\'' + ", restrictIPList=" + restrictIPList
                + ", tsig=" + tsig + ", notifyAddresses=" + notifyAddresses + ", inherit=" + inherit + '}';
    }
}

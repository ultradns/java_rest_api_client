package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

@JsonInclude(Include.NON_DEFAULT)
public class ZoneOutInfo {

    /**
     * ZoneProperties.
     */
    private ZoneProperties properties;
    /**
     * RegistrarInfo.
     */
    private RegistrarInfo registrarInfo;
    /**
     * restrictIpList.
     */

    private List<RestrictIP> restrictIpList = Lists.newLinkedList();

    /**
     * The TSIG associated with transfer.
     */
    private Tsig tsig;

    /**
     * The notify addresses for zone change notification.
     */
    private List<NotifyAddressDetail> notifyAddresses = Lists.newLinkedList();

    /**
     * PrimaryNameServers.
     */
    private PrimaryNameServers primaryNameServers;
    /**
     * Original Zone Name.
     */
    private String originalZoneName;

    /**
     * Zone's account inheritance information.
     */
    private String inherit;

    /**
     * Zone's Notification Email Address.
     */
    private String notificationEmailAddress;

    /**
     * Zone's transfer status details.
     */
    private TransferStatusDetails transferStatusDetails;

    /**
     * Empty constructor.
     */
    public ZoneOutInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param properties               - {@link ZoneProperties}
     * @param restrictIpList           - {@link List< RestrictIP >}
     * @param tsig                     - {@link Tsig}
     * @param notifyAddresses          - {@link List< NotifyAddressDetail >}
     * @param primaryNameServers       - {@link PrimaryNameServers}
     * @param originalZoneName         - Original zone name
     * @param registrarInfo            - {@link RegistrarInfo}
     * @param inherit                  - Inherit
     * @param notificationEmailAddress - Noification email address
     * @param transferStatusDetails    - Zone's transfer status details
     */
    @SuppressWarnings("PMD.ExcessiveParameterList")
    public ZoneOutInfo(ZoneProperties properties, List<RestrictIP> restrictIpList, Tsig tsig,
            List<NotifyAddressDetail> notifyAddresses, PrimaryNameServers primaryNameServers, String originalZoneName,
            RegistrarInfo registrarInfo, String inherit, String notificationEmailAddress,
            TransferStatusDetails transferStatusDetails) {
        this.properties = properties;
        this.restrictIpList = restrictIpList;
        this.tsig = tsig;
        this.notifyAddresses = notifyAddresses;
        this.primaryNameServers = primaryNameServers;
        this.originalZoneName = originalZoneName;
        this.registrarInfo = registrarInfo;
        this.inherit = inherit;
        this.notificationEmailAddress = notificationEmailAddress;
        this.transferStatusDetails = transferStatusDetails;
    }

    /**
     * To instantiate zone object.
     *
     * @return - {@link Zone}
     */
    public static ZoneOutInfo getZoneInstance() {
        ZoneOutInfo zone = new ZoneOutInfo();
        zone.setProperties(new ZoneProperties());
        return zone;
    }

    /**
     * Get inherit attribute.
     *
     * @return Attribute value.
     */
    public String getInherit() {
        return inherit;
    }

    /**
     * Set inherit attribute.
     *
     * @param inherit Attribute value to set.
     */
    public void setInherit(String inherit) {
        this.inherit = inherit;
    }

    /**
     * Get Restrict Ip List.
     *
     * @return restrictIpList
     */
    public final List<RestrictIP> getRestrictIpList() {
        return restrictIpList;
    }

    /**
     * Set Restrict Ip List.
     *
     * @param restrictIpList the restrictIpList to set
     */
    public final void setRestrictIpList(List<RestrictIP> restrictIpList) {
        this.restrictIpList = restrictIpList;
    }

    /**
     * Get properties.
     *
     * @return the properties
     */
    public final ZoneProperties getProperties() {
        return properties;
    }

    /**
     * Set properties.
     *
     * @param properties the properties to set
     */
    public final void setProperties(ZoneProperties properties) {
        this.properties = properties;
    }

    /**
     * Get primaryNameServers.
     *
     * @return the primaryNameServers
     */
    public final PrimaryNameServers getPrimaryNameServers() {
        return primaryNameServers;
    }

    /**
     * Set primaryNameServers.
     *
     * @param primaryNameServers the primaryNameServers to set
     */
    public final void setPrimaryNameServers(PrimaryNameServers primaryNameServers) {
        this.primaryNameServers = primaryNameServers;
    }

    /**
     * Get originalZoneName.
     *
     * @return the originalZoneName
     */
    public final String getOriginalZoneName() {
        return originalZoneName;
    }

    /**
     * Set originalZoneName.
     *
     * @param originalZoneName the originalZoneName to set
     */
    public final void setOriginalZoneName(String originalZoneName) {
        this.originalZoneName = originalZoneName;
    }

    /**
     * Get registrarInfo.
     *
     * @return the registrarInfo
     */
    public final RegistrarInfo getRegistrarInfo() {
        return registrarInfo;
    }

    /**
     * Set registrarInfo.
     *
     * @param registrarInfo the registrarInfo to set
     */
    public final void setRegistrarInfo(RegistrarInfo registrarInfo) {
        this.registrarInfo = registrarInfo;
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

    public String getNotificationEmailAddress() {
        return notificationEmailAddress;
    }

    public void setNotificationEmailAddress(String notificationEmailAddress) {
        this.notificationEmailAddress = notificationEmailAddress;
    }

    public TransferStatusDetails getTransferStatusDetails() {
        return transferStatusDetails;
    }

    public void setTransferStatusDetails(TransferStatusDetails transferStatusDetails) {
        this.transferStatusDetails = transferStatusDetails;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getProperties(), getRegistrarInfo(), getRestrictIpList(), getTsig(),
                getNotifyAddresses(), getPrimaryNameServers(), getOriginalZoneName(), getInherit(),
                getNotificationEmailAddress());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final ZoneOutInfo other = (ZoneOutInfo) obj;
        isEqual = Objects.equal(getProperties(), other.getProperties()) && Objects.equal(getRegistrarInfo(),
                other.getRegistrarInfo()) && Objects.equal(getRestrictIpList(), other.getRestrictIpList())
                && Objects.equal(getTsig(), other.getTsig()) && Objects.equal(getNotifyAddresses(),
                other.getNotifyAddresses()) && Objects.equal(getPrimaryNameServers(), other.getPrimaryNameServers())
                && Objects.equal(getOriginalZoneName(), other.getOriginalZoneName()) && Objects.equal(getInherit(),
                other.getInherit()) && Objects.equal(getNotificationEmailAddress(),
                other.getNotificationEmailAddress());
        return isEqual;
    }

    @Override
    public String toString() {
        return "ZoneOutInfo{" + "properties=" + properties + ", registrarInfo=" + registrarInfo + ", restrictIpList="
                + restrictIpList + ", tsig=" + tsig + ", notifyAddresses=" + notifyAddresses + ", primaryNameServers="
                + primaryNameServers + ", originalZoneName='" + originalZoneName + '\'' + ", inherit=" + inherit
                + ", notificationEmailAddress=" + notificationEmailAddress + ", transferStatusDetails="
                + transferStatusDetails + '}';
    }
}

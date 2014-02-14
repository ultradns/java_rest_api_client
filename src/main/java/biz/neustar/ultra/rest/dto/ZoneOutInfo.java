package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

import java.util.List;

@JsonInclude(Include.NON_DEFAULT)
public class ZoneOutInfo {

    /**
     * Empty constructor.
     */
    public ZoneOutInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     * @param properties
     * @param restrictIpList
     * @param primaryNameServers
     * @param originalZoneName
     * @param registrarInfo
     */
    public ZoneOutInfo(ZoneProperties properties, List<RestrictIP> restrictIpList,
                       PrimaryNameServers primaryNameServers, String originalZoneName, RegistrarInfo registrarInfo) {
        super();
        this.properties = properties;
        this.restrictIpList = restrictIpList;
        this.primaryNameServers = primaryNameServers;
        this.originalZoneName = originalZoneName;
        this.registrarInfo = registrarInfo;
    }

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
    private List<RestrictIP> restrictIpList;
    /**
     * PrimaryNameServers.
     */
    private PrimaryNameServers primaryNameServers;
    /**
     * Original Zone Name.
     */
    private String originalZoneName;
    /**
     * Get Restrict Ip List.
     * @return restrictIpList
     */
    public final List<RestrictIP> getRestrictIpList() {
        return restrictIpList;
    }

    /**
     * Set Restrict Ip List.
     * @param restrictIpList the restrictIpList to set
     */
    public final void setRestrictIpList(List<RestrictIP> restrictIpList) {
        this.restrictIpList = restrictIpList;
    }

    /**
     * Get properties.
     * @return the properties
     */
    public final ZoneProperties getProperties() {
        return properties;
    }

    /**
     * Set properties.
     * @param properties the properties to set
     */
    public final void setProperties(ZoneProperties properties) {
        this.properties = properties;
    }

    /**
     * Get primaryNameServers.
     * @return the primaryNameServers
     */
    public final PrimaryNameServers getPrimaryNameServers() {
        return primaryNameServers;
    }

    /**
     * Set primaryNameServers.
     * @param primaryNameServers the primaryNameServers to set
     */
    public final void setPrimaryNameServers(PrimaryNameServers primaryNameServers) {
        this.primaryNameServers = primaryNameServers;
    }

    /**
     * Get originalZoneName.
     * @return the originalZoneName
     */
    public final String getOriginalZoneName() {
        return originalZoneName;
    }

    /**
     * Set originalZoneName.
     * @param originalZoneName the originalZoneName to set
     */
    public final void setOriginalZoneName(String originalZoneName) {
        this.originalZoneName = originalZoneName;
    }

    /**
     * Get registrarInfo.
     * @return the registrarInfo
     */
    public final RegistrarInfo getRegistrarInfo() {
        return registrarInfo;
    }

    /**
     * Set registrarInfo.
     * @param registrarInfo the registrarInfo to set
     */
    public final void setRegistrarInfo(RegistrarInfo registrarInfo) {
        this.registrarInfo = registrarInfo;
    }
    /**
     * To instantiate zone object.
     * @return - {@link Zone}
     */
    public static final ZoneOutInfo getZoneInstance() {
        ZoneOutInfo zone = new ZoneOutInfo();
        zone.setProperties(new ZoneProperties());
        PrimaryZoneInfo primaryZoneInfo = new PrimaryZoneInfo();
        primaryZoneInfo.setNameServer(new NameServer());
        return zone;
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
        boolean isEqual = true;
        if (!(obj instanceof ZoneOutInfo)) {
            return false;
        }
        final ZoneOutInfo other = (ZoneOutInfo) obj;
        isEqual =  Objects.equal(getProperties(), other.getProperties());
        return isEqual;
    }

    @Override
    public String toString() {
        return "ZoneOutInfo{" +
                "properties=" + properties +
                ", registrarInfo=" + registrarInfo +
                ", restrictIpList=" + restrictIpList +
                ", primaryNameServers=" + primaryNameServers +
                ", originalZoneName='" + originalZoneName + '\'' +
                "} " + super.toString();
    }
}

package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

/**
 * Registrar info.
 */
@JsonInclude(Include.NON_DEFAULT)
public class RegistrarInfo {

    /**
     * Registrar.
     */
    private String registrar;

    /**
     * Whois Expiration.
     */
    private String whoisExpiration;
    /**
     * NameServers.
     */
    private NameServers nameServers;

    /**
     * Empty constructor.
     */
    public RegistrarInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param registrar
     * @param whoisExpiration
     * @param nameServers
     */
    public RegistrarInfo(String registrar, String whoisExpiration, NameServers nameServers) {
        this.registrar = registrar;
        this.whoisExpiration = whoisExpiration;
        this.nameServers = nameServers;
    }

    /**
     * Get registrar.
     *
     * @return the registrar
     */
    public final String getRegistrar() {
        return registrar;
    }

    /**
     * Set registrar.
     *
     * @param registrar the registrar to set
     */
    public final void setRegistrar(String registrar) {
        this.registrar = registrar;
    }

    /**
     * Get Whois Expiration.
     *
     * @return the whoisExpiration
     */
    public final String getWhoisExpiration() {
        return whoisExpiration;
    }

    /**
     * Set Whois Expiration.
     *
     * @param whoisExpiration the whoisExpiration to set
     */
    public final void setWhoisExpiration(String whoisExpiration) {
        this.whoisExpiration = whoisExpiration;
    }

    /**
     * Get NameServers.
     *
     * @return the nameServers
     */
    public final NameServers getNameServers() {
        return nameServers;
    }

    /**
     * Set NameServers.
     *
     * @param nameServers the nameServers to set
     */
    public final void setNameServers(NameServers nameServers) {
        this.nameServers = nameServers;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getRegistrar(), getWhoisExpiration(), getNameServers());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual;
        if (!(obj instanceof RegistrarInfo)) {
            return false;
        }
        final RegistrarInfo other = (RegistrarInfo) obj;
        isEqual = Objects.equal(getRegistrar(), other.getRegistrar()) && Objects.equal(getWhoisExpiration(),
                other.getWhoisExpiration()) && Objects.equal(getNameServers(), other.getNameServers());
        return isEqual;
    }

    @Override
    public String toString() {
        return "RegistrarInfo{" + "registrar='" + registrar + '\'' + ", whoisExpiration='" + whoisExpiration + '\''
                + ", nameServers=" + nameServers + "} " + super.toString();
    }
}

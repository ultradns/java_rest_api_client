package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

/**
 *
 * Registrar info.
 *
 */
@JsonInclude(Include.NON_NULL)
public class RegistrarInfo {

    /**
     * Empty constructor.
     */
    public RegistrarInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     * @param registrar
     * @param whoisNameServer
     * @param whoisExpiration
     * @param nameServers
     */
    public RegistrarInfo(String registrar, String whoisNameServer, String whoisExpiration, NameServers nameServers) {
        this.registrar = registrar;
        this.whoisNameServer = whoisNameServer;
        this.whoisExpiration = whoisExpiration;
        this.nameServers = nameServers;
    }

    /**
     * Registrar.
     */
    private String registrar;

    /**
     * Whois Nameserver.
     */
    private String whoisNameServer;

    /**
     * Whois Expiration.
     */
    private String whoisExpiration;
    /**
     * NameServers.
     */
    private NameServers nameServers;
    /**
     * Get registrar.
     * @return the registrar
     */
    public final String getRegistrar() {
        return registrar;
    }

    /**
     * Set registrar.
     * @param registrar the registrar to set
     */
    public final void setRegistrar(String registrar) {
        this.registrar = registrar;
    }

    /**
     * Get Whois NameServer.
     * @return the whoisNameServer
     */
    public final String getWhoisNameServer() {
        return whoisNameServer;
    }

    /**
     * Set Whois NameServer.
     * @param whoisNameServer the whoisNameServer to set
     */
    public final void setWhoisNameServer(String whoisNameServer) {
        this.whoisNameServer = whoisNameServer;
    }

    /**
     * Get Whois Expiration.
     * @return the whoisExpiration
     */
    public final String getWhoisExpiration() {
        return whoisExpiration;
    }

    /**
     * Set Whois Expiration.
     * @param whoisExpiration the whoisExpiration to set
     */
    public final void setWhoisExpiration(String whoisExpiration) {
        this.whoisExpiration = whoisExpiration;
    }

    /**
     * Get NameServers.
     * @return the nameServers
     */
    public final NameServers getNameServers() {
        return nameServers;
    }

    /**
     * Set NameServers.
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
        return Objects.hashCode(getRegistrar(), getWhoisExpiration(), getWhoisNameServer(), getNameServers());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof RegistrarInfo)) {
            return false;
        }
        final RegistrarInfo other = (RegistrarInfo) obj;
        isEqual =  Objects.equal(getRegistrar(), other.getRegistrar())
                && Objects.equal(getWhoisExpiration(), other.getWhoisExpiration())
                && Objects.equal(getWhoisNameServer(), other.getWhoisNameServer())
                && Objects.equal(getNameServers(), other.getNameServers());
        return isEqual;
    }

    @Override
    public String toString() {
        return "RegistrarInfo{" +
                "registrar='" + registrar + '\'' +
                ", whoisNameServer='" + whoisNameServer + '\'' +
                ", whoisExpiration='" + whoisExpiration + '\'' +
                ", nameServers=" + nameServers +
                "} " + super.toString();
    }
}

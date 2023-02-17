package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;

import java.util.Objects;

/**
 * The AccountNameServer.
 */
@JsonInclude(Include.NON_NULL)
public class AccountNameServer {

    /** Server Name. */
    private String nameServer;

    /** IPV4 address. */
    private String ipv4Address;

    /** IPV6 address. */
    private String ipv6Address;

    /**
     * Record state i.e. Active or Pending
     */
    private String state;

    /**
     * Gets the account name server.
     *
     * @return the account name server
     */
    public String getNameServer() {
        return nameServer;
    }

    /**
     * Sets the account name server.
     *
     * @param accountNameServer
     *            the new account name server
     */
    public void setNameServer(String nameServer) {
        this.nameServer = nameServer;
    }

    /**
     * Gets the ipv 4 address.
     *
     * @return the ipv 4 address
     */
    public String getIpv4Address() {
        return ipv4Address;
    }

    /**
     * Sets the ipv 4 address.
     *
     * @param ipv4Address
     *            the new ipv 4 address
     */
    public void setIpv4Address(String ipv4Address) {
        this.ipv4Address = ipv4Address;
    }

    /**
     * Gets the ipv 6 address.
     *
     * @return the ipv 6 address
     */
    public String getIpv6Address() {
        return ipv6Address;
    }

    /**
     * Sets the ipv 6 address.
     *
     * @param ipv6Address
     *            the new ipv 6 address
     */
    public void setIpv6Address(String ipv6Address) {
        this.ipv6Address = ipv6Address;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state
     *            the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("nameServer", getNameServer()).add("ipv4Address", getIpv4Address())
                .add("ipv6Address", getIpv6Address()).add("state", getState()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(getNameServer(), getIpv4Address(), getIpv6Address(), getState());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof AccountNameServer)) {
            return false;
        }
        final AccountNameServer other = (AccountNameServer) obj;
        isEqual = Objects.equals(getNameServer(), other.getNameServer())
                && Objects.equals(getIpv4Address(), other.getIpv4Address())
                && Objects.equals(getIpv6Address(), other.getIpv6Address())
                && Objects.equals(getState(), other.getState());
        return isEqual;
    }

}

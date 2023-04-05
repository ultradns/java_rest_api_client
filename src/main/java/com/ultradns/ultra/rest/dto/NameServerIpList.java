/**
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Namer Server IP list.
 *
 */
@JsonInclude(Include.NON_NULL)
public class NameServerIpList {

    /**
     * Name server IP1.
     */
    private NameServer nameServerIp1;
    /**
     * Name Servier IP2.
     */
    private NameServer nameServerIp2;
    /**
     * Name Server IP3.
     */
    private NameServer nameServerIp3;

    /**
     * Empty constructor.
     */
    public NameServerIpList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param nameServerIp1 - Name Server IP 1
     * @param nameServerIp2 - Name Server IP 2
     * @param nameServerIp3 - Name Server IP 3
     */
    public NameServerIpList(NameServer nameServerIp1, NameServer nameServerIp2, NameServer nameServerIp3) {
        super();
        this.nameServerIp1 = nameServerIp1;
        this.nameServerIp2 = nameServerIp2;
        this.nameServerIp3 = nameServerIp3;
    }

    /**
     * Get name server IP One.
     *
     * @return the nameServerIp1
     */
    public final NameServer getNameServerIp1() {
        return nameServerIp1;
    }

    /**
     * Set name server IP one.
     *
     * @param nameServerIp1 the nameServerIp1 to set
     */
    public final void setNameServerIp1(NameServer nameServerIp1) {
        this.nameServerIp1 = nameServerIp1;
    }

    /**
     * Get name server IP two.
     *
     * @return the nameServerIp2
     */
    public final NameServer getNameServerIp2() {
        return nameServerIp2;
    }

    /**
     * Set name server IP two.
     *
     * @param nameServerIp2 the nameServerIp2 to set
     */
    public final void setNameServerIp2(NameServer nameServerIp2) {
        this.nameServerIp2 = nameServerIp2;
    }

    /**
     * Get name server IP three.
     *
     * @return the nameServerIp3
     */
    public final NameServer getNameServerIp3() {
        return nameServerIp3;
    }

    /**
     * Set name server IP three.
     *
     * @param nameServerIp3 the nameServerIp3 to set
     */
    public final void setNameServerIp3(NameServer nameServerIp3) {
        this.nameServerIp3 = nameServerIp3;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("nameServerIp1", getNameServerIp1())
                .add("nameServerIp2", getNameServerIp2())
                .add("nameServerIp3", getNameServerIp3())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getNameServerIp1());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof NameServerIpList)) {
            return false;
        }
        final NameServerIpList other = (NameServerIpList) obj;
        isEqual = Objects.equal(getNameServerIp1(), other.getNameServerIp1());
        return isEqual;
    }
}

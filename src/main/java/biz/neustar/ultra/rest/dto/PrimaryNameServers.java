/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Primary name servers.
 *
 * @author nupadhyay
 */
@JsonInclude(Include.NON_NULL)
public class PrimaryNameServers {

    /**
     * Name server ip list.
     */
    private NameServerIpList nameServerIpList;

    /**
     * Empty constructor.
     */
    public PrimaryNameServers() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param nameServerIpList - Name Server IP List.
     */
    public PrimaryNameServers(NameServerIpList nameServerIpList) {
        super();
        this.nameServerIpList = nameServerIpList;
    }

    /**
     * Get name server IP list.
     *
     * @return the nameServerIpList
     */
    public final NameServerIpList getNameServerIpList() {
        return nameServerIpList;
    }

    /**
     * Set Name Server IP list.
     *
     * @param nameServerIpList the nameServerIpList to set
     */
    public final void setNameServerIpList(NameServerIpList nameServerIpList) {
        this.nameServerIpList = nameServerIpList;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("nameServerIpList", getNameServerIpList()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getNameServerIpList());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof PrimaryNameServers)) {
            return false;
        }
        final PrimaryNameServers other = (PrimaryNameServers) obj;
        isEqual = Objects.equal(getNameServerIpList(), other.getNameServerIpList());
        return isEqual;
    }
}

/**
 * Copyright 2000-2014 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class represents DTO to hold IP restrictions for transfer of a primary zone. The IP restrictions can be
 * specified as CIDR, single IP or IP ranges. At a time, one of these attribute should be set.
 */
@JsonInclude(Include.NON_NULL)
public class IpRestriction {
    /**
     * The IP range.
     */
    private IpRange ipRange;

    /**
     * The CIDR.
     */
    private String cidr;

    /**
     * The single IP for restriction.
     */
    private String singleIp;

    /**
     * The description.
     */
    private String description;

    /**
     * Default constructor.
     */
    public IpRestriction() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param ipRange     The IP range.
     * @param cidr        The CIDR.
     * @param singleIp    The single IP.
     * @param description The description.
     */
    public IpRestriction(final IpRange ipRange, final String cidr, final String singleIp, final String description) {
        this.ipRange = ipRange;
        this.cidr = cidr;
        this.singleIp = singleIp;
        this.description = description;
    }

    /**
     * This method returns the IP range for restriction.
     *
     * @return the ipRange
     */
    public IpRange getIpRange() {
        return ipRange;
    }

    /**
     * This method sets the IP range for restriction.
     *
     * @param ipRange The ipRange to set
     */
    public void setIpRange(final IpRange ipRange) {
        this.ipRange = ipRange;
    }

    /**
     * This method returns the CIDR for restriction.
     *
     * @return the cidr
     */
    public String getCidr() {
        return cidr;
    }

    /**
     * This method sets the CIDR for restriction.
     *
     * @param cidr The cidr to set
     */
    public void setCidr(final String cidr) {
        this.cidr = cidr;
    }

    /**
     * This method returns the single IP for restriction.
     *
     * @return The singleIp
     */
    public String getSingleIp() {
        return singleIp;
    }

    /**
     * This method sets the single IP for restrictions.
     *
     * @param singleIp The singleIp to set
     */
    public void setSingleIp(final String singleIp) {
        this.singleIp = singleIp;
    }

    /**
     * This method returns the description.
     *
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method sets the description.
     *
     * @param description The description.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIpRange(), getCidr(), getSingleIp(), getDescription());
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof IpRestriction) {
            IpRestriction that = (IpRestriction) object;
            return Objects.equal(getIpRange(), that.getIpRange()) && Objects.equal(getCidr(), that.getCidr()) && Objects
                    .equal(getSingleIp(), that.getSingleIp()) && Objects.equal(getDescription(), that.getDescription());
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ipRange", getIpRange())
                .add("cidr", getCidr())
                .add("singleIp", getSingleIp())
                .add("description", getDescription())
                .toString();
    }

}

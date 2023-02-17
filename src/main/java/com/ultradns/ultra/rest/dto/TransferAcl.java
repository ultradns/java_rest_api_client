/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * This class represents DTO to hold transfer ACL for accounts. The transfer ACL consists of TSIG, IP restrictions and
 * notify addresses.
 */
@JsonInclude(Include.NON_DEFAULT)
public class TransferAcl {

    /**
     * The IP restrictions for transfer.
     */
    private List<RestrictIP> restrictIPList = Lists.newArrayList();

    /**
     * The TSIG associated with transfer.
     */
    private Tsig tsig;

    /**
     * The notify addresses for zone change notification.
     */
    private List<NotifyAddressDetail> notifyAddresses = Lists.newArrayList();

    /**
     * Empty constructor.
     */
    public TransferAcl() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param restrictIPList  The restrict IPs list.
     * @param tsig            The transfer signature data.
     * @param notifyAddresses The notify addresses.
     */
    public TransferAcl(final List<RestrictIP> restrictIPList, final Tsig tsig,
            final List<NotifyAddressDetail> notifyAddresses) {
        super();
        this.restrictIPList = restrictIPList;
        this.tsig = tsig;
        this.notifyAddresses = notifyAddresses;
    }

    /**
     * This method returns the restrictIPs associated with zone transfer.
     *
     * @return The restrictIPList.
     */
    public final List<RestrictIP> getRestrictIPList() {
        return restrictIPList;
    }

    /**
     * This method sets the restrictIPs associated with zone transfer.
     *
     * @param restrictIPList The list of restrictIPs to set.
     */
    public final void setRestrictIPList(final List<RestrictIP> restrictIPList) {
        this.restrictIPList = restrictIPList;
    }

    /**
     * This method returns TSIG associated with zone transfer.
     *
     * @return The TSIG.
     */
    public final Tsig getTsig() {
        return tsig;
    }

    /**
     * This method sets the TSIG associated with zone transfer.
     *
     * @param tsig The TSIG to set.
     */
    public final void setTsig(final Tsig tsig) {
        this.tsig = tsig;
    }

    /**
     * This method returns the notify addresses for zone change notification.
     *
     * @return The notifyAddresses.
     */
    public final List<NotifyAddressDetail> getNotifyAddresses() {
        return notifyAddresses;
    }

    /**
     * This method sets the notify addresses for zone change notification.
     *
     * @param notifyAddresses The notifyAddresses to set.
     */
    public final void setNotifyAddresses(final List<NotifyAddressDetail> notifyAddresses) {
        this.notifyAddresses = notifyAddresses;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(getRestrictIPList(), getTsig(), getNotifyAddresses());
    }

    @Override
    public final boolean equals(final Object object) {
        if (object instanceof TransferAcl) {
            TransferAcl that = (TransferAcl) object;
            return Objects.equal(getTsig(), that.getTsig()) && Objects.equal(getRestrictIPList(),
                    that.getRestrictIPList()) && Objects.equal(getNotifyAddresses(), that.getNotifyAddresses());
        }
        return false;
    }

    @Override
    public final String toString() {
        return "TransferAcl{" + "restrictIPList=" + restrictIPList + ", tsig=" + tsig + ", notifyAddresses="
                + notifyAddresses + '}';
    }

}

/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Agari Email body DTO.
 */
@JsonInclude(Include.NON_NULL)
public class AgariEmailBody {

    private String company;
    private String accountID;
    private String billingID;
    private AgariContactInfo contact;
    private List<String> zones = Lists.newLinkedList();

    /**
     * Default constructor.
     */
    public AgariEmailBody() {
        super();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getBillingID() {
        return billingID;
    }

    public void setBillingID(String billingID) {
        this.billingID = billingID;
    }

    public AgariContactInfo getContact() {
        return contact;
    }

    public void setContact(AgariContactInfo contact) {
        this.contact = contact;
    }

    public List<String> getZones() {
        return zones;
    }

    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("company", this.getCompany())
                .add("accountID", this.getAccountID())
                .add("billingID", this.getBillingID())
                .add("contact", this.getContact())
                .add("zones", this.getZones())
                .toString();
    }

}

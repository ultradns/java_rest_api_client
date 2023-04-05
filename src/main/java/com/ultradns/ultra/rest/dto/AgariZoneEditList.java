/**
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Agari Zone Edit list DTO.
 */
@JsonInclude(Include.NON_NULL)
public class AgariZoneEditList {

    /**
     * {@link List} of {@link AgariZoneEdit}.
     */
    private List<AgariZoneEdit> zoneEditList = Lists.newLinkedList();

    private String companyName;
    private AgariContactInfo contactInfo;

    /**
     * Default constructor.
     */
    public AgariZoneEditList() {
        super();
    }

    public AgariZoneEditList(List<AgariZoneEdit> zoneEditList, String companyName, AgariContactInfo contactInfo) {
        this.zoneEditList = zoneEditList;
        this.companyName = companyName;
        this.contactInfo = contactInfo;
    }

    public List<AgariZoneEdit> getZoneEditList() {
        return zoneEditList;
    }

    public void setZoneEditList(List<AgariZoneEdit> zoneEditList) {
        this.zoneEditList = zoneEditList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public AgariContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(AgariContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("zoneEditList", this.getZoneEditList())
                .add("companyName", this.getCompanyName())
                .add("contactInfo", this.getContactInfo())
                .toString();
    }

}

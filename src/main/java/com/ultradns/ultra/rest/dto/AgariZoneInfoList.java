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
 * Agari Zone Info list DTO.
 */
@JsonInclude(Include.NON_NULL)
public class AgariZoneInfoList extends BaseQueryList {

    /**
     * {@link List} of {@link AgariZoneInfo}.
     */
    private List<AgariZoneInfo> zoneInfoList = Lists.newLinkedList();

    /**
     * Default constructor.
     */
    public AgariZoneInfoList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param zoneInfoList
     */
    public AgariZoneInfoList(List<AgariZoneInfo> zoneInfoList) {
        super();
        this.zoneInfoList = zoneInfoList;
    }

    public List<AgariZoneInfo> getZoneInfoList() {
        return zoneInfoList;
    }

    public void setZoneInfoList(List<AgariZoneInfo> zoneInfoList) {
        this.zoneInfoList = zoneInfoList;
    }

    @Override
    public String toString() {
        return "AgariZoneInfoList{" + "zoneInfoList=" + zoneInfoList + "} " + super.toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getZoneInfoList());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof AgariZoneInfoList)) {
            return false;
        }
        final AgariZoneInfoList other = (AgariZoneInfoList) obj;
        isEqual = Objects.equal(getZoneInfoList(), other.getZoneInfoList());
        return isEqual;
    }

}

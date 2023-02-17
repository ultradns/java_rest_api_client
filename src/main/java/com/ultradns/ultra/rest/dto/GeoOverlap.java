/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Objects;
import com.google.common.collect.Sets;

import java.util.LinkedHashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GeoOverlap {

    private String poolName;
    private String groupName;
    private LinkedHashSet<String> overlappingCodes;
    private LinkedHashSet<String> overlappingTerritories;

    public GeoOverlap() {
        // I mean it
    }

    public GeoOverlap(String poolName, String groupName, Iterable<String> overlappingCodes,
            Iterable<String> overlappingTerritories) {
        this.poolName = poolName;
        this.groupName = groupName;
        this.overlappingCodes = Sets.newLinkedHashSet(overlappingCodes);
        this.overlappingTerritories = Sets.newLinkedHashSet(overlappingTerritories);
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<String> getOverlappingCodes() {
        return overlappingCodes;
    }

    public void setOverlappingCodes(Iterable<String> overlappingCodes) {
        this.overlappingCodes = Sets.newLinkedHashSet(overlappingCodes);
    }

    public Set<String> getOverlappingTerritories() {
        return overlappingTerritories;
    }

    public void setOverlappingTerritories(Iterable<String> overlappingTerritories) {
        this.overlappingTerritories = Sets.newLinkedHashSet(overlappingTerritories);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GeoOverlap)) {
            return false;
        }
        GeoOverlap that = (GeoOverlap) o;
        return Objects.equal(getPoolName().toLowerCase(), that.getPoolName().toLowerCase()) && Objects.equal(
                getGroupName().toLowerCase(), that.getGroupName().toLowerCase()) && Objects.equal(getOverlappingCodes(),
                that.getOverlappingCodes()) && Objects.equal(getOverlappingTerritories(),
                that.getOverlappingTerritories());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPoolName().toLowerCase(), getGroupName().toLowerCase(), getOverlappingCodes(),
                getOverlappingTerritories());
    }

    @Override
    public String toString() {
        return "GeoOverlap{" + "poolName='" + poolName + '\'' + ", groupName='" + groupName + '\''
                + ", overlappingCodes=" + overlappingCodes + ", overlappingTerritories=" + overlappingTerritories + '}';
    }
}

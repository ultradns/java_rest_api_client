package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.Set;

/*
 * User: kbhandar
 * Date: 10/3/19
 *
 * Copyright 2019 Neustar, Inc. All rights reserved.
 * Neustar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of Neustar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoveZonesInfo {

    private String targetAccountName;
    private Set<String> zones;

    public MoveZonesInfo() {
        super();
    }

    public MoveZonesInfo(String targetAccountName, Set<String> zones) {
        this.targetAccountName = targetAccountName;
        this.zones = zones;
    }

    public String getTargetAccountName() {
        return targetAccountName;
    }

    public void setTargetAccountName(String targetAccountName) {
        this.targetAccountName = targetAccountName;
    }

    public Set<String> getZones() {
        return zones;
    }

    public void setZones(Set<String> zones) {
        this.zones = zones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MoveZonesInfo that = (MoveZonesInfo) o;
        return Objects.equal(targetAccountName, that.targetAccountName) && Objects.equal(zones, that.zones);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(targetAccountName, zones);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("targetAccountName", targetAccountName)
                .add("zones", zones)
                .toString();
    }
}

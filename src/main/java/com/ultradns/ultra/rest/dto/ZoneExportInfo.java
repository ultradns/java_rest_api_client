package com.ultradns.ultra.rest.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Sets;

import java.util.Set;

/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class ZoneExportInfo {

    private Set<String> zoneNames = Sets.newTreeSet();

    public ZoneExportInfo() {
        super();
    }

    public ZoneExportInfo(Set<String> zoneNames) {
        this.zoneNames = zoneNames;
    }

    public Set<String> getZoneNames() {
        return zoneNames;
    }

    public void setZoneNames(Set<String> zoneNames) {
        this.zoneNames = zoneNames;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("zoneNames", zoneNames).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ZoneExportInfo that = (ZoneExportInfo) o;
        return Objects.equal(zoneNames, that.zoneNames);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(zoneNames);
    }
}

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

import java.util.Set;

/*
 * @author vpavlyuk
 * @date 9/6/16
 * @time 4:49 PM
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IpOverlap {

    private String poolName;
    private String groupName;
    private Set<String> overlappingIps;

    public IpOverlap() {
        // I mean it
    }

    public IpOverlap(String poolName, String groupName, Iterable<String> overlappingIps) {
        this.poolName = poolName;
        this.groupName = groupName;
        this.overlappingIps = Sets.newHashSet(overlappingIps);
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

    public Set<String> getOverlappingIps() {
        return overlappingIps;
    }

    public void setOverlappingIps(Iterable<String> overlappingIps) {
        this.overlappingIps = Sets.newHashSet(overlappingIps);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IpOverlap)) {
            return false;
        }
        IpOverlap ipOverlap = (IpOverlap) o;
        return Objects.equal(getPoolName().toLowerCase(), ipOverlap.getPoolName().toLowerCase()) && Objects.equal(
                getGroupName().toLowerCase(), ipOverlap.getGroupName().toLowerCase()) && Objects.equal(
                getOverlappingIps(), ipOverlap.getOverlappingIps());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPoolName().toLowerCase(), getGroupName().toLowerCase(), getOverlappingIps());
    }

    @Override
    public String toString() {
        return "IpOverlap{" + "poolName='" + poolName + '\'' + ", groupName='" + groupName + '\'' + ", overlappingIps="
                + overlappingIps + '}';
    }
}

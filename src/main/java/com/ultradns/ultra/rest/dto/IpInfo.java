package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;
import com.google.common.collect.Sets;

import java.util.Set;

@JsonInclude(Include.NON_NULL)
public class IpInfo {
    /**
     * The list of ip addresses and ip ranges for the no response group.
     */
    @JsonInclude(Include.NON_DEFAULT)
    private Set<IP> ips = Sets.newTreeSet();
    /**
     * The name of the ip group.
     */
    private String name;

    /**
     * True if this ip group is referring to an account-level geo group, false otherwise.
     */
    private boolean isAccountLevel;

    private boolean isExistingGroupFromPool;

    /**
     * Empty constructor.
     */
    public IpInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param ips                     - {@link IpInfo#ips}
     * @param name                    - {@link IpInfo#name}
     * @param isAccountLevel          - {@link GeoInfo#isAccountLevel}
     * @param isExistingGroupFromPool {@link GeoInfo#isExistingGroupFromPool}
     */
    public IpInfo(Set<IP> ips, String name, boolean isAccountLevel, boolean isExistingGroupFromPool) {
        super();
        this.ips = ips;
        this.name = name;
        this.isAccountLevel = isAccountLevel;
        this.isExistingGroupFromPool = isExistingGroupFromPool;
    }

    /**
     * Get name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Set name.
     *
     * @param name the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * Get ips.
     *
     * @return the ip
     */
    public Set<IP> getIps() {
        return ips;
    }

    /**
     * Set ips.
     *
     * @param ips the ip to set
     */
    public void setIps(Set<IP> ips) {
        this.ips = ips;
    }

    public boolean isIsAccountLevel() {
        return isAccountLevel;
    }

    public void setIsAccountLevel(boolean isAccountLevel) {
        this.isAccountLevel = isAccountLevel;
    }

    public boolean isIsExistingGroupFromPool() {
        return isExistingGroupFromPool;
    }

    public void setIsExistingGroupFromPool(boolean isExistingGroupFromPool) {
        this.isExistingGroupFromPool = isExistingGroupFromPool;
    }

    @Override
    public String toString() {
        return "IpInfo{" + "ips=" + ips + ", name='" + name + '\'' + ", isAccountLevel=" + isAccountLevel
                + ", isExistingGroupFromPool=" + isExistingGroupFromPool + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IpInfo ipInfo = (IpInfo) o;
        return isAccountLevel == ipInfo.isAccountLevel && Objects.equal(ips, ipInfo.ips) && Objects.equal(name,
                ipInfo.name) && isExistingGroupFromPool == ipInfo.isExistingGroupFromPool;

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ips, name, isAccountLevel, isExistingGroupFromPool);
    }
}

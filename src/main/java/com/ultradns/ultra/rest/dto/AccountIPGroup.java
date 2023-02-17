package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Sets;

import java.util.TreeSet;

@JsonInclude(Include.NON_NULL)
public class AccountIPGroup {

    /**
     * The name of the group.
     */
    private String name;
    /**
     * The description for the group.
     */
    private String description;
    /**
     * The list of ip addresses and ip ranges this group contains.
     */
    private TreeSet<IP> ips = Sets.newTreeSet();

    /**
     * The count of IP group being used in directional pools.
     */
    private int recordCount;

    /**
     * Empty consructor.
     */
    public AccountIPGroup() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param name        - {@link AccountIPGroup#name}
     * @param description - {@link AccountIPGroup#description}
     * @param ips         - {@link AccountIPGroup#ips}
     */
    public AccountIPGroup(String name, String description, TreeSet<IP> ips) {
        super();
        this.name = name;
        this.description = description;
        this.ips = ips;
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
     * Get description.
     *
     * @return the description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Set description.
     *
     * @param description the description to set
     */
    public final void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get IPs.
     *
     * @return the ips
     */
    public final TreeSet<IP> getIps() {
        return ips;
    }

    /**
     * Set IPs.
     *
     * @param ips the ips to set
     */
    public final void setIps(TreeSet<IP> ips) {
        this.ips = ips;
    }

    /**
     * Get ip group record count.
     *
     * @return ip group record count
     */
    public int getRecordCount() {
        return recordCount;
    }

    /**
     * Set ip group record count.
     *
     * @param recordCount the count of IP group being used in directional pools
     */
    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", getName())
                .add("ips", getIps())
                .add("description", getDescription())
                .add("recordCount", getRecordCount())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getName(), getIps(), getDescription(), getRecordCount());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof AccountIPGroup)) {
            return false;
        }
        final AccountIPGroup other = (AccountIPGroup) obj;
        isEqual = Objects.equal(getName(), other.getName()) && Objects.equal(getIps(), other.getIps()) && Objects.equal(
                getDescription(), other.getDescription()) && Objects.equal(getRecordCount(), other.getRecordCount());
        return isEqual;
    }
}

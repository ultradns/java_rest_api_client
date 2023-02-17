package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Sets;

import java.util.TreeSet;

@JsonInclude(Include.NON_NULL)
public class AccountGeoGroup {

    /**
     * The name of the group.
     */
    private String name;
    /**
     * The description for the group.
     */
    private String description;
    /**
     * The codes for the geographical regions that make up this group.
     */
    private TreeSet<String> codes = Sets.newTreeSet();

    /**
     * The count of Geo group being used in directional pools.
     */
    private int recordCount;

    /**
     * Empty constructor.
     */
    public AccountGeoGroup() {
        super();
    }

    /**
     * Parametrized constructor.
     *
     * @param name        - {@link AccountGeoGroup#name}
     * @param description - {@link AccountGeoGroup#description}
     * @param codes       - {@link AccountGeoGroup#codes}
     */
    public AccountGeoGroup(String name, String description, TreeSet<String> codes) {
        super();
        this.name = name;
        this.description = description;
        this.codes = codes;
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
     * Get codes.
     *
     * @return the codes
     */
    public final TreeSet<String> getCodes() {
        return codes;
    }

    /**
     * Set codes.
     *
     * @param codes the codes to set
     */
    public final void setCodes(TreeSet<String> codes) {
        this.codes = codes;
    }

    /**
     * Get geo group record count.
     *
     * @return geo group record count
     */
    public int getRecordCount() {
        return recordCount;
    }

    /**
     * Set geo group record count.
     *
     * @param recordCount the count of Geo group being used in directional pools
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
                .add("codes", getCodes())
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
        return Objects.hashCode(getCodes(), getName(), getDescription(), getRecordCount());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof AccountGeoGroup)) {
            return false;
        }
        final AccountGeoGroup other = (AccountGeoGroup) obj;
        isEqual = Objects.equal(getName(), other.getName()) && Objects.equal(getCodes(), other.getCodes())
                && Objects.equal(getDescription(), other.getDescription()) && Objects.equal(getRecordCount(),
                other.getRecordCount());
        return isEqual;
    }
}

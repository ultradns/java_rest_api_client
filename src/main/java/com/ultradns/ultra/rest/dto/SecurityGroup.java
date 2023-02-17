package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

/**
 * The Class SecurityGroup.
 */

@JsonInclude(Include.NON_NULL)
public class SecurityGroup {

    /**
     * The name.
     */
    private String name;

    /**
     * The entries.
     */
    @JsonInclude(Include.NON_EMPTY)
    private List<SecurityGroupEntry> entries;

    /**
     * The exceptions.
     */
    private SecurityExceptionList exceptions;

    /**
     * The user count in a group.
     */
    private Integer usersCount;

    /**
     * Instantiates a new security group.
     *
     * @param name       the name
     * @param entries    the entries
     * @param exceptions the exceptions
     */
    public SecurityGroup(String name, List<SecurityGroupEntry> entries, SecurityExceptionList exceptions) {
        super();
        this.name = name;
        this.entries = entries;
        this.exceptions = exceptions;
    }

    /**
     * Instantiates a new security group.
     *
     * @param name       the name
     * @param entries    the entries
     * @param exceptions the exceptions
     */
    public SecurityGroup(String name, List<SecurityGroupEntry> entries, SecurityExceptionList exceptions,
            Integer usersCount) {
        super();
        this.name = name;
        this.entries = entries;
        this.exceptions = exceptions;
        this.usersCount = usersCount;
    }

    /**
     * Instantiates a new security group.
     */
    public SecurityGroup() {
        super();
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the exceptions.
     *
     * @return the exceptions
     */
    public SecurityExceptionList getExceptions() {
        return exceptions;
    }

    /**
     * Sets the exceptions.
     *
     * @param exceptions the new exceptions
     */
    public void setExceptions(SecurityExceptionList exceptions) {
        this.exceptions = exceptions;
    }

    /**
     * Gets the entries.
     *
     * @return the entries
     */
    public List<SecurityGroupEntry> getEntries() {
        return entries;
    }

    /**
     * Sets the entries.
     *
     * @param entries the new entries
     */
    public void setEntries(List<SecurityGroupEntry> entries) {
        this.entries = entries;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getEntries(), getExceptions(), getName(), getUsersCount());
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof SecurityGroup)) {
            return false;
        }
        final SecurityGroup other = (SecurityGroup) obj;
        isEqual = Objects.equal(getEntries(), other.getEntries())
                && Objects.equal(getExceptions(), other.getExceptions()) && Objects.equal(getName(), other.getName())
                && Objects.equal(getUsersCount(), other.getUsersCount());
        return isEqual;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", getName()).add("entries", getEntries())
                .add("exceptions", getExceptions()).add("usersCount", getUsersCount()).toString();
    }

    /**
     * Returns user count in a group.
     *
     * @return user count.
     */
    public Integer getUsersCount() {
        return usersCount;
    }

    /**
     * Set user count in a group.
     *
     * @param usersCount
     *            The user count.
     */
    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }
}


package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

@JsonInclude(Include.NON_NULL)
public class SecurityGroupList {

    /**
     * The list of all Security Groups.
     */
    private List<SecurityGroup> groups;

    /**
     * {@link ResultInfo}.
     */
    private ResultInfo resultInfo;

    /**
     * Empty constructor.
     */
    public SecurityGroupList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param groups
     * @param resultInfo
     */
    public SecurityGroupList(List<SecurityGroup> groups, ResultInfo resultInfo) {
        super();
        this.groups = groups;
        this.resultInfo = resultInfo;
    }

    /**
     * Get groups.
     *
     * @return the groups
     */
    public List<SecurityGroup> getGroups() {
        return groups;
    }

    /**
     * Set groups.
     *
     * @param groups the groups to set
     */
    public void setGroups(List<SecurityGroup> groups) {
        this.groups = groups;
    }

    /**
     * Get result info.
     *
     * @return the resultInfo
     */
    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    /**
     * Set result info.
     *
     * @param resultInfo the resultInfo to set
     */
    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("groups", getGroups())
                .add("resultInfo", getResultInfo())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getGroups());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof SecurityGroupList)) {
            return false;
        }
        final SecurityGroupList other = (SecurityGroupList) obj;
        isEqual =
                Objects.equal(getGroups(), other.getGroups()) && Objects.equal(getResultInfo(), other.getResultInfo());
        return isEqual;
    }
}

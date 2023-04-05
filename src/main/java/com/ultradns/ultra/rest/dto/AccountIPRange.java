package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
@JsonInclude(Include.NON_NULL)
public class AccountIPRange {
    private String guid;
    private String startIP;
    private String endIP;
    private String comments;
    private List<AccessRestrictionApplication> applications;

    public AccountIPRange() {
        //empty constructor
    }

    public AccountIPRange(String guid, String startIP, String endIP, String comments,
            List<AccessRestrictionApplication> applications) {
        this.guid = guid;
        this.startIP = startIP;
        this.endIP = endIP;
        this.comments = comments;
        this.applications = applications;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getStartIP() {
        return startIP;
    }

    public void setStartIP(String startIP) {
        this.startIP = startIP;
    }

    public String getEndIP() {
        return endIP;
    }

    public void setEndIP(String endIP) {
        this.endIP = endIP;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<AccessRestrictionApplication> getApplications() {
        return applications;
    }

    public void setApplications(List<AccessRestrictionApplication> applications) {
        this.applications = applications;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("guid", getGuid())
                .add("startIP", getStartIP())
                .add("endIP", getEndIP())
                .add("comments", getComments())
                .add("applications", getApplications())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getGuid(), getStartIP(), getEndIP(), getComments(), getApplications());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof AccountIPRange)) {
            return false;
        }
        final AccountIPRange other = (AccountIPRange) obj;
        isEqual = Objects.equal(getGuid(), other.getGuid()) && Objects.equal(getStartIP(), other.getStartIP())
                && Objects.equal(getEndIP(), other.getEndIP()) && Objects.equal(getComments(), other.getComments())
                && Objects.equal(getApplications(), other.getApplications());
        return isEqual;
    }
}

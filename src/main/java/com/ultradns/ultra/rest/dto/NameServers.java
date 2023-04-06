package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * NameServers.
 */
@JsonInclude(Include.NON_DEFAULT)
public class NameServers {

    /**
     * Name servers that are expected in the WHOIS data and are present in the WHOIS data.
     */
    private List<String> ok;

    /**
     * Name servers that are present in the WHOIS data, but are unexpected.
     */
    private List<String> unknown;

    /**
     * Name servers that are expected in the WHOIS data, but are not present.
     */
    private List<String> missing;

    /**
     * Name servers that should not be used.
     */
    private List<String> incorrect;

    /**
     * Empty constructor.
     */
    public NameServers() {
        ok = Lists.newArrayList();
        unknown = Lists.newArrayList();
        missing = Lists.newArrayList();
        incorrect = Lists.newArrayList();
    }

    public NameServers(List<String> ok, List<String> unknown, List<String> missing, List<String> incorrect) {
        this.ok = ok;
        this.unknown = unknown;
        this.missing = missing;
        this.incorrect = incorrect;
    }

    public List<String> getOk() {
        return ok;
    }

    public void setOk(List<String> ok) {
        this.ok = ok;
    }

    public List<String> getUnknown() {
        return unknown;
    }

    public void setUnknown(List<String> unknown) {
        this.unknown = unknown;
    }

    public List<String> getMissing() {
        return missing;
    }

    public void setMissing(List<String> missing) {
        this.missing = missing;
    }

    public List<String> getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(List<String> incorrect) {
        this.incorrect = incorrect;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof NameServers)) {
            return false;
        }
        final NameServers other = (NameServers) obj;
        isEqual = Objects.equal(getOk(), other.getOk()) && Objects.equal(getMissing(), other.getMissing())
                && Objects.equal(getIncorrect(), other.getIncorrect()) && Objects.equal(getUnknown(),
                other.getUnknown());
        return isEqual;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ok", getOk())
                .add("missing", getMissing())
                .add("incorrect", getIncorrect())
                .add("unknown", getUnknown())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getOk(), getMissing(), getIncorrect(), getUnknown());
    }
}

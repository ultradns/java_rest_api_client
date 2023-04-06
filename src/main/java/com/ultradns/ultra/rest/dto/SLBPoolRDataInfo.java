/**
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

/**
 * SLB Pool RData Info.
 */
@JsonInclude(Include.NON_NULL)
public class SLBPoolRDataInfo {
    /**
     * An optional description of the record in the live pool.
     */
    private String description;
    private BaseAdaptiveResponseRecord.ForcedState forcedState;
    private Boolean availableToServe;
    private Boolean probingEnabled;

    /**
     * Empty constructor.
     */
    public SLBPoolRDataInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param description      - Description
     * @param forcedState      - ForcedState
     * @param availableToServe - AvailableToServe
     * @param probingEnabled   - ProbingEnabled
     */
    public SLBPoolRDataInfo(String description, BaseAdaptiveResponseRecord.ForcedState forcedState,
                            Boolean availableToServe, Boolean probingEnabled) {
        super();
        this.description = description;
        this.forcedState = forcedState;
        this.availableToServe = availableToServe;
        this.probingEnabled = probingEnabled;
    }

    /**
     * Parameterized constructor.
     *
     * @param description    - Description
     * @param forcedState    - ForcedState
     * @param probingEnabled - ProbingEnabled
     */
    public SLBPoolRDataInfo(String description, BaseAdaptiveResponseRecord.ForcedState forcedState,
                            Boolean probingEnabled) {
        super();
        this.description = description;
        this.forcedState = forcedState;
        this.probingEnabled = probingEnabled;
    }

    /**
     * Get the description.
     *
     * @return the description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Set the description.
     *
     * @param description the description to set
     */
    public final void setDescription(String description) {
        this.description = description;
    }

    public final BaseAdaptiveResponseRecord.ForcedState getForcedState() {
        return forcedState;
    }

    public final void setForcedState(BaseAdaptiveResponseRecord.ForcedState forcedState) {
        this.forcedState = forcedState;
    }

    public final Boolean getAvailableToServe() {
        return availableToServe;
    }

    public final void setAvailableToServe(Boolean availableToServe) {
        this.availableToServe = availableToServe;
    }

    public final Boolean getProbingEnabled() {
        return probingEnabled;
    }

    public final void setProbingEnabled(Boolean probingEnabled) {
        this.probingEnabled = probingEnabled;
    }

    @Override
    public final String toString() {
        return "SLBPoolRDataInfo [description=" + description + ", forcedState=" + forcedState + ", availableToServe="
                + availableToServe + ", probingEnabled=" + probingEnabled + "]";
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getDescription(), getForcedState(), getAvailableToServe(), getProbingEnabled());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof SLBPoolRDataInfo)) {
            return false;
        }
        final SLBPoolRDataInfo other = (SLBPoolRDataInfo) obj;
        return Objects.equal(getDescription(), other.getDescription()) && Objects.equal(getForcedState(),
                other.getForcedState()) && Objects.equal(getAvailableToServe(), other.getAvailableToServe())
                && Objects.equal(getProbingEnabled(), other.getProbingEnabled());
    }

}

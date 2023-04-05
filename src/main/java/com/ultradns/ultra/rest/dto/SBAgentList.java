/**
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * SB Agent list DTO.
 */
@JsonInclude(Include.NON_NULL)
public class SBAgentList {

    /**
     * {@link List} of {@link SBAgent}.
     */
    private List<SBAgent> agents = Lists.newLinkedList();

    /**
     * Default constructor.
     */
    public SBAgentList() {
        super();
    }

    public List<SBAgent> getAgents() {
        return agents;
    }

    public void setAgents(List<SBAgent> agents) {
        this.agents = agents;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("agents", this.getAgents()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SBAgentList)) {
            return false;
        }
        final SBAgentList other = (SBAgentList) obj;
        return Objects.equal(this.getAgents(), other.getAgents());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(this.getAgents());
    }
}

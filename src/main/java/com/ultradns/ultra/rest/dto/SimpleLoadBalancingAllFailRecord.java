package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Objects;

/**
 * Represents an SLB AllFail (aka Backup) record.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleLoadBalancingAllFailRecord extends AllFailRecord {
    private Boolean serving;

    public SimpleLoadBalancingAllFailRecord() {
        super();
    }

    public SimpleLoadBalancingAllFailRecord(String rdata, String description) {
        super(rdata, description);
    }

    public SimpleLoadBalancingAllFailRecord(String rdata, String description, Boolean serving) {
        super(rdata, description);
        this.serving = serving;

    }

    public Boolean getServing() {
        return serving;
    }

    public void setServing(Boolean serving) {
        this.serving = serving;
    }

    @Override
    public String toString() {
        return super.toString() + ", serving=" + serving + "]";
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(super.hashCode(), getServing());
    }

    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof SimpleLoadBalancingAllFailRecord)) {
            return false;
        }
        final SimpleLoadBalancingAllFailRecord other = (SimpleLoadBalancingAllFailRecord) obj;
        return super.equals(obj) && Objects.equal(getServing(), other.getServing());
    }
}

package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;

/**
 * Represents an abstract AllFail (aka Backup) record for a AR Pools(SF,SLB,TM pools).
 */
@SuppressWarnings("PMD.AbstractClassWithoutAbstractMethod")
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AllFailRecord {
    @NotNull(message = "ALLFAIL_RECORD_RDATA_REQUIRED")
    private String rData;
    private String description;

    protected AllFailRecord() {
        // empty constructor
    }

    protected AllFailRecord(String rdata, String description) {
        this.rData = rdata;
        this.description = description;
    }

    public String getRData() {
        return rData;
    }

    public void setRData(String rdata) {
        this.rData = rdata;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FailoverRecord [rData=" + rData + ", description=" + description + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getRData(), getDescription());
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof AllFailRecord)) {
            return false;
        }
        final AllFailRecord other = (AllFailRecord) obj;
        return Objects.equal(getRData(), other.getRData()) && Objects.equal(getDescription(), other.getDescription());
    }
}

package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;

/**
 * Represents a Failover (aka Backup) record.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FailoverRecord {
    @NotNull(message = "FAILOVER_RECORD_RDATA_REQUIRED")
    private String rData;
    private String description;

    public FailoverRecord() {
        // empty constructor
    }

    public FailoverRecord(String rdata, String description) {
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
    public final int hashCode() {
        return Objects.hashCode(getRData(), getDescription());
    }

    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof FailoverRecord)) {
            return false;
        }
        final FailoverRecord other = (FailoverRecord) obj;
        return Objects.equal(getRData(), other.getRData()) && Objects.equal(getDescription(), other.getDescription());
    }

}

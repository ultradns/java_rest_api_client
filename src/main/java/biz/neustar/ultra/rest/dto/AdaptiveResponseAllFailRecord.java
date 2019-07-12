package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdaptiveResponseAllFailRecord extends BaseAdaptiveResponseRecord {

    private static final int SIZE_134 = 134;
    private String rdata;

    public AdaptiveResponseAllFailRecord() {
        super();
    }

    public AdaptiveResponseAllFailRecord(RecordType recordType, String description, ForcedState forcedState,
            Boolean probesEnabled, String rdata) {
        this.setType(recordType);
        this.setDescription(description);
        this.setForcedState(forcedState);
        this.setProbesEnabled(probesEnabled);
        this.rdata = rdata;
    }

    public String getRdata() {
        return rdata;
    }

    public void setRdata(String rdata) {
        this.rdata = rdata;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConfigurationName(), getDescription(), getForcedState(), getProbesEnabled(), getState(),
                getStatus(), getType(), getRdata(), getWeight());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AdaptiveResponseAllFailRecord)) {
            return false;
        }
        final AdaptiveResponseAllFailRecord other = (AdaptiveResponseAllFailRecord) obj;
        return Objects.equals(getConfigurationName(), other.getConfigurationName()) && Objects.equals(getDescription(),
                other.getDescription()) && Objects.equals(getForcedState(), other.getForcedState()) && Objects.equals(
                getProbesEnabled(), other.getProbesEnabled()) && Objects.equals(getState(), other.getState()) && Objects
                .equals(getStatus(), other.getStatus()) && Objects.equals(getRdata(), other.getRdata())
                && Objects.equals(getWeight(), other.getWeight()) && Objects.equals(getType(), other.getType());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(SIZE_134);
        builder.append("AdaptiveResponseRecord [recordType=")
                .append(getType())
                .append(", configurationName=")
                .append(getConfigurationName())
                .append(", description=")
                .append(getDescription())
                .append(", forcedState=")
                .append(getForcedState())
                .append(", state=")
                .append(getState())
                .append(", probesEnabled=")
                .append(getProbesEnabled())
                .append(", status=")
                .append(getStatus())
                .append(", rdata=")
                .append(getRdata())
                .append(", weight=")
                .append(getWeight())
                .append(']');
        return builder.toString();
    }

}

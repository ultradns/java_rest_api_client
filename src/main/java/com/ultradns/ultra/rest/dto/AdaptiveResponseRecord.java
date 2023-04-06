package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdaptiveResponseRecord extends BaseAdaptiveResponseRecord {

    private static final int SIZE_126 = 126;

    public AdaptiveResponseRecord() {
        super();
    }

    public AdaptiveResponseRecord(RecordType recordType, String description, ForcedState forcedState,
            Boolean probesEnabled) {
        this.setType(recordType);
        this.setDescription(description);
        this.setForcedState(forcedState);
        this.setProbesEnabled(probesEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConfigurationName(), getDescription(), getForcedState(), getProbesEnabled(), getState(),
                getStatus(), getType(), getWeight());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AdaptiveResponseRecord)) {
            return false;
        }
        final AdaptiveResponseRecord other = (AdaptiveResponseRecord) obj;
        return Objects.equals(getConfigurationName(), other.getConfigurationName()) && Objects.equals(getDescription(),
                other.getDescription()) && Objects.equals(getForcedState(), other.getForcedState()) && Objects.equals(
                getProbesEnabled(), other.getProbesEnabled()) && Objects.equals(getState(), other.getState()) && Objects
                .equals(getStatus(), other.getStatus()) && Objects.equals(getWeight(), other.getWeight())
                && Objects.equals(getType(), other.getType());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(SIZE_126);
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
                .append(", weight=")
                .append(getWeight())
                .append(']');
        return builder.toString();
    }

}

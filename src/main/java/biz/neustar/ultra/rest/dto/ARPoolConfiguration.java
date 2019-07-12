package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ARPoolConfiguration {

    private Boolean failoverEnabled;

    private Boolean probingEnabled;

    private ResponseMethod responseMethod;

    private Long maxActive;

    private Long maxResponse;

    private String description;

    public Boolean isFailoverEnabled() {
        return failoverEnabled;
    }

    public Boolean isProbingEnabled() {
        return probingEnabled;
    }

    public ResponseMethod getResponseMethod() {
        return responseMethod;
    }

    public void setResponseMethod(ResponseMethod responseMethod) {
        this.responseMethod = responseMethod;
    }

    public Long getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Long maxActive) {
        this.maxActive = maxActive;
    }

    public Long getMaxResponse() {
        return maxResponse;
    }

    public void setMaxResponse(Long maxResponse) {
        this.maxResponse = maxResponse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFailoverEnabled(Boolean failoverEnabled) {
        this.failoverEnabled = failoverEnabled;
    }

    public void setProbingEnabled(Boolean probingEnabled) {
        this.probingEnabled = probingEnabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getMaxActive(), getMaxResponse(), getResponseMethod());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ARPoolConfiguration)) {
            return false;
        }
        ARPoolConfiguration other = (ARPoolConfiguration) obj;
        return Objects.equals(getDescription(), other.getDescription()) && Objects.equals(getMaxActive(),
                other.getMaxActive()) && Objects.equals(getMaxResponse(), other.getMaxResponse()) && Objects.equals(
                getResponseMethod(), other.getResponseMethod());
    }

    public enum ResponseMethod {
        FIXED,
        RANDOM,
        ROUND_ROBIN,
        WEIGHTED;
    }
}

package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.MonitorHttpMethod;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;

/**
 * Represents a Monitor object. A Monitor object is what is used to monitor the health of a record
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Monitor {
    @NotNull(message = "MONITOR_METHOD_REQUIRED")
    private MonitorHttpMethod method;
    @NotNull(message = "MONITOR_URL_REQUIRED")
    private String url;
    private String transmittedData;
    private String searchString;

    public Monitor() {
        //empty constructor
    }

    public Monitor(MonitorHttpMethod method, String url, String transmittedData, String searchString) {
        this.method = method;
        this.url = url;
        this.transmittedData = transmittedData;
        this.searchString = searchString;
    }

    public MonitorHttpMethod getMethod() {
        return method;
    }

    public void setMethod(MonitorHttpMethod method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTransmittedData() {
        return transmittedData;
    }

    public void setTransmittedData(String transmittedData) {
        this.transmittedData = transmittedData;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("method", getMethod())
                .add("url", getUrl())
                .add("transmittedData", getTransmittedData())
                .add("searchString", getSearchString())
                .toString();

    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(getMethod(), getUrl(), getTransmittedData(), getSearchString());
    }

    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof Monitor)) {
            return false;
        }
        final Monitor other = (Monitor) obj;
        return Objects.equal(getMethod(), other.getMethod()) && Objects.equal(getUrl(), other.getUrl())
                && Objects.equal(getTransmittedData(), other.getTransmittedData()) && Objects.equal(getSearchString(),
                other.getSearchString());
    }
}

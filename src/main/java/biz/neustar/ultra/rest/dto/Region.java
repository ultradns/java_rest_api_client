package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Created by s_yju on 2/23/16.
 */
public class Region {
    /*
      [
        [
        {"name": "Asia (AS)", "code": "AS", "type": "continent", "id": "<territiryId>"}
        ,
        {"name": "South America (SA)", "code": "SA", "type": "continent", "id": "<territiryId>"}
        ,
        {"name": "North America (NA)", "code": "NA", "type": "continent", "id": "<territiryId>"}
        ,...],
        [
        {"name":"United States (US)", "code": "US", "type": "country", "id": "<territiryId>"}
        ,
        {"name":"Mexico (MX)", "code": "MX", "type": "country", "id": "<territiryId>"}
        ,...],
        ["name":"New York (US-NY)", "code": "US-NY", "type": "state", "id": "<territiryId>"},
         {"name":"Virginia (US-VA)", "code": "US-VA", "type": "state", "id": "<territiryId>"}
         ,...]]
    */
    @JsonProperty("name")
    private String name;

    @JsonProperty("code")
    private String code;

    @JsonProperty("type")
    private String type;

    @JsonProperty("id")
    private int id;

    public Region(String name, String code, String type, int id) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getCode(), getName(), getType());
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof Region)) {
            return false;
        }
        final Region other = (Region) obj;
        isEqual = Objects.equal(getId(), other.getId()) && Objects.equal(getCode(), other.getCode()) && Objects.equal(
                getName(), other.getName()) && Objects.equal(getType(), other.getType());
        return isEqual;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("code", getCode())
                .add("name", getName())
                .add("type", getType())
                .toString();
    }
}

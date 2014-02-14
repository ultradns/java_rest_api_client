/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

/**
 * Zone List.
 * 
 * @author nupadhyay
 * 
 */
@JsonInclude(Include.NON_NULL)
public class ZoneInfoList extends BaseQueryList {

    /**
     * Empty constructor.
     */
    public ZoneInfoList() {
        super();
    }

    /**
     * Parameterized constructor.
     * 
     * @param zones
     *            - Zones.
     * @param queryInfo
     *            - Query Info
     * @param resultInfo
     *            - Result Info
     */
    public ZoneInfoList(List<ZoneOutInfo> zones, QueryInfo queryInfo, ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.zones = zones;
    }

    /**
     * List of {@link Zone}.
     */
    private List<ZoneOutInfo> zones;

    public List<ZoneOutInfo> getZones() {
        return zones;
    }

    public void setZones(List<ZoneOutInfo> zones) {
        this.zones = zones;
    }

    @Override
    public String toString() {
        return "ZoneInfoList{" +
                "zones=" + zones +
                "} " + super.toString();
    }
}

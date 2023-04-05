/**
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

/**
 * Zone List.
 *
 */
@JsonInclude(Include.NON_NULL)
public class ZoneList extends BaseQueryList {

    /**
     * List of {@link Zone}.
     */
    private List<Zone> zones;

    /**
     * Empty constructor.
     */
    public ZoneList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param zones      - Zones.
     * @param queryInfo  - Query Info
     * @param resultInfo - Result Info
     */
    public ZoneList(List<Zone> zones, QueryInfo queryInfo, ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.zones = zones;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }
}

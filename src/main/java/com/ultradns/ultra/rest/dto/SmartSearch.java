/*
 * User: nupadhyay
 * Date: Nov 24, 2014
 * Time: 4:10:27 PM
 *
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.MoreObjects;

import java.util.Set;

/**
 * This DTO for containing attributes related to smart search and replace functionality.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SmartSearch {
    public static final String ZONE_FILTER = "zone";
    public static final String ZONE_TYPE_FILTER = "zone_type";
    public static final String ACCOUNT_FILTER = "account";
    public static final String ZONE_STATUS_FILTER = "zone_status";
    public static final String PATH_FILTER = "path";
    public static final String WILD_CARD_ASTERISK = "*";
    public static final String OWNER_FILTER = "owner";
    public static final String DNSSEC_STATUS_FILTER = "dnssec_status";
    public static final String TYPE_FILTER = "type";
    private Kind kind;
    @JsonProperty("if")
    private Set<SearchFilter> filters;
    private JsonNode then;

    public SmartSearch() {
        super();
    }

    public SmartSearch(Kind kind, Set<SearchFilter> filters, JsonNode then) {
        super();
        this.kind = kind;
        this.filters = filters;
        this.then = then;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public Set<SearchFilter> getFilters() {
        return filters;
    }

    public void setFilters(Set<SearchFilter> filters) {
        this.filters = filters;
    }

    public JsonNode getThen() {
        return then;
    }

    public void setThen(JsonNode then) {
        this.then = then;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("filters", getFilters())
                .add("kind", getKind())
                .add("then", getThen())
                .toString();
    }

    public enum Kind {
        ZONE,
        RRSET
    }

    public enum BulkMode {
        SHOW_MATCHING,
        SHOW_EDITABLE,
        PREVIEW,
        APPLY
    }

    public enum Operations {
        REPLACE("replace"),
        REMOVE("remove"),
        ADD("add");
        private final String value;

        Operations(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}

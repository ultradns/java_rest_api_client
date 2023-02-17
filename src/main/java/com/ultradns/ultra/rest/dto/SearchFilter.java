/*
 * User: nupadhyay
 * Date: Dec 15, 2014
 * Time: 12:55:13 PM
 *
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchFilter {

    private String cond;
    private String value;
    private MatchType match = MatchType.ANYWHERE;
    private String arg;

    public SearchFilter() {
        super();
    }

    public SearchFilter(String cond, String value, MatchType match, String arg) {
        super();
        this.cond = cond;
        this.value = value;
        this.match = match;
        this.arg = arg;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MatchType getMatch() {
        return match;
    }

    public void setMatch(MatchType match) {
        this.match = match;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getCond());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof SearchFilter)) {
            return false;
        }
        final SearchFilter other = (SearchFilter) obj;
        // There can be multiple paths in a search filter so differentiating the
        // path based on their arguments.
        if (SmartSearch.PATH_FILTER.equals(getCond())) {
            return Objects.equal(getCond(), other.getCond()) && Objects.equal(getArg(), other.getArg());
        } else {
            return Objects.equal(getCond(), other.getCond());
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", getValue())
                .add("arg", getArg())
                .add("cond", getCond())
                .add("match", getMatch())
                .toString();
    }

    public enum Filter {
        ZONE("zone", true, false),
        ACCOUNT("account", true, false),
        OWNER("owner", true, false),
        RR_TYPE("type", false, false),
        ZONE_TYPE("zone_type", false, false),
        ZONE_STATUS("zone_status", false, false),
        PATH("path", true, true),
        DNSSEC_STATUS("dnssec_status", false, false);

        public static final Set<Filter> ZONE_FILTERS = Collections.unmodifiableSet(
                Sets.newHashSet(ZONE, ZONE_STATUS, ZONE_TYPE, PATH, OWNER, DNSSEC_STATUS));
        public static final Set<Filter> ACCOUNT_FILTERS = Collections.unmodifiableSet(Sets.newHashSet(ACCOUNT));
        public static final Set<Filter> RR_FILTERS = Collections.unmodifiableSet(Sets.newHashSet(OWNER, RR_TYPE));
        private static final Map<String, Filter> FILTER_NAME_MAP = Maps.newHashMap();

        static {
            for (Filter filter : values()) {
                FILTER_NAME_MAP.put(filter.getValue(), filter);
            }
        }

        private final String value;
        private final boolean hasMatch;
        private final boolean hasArg;

        Filter(String value, boolean hasMatch, boolean hasArg) {
            this.value = value;
            this.hasMatch = hasMatch;
            this.hasArg = hasArg;
        }

        public static Filter getFilter(String filterName) {
            return FILTER_NAME_MAP.get(filterName);
        }

        public String getValue() {
            return this.value;
        }

        public boolean hasMatch() {
            return hasMatch;
        }

        public boolean hasArg() {
            return hasArg;
        }

    }

}

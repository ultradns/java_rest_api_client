/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * Web forward.
 */
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("PMD.GodClass")
public class WebForward implements Serializable {

    /**
     * The generated unique identifier for this object.
     */
    private String guid;
    /**
     * URL that you want to redirect.
     */
    private String requestTo;
    /**
     * the URL destination of the redirect.
     */
    private String defaultRedirectTo;
    /**
     * Type of forward.
     */
    private RedirectType defaultForwardType;

    /**
     * Present if you are using advanced web forward to specify where to forward to based on custom headers.
     */
    private List<Record> records = Lists.newLinkedList();

    /**
     *  Type of Relative forward.
     */
    private RelativeForward relativeForwardType;

    /**
     * Empty constructor.
     */
    public WebForward() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param guid               - Guid
     * @param requestTo          - Request To
     * @param defaultRedirectTo  - Default redirect to
     * @param defaultForwardType - Default forward type
     * @param records            - Records
     */
    public WebForward(String guid, String requestTo, String defaultRedirectTo, RedirectType defaultForwardType,
            List<Record> records) {
        super();
        this.guid = guid;
        this.requestTo = requestTo;
        this.defaultRedirectTo = defaultRedirectTo;
        this.defaultForwardType = defaultForwardType;
        this.records = records;
    }

    /**
     * Get guid.
     *
     * @return the guid
     */
    public final String getGuid() {
        return guid;
    }

    /**
     * Set guid.
     *
     * @param guid the guid to set
     */
    public final void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * Get Request to.
     *
     * @return the requestTo
     */
    public final String getRequestTo() {
        return requestTo;
    }

    /**
     * Set request to.
     *
     * @param requestTo the requestTo to set
     */
    public final void setRequestTo(String requestTo) {
        this.requestTo = requestTo;
    }

    /**
     * Get default redirect to.
     *
     * @return the defaultRedirectTo
     */
    public final String getDefaultRedirectTo() {
        return defaultRedirectTo;
    }

    /**
     * Set default redirect to.
     *
     * @param defaultRedirectTo the defaultRedirectTo to set
     */
    public final void setDefaultRedirectTo(String defaultRedirectTo) {
        this.defaultRedirectTo = defaultRedirectTo;
    }

    /**
     * Get default forward type.
     *
     * @return the defaultForwardType
     */
    public final RedirectType getDefaultForwardType() {
        return defaultForwardType;
    }

    /**
     * Set default forward type.
     *
     * @param defaultForwardType the defaultForwardType to set
     */
    public final void setDefaultForwardType(RedirectType defaultForwardType) {
        this.defaultForwardType = defaultForwardType;
    }

    /**
     * Get relative forward type.
     *
     * @return the relativeForwardType
     */
    public RelativeForward getRelativeForwardType() {
        return relativeForwardType;
    }

    /**
     * Set relative forward type.
     *
     * @param relativeForwardType the relativeForwardType to set
     */
    public void setRelativeForwardType(RelativeForward relativeForwardType) {
        this.relativeForwardType = relativeForwardType;
    }

    /**
     * Get records.
     *
     * @return the records
     */
    public final List<Record> getRecords() {
        return records;
    }

    /**
     * Set records.
     *
     * @param records the records to set
     */
    public final void setRecords(List<Record> records) {
        this.records = records;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("guid", getGuid())
                .add("requestTo", getRequestTo())
                .add("defaultRedirectTo", getDefaultRedirectTo())
                .add("defaultForwardType", getDefaultForwardType())
                .add("records", getRecords())
                .add("relativeForwardType", getRelativeForwardType())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getGuid(), getRequestTo(), getDefaultRedirectTo(), getDefaultForwardType(),
                getRecords(), getRelativeForwardType());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof WebForward)) {
            return false;
        }
        final WebForward other = (WebForward) obj;
        isEqual = Objects.equal(getGuid(), other.getGuid()) && Objects.equal(getRequestTo(), other.getRequestTo())
                && Objects.equal(getDefaultRedirectTo(), other.getDefaultRedirectTo())
                && Objects.equal(getDefaultForwardType(), other.getDefaultForwardType()) && Objects.equal(getRecords(),
                other.getRecords()) && Objects.equal(getRelativeForwardType(), other.getRelativeForwardType());
        return isEqual;
    }

    /*
     * to copy the object
     */
    public WebForward copyTo() {
        WebForward newWebForward = new WebForward();
        newWebForward.setDefaultRedirectTo(this.getDefaultRedirectTo());
        newWebForward.setRequestTo(this.getRequestTo());
        List<Record> newRecords = Lists.newArrayList();
        newRecords.addAll(this.getRecords());
        newWebForward.setRecords(newRecords);
        newWebForward.setGuid(this.getGuid());
        newWebForward.setDefaultForwardType(this.getDefaultForwardType());
        return newWebForward;
    }

    /**
     * Redirect Type.
     */
    public enum RedirectType {
        Framed(1),
        HTTP_301_REDIRECT(301),
        HTTP_302_REDIRECT(302),
        HTTP_303_REDIRECT(303),
        HTTP_307_REDIRECT(307);

        private final long value;

        RedirectType(long v) {
            value = v;
        }

        public static RedirectType fromValue(long v) {
            for (RedirectType c : RedirectType.values()) {
                if (c.value == v) {
                    return c;
                }
            }
            throw new IllegalArgumentException();
        }

        public long value() {
            return value;
        }
    }

    /**
     * Crs Web match criteria.
     */
    public enum CrsWebMatchCriteria {

        BEGINS_WITH(1),
        CONTAINS(2),
        ENDS_WITH(3),
        MATCHES(4);
        private final long value;

        CrsWebMatchCriteria(long v) {
            value = v;
        }

        public static CrsWebMatchCriteria fromValue(long v) {
            for (CrsWebMatchCriteria c : CrsWebMatchCriteria.values()) {
                if (c.value == v) {
                    return c;
                }
            }
            throw new IllegalArgumentException();
        }

        public long value() {
            return value;
        }
    }

    /**
     * Relative Forward.
     */
    public enum RelativeForward {

        /**
         * Parameter is appended to redirect_path.
         */
        PARAMETER(1),
        /**
         * Path is appended to redirect_path.
         */
        PATH(2),
        /**
         * Both Parameter and Path are appended to redirect_path.
         */
        PARAMETER_AND_PATH(3);

        private final long value;

        RelativeForward(long value) {
            this.value = value;
        }

        public static RelativeForward fromValue(long value) {
            for (RelativeForward relativeForward : RelativeForward.values()) {
                if (relativeForward.value == value) {
                    return relativeForward;
                }
            }
            throw new IllegalArgumentException();
        }

        public long value() {
            return value;
        }
    }

    /**
     * Record.
     */
    public static class Record implements Serializable {

        /**
         * The URL destination of the redirect.
         */
        private String redirectTo;
        /**
         * Type of forward.
         */
        private RedirectType forwardType;
        /**
         * Order for a record to match. Lower numbers have higher priority.
         */
        private long priority;
        /**
         * One or more rules.
         */
        private List<Rule> rules = Lists.newLinkedList();

        /**
         * Empty constructor.
         */
        public Record() {
            super();
        }

        /**
         * Parameterized constructor.
         *
         * @param redirectTo  - Redirect to
         * @param forwardType - forward type
         * @param priority    - Priority
         * @param rules       - rules
         */
        public Record(String redirectTo, RedirectType forwardType, long priority, List<Rule> rules) {
            super();
            this.redirectTo = redirectTo;
            this.forwardType = forwardType;
            this.priority = priority;
            this.rules = rules;
        }

        /**
         * Get redirect to.
         *
         * @return the redirectTo
         */
        public final String getRedirectTo() {
            return redirectTo;
        }

        /**
         * Set redirect to.
         *
         * @param redirectTo the redirectTo to set
         */
        public final void setRedirectTo(String redirectTo) {
            this.redirectTo = redirectTo;
        }

        /**
         * Get forward type.
         *
         * @return the forwardType
         */
        public final RedirectType getForwardType() {
            return forwardType;
        }

        /**
         * Set forward type.
         *
         * @param forwardType the forwardType to set
         */
        public final void setForwardType(RedirectType forwardType) {
            this.forwardType = forwardType;
        }

        /**
         * Get priority.
         *
         * @return the priority
         */
        public final long getPriority() {
            return priority;
        }

        /**
         * Set priority.
         *
         * @param priority the priority to set
         */
        public final void setPriority(long priority) {
            this.priority = priority;
        }

        /**
         * Get rules.
         *
         * @return the rules
         */
        public final List<Rule> getRules() {
            return rules;
        }

        /**
         * Set rules.
         *
         * @param rules the rules to set
         */
        public final void setRules(List<Rule> rules) {
            this.rules = rules;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
        @Override
        public final String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("redirectTo", getRedirectTo())
                    .add("forwardType", getForwardType())
                    .add("priority", getPriority())
                    .add("rules", getRules())
                    .toString();
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public final int hashCode() {
            return Objects.hashCode(getRedirectTo(), getForwardType(), getPriority(), getRules());
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public final boolean equals(final Object obj) {
            boolean isEqual = true;
            if (!(obj instanceof Record)) {
                return false;
            }
            final Record other = (Record) obj;
            isEqual = Objects.equal(getRedirectTo(), other.getRedirectTo()) && Objects.equal(getForwardType(),
                    other.getForwardType()) && Objects.equal(getPriority(), other.getPriority()) && Objects.equal(
                    getRules(), other.getRules());
            return isEqual;
        }
    }

    /**
     * Rule.
     */
    public static class Rule implements Serializable {

        /**
         * Name of the header to match.
         */
        private String header;
        /**
         * Type of match to perform.
         */
        private CrsWebMatchCriteria matchCriteria;
        /**
         * The expected header value.
         */
        private String value;
        /**
         * Flag to indicate if the match takes case into account.
         */
        private boolean caseInsensitive;

        /**
         * Empty constructor.
         */
        public Rule() {
            super();
        }

        /**
         * Parameterized constructor.
         *
         * @param header          - Header
         * @param matchCriteria   - Match criteria
         * @param value           - value
         * @param caseInsensitive - Case sensitive
         */
        public Rule(String header, CrsWebMatchCriteria matchCriteria, String value, boolean caseInsensitive) {
            super();
            this.header = header;
            this.matchCriteria = matchCriteria;
            this.value = value;
            this.caseInsensitive = caseInsensitive;
        }

        /**
         * Get header.
         *
         * @return the header
         */
        public final String getHeader() {
            return header;
        }

        /**
         * Set header.
         *
         * @param header the header to set
         */
        public final void setHeader(String header) {
            this.header = header;
        }

        /**
         * Get match criteria.
         *
         * @return the matchCriteria
         */
        public final CrsWebMatchCriteria getMatchCriteria() {
            return matchCriteria;
        }

        /**
         * Set match criteria.
         *
         * @param matchCriteria the matchCriteria to set
         */
        public final void setMatchCriteria(CrsWebMatchCriteria matchCriteria) {
            this.matchCriteria = matchCriteria;
        }

        /**
         * Get value.
         *
         * @return the value
         */
        public final String getValue() {
            return value;
        }

        /**
         * Set value.
         *
         * @param value the value to set
         */
        public final void setValue(String value) {
            this.value = value;
        }

        /**
         * Is case insensitive.
         *
         * @return the caseInsensitive
         */
        public final boolean isCaseInsensitive() {
            return caseInsensitive;
        }

        /**
         * Set case insensitive.
         *
         * @param caseInsensitive the caseInsensitive to set
         */
        public final void setCaseInsensitive(boolean caseInsensitive) {
            this.caseInsensitive = caseInsensitive;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
        @Override
        public final String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("header", getHeader())
                    .add("matchCriteria", getMatchCriteria())
                    .add("value", getValue())
                    .add("caseInsensitive", isCaseInsensitive())
                    .toString();
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public final int hashCode() {
            return Objects.hashCode(getHeader(), getMatchCriteria(), getValue(), isCaseInsensitive());
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public final boolean equals(final Object obj) {
            boolean isEqual = true;
            if (!(obj instanceof Rule)) {
                return false;
            }
            final Rule other = (Rule) obj;
            isEqual = Objects.equal(getHeader(), other.getHeader()) && Objects.equal(getMatchCriteria(),
                    other.getMatchCriteria()) && Objects.equal(getValue(), other.getValue()) && Objects.equal(
                    isCaseInsensitive(), other.isCaseInsensitive());
            return isEqual;
        }
    }
}

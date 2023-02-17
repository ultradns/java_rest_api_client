/**
 * Copyright 2000-2014 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * This class represents DTO to hold TSIG information for zone transfer.
 */
@JsonInclude(Include.NON_NULL)
public class Tsig {

    /**
     * The TSIG key name.
     */
    private String tsigKeyName;

    /**
     * The TSIG key value.
     */
    private String tsigKeyValue;

    /**
     * The description.
     */
    private String description;

    /**
     * The TSIG Algorithm.
     */
    private String tsigAlgorithm;

    /**
     * Default constructor.
     */
    public Tsig() {
        super();
    }

    /**
     * The parameterized constructor.
     *
     * @param tsigKeyName   The TSIG key name.
     * @param tsigKeyValue  The TSIG key value.
     * @param tsigAlgorithm The TSIG algorithm.
     * @param description   The description.
     */
    public Tsig(final String tsigKeyName, final String tsigKeyValue, final TsigAlgorithm tsigAlgorithm,
            final String description) {
        this.tsigKeyName = tsigKeyName;
        this.tsigKeyValue = tsigKeyValue;
        if (tsigAlgorithm != null) {
            this.tsigAlgorithm = tsigAlgorithm.getValue();
        }
        this.description = description;
    }

    /**
     * This method returns the TSIG key name.
     *
     * @return the tsigKeyName
     */
    public String getTsigKeyName() {
        return tsigKeyName;
    }

    /**
     * This method sets the TSIG key name.
     *
     * @param tsigKeyName the tsigKeyName to set
     */
    public void setTsigKeyName(final String tsigKeyName) {
        this.tsigKeyName = tsigKeyName;
    }

    /**
     * This method returns the TSIG key value.
     *
     * @return the tsigKeyValue
     */
    public String getTsigKeyValue() {
        return tsigKeyValue;
    }

    /**
     * This method sets the TSIG key value.
     *
     * @param tsigKeyValue the tsigKeyValue to set
     */
    public void setTsigKeyValue(final String tsigKeyValue) {
        this.tsigKeyValue = tsigKeyValue;
    }

    /**
     * This method returns the TSIG algorithm.
     *
     * @return the tsigAlgorithm
     */
    public String getTsigAlgorithm() {
        return tsigAlgorithm;
    }

    /**
     * This method sets TSIG algorithm.
     *
     * @param tsigAlgorithm the tsigAlgorithm to set
     */
    public void setTsigAlgorithm(final String tsigAlgorithm) {
        TsigAlgorithm algorithmEnum = TsigAlgorithm.fromVal(tsigAlgorithm);
        this.tsigAlgorithm = algorithmEnum.getValue();
    }

    /**
     * This method returns the description.
     *
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method sets the description.
     *
     * @param description The description.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tsigKeyValue, tsigKeyName, tsigAlgorithm, description);
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Tsig) {
            Tsig that = (Tsig) object;
            return Objects.equal(getTsigKeyValue(), that.getTsigKeyValue()) && Objects.equal(getTsigKeyName(),
                    that.getTsigKeyName()) && Objects.equal(getTsigAlgorithm(), that.getTsigAlgorithm())
                    && Objects.equal(getDescription(), that.getDescription());
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("tsigKeyValue", getTsigKeyValue())
                .add("tsigKeyName", getTsigKeyName())
                .add("tsigAlgorithm", getTsigAlgorithm())
                .add("description", getDescription())
                .toString();
    }

    /**
     * Enum for TSIG algorithms.
     */
    public enum TsigAlgorithm {
        /**
         * Tsig algorithm hmac-md5.
         */
        HMAC_MD5("hmac-md5"),

        /**
         * Tsig algorithm hmac-sha1.
         */
        HMAC_SHA1("hmac-sha1"),

        /**
         * Tsig algorithm hmac-sha224.
         */
        HMAC_SHA224("hmac-sha224"),

        /**
         * Tsig algorithm hmac-sha256.
         */
        HMAC_SHA256("hmac-sha256"),

        /**
         * Tsig algorithm hmac-sha384.
         */
        HMAC_SHA384("hmac-sha384"),

        /**
         * Tsig algorithm hmac-sha512.
         */
        HMAC_SHA512("hmac-sha512");

        private static final List<String> VALID_VALUES = Lists.newArrayList();

        static {
            for (TsigAlgorithm algorithm : values()) {
                VALID_VALUES.add(algorithm.getValue());
            }
        }

        /**
         * Tsig algorithm value.
         */
        private final String value;

        /**
         * Constructor.
         *
         * @param value
         */
        TsigAlgorithm(String value) {
            this.value = value;
        }

        /**
         * Returns corresponding TsigAlgorithm for the given string.
         *
         * @param val String representing tsig algorithm value.
         * @return TsigAlgorithm.
         */
        public static TsigAlgorithm fromVal(String val) {
            for (TsigAlgorithm tsigAlgorithm : values()) {
                if (tsigAlgorithm.getValue().equalsIgnoreCase(val)) {
                    return tsigAlgorithm;
                }
            }
            throw new IllegalArgumentException("Unknown tsig algorithm " + val + " valid values are: " + VALID_VALUES);
        }

        /**
         * Returns current tsig algorithm value.
         *
         * @return String representing tsig algorithm value.
         */
        public String getValue() {
            return value;
        }
    }

}

/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * RR Set.
 *
 * @author nupadhyay
 */
@JsonInclude(Include.NON_DEFAULT)
public class RRSet implements Serializable {

    /**
     * The Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * The domain name of the apex of the zone.
     */
    private String zoneName;
    /**
     * The domain name of the owner of the RRSet.
     */
    private String ownerName;
    /**
     * Resource record type for the RRSet.
     */
    private String rrtype;

    /**
     * The time to live for all records in the rrset.
     */
    private Integer ttl;

    /**
     * The records in the rrset.
     */
    private List<String> rdata = Lists.newLinkedList();

    /**
     * List to maintain the system generated NS records.
     */
    @JsonInclude(Include.NON_EMPTY)
    private List<Boolean> systemGenerated = Lists.newLinkedList();

    /**
     * The rdataguids in the rrsets.
     */
    @JsonInclude(Include.NON_EMPTY)
    private List<String> rdataguids = Lists.newLinkedList();

    /**
     * RRSIG information for the RRSet. Present only for signed zones.
     */
    private List<RRSigs> rrsigs = Lists.newLinkedList();

    /**
     * Profile information for RD Pools.
     */
    private Map<String, Object> profile = Maps.newLinkedHashMap();

    /**
     * Empty constructor.
     */
    public RRSet() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param zoneName  - Zone Name
     * @param ownerName - Owner Name
     * @param rrtype    - RR type
     * @param ttl       - TTL
     * @param rdata     - RR Data
     * @param rrsigs    - {@link RRSigs}
     */
    public RRSet(String zoneName, String ownerName, String rrtype, Integer ttl, List<String> rdata,
            List<RRSigs> rrsigs) {
        super();
        this.zoneName = zoneName;
        this.ownerName = ownerName;
        this.rrtype = rrtype;
        this.ttl = ttl;
        this.rdata = rdata;
        this.rrsigs = rrsigs;
    }

    /**
     * Parameterized constructor.
     *
     * @param zoneName   - Zone Name
     * @param ownerName  - Owner Name
     * @param rrtype     - RR type
     * @param ttl        - TTL
     * @param rdata      - RR Data
     * @param rdataguids - RR Data GUIDs
     * @param rrsigs     - {@link RRSigs}
     */
    public RRSet(String zoneName, String ownerName, String rrtype, Integer ttl, List<String> rdata,
            List<String> rdataguids, List<RRSigs> rrsigs) {
        super();
        this.zoneName = zoneName;
        this.ownerName = ownerName;
        this.rrtype = rrtype;
        this.ttl = ttl;
        this.rdata = rdata;
        this.rdataguids = rdataguids;
        this.rrsigs = rrsigs;
    }

    /**
     * Get zone name.
     *
     * @return the zoneName
     */
    public final String getZoneName() {
        return zoneName;
    }

    /**
     * Set zone name.
     *
     * @param zoneName the zoneName to set
     */
    public final void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    /**
     * Get owner name.
     *
     * @return the ownerName
     */
    public final String getOwnerName() {
        return ownerName;
    }

    /**
     * Set owner name.
     *
     * @param ownerName the ownerName to set
     */
    public final void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Get RR type.
     *
     * @return the rrtype
     */
    public final String getRrtype() {
        return rrtype;
    }

    /**
     * To set RR Type.
     *
     * @param rrtype the rrtype to set
     */
    public final void setRrtype(String rrtype) {
        this.rrtype = rrtype;
    }

    /**
     * Get TTL.
     *
     * @return the ttl
     */
    public final Integer getTtl() {
        return ttl;
    }

    /**
     * Set TTL.
     *
     * @param ttl the ttl to set
     */
    public final void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    /**
     * Set RData.
     *
     * @return the rdata
     */
    public final List<String> getRdata() {
        return rdata;
    }

    /**
     * Get RData.
     *
     * @param rdata the rdata to set
     */
    public final void setRdata(List<String> rdata) {
        this.rdata = rdata;
    }

    public List<String> getRdataguids() {
        return rdataguids;
    }

    public void setRdataguids(List<String> rdataguids) {
        this.rdataguids = rdataguids;
    }

    /**
     * Get rrsigs.
     *
     * @return the rrsigs
     */
    public final List<RRSigs> getRrsigs() {
        return rrsigs;
    }

    /**
     * Set RR rrsigs.
     *
     * @param rrsigs the rrsigs to set
     */
    public final void setRrsigs(List<RRSigs> rrsigs) {
        this.rrsigs = rrsigs;
    }

    /**
     * Get profile.
     *
     * @return the profile
     */
    public final Map<String, Object> getProfile() {
        return profile;
    }

    /**
     * Set profile.
     *
     * @param profile - the profile to set
     */
    public final void setProfile(Map<String, Object> profile) {
        this.profile = profile;
    }

    /**
     * Returns list of boolean values for the records to specify whether the
     * record is system generated or not.
     *
     * @return - list of boolean values.
     */
    public List<Boolean> getSystemGenerated() {
        return systemGenerated;
    }

    /**
     * Set system generated record's boolean value.
     * @param systemGenerated - {@link List<Boolean>}
     */
    public void setSystemGenerated(List<Boolean> systemGenerated) {
        this.systemGenerated = systemGenerated;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ttl", getTtl())
                .add("ownerName", getOwnerName())
                .add("rdata", getRdata())
                .add("rrsigs", getRrsigs())
                .add("rrtype", getRrtype())
                .add("zoneName", getZoneName())
                .add("profile", getProfile())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getZoneName(), getOwnerName(), getRrtype(), getTtl(), getRdata(), getRdataguids(),
                getRrsigs(), getProfile());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof RRSet)) {
            return false;
        }
        final RRSet other = (RRSet) obj;
        isEqual =
                Objects.equal(getZoneName(), other.getZoneName()) && Objects.equal(getOwnerName(), other.getOwnerName())
                        && Objects.equal(getRrtype(), other.getRrtype()) && Objects.equal(getTtl(), other.getTtl())
                        && Objects.equal(getRdata(), other.getRdata()) && Objects.equal(getRdataguids(),
                        other.getRdataguids()) && Objects.equal(getRrsigs(), other.getRrsigs()) && Objects.equal(
                        getProfile(), other.getProfile());
        return isEqual;
    }

    /**
     * RRSIG information for the RRSet.
     *
     * @author nupadhyay
     */
    public static class RRSigs implements Serializable {

        /**
         * Algorithm used for rrsig.
         */
        private int algorithm;
        /**
         * Expiration date/time for rrsig.
         */
        private String expiration;
        /**
         * inception date/time for rrsig.
         */
        private String inception;
        /**
         * Unsigned 16-bit integer in base 10.
         */
        private int keyTag;
        /**
         * Domain name that's signing domain name.
         */
        private String signerName;
        /**
         * Base-64 encoded signature.
         */
        private String signature;

        /**
         * Empty constructor.
         */
        public RRSigs() {
            super();
        }

        /**
         * Parameterized constructor.
         *
         * @param algorithm  - Algorithm
         * @param expiration - Expiration
         * @param inception  - Inception
         * @param keyTag     - Key tag.
         * @param signerName - Signer Name.
         * @param signature  - Signature.
         */
        public RRSigs(int algorithm, String expiration, String inception, int keyTag, String signerName,
                String signature) {
            super();
            this.algorithm = algorithm;
            this.expiration = expiration;
            this.inception = inception;
            this.keyTag = keyTag;
            this.signerName = signerName;
            this.signature = signature;
        }

        /**
         * Get algorithm.
         *
         * @return the algorithm.
         */
        public final int getAlgorithm() {
            return algorithm;
        }

        /**
         * Set algorithm.
         *
         * @param algorithm the algorithm to set
         */
        public final void setAlgorithm(int algorithm) {
            this.algorithm = algorithm;
        }

        /**
         * Get expiration.
         *
         * @return the expiration
         */
        public final String getExpiration() {
            return expiration;
        }

        /**
         * To set expiration.
         *
         * @param expiration the expiration to set
         */
        public final void setExpiration(String expiration) {
            this.expiration = expiration;
        }

        /**
         * Get inception.
         *
         * @return the inception
         */
        public final String getInception() {
            return inception;
        }

        /**
         * Set inception.
         *
         * @param inception the inception to set
         */
        public final void setInception(String inception) {
            this.inception = inception;
        }

        /**
         * Get Key Tag.
         *
         * @return the keyTag
         */
        public final int getKeyTag() {
            return keyTag;
        }

        /**
         * Set key tag.
         *
         * @param keyTag the keyTag to set
         */
        public final void setKeyTag(int keyTag) {
            this.keyTag = keyTag;
        }

        /**
         * Set signer name.
         *
         * @return the signerName
         */
        public final String getSignerName() {
            return signerName;
        }

        /**
         * Get signer name.
         *
         * @param signerName the signerName to set
         */
        public final void setSignerName(String signerName) {
            this.signerName = signerName;
        }

        /**
         * Get signature.
         *
         * @return the signature
         */
        public final String getSignature() {
            return signature;
        }

        /**
         * Set signature.
         *
         * @param signature the signature to set
         */
        public final void setSignature(String signature) {
            this.signature = signature;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
        @Override
        public final String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("algorithm", getAlgorithm())
                    .add("keyTag", getKeyTag())
                    .add("signature", getSignature())
                    .add("signerName", getSignerName())
                    .add("inception", getInception())
                    .add("expiration", getExpiration())
                    .toString();
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public final int hashCode() {
            return Objects.hashCode(getAlgorithm(), getExpiration(), getInception(), getKeyTag(), getSignature(),
                    getSignerName());
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public final boolean equals(final Object obj) {
            boolean isEqual = true;
            if (!(obj instanceof RRSigs)) {
                return false;
            }
            final RRSigs other = (RRSigs) obj;
            isEqual = Objects.equal(getAlgorithm(), other.getAlgorithm()) && Objects.equal(getExpiration(),
                    other.getExpiration()) && Objects.equal(getInception(), other.getInception()) && Objects.equal(
                    getKeyTag(), other.getKeyTag()) && Objects.equal(getSignature(), other.getSignature())
                    && Objects.equal(getSignerName(), other.getSignerName());
            return isEqual;
        }
    }
}

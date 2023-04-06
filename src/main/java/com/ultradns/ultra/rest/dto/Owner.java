/**
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Owner.
 *
 */
public class Owner {

    /**
     * The domain name of the owner of the RRSet.
     */
    private String ownerName;
    /**
     * RR Types. {@link List} of {@link RRTypes}
     */
    private Map<String, RRTypesObject> rrtypes = new HashMap<>();
    /**
     * A list of NSEC3s. Multiple NSEC3s are allowed for key rollover purposes (the salt, in particular, could be
     * changing) {@link List} of {@link Nsec3}
     */
    private List<Nsec3> nsec3s = Lists.newArrayList();

    /**
     * Parameterized  Constructor.
     *
     * @param ownerName - Owner Name.
     * @param rrtypes   - RR types
     * @param nsec3s    - nsec3s
     */
    public Owner(String ownerName, Map<String, RRTypesObject> rrtypes, List<Nsec3> nsec3s) {
        this.ownerName = ownerName;
        this.rrtypes = rrtypes;
        this.nsec3s = nsec3s;
    }

    /**
     * Empty Constructor.
     */
    public Owner() {
        super();
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
     * Get RR types.
     *
     * @return the rrtypes
     */
    public final Map<String, RRTypesObject> getRrtypes() {
        return rrtypes;
    }

    /**
     * Set owner type.
     *
     * @param rrtypes the rrtypes to set
     */
    public final void setRrtypes(Map<String, RRTypesObject> rrtypes) {
        this.rrtypes = rrtypes;
    }

    /**
     * Get nsec3s.
     *
     * @return the nsec3s
     */
    public final List<Nsec3> getNsec3s() {
        return nsec3s;
    }

    /**
     * Set nsec3s.
     *
     * @param nsec3s the nsec3s to set
     */
    public final void setNsec3s(List<Nsec3> nsec3s) {
        this.nsec3s = nsec3s;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("nsec3s", getNsec3s())
                .add("ownerName", getOwnerName())
                .add("rrtypes", getRrtypes())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getNsec3s(), getOwnerName(), getRrtypes());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof Owner)) {
            return false;
        }
        final Owner other = (Owner) obj;
        isEqual = Objects.equal(getNsec3s(), other.getNsec3s()) && Objects.equal(getOwnerName(), other.getOwnerName())
                && Objects.equal(getRrtypes(), other.getRrtypes());
        return isEqual;
    }

    /**
     * RR Types object.
     */
    public static class RRTypesObject {

        /**
         * RRSets.
         */
        private List<RRSet> rrsets = new ArrayList<>();
        /**
         * Profile.
         */
        private Object profile;

        /**
         * Empty construtor.
         */
        public RRTypesObject() {
            super();
        }

        /**
         * Parameterized constructor.
         *
         * @param rrsets  - {@link List} of {@link RRSet}
         * @param profile - An object
         */
        public RRTypesObject(List<RRSet> rrsets, Object profile) {
            super();
            this.rrsets = rrsets;
            this.profile = profile;
        }

        /**
         * Get RRsets.
         *
         * @return the rrsets
         */
        public final List<RRSet> getRrsets() {
            return rrsets;
        }

        /**
         * Set RRSets.
         *
         * @param rrsets the rrsets to set
         */
        public final void setRrsets(List<RRSet> rrsets) {
            this.rrsets = rrsets;
        }

        /**
         * Get profile.
         *
         * @return the profile
         */
        public final Object getProfile() {
            return profile;
        }

        /**
         * Set profile.
         *
         * @param profile the profile to set
         */
        public final void setProfile(Object profile) {
            this.profile = profile;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
        @Override
        public final String toString() {
            return MoreObjects.toStringHelper(this).add("rrsets", getRrsets()).toString();
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public final int hashCode() {
            return Objects.hashCode(getRrsets(), getProfile());
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public final boolean equals(final Object obj) {
            boolean isEqual = true;
            if (!(obj instanceof RRTypesObject)) {
                return false;
            }
            final RRTypesObject other = (RRTypesObject) obj;
            isEqual = Objects.equal(getRrsets(), other.getRrsets()) && Objects.equal(getProfile(), other.getProfile());
            return isEqual;
        }
    }

    /**
     * Present only for a signed domain. The NSEC3 records defined for the owner name.
     */
    public static class Nsec3 {

        /**
         * Algorithm used to generate the hash.
         */
        private int algorithm;
        /**
         * Flags for NSEC3 SeeRFC 5155 for more details.
         */
        private int flags;
        /**
         * Flags for NSEC3 SeeRFC 5155 for more details.
         */
        private int iterations;
        /**
         * Salt.
         */
        private String salt;
        /**
         * Next owner name.
         */
        private String nextOwnerName;

        /**
         * NSec3 Constructor.
         */
        public Nsec3() {
            super();
        }

        /**
         * Parameterized constructor.
         *
         * @param algorithm     - Alogirithm
         * @param flags         - Flags
         * @param iterations    - Interaction
         * @param salt          - Salt
         * @param nextOwnerName - Next Owner Name
         */
        public Nsec3(int algorithm, int flags, int iterations, String salt, String nextOwnerName) {
            super();
            this.algorithm = algorithm;
            this.flags = flags;
            this.iterations = iterations;
            this.salt = salt;
            this.nextOwnerName = nextOwnerName;
        }

        /**
         * Get algorithm.
         *
         * @return the algorithm
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
         * Get flags.
         *
         * @return the flags
         */
        public final int getFlags() {
            return flags;
        }

        /**
         * Set flags.
         *
         * @param flags the flags to set
         */
        public final void setFlags(int flags) {
            this.flags = flags;
        }

        /**
         * Get iterations.
         *
         * @return the iterations
         */
        public final int getIterations() {
            return iterations;
        }

        /**
         * Set iterations.
         *
         * @param iterations the iterations to set
         */
        public final void setIterations(int iterations) {
            this.iterations = iterations;
        }

        /**
         * Get salt.
         *
         * @return the salt
         */
        public final String getSalt() {
            return salt;
        }

        /**
         * Set salt.
         *
         * @param salt the salt to set
         */
        public final void setSalt(String salt) {
            this.salt = salt;
        }

        /**
         * Get next owner name.
         *
         * @return the nextOwnerName
         */
        public final String getNextOwnerName() {
            return nextOwnerName;
        }

        /**
         * Set next owner name.
         *
         * @param nextOwnerName the nextOwnerName to set
         */
        public final void setNextOwnerName(String nextOwnerName) {
            this.nextOwnerName = nextOwnerName;
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
                    .add("flags", getFlags())
                    .add("iterations", getIterations())
                    .add("ownerName", getNextOwnerName())
                    .add("salt", getSalt())
                    .toString();
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public final int hashCode() {
            return Objects.hashCode(getAlgorithm(), getFlags(), getIterations(), getNextOwnerName(), getSalt());
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public final boolean equals(final Object obj) {
            boolean isEqual = true;
            if (!(obj instanceof Nsec3)) {
                return false;
            }
            final Nsec3 other = (Nsec3) obj;
            isEqual = Objects.equal(getAlgorithm(), other.getAlgorithm()) && Objects.equal(getFlags(), other.getFlags())
                    && Objects.equal(getIterations(), other.getIterations()) && Objects.equal(getNextOwnerName(),
                    other.getNextOwnerName()) && Objects.equal(getSalt(), other.getSalt());
            return isEqual;
        }
    }
}

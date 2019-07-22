package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;
import com.google.common.collect.Sets;

import java.util.TreeSet;

@JsonInclude(Include.NON_NULL)
public class GeoInfo {

    /**
     * name of geoInfo group.
     */
    private String name;
    /**
     * True if this ip group is referring to an account-level geo group, false otherwise.
     */
    private boolean isAccountLevel;
    /**
     * The codes for the geographical regions that make up this group.
     */
    @JsonInclude(Include.NON_DEFAULT)
    private TreeSet<String> codes = Sets.newTreeSet();
    /**
     * True if this group is referring to an existing pool geo group, false otherwise.
     */
    private boolean isExistingGroupFromPool;
    /**
     * Force overlapping territories out of existing conflicting local groups.
     */
    private Boolean forceOverlap;

    /**
     * Empty constructor.
     */
    public GeoInfo() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param name                    - {@link GeoInfo#name}
     * @param isAccountLevel          - {@link GeoInfo#isAccountLevel}
     * @param codes                   - {@link GeoInfo#codes}
     * @param isExistingGroupFromPool {@link GeoInfo#isExistingGroupFromPool}
     */
    public GeoInfo(String name, boolean isAccountLevel, TreeSet<String> codes, boolean isExistingGroupFromPool) {
        this(name, isAccountLevel, codes, isExistingGroupFromPool, null);
    }

    /**
     * Parameterized constructor.
     *
     * @param name                    - {@link GeoInfo#name}
     * @param isAccountLevel          - {@link GeoInfo#isAccountLevel}
     * @param codes                   - {@link GeoInfo#codes}
     * @param isExistingGroupFromPool {@link GeoInfo#isExistingGroupFromPool}
     * @param forceOverlap            {@link GeoInfo#forceOverlap}
     */
    public GeoInfo(String name, boolean isAccountLevel, TreeSet<String> codes, boolean isExistingGroupFromPool,
            Boolean forceOverlap) {
        super();
        this.name = name;
        this.isAccountLevel = isAccountLevel;
        this.codes = codes;
        this.isExistingGroupFromPool = isExistingGroupFromPool;
        this.forceOverlap = forceOverlap;
    }

    /**
     * Get name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Set name.
     *
     * @param name the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    public boolean isIsAccountLevel() {
        return isAccountLevel;
    }

    public void setIsAccountLevel(boolean isAccountLevel) {
        this.isAccountLevel = isAccountLevel;
    }

    /**
     * Get codes.
     *
     * @return the codes
     */
    public final TreeSet<String> getCodes() {
        return codes;
    }

    /**
     * Set codes.
     *
     * @param codes the codes to set
     */
    public final void setCodes(TreeSet<String> codes) {
        this.codes = codes;
    }

    public boolean isIsExistingGroupFromPool() {
        return isExistingGroupFromPool;
    }

    public void setIsExistingGroupFromPool(boolean isExistingGroupFromPool) {
        this.isExistingGroupFromPool = isExistingGroupFromPool;
    }

    public Boolean isForceOverlap() {
        return forceOverlap;
    }

    public void setForceOverlap(Boolean forceOverlap) {
        this.forceOverlap = forceOverlap;
    }

    @Override
    public String toString() {
        return "GeoInfo{" + "name='" + name + '\'' + ", isAccountLevel=" + isAccountLevel + ", codes=" + codes
                + ", isExistingGroupFromPool=" + isExistingGroupFromPool + ", forceOverlap=" + forceOverlap + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GeoInfo geoInfo = (GeoInfo) o;
        return isAccountLevel == geoInfo.isAccountLevel && isExistingGroupFromPool == geoInfo.isExistingGroupFromPool
                && Objects.equal(forceOverlap, geoInfo.forceOverlap) && Objects.equal(name, geoInfo.name)
                && Objects.equal(codes, geoInfo.codes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, isAccountLevel, codes, isExistingGroupFromPool, forceOverlap);
    }
}

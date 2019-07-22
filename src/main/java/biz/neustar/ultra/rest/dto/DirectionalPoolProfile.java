/**
 *
 */
package biz.neustar.ultra.rest.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Directional Pool Profile Dto.
 *
 * @author ankitm.agarwal
 */
public class DirectionalPoolProfile implements Profile {

    /**
     * An optional description of the DIR pool.
     */
    private String description;

    /**
     * Which should take precedence when there is a conflict between a matching geo group and a matching ip group.
     */
    private ConflictResolve conflictResolve;

    /**
     * One entry for each entry in rdata. The order of the rdata entries matches with the order of the rdataInfo
     * entries.
     */
    private List<RDataInfo> rDataInfo = Lists.newLinkedList();

    /**
     * Allows a user to specify certain geographical regions and IP address that will get a no response if they try to
     * access the directional pool.
     */
    private RDataInfo noResponse;

    /**
     * For ECS flag.
     */
    private Boolean ignoreECS = null;

    /**
     * Empty constructor.
     */
    public DirectionalPoolProfile() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param description     - An optional description of the DIR pool.
     * @param conflictResolve - Which should take precedence when there is a conflict between a matching geo group and a
     *                        matching ip group.
     * @param rDataInfo       - Allows a user to specify certain geographical regions and IP address that will get a no
     *                        response if they try to access the directional pool.
     * @param noResponse      - Allows a user to specify certain geographical regions and IP address that will get a no
     *                        response if they try to access the directional pool.
     */
    public DirectionalPoolProfile(String description, ConflictResolve conflictResolve, List<RDataInfo> rDataInfo,
            RDataInfo noResponse) {
        super();
        this.description = description;
        this.conflictResolve = conflictResolve;
        this.rDataInfo = rDataInfo;
        this.noResponse = noResponse;
    }

    /**
     * Getter for ECS flag.
     *
     * @return
     */
    public Boolean getIgnoreECS() {
        return ignoreECS;
    }

    /**
     * Setter for ECS flag.
     *
     * @param ignoreECS
     */
    public void setIgnoreECS(Boolean ignoreECS) {
        this.ignoreECS = ignoreECS;
    }

    /**
     * To get description.
     *
     * @return the description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * to set description.
     *
     * @param description the description to set
     */
    public final void setDescription(String description) {
        this.description = description;
    }

    /**
     * get conflictResolve.
     *
     * @return the conflictResolve
     */
    public final ConflictResolve getConflictResolve() {
        return conflictResolve;
    }

    /**
     * set conflictResolve.
     *
     * @param conflictResolve the conflictResolve to set
     */
    public final void setConflictResolve(ConflictResolve conflictResolve) {
        this.conflictResolve = conflictResolve;
    }

    /**
     * get RdataInfo List.
     *
     * @return the list
     */
    public final List<RDataInfo> getRDataInfo() {
        return rDataInfo;
    }

    /**
     * set RdataInfoList.
     *
     * @param rDataInfo the list to set
     */
    public final void setRDataInfo(List<RDataInfo> arg0) {
        this.rDataInfo = arg0;
    }

    /**
     * Get NoResponse.
     *
     * @return the noResponse
     */
    public final RDataInfo getNoResponse() {
        return noResponse;
    }

    /**
     * set NoResponse.
     *
     * @param noResponse the noResponse to set
     */
    public final void setNoResponse(RDataInfo noResponse) {
        this.noResponse = noResponse;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("description", getDescription())
                .add("conflictResolve", getConflictResolve())
                .add("rDataInfo", getRDataInfo())
                .add("noResponse", getNoResponse())
                .add("ignoreECS", getIgnoreECS())
                .toString();

    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getDescription(), getConflictResolve(), getRDataInfo(), getNoResponse(),
                getIgnoreECS());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof DirectionalPoolProfile)) {
            return false;
        }
        final DirectionalPoolProfile other = (DirectionalPoolProfile) obj;
        return Objects.equal(getDescription(), other.getDescription()) && Objects.equal(getConflictResolve(),
                other.getConflictResolve()) && Objects.equal(getRDataInfo(), other.getRDataInfo()) && Objects.equal(
                getNoResponse(), other.getNoResponse()) && Objects.equal(getIgnoreECS(), other.getIgnoreECS());
    }

    /**
     * ConflictResolve type.
     *
     * @author ankitm.agarwal
     */
    public enum ConflictResolve {
        GEO,
        IP
    }
}

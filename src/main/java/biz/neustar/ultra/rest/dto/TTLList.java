package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * TTL list DTO.
 */
@JsonInclude(Include.NON_NULL)
public class TTLList {

    /**
     * {@link List} of {@link TTL}.
     */
    private List<TTL> ttls = Lists.newLinkedList();

    /**
     * Default constructor.
     */
    public TTLList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param ttls       - {@link TTLList#list}
     * @param queryInfo  - {@link TTLList#queryInfo}
     * @param resultInfo - - {@link TTLList#resultInfo}
     */
    public TTLList(List<TTL> ttls) {
        this.ttls = ttls;
    }

    public List<TTL> getTtls() {
        return ttls;
    }

    public void setTtls(List<TTL> ttls) {
        this.ttls = ttls;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof TTLList)) {
            return false;
        }
        final TTLList other = (TTLList) obj;
        isEqual = Objects.equal(getTtls(), other.getTtls());
        return isEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getTtls());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("ttls", getTtls()).toString();
    }
}

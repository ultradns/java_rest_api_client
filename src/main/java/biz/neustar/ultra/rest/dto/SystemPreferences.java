package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonInclude(Include.NON_NULL)
public class SystemPreferences {

    /**
     * True if PTR records should be auto-created when A records are created, false otherwise.
     */
    private boolean autoCreatePTR;

    /**
     * Empty Constructor.
     */
    public SystemPreferences() {
        super();
    }

    public SystemPreferences(boolean autoCreatePTR) {
        super();
        this.setAutoCreatePTR(autoCreatePTR);
    }

    /**
     * Get Auto Ptr Value.
     *
     * @return the autoCreatePTR
     */
    public final boolean isAutoCreatePTR() {
        return autoCreatePTR;
    }

    /**
     * Set Auto Ptr value.
     *
     * @param autoCreatePTR the autoCreatePTR to set
     */
    public final void setAutoCreatePTR(boolean autoCreatePTR) {
        this.autoCreatePTR = autoCreatePTR;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("autoCreatePTR", isAutoCreatePTR()).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(isAutoCreatePTR());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof SystemPreferences)) {
            return false;
        }
        final SystemPreferences other = (SystemPreferences) obj;
        isEqual = Objects.equal(isAutoCreatePTR(), other.isAutoCreatePTR());
        return isEqual;
    }
}

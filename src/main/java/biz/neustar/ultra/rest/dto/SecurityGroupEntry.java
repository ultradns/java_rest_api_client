package biz.neustar.ultra.rest.dto;

import biz.neustar.ultra.rest.constants.SecurityGroupEntryPermission;
import biz.neustar.ultra.rest.constants.SecurityGroupEntryType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

/**
 * The Class SecurityGroupEntry.
 */
@JsonInclude(Include.NON_NULL)
public class SecurityGroupEntry {

    /**
     * The type.
     */
    private SecurityGroupEntryType type;

    /**
     * The permission.
     */
    private SecurityGroupEntryPermission permission;

    /**
     * The inherited value.
     */
    private SecurityExceptionPermission inheritedValue;

    /**
     * Instantiates a new security group entry.
     *
     * @param type           the type
     * @param permission     the permission
     * @param inheritedValue the inherited value
     */
    public SecurityGroupEntry(SecurityGroupEntryType type, SecurityGroupEntryPermission permission,
            SecurityExceptionPermission inheritedValue) {
        super();
        this.type = type;
        this.permission = permission;
        this.inheritedValue = inheritedValue;
    }

    /**
     * Instantiates a new security group entry.
     */
    public SecurityGroupEntry() {
        super();
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public SecurityGroupEntryType getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(SecurityGroupEntryType type) {
        this.type = type;
    }

    /**
     * Gets the permission.
     *
     * @return the permission
     */
    public SecurityGroupEntryPermission getPermission() {
        return permission;
    }

    /**
     * Sets the permission.
     *
     * @param permission the new permission
     */
    public void setPermission(SecurityGroupEntryPermission permission) {
        this.permission = permission;
    }

    /**
     * Gets the inherited value.
     *
     * @return the inherited value
     */
    public SecurityExceptionPermission getInheritedValue() {
        return inheritedValue;
    }

    /**
     * Sets the inherited value.
     *
     * @param inheritedValue the new inherited value
     */
    public void setInheritedValue(SecurityExceptionPermission inheritedValue) {
        this.inheritedValue = inheritedValue;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getInheritedValue(), getPermission(), getType());
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof SecurityGroupEntry)) {
            return false;
        }
        final SecurityGroupEntry other = (SecurityGroupEntry) obj;
        isEqual = Objects.equal(getInheritedValue(), other.getInheritedValue()) && Objects.equal(getPermission(),
                other.getPermission()) && Objects.equal(getType(), other.getType());
        return isEqual;
    }

    @Override
    public String toString() {
        return "SecurityGroupEntry [type=" + type + ", permission=" + permission + ", inheritedValue=" + inheritedValue
                + "]";
    }

}

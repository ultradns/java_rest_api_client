package biz.neustar.ultra.rest.dto;

import biz.neustar.ultra.rest.constants.SecurityExceptionAssetType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

import java.util.List;

/**
 * The Class SecurityExceptionInfo.
 */
@JsonInclude(Include.NON_NULL)
public class SecurityExceptionInfo {

    /**
     * The group name.
     */
    private String groupName;

    /**
     * The type.
     */
    private SecurityExceptionAssetType type;

    /**
     * The name.
     */
    private String name;

    /**
     * The permission.
     */
    private SecurityExceptionPermission permission;

    private List<String> rdata;

    private String rrtype;

    /**
     * Instantiates a new security exception info.
     *
     * @param groupName  the group name
     * @param type       the type
     * @param name       the name
     * @param permission the permission
     * @param rdata      the rdata
     * @param rrtype     the rrtype
     */
    public SecurityExceptionInfo(String groupName, SecurityExceptionAssetType type, String name,
            SecurityExceptionPermission permission, List<String> rdata, String rrtype) {
        super();
        this.groupName = groupName;
        this.type = type;
        this.name = name;
        this.permission = permission;
        this.rdata = rdata;
        this.rrtype = rrtype;
    }

    /**
     * Instantiates a new security exception.
     */
    public SecurityExceptionInfo() {
        super();
    }

    /**
     * Gets the group name.
     *
     * @return the group name
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the group name.
     *
     * @param groupName the new group name
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public SecurityExceptionAssetType getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(SecurityExceptionAssetType type) {
        this.type = type;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the permission.
     *
     * @return the permission
     */
    public SecurityExceptionPermission getPermission() {
        return permission;
    }

    /**
     * Sets the permission.
     *
     * @param permission the new permission
     */
    public void setPermission(SecurityExceptionPermission permission) {
        this.permission = permission;
    }

    /**
     * Gets the rdata.
     *
     * @return the rdata
     */
    public List<String> getRdata() {
        return rdata;
    }

    /**
     * Sets the rdata.
     *
     * @param rdata the new rdata
     */
    public void setRdata(List<String> rdata) {
        this.rdata = rdata;
    }

    /**
     * Gets the rrtype.
     *
     * @return the rrtype
     */
    public String getRrtype() {
        return rrtype;
    }

    /**
     * Sets the rrtype.
     *
     * @param rrtype the new rrtype
     */
    public void setRrtype(String rrtype) {
        this.rrtype = rrtype;
    }

    @Override
    public String toString() {
        return "SecurityExceptionInfo [groupName=" + groupName + ", type=" + type + ", name=" + name + ", permission="
                + permission + ", rdata=" + rdata + ", rrtype=" + rrtype + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getGroupName(), getName(), getPermission(), getType(), getRdata(), getRrtype());
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof SecurityExceptionInfo)) {
            return false;
        }
        final SecurityExceptionInfo other = (SecurityExceptionInfo) obj;
        isEqual = Objects.equal(getGroupName(), other.getGroupName()) && Objects.equal(getName(), other.getName())
                && Objects.equal(getPermission(), other.getPermission()) && Objects.equal(getType(), other.getType())
                && Objects.equal(getRdata(), other.getRdata()) && Objects.equal(getRrtype(), other.getRrtype());
        return isEqual;
    }

}

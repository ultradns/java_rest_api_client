package biz.neustar.ultra.rest.dto;

/**
 * Copyright 2000-2018 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */

import biz.neustar.ultra.rest.constants.PermissionLevel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

/**
 * Account permission entry details DTO.
 *
 */
@JsonInclude(Include.NON_NULL)
public class AccountPermissionEntry implements Comparable<AccountPermissionEntry> {

    /**
     * The type of the asset.
     */
    private String type;

    /**
     * The permission which is being applied to the type.
     */
    private PermissionLevel permission;

    /**
     * Empty constructor.
     */
    public AccountPermissionEntry() {
        super();
    }

    /**
     * Parameterized constructor for AccountPermissionEntry.
     *
     * @param type
     *            - Type
     * @param permission
     *            - Permission
     */
    public AccountPermissionEntry(String type, PermissionLevel permission) {

        this.type = type;
        this.permission = permission;
    }

    /**
     * Get the type of asset.
     *
     * @return type - Type of asset.
     */
    public String getType() {
        return type;
    }

    /**
     * Get the type of asset.
     *
     * @param type
     *            - Type of asset.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the permission.
     *
     * @return permission - Permission
     */
    public PermissionLevel getPermission() {
        return permission;
    }

    /**
     * Set the permission.
     *
     * @param permission
     *            - Permission
     */
    public void setPermission(PermissionLevel permission) {
        this.permission = permission;
    }

    /**
     * Overridden toString method.
     *
     * @return string - String value.
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("type", getType()).add("permission", getPermission()).toString();
    }

    /**
     * Overridden equals method.
     *
     * @param obj
     *            - Object
     * @return boolean - Boolean value.
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof AccountPermissionEntry)) {
            return false;
        }
        final AccountPermissionEntry other = (AccountPermissionEntry) obj;
        isEqual = Objects.equal(getType(), other.getType()) && Objects.equal(getPermission(), other.getPermission());
        return isEqual;
    }

    /**
     * Overridden hash code method.
     *
     * @return int - Hash value
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getType(), getPermission());
    }

    /**
     * Compares on the basis of type.
     *
     * @param permissionEntry
     *            - Account Permission Entry
     * @return int - Integer value
     */
    @Override
    public int compareTo(AccountPermissionEntry permissionEntry) {

        return ComparisonChain.start().compare(type, permissionEntry.getType())
                .compare(permission, permissionEntry.getPermission()).result();
    }

}

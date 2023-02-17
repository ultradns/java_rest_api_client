package com.ultradns.ultra.rest.dto;

/**
 * Copyright 2000-2018 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

/**
 * Account and its permission details DTO.
 *
 */
@JsonInclude(Include.NON_NULL)
public class AccountPermission {

    /**
     * The name of the account.
     */
    private String accountName;

    /**
     * List of permissions in the account.
     */
    private List<AccountPermissionEntry> entries;

    /**
     * Empty constructor.
     */
    public AccountPermission() {
        super();
    }

    /**
     * Get account name.
     *
     * @return accountName - account name.
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Set account name.
     *
     * @param accountName
     *            - account name.
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Set permission entries.
     *
     * @return entries - AccountPermissionEntry List.
     */
    public List<AccountPermissionEntry> getEntries() {
        return entries;
    }

    /**
     * Get permission entries.
     *
     * @param entries
     *            - AccountPermissionEntry List.
     */
    public void setEntries(List<AccountPermissionEntry> entries) {
        this.entries = entries;
    }

    /**
     * Overridden toString method.
     *
     * @return string - String value.
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("accountName", getAccountName())
                .add("permissionsEntry", getEntries()).toString();
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
        if (!(obj instanceof AccountPermission)) {
            return false;
        }
        final AccountPermission other = (AccountPermission) obj;
        return Objects.equal(getAccountName(), other.getAccountName())
                && Objects.equal(getEntries(), other.getEntries());
    }

    /**
     * Overridden hash code method.
     *
     * @return int - Hash value
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getAccountName(), getEntries());
    }
}

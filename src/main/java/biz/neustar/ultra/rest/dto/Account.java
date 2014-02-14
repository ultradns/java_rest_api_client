/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

/**
 * Account DTO.
 * 
 */
@JsonInclude(Include.NON_NULL)
public class Account {
    /**
     *Name of the account. 
     */
    private String accountName;
    /**
     * User name for the account holder.
     */
    private String accountHolderUserName;
    /**
     *  User name of the owner (primary user). 
     */
    private String ownerUserName;
    /**
     * User count for account. 
     */
    private int numberOfUsers;
    /**
     *  Group count for account. 
     */
    private int numberOfGroups;
    /**
     * Type of the account. 
     */
    private AccountType accountType;

    /**
    * Empty constructor.
    */
    public Account() {
        super();
    }

    /**
     * Parameterized constructor.
     * @param accountName - {@link Account#accountName}
     * @param accountHolderUserName - {@link Account#accountHolderUserName}
     * @param ownerUserName -  {@link Account#ownerUserName}
     * @param numberOfUsers - {@link Account#numberOfUsers}
     * @param numberOfGroups - {@link Account#numberOfGroups}
     * @param accountType - {@link Account#accountType}
     */
    public Account(String accountName, String accountHolderUserName, String ownerUserName, int numberOfUsers,
                   int numberOfGroups, AccountType accountType) {
        super();
        this.accountName = accountName;
        this.accountHolderUserName = accountHolderUserName;
        this.ownerUserName = ownerUserName;
        this.numberOfUsers = numberOfUsers;
        this.numberOfGroups = numberOfGroups;
        this.accountType = accountType;
    }

    /**
     * Get account name.
     * @return the accountName
     */
    public final String getAccountName() {
        return accountName;
    }

    /**
     * Set account name.
     * @param accountName
     *            the accountName to set
     */
    public final void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Get account holder user name.
     * @return the accountHolderUserName
     */
    public final String getAccountHolderUserName() {
        return accountHolderUserName;
    }

    /**
     * Set account holder user name.
     * @param accountHolderUserName
     *            the accountHolderUserName to set
     */
    public final void setAccountHolderUserName(String accountHolderUserName) {
        this.accountHolderUserName = accountHolderUserName;
    }

    /**
     * Get owner user name.
     * @return the ownerUserName
     */
    public final String getOwnerUserName() {
        return ownerUserName;
    }

    /**
     * Set owner user name.
     * @param ownerUserName
     *            the ownerUserName to set
     */
    public final void setOwnerUserName(String ownerUserName) {
        this.ownerUserName = ownerUserName;
    }

    /**
     * Get numbers of users.
     * @return the numberOfUsers
     */
    public final int getNumberOfUsers() {
        return numberOfUsers;
    }

    /**
     * Set numbers of users.
     * @param numberOfUsers
     *            the numberOfUsers to set
     */
    public final void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    /**
     * Get number of groups.
     * @return the numberOfGroups
     */
    public final int getNumberOfGroups() {
        return numberOfGroups;
    }

    /**
     * Set number of groups.
     * @param numberOfGroups
     *            the numberOfGroups to set
     */
    public final void setNumberOfGroups(int numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
    }

    /**
     * Get account type.
     * @return the accountType
     */
    public final AccountType getAccountType() {
        return accountType;
    }

    /**
     * Set account type.
     * @param accountType
     *            the accountType to set
     */
    public final void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return Objects.toStringHelper(this).add("accountName", getAccountName())
                .add("accountHolderUserName", getAccountHolderUserName())
                .add("ownerUserName", getOwnerUserName())
                .add("numberOfUsers", getNumberOfUsers())
                .add("numberOfGroups", getNumberOfGroups())
                .add("accountType", getAccountType())
                .toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getAccountName(), getAccountHolderUserName(), getOwnerUserName());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof Account)) {
            return false;
        }
        final Account other = (Account) obj;
        isEqual = Objects.equal(getAccountName(), other.getAccountName())
                && Objects.equal(getAccountHolderUserName(), other.getAccountHolderUserName())
                && Objects.equal(getOwnerUserName(), other.getOwnerUserName());
        return isEqual;
    }
    
    /**
     * Account Type.
     *
     */
    public static enum AccountType {
        INDIVIDUAL("I"), ORGANIZATION("O");
        private String value;

        private AccountType(String value) {
            this.value = value;
        }

        public static AccountType getAccountType(final String accountTypeStr) {
            if (accountTypeStr.equalsIgnoreCase(AccountType.INDIVIDUAL.value)) {
                return AccountType.INDIVIDUAL;
            } else if (accountTypeStr.equalsIgnoreCase(AccountType.ORGANIZATION.value)) {
                return AccountType.ORGANIZATION;
            }
            throw new IllegalArgumentException();
        }
    };
}

/**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;
import java.util.TreeSet;

/**
 * Account DTO.
 */
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("PMD.TooManyFields")
public class Account {
    /**
     * Name of the account.
     */
    private String accountName;
    /**
     * Account Id of the account.
     */
    private String guid;
    /**
     * User name for the account holder.
     */
    private String accountHolderUserName;
    /**
     * User name of the owner (primary user).
     */
    private String ownerUserName;
    /**
     * Address of the owner (primary user).
     */
    private Address ownerAddress;
    /**
     * User count for account.
     */
    private int numberOfUsers;
    /**
     * Group count for account.
     */
    private int numberOfGroups;
    /**
     * Type of the account.
     */
    private AccountType accountType;
    /**
     * The short name of the account.
     */
    private String accountId;
    /**
     * Status of the account.
     * <p>
     * One of: ACTIVE, SUSPENDED.
     */
    private Status status;
    /**
     * Date the account was created in ISO 8601 format.
     */
    private String created;
    /**
     * The default value used for the SOA email address in newly created zones. If null, not present.
     */
    private String defaultSOAEmail;
    /**
     * List of IP restrictions that apply for all users in the account.
     */
    private List<RestrictAccessIP> restrictAccessIPs;
    /**
     * List of features for the account.
     */
    private TreeSet<String> features;

    /**
     * Address information of account holder.
     */
    private Address accountHolderAddress;

    /**
     * Account Name Servers List.
     */
    private List<AccountNameServer> accountNameServers;

    /**
     * Usage limits.
     */
    private UsageLimits usageLimits;

    /**
     * Empty constructor.
     */
    public Account() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param accountName           - {@link Account#accountName}
     * @param accountHolderUserName - {@link Account#accountHolderUserName}
     * @param ownerUserName         -  {@link Account#ownerUserName}
     * @param numberOfUsers         - {@link Account#numberOfUsers}
     * @param numberOfGroups        - {@link Account#numberOfGroups}
     * @param accountType           - {@link Account#accountType}
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
     * Parameterized constructor.
     *
     * @param accountName
     * @param accountHolderUserName
     * @param ownerUserName
     * @param ownerAddress
     * @param numberOfUsers
     * @param numberOfGroups
     * @param accountType
     * @param accountId
     * @param status
     * @param defaultSOAEmail
     * @param restrictAccessIPs
     * @param features
     * @param accountHolderAddress
     * @param accountNameServers
     * @param usageLimits
     */
    @SuppressWarnings("PMD.ExcessiveParameterList")
    public Account(String accountName, String accountHolderUserName, String ownerUserName, Address ownerAddress,
            int numberOfUsers, int numberOfGroups, AccountType accountType, String accountId, Status status,
            String defaultSOAEmail, List<RestrictAccessIP> restrictAccessIPs, TreeSet<String> features,
            Address accountHolderAddress, List<AccountNameServer> accountNameServers, UsageLimits usageLimits) {
        this.accountName = accountName;
        this.accountHolderUserName = accountHolderUserName;
        this.ownerUserName = ownerUserName;
        this.ownerAddress = ownerAddress;
        this.numberOfUsers = numberOfUsers;
        this.numberOfGroups = numberOfGroups;
        this.accountType = accountType;
        this.accountId = accountId;
        this.status = status;
        this.defaultSOAEmail = defaultSOAEmail;
        this.restrictAccessIPs = restrictAccessIPs;
        this.features = features;
        this.accountHolderAddress = accountHolderAddress;
        this.accountNameServers = accountNameServers;
        this.usageLimits = usageLimits;
    }

    /**
     * Get account name.
     *
     * @return the accountName
     */
    public final String getAccountName() {
        return accountName;
    }

    /**
     * Set account name.
     *
     * @param accountName the accountName to set
     */
    public final void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Get the account id.
     * @return the guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Set the account id.
     * @param guid the guid to set
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }
    /**
     * Get account holder user name.
     *
     * @return the accountHolderUserName
     */
    public final String getAccountHolderUserName() {
        return accountHolderUserName;
    }

    /**
     * Set account holder user name.
     *
     * @param accountHolderUserName the accountHolderUserName to set
     */
    public final void setAccountHolderUserName(String accountHolderUserName) {
        this.accountHolderUserName = accountHolderUserName;
    }

    /**
     * Get owner user name.
     *
     * @return the ownerUserName
     */
    public final String getOwnerUserName() {
        return ownerUserName;
    }

    /**
     * Set owner user name.
     *
     * @param ownerUserName the ownerUserName to set
     */
    public final void setOwnerUserName(String ownerUserName) {
        this.ownerUserName = ownerUserName;
    }

    /**
     * Get numbers of users.
     *
     * @return the numberOfUsers
     */
    public final int getNumberOfUsers() {
        return numberOfUsers;
    }

    /**
     * Set numbers of users.
     *
     * @param numberOfUsers the numberOfUsers to set
     */
    public final void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    /**
     * Get number of groups.
     *
     * @return the numberOfGroups
     */
    public final int getNumberOfGroups() {
        return numberOfGroups;
    }

    /**
     * Set number of groups.
     *
     * @param numberOfGroups the numberOfGroups to set
     */
    public final void setNumberOfGroups(int numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
    }

    /**
     * Get account type.
     *
     * @return the accountType
     */
    public final AccountType getAccountType() {
        return accountType;
    }

    /**
     * Set account type.
     *
     * @param accountType the accountType to set
     */
    public final void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Address getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(Address ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDefaultSOAEmail() {
        return defaultSOAEmail;
    }

    public void setDefaultSOAEmail(String defaultSOAEmail) {
        this.defaultSOAEmail = defaultSOAEmail;
    }

    public List<RestrictAccessIP> getRestrictAccessIPs() {
        return restrictAccessIPs;
    }

    public void setRestrictAccessIPs(List<RestrictAccessIP> restrictAccessIPs) {
        this.restrictAccessIPs = restrictAccessIPs;
    }

    public TreeSet<String> getFeatures() {
        return features;
    }

    public void setFeatures(TreeSet<String> features) {
        this.features = features;
    }

    public Address getAccountHolderAddress() {
        return accountHolderAddress;
    }

    public void setAccountHolderAddress(Address accountHolderAddress) {
        this.accountHolderAddress = accountHolderAddress;
    }

    public List<AccountNameServer> getAccountNameServers() {
        return accountNameServers;
    }

    public void setAccountNameServers(List<AccountNameServer> accountNameServers) {
        this.accountNameServers = accountNameServers;
    }


    public UsageLimits getUsageLimits() {
        return usageLimits;
    }

    public void setUsageLimits(UsageLimits usageLimits) {
        this.usageLimits = usageLimits;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("accountName", getAccountName())
                .add("guid", getGuid())
                .add("accountHolderUserName", getAccountHolderUserName())
                .add("ownerUserName", getOwnerUserName())
                .add("ownerAddress", getOwnerAddress())
                .add("numberOfUsers", getNumberOfUsers())
                .add("numberOfGroups", getNumberOfGroups())
                .add("accountType", getAccountType())
                .add("accountId", getAccountId())
                .add("status", getStatus())
                .add("created", getCreated())
                .add("defaultSOAEmail", getDefaultSOAEmail())
                .add("restrictAccessIPs", getRestrictAccessIPs())
                .add("features", getFeatures())
                .add("accountHolderAddress", getAccountHolderAddress())
                .add("accountNameServers", getAccountNameServers())
                .add("usageLimits", getUsageLimits())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getAccountName(), getGuid(), getAccountHolderUserName(), getOwnerUserName(),
                getOwnerAddress(), getNumberOfUsers(), getNumberOfGroups(), getAccountType(), getAccountId(),
                getStatus(), getDefaultSOAEmail(), getRestrictAccessIPs(), getFeatures(), getAccountHolderAddress(),
                getAccountNameServers(), getUsageLimits());
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
        isEqual = Objects.equal(getAccountName(), other.getAccountName()) && Objects.equal(getGuid(), other.getGuid())
                && Objects.equal(getAccountHolderUserName(), other.getAccountHolderUserName())
                && Objects.equal(getOwnerUserName(), other.getOwnerUserName())
                && Objects.equal(getOwnerAddress(), other.getOwnerAddress())
                && Objects.equal(getNumberOfUsers(), other.getNumberOfUsers())
                && Objects.equal(getAccountType(), other.getAccountType())
                && Objects.equal(getAccountId(), other.getAccountId()) && Objects.equal(getStatus(), other.getStatus())
                && Objects.equal(getDefaultSOAEmail(), other.getDefaultSOAEmail())
                && Objects.equal(getRestrictAccessIPs(), other.getRestrictAccessIPs())
                && Objects.equal(getFeatures(), other.getFeatures())
                && Objects.equal(getAccountHolderAddress(), other.getAccountHolderAddress())
                && Objects.equal(getAccountNameServers(), other.getAccountNameServers())
                && Objects.equal(getUsageLimits(), other.getUsageLimits());
        return isEqual;
    }

    /**
     * Account Type.
     */
    public enum AccountType {
        INDIVIDUAL("I"),
        ORGANIZATION("O");
        private String value;

        AccountType(String value) {
            this.value = value;
        }

        public static AccountType getAccountType(final String accountTypeStr) {
            if (AccountType.INDIVIDUAL.value.equalsIgnoreCase(accountTypeStr)) {
                return AccountType.INDIVIDUAL;
            } else if (AccountType.ORGANIZATION.value.equalsIgnoreCase(accountTypeStr)) {
                return AccountType.ORGANIZATION;
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Status {
        ACTIVE,
        SUSPENDED;
    }
}

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

/**
 * User DTO.
 */
@JsonInclude(Include.NON_NULL)
public class User {
    /**
     * User name in UltraDNS system.
     */
    private String userName;
    /**
     * User's given name.
     */
    private String firstName;
    /**
     * User's family name.
     */
    private String lastName;

    /**
     * Default contructor.
     */
    public User() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param userName  - {@link User#userName}
     * @param firstName - {@link User#firstName}
     * @param lastName  - {@link User#lastName}
     */
    public User(String userName, String firstName, String lastName) {
        super();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Get user name.
     *
     * @return the userName
     */
    public final String getUserName() {
        return userName;
    }

    /**
     * Set user name.
     *
     * @param userName the userName to set
     */
    public final void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get first name.
     *
     * @return the firstName
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * Set first name.
     *
     * @param firstName the firstName to set
     */
    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get last name.
     *
     * @return the lastName
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * Set last name.
     *
     * @param lastName the lastName to set
     */
    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("userName", getUserName())
                .add("firstName", getFirstName())
                .add("lastName", getLastName())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(getUserName(), getFirstName(), getLastName());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof User)) {
            return false;
        }
        final User other = (User) obj;
        isEqual =
                Objects.equal(getUserName(), other.getUserName()) && Objects.equal(getFirstName(), other.getFirstName())
                        && Objects.equal(getLastName(), other.getLastName());
        return isEqual;
    }
}

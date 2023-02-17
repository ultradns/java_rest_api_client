/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Address DTO.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

    /**
     * First line of address.
     */
    private String address1;

    /**
     * Second line of address.
     * <p>
     * Optional.
     */
    private String address2;

    /**
     * Country.
     * <p>
     * Validated using the ISO-3166-1 three-letter codes for country.
     */
    private String country;

    /**
     * State or province.
     * <p>
     * Optional outside of the US and Canada. Validated using the ISO-3166-2:US standard for US states and territories,
     * and the ISO-3166-2:CA standard for Canadian provinces and territories. Not validated for other countries.
     */
    private String state;

    /**
     * City.
     */
    private String city;

    /**
     * Zip/postal code.
     * <p>
     * Optional.
     */
    private String zip;

    public Address() {
        super();
    }

    /**
     * Parameterized constructor.
     */
    public Address(String address1, String address2, String country, String state, String city, String zip) {
        super();
        this.address1 = address1;
        this.address2 = address2;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zip = zip;
    }

    /**
     * Get address1.
     *
     * @return the address1
     */
    public final String getAddress1() {
        return address1;
    }

    /**
     * Set address1.
     *
     * @param address1 the address1 to set
     */
    public final void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * Get address2.
     *
     * @return the address2
     */
    public final String getAddress2() {
        return address2;
    }

    /**
     * Set address2.
     *
     * @param address2 the address2 to set
     */
    public final void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * Get country.
     *
     * @return the country
     */
    public final String getCountry() {
        return country;
    }

    /**
     * Set country.
     *
     * @param country the country to set
     */
    public final void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get state.
     *
     * @return the state
     */
    public final String getState() {
        return state;
    }

    /**
     * Set state.
     *
     * @param state the state to set
     */
    public final void setState(String state) {
        this.state = state;
    }

    /**
     * Get city.
     *
     * @return the city
     */
    public final String getCity() {
        return city;
    }

    /**
     * Set city.
     *
     * @param city the city to set
     */
    public final void setCity(String city) {
        this.city = city;
    }

    /**
     * Get zip.
     *
     * @return the zip
     */
    public final String getZip() {
        return zip;
    }

    /**
     * Set zip.
     *
     * @param zip the zip to set
     */
    public final void setZip(String zip) {
        this.zip = zip;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("address1", getAddress1())
                .add("address2", getAddress2())
                .add("country", getCountry())
                .add("state", getState())
                .add("city", getCity())
                .add("zip", getZip())
                .toString();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getAddress1(), getAddress2(), getCountry(), getState(), getCity(), getZip());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof Address)) {
            return false;
        }
        final Address other = (Address) obj;
        return Objects.equal(getAddress1(), other.getAddress1()) && Objects.equal(getAddress2(), other.getAddress2())
                && Objects.equal(getCity(), other.getCity()) && Objects.equal(getCountry(), other.getCountry())
                && Objects.equal(getState(), other.getState()) && Objects.equal(getZip(), other.getZip());
    }
}

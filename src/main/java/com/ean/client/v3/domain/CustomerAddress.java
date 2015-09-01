package com.ean.client.v3.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains details for a customers address.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerAddress implements Serializable {

    @JsonProperty("address1")
    private String address1;

    @JsonProperty("address2")
    private String address2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("stateProvinceCode")
    private String stateProvinceCode;

    @JsonProperty("countryCode")
    private String countryCode;

    @JsonProperty("postalCode")
    private String postalCode;

    @JsonProperty("isPrimary")
    private Boolean isPrimary;

    /**
     * Returns the address1 for the CustomerAddresses
     *
     * @return String for the address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Returns the address2 for the CustomerAddresses
     *
     * @return String for the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Returns the city for the CustomerAddresses
     *
     * @return String for the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the stateProvinceCode for the CustomerAddresses
     *
     * @return String for the stateProvinceCode
     */
    public String getStateProvinceCode() {
        return stateProvinceCode;
    }

    /**
     * Returns the countryCode for the CustomerAddresses
     *
     * @return String for the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Returns the postalCode for the CustomerAddresses
     *
     * @return String for the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Returns if this is the primary address.
     * @return true if it is the primary address, otherwise no.
     */
    public boolean isPrimary() {
        return isPrimary;
    }
}

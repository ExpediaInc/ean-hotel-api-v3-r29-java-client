package com.ean.client.v3.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains hotel information for the itinerary.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotel implements Serializable {

    @JsonProperty("hotelId")
    private int hotelId;

    @JsonProperty("name")
    private String name;

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

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("phone")
    private String phone;

    /**
     * Constructs an empty instance of the Hotel class.
     */
    public Hotel() {
    }

    /**
     * Returns the hotelId for the Hotel
     *
     * @return int for the hotelId
     */
    public int getHotelId() {
        return hotelId;
    }

    /**
     * Returns the name for the Hotel
     *
     * @return String for the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the address1 for the Hotel
     *
     * @return String for the address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Returns the address2 for the Hotel
     *
     * @return String for the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Returns the city for the Hotel
     *
     * @return String for the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the stateProvinceCode for the Hotel
     *
     * @return String for the stateProvinceCode
     */
    public String getStateProvinceCode() {
        return stateProvinceCode;
    }

    /**
     * Returns the countryCode for the Hotel
     *
     * @return String for the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Returns the postalCode for the Hotel
     *
     * @return String for the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Returns the latitude for the Hotel
     *
     * @return double for the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Returns the longitude for the Hotel
     *
     * @return double for the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Returns the Hotel phone number
     *
     * @return string for the phone number
     */
    public String getPhone() {
        return phone;
    }

}

package com.ean.client.v3.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains the reservation guest details.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationGuest implements Serializable {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    /**
     * Returns the firstName for the ReservationGuest
     *
     * @return String for the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the lastName for the ReservationGuest
     *
     * @return String for the lastName
     */
    public String getLastName() {
        return lastName;
    }
}

package com.ean.client.v3.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains the itinerary details.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Itinerary implements Serializable {

    private static final long serialVersionUID = -140593219864810226L;

    @JsonProperty("Customer")
    private Customer customer;

    private List<HotelConfirmation> hotelConfirmations;

    @JsonProperty("creationDate")
    private Date creationDate = new Date();

    @JsonProperty("itineraryId")
    private long itineraryId;

    @JsonProperty("affiliateId")
    private long affiliateId;

    @JsonProperty("itineraryStartDate")
    private Date itineraryStartDate = new Date();

    @JsonProperty("itineraryEndDate")
    private Date itineraryEndDate = new Date();

    /**
     * Sets the hotel room booking confirmations for this itinerary.
     *
     * @param hotelConfirmations the room bookings.
     */
    @JsonProperty("HotelConfirmation")
    public void setHotelConfirmations(List<HotelConfirmation> hotelConfirmations) {
        this.hotelConfirmations = hotelConfirmations;
    }

    /**
     * Returns the itinerary start date.
     *
     * @return the date of the hotel check in
     */
    public Date getItineraryStartDate() {
        return itineraryStartDate;
    }

    /**
     * Returns the itinerary end date.
     *
     * @return the date of the hotel check out
     */
    public Date getItineraryEndDate() {
        return itineraryEndDate;
    }

    /**
     * Returns the affiliateId for the Itinerary
     *
     * @return long for the affiliateId
     */
    public long getAffiliateId() {
        return affiliateId;
    }

    /**
     * Returns the itinerary creation date
     *
     * @return returns the itinerary creation date.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Returns the customer for the Itinerary
     *
     * @return Customer for the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Returns the hotelConfirmation for the Itinerary
     *
     * @return List<HotelConfirmation> for the hotelConfirmation
     */
    public List<HotelConfirmation> getHotelConfirmations() {
        List<HotelConfirmation> validConfirmations = new ArrayList<HotelConfirmation>();
        for (HotelConfirmation hotelConfirmation : hotelConfirmations) {
            if (hotelConfirmation.isValidStatus()) {
                validConfirmations.add(hotelConfirmation);
            }
        }

        return validConfirmations;
    }

    /**
     * Returns the itineraryId for the Itinerary
     *
     * @return long for the itineraryId
     */
    public long getItineraryId() {
        return itineraryId;
    }

}


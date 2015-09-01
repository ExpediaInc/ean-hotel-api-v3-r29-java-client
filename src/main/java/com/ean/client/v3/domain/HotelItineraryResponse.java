package com.ean.client.v3.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ean.client.v3.domain.EanWsError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains the hotel itinerary response for the service request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelItineraryResponse extends BaseResponse implements Serializable {

    @JsonProperty("@size")
    private int size;

    @JsonProperty("Itinerary")
    private List<Itinerary> itineraries = new ArrayList<Itinerary>();

    /**
     * Returns the size for the HotelItineraryResponse
     *
     * @return int for the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the first itinerary for the HotelItineraryResponse
     *
     * @return Itinerary for the itinerary
     */
    public Itinerary getItinerary() {
        return itineraries.get(0);
    }

    /**
     * Returns all itineraries for the HotelItineraryResponse
     *
     * @return a list containing all itineraries from this HotelItineraryResponse
     */
    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("HotelItineraryResponse [customerSessionId=%s, size=%s, itineraries=%s, error=%s]",
            this.getCustomerSessionId(), size, itineraries, this.getEanWsError());
    }

}

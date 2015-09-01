package com.ean.client.v3.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Error data returned with a failed attempt to invoke a EAN API service.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EanWsError implements Serializable {

    @JsonProperty("itineraryId")
    private long itineraryId;

    @JsonProperty("handling")
    private String handling;

    @JsonProperty("category")
    private String category;

    @JsonProperty("exceptionConditionId")
    private int exceptionConditionId;

    @JsonProperty("presentationMessage")
    private String preventionMessage;

    @JsonProperty("verboseMessage")
    private String verboseMessage;

    /**
     * Returns the handling for the EanWsError
     *
     * @return String for the handling
     */
    public String getHandling() {
        return handling;
    }

    /**
     * Returns the category for the EanWsError
     *
     * @return String for the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the exceptionConditionId for the EanWsError
     *
     * @return int for the exceptionConditionId
     */
    public int getExceptionConditionId() {
        return exceptionConditionId;
    }

    /**
     * Returns the preventionMessage for the EanWsError
     *
     * @return String for the preventionMessage
     */
    public String getPreventionMessage() {
        return preventionMessage;
    }

    /**
     * Returns the verboseMessage for the EanWsError
     *
     * @return String for the verboseMessage
     */
    public String getVerboseMessage() {
        return verboseMessage;
    }

    /**
     * Returns the itinerary id associated with the request
     *
     * @return The itinerary id if the request included one, -1 if not.
     */
    public long getItineraryId() {
        return itineraryId;
    }

    @Override
    public String toString() {
        return "EanWsError{" +
            "exceptionConditionId=" + exceptionConditionId +
            ", preventionMessage='" + preventionMessage + '\'' +
            ", verboseMessage='" + verboseMessage + '\'' +
            '}';
    }
}

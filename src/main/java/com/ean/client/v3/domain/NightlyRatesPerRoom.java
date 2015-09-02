package com.ean.client.v3.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains details on the nightly rates for a room.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NightlyRatesPerRoom implements Serializable {

    private static final long serialVersionUID = 233012885368856033L;

    @JsonProperty("@size")
    private int size;

    @JsonProperty("NightlyRate")
    private List<NightlyRate> nightlyRates;

    /**
     * Returns the size for the NightlyRatesPerRoom
     *
     * @return int for the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the nightlyRates for the NightlyRatesPerRoom
     *
     * @return List<NightlyRate> for the nightlyRates
     */
    public List<NightlyRate> getNightlyRates() {
        return nightlyRates;
    }

}

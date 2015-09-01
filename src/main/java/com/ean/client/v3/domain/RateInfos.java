package com.ean.client.v3.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains all rate info details for a hotel reservation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateInfos implements Serializable {

    @JsonProperty("@size")
    private int size;

    @JsonProperty("RateInfo")
    private List<RateInfo> rateInfos;

    /**
     * Returns the size for the RateInfos
     *
     * @return int for the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the rateInfos for the RateInfos
     *
     * @return List<RateInfo> for the rateInfos
     */
    public List<RateInfo> getRateInfos() {
        return rateInfos;
    }

}

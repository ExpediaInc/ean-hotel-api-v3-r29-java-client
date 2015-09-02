package com.ean.client.v3.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains all surcharges for a chargeable rate.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Surcharges implements Serializable {

    private static final long serialVersionUID = -7338271867760339388L;

    @JsonProperty("@size")
    private int size;

    @JsonProperty("Surcharge")
    private List<Surcharge> surcharges;

    /**
     * Returns the size for the Surcharges
     *
     * @return int for the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the surcharges for the Surcharges
     *
     * @return List<Surcharge> for the surcharges
     */
    public List<Surcharge> getSurcharges() {
        return surcharges;
    }

}

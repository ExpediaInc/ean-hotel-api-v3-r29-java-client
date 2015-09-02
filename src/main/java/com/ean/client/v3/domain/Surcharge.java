package com.ean.client.v3.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains surcharge details.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Surcharge implements Serializable {

    private static final long serialVersionUID = 144740692331106795L;

    @JsonProperty("@amount")
    private BigDecimal amount = BigDecimal.ZERO;

    @JsonProperty("@type")
    private String type;

    /**
     * Returns the amount for the Surcharge
     *
     * @return BigDecimal for the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Returns the type for the Surcharge
     *
     * @return String for the type
     */
    public String getType() {
        return type;
    }

}

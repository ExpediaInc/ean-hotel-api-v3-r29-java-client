package com.ean.client.v3.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains details on the nightly rate.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NightlyRate implements Serializable {

    @JsonProperty("@promo")
    private boolean promo;

    @JsonProperty("@rate")
    private BigDecimal rate = BigDecimal.ZERO;

    @JsonProperty("@baseRate")
    private BigDecimal baseRate = BigDecimal.ZERO;

    /**
     * Returns the promo for the NightlyRate
     *
     * @return boolean for the promo
     */
    public boolean isPromo() {
        return promo;
    }

    /**
     * Returns the rate for the NightlyRate
     *
     * @return BigDecimal for the rate
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * Returns the baseRate for the NightlyRate
     *
     * @return BigDecimal for the baseRate
     */
    public BigDecimal getBaseRate() {
        return baseRate;
    }
}

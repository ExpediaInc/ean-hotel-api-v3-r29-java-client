package com.ean.client.v3.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Contains the details on the chargeable rate.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChargeableRateInfo implements Serializable {

    private static final long serialVersionUID = -3557042242820190093L;

    @JsonProperty("NightlyRatesPerRoom")
    private NightlyRatesPerRoom nightlyRatesPerRoom;

    @JsonProperty("Surcharges")
    private Surcharges surcharges;

    @JsonProperty("@commissionableUsdTotal")
    private BigDecimal commissionableUsdTotal = BigDecimal.ZERO;

    @JsonProperty("@total")
    private BigDecimal total = BigDecimal.ZERO;

    @JsonProperty("@surchargeTotal")
    private BigDecimal surchargeTotal = BigDecimal.ZERO;

    @JsonProperty("@nightlyRateTotal")
    private BigDecimal nightlyRateTotal = BigDecimal.ZERO;

    @JsonProperty("@averageBaseRate")
    private BigDecimal averageBaseRate = BigDecimal.ZERO;

    @JsonProperty("@averageRate")
    private BigDecimal averageRate = BigDecimal.ZERO;

    @JsonProperty("@maxNightlyRate")
    private BigDecimal maxNightlyRate = BigDecimal.ZERO;

    @JsonProperty("@currencyCode")
    private String currencyCode;

    /**
     * Returns the commissionableUsdTotal for the ChargeableRateInfo
     *
     * @return BigDecimal for the commissionableUsdTotal
     */
    public BigDecimal getCommissionableUsdTotal() {
        return commissionableUsdTotal;
    }

    /**
     * Returns the total for the ChargeableRateInfo
     *
     * @return BigDecimal for the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Returns the surchargeTotal for the ChargeableRateInfo
     *
     * @return BigDecimal for the surchargeTotal
     */
    public BigDecimal getSurchargeTotal() {
        return surchargeTotal;
    }

    /**
     * Returns the nightlyRateTotal for the ChargeableRateInfo
     *
     * @return BigDecimal for the nightlyRateTotal
     */
    public BigDecimal getNightlyRateTotal() {
        return nightlyRateTotal;
    }

    /**
     * Returns the averageBaseRate for the ChargeableRateInfo
     *
     * @return BigDecimal for the averageBaseRate
     */
    public BigDecimal getAverageBaseRate() {
        return averageBaseRate;
    }

    /**
     * Returns the averageRate for the ChargeableRateInfo
     *
     * @return BigDecimal for the averageRate
     */
    public BigDecimal getAverageRate() {
        return averageRate;
    }

    /**
     * Returns the maxNightlyRate for the ChargeableRateInfo
     *
     * @return BigDecimal for the maxNightlyRate
     */
    public BigDecimal getMaxNightlyRate() {
        return maxNightlyRate;
    }

    /**
     * Returns the currencyCode for the ChargeableRateInfo
     *
     * @return String for the currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Returns the nightlyRatesPerRoom for the ChargeableRateInfo
     *
     * @return NightlyRatesPerRoom for the nightlyRatesPerRoom
     */
    public NightlyRatesPerRoom getNightlyRatesPerRoom() {
        return nightlyRatesPerRoom;
    }

    /**
     * Returns the surcharges for the ChargeableRateInfo
     *
     * @return Surcharges for the surcharges
     */
    public Surcharges getSurcharges() {
        return surcharges;
    }

}

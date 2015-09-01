package com.ean.client.v3.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains rate information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateInfo implements Serializable {

    @JsonProperty("ChargeableRateInfo")
    private ChargeableRateInfo chargeableRateInfo;

    @JsonProperty("@rateChange")
    private boolean rateChange;

    @JsonProperty("@promo")
    private boolean promo;

    @JsonProperty("@priceBreakdown")
    private boolean priceBreakdown;

    private String rateType;

    private String cancellationPolicy;

    private boolean nonRefundable;

    private boolean depositRequired;

    @JsonProperty("Deposit")
    private Deposit deposit;

    private static final String DIRECT_AGENCY = "DirectAgency";

    /**
     * Returns the rate is non refundable for the rate.
     *
     * @return a true if it is non refundable, false if it can be refunded.
     */
    public boolean isNonRefundable() {
        return nonRefundable;
    }

    /**
     * Returns if there is a rate change for the rate.
     *
     * @return true if there is, false if not.
     */
    public boolean isRateChange() {
        return rateChange;
    }

    /**
     * Returns the promo for the rate.
     *
     * @return boolean for the promo
     */
    public boolean isPromo() {
        return promo;
    }

    /**
     * Returns the priceBreakdown for the rate.
     *
     * @return boolean for the priceBreakdown
     */
    public boolean isPriceBreakdown() {
        return priceBreakdown;
    }

    /**
     * Returns the chargeableRateInfo for the RateInfo
     *
     * @return ChargeableRateInfo for the chargeableRateInfo
     */
    public ChargeableRateInfo getChargeableRateInfo() {
        return chargeableRateInfo;
    }

    /**
     * Returns the rate type being used with this rate.
     * @return A <code>String</code> containing the rate type ("MerchantStandard", "DirectAgency") or null if there is
     * not one.
     */
    public String getRateType() {
        return rateType;
    }

    /**
     * Returns the cancellation policy for the rate.
     *
     * @return a <code>String</code> for the cancellation policy.
     */
    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    /**
     * Returns the chargeableRateSurchargeTotal for the RateInfo
     *
     * @return BigDecimal for the chargeableRateSurchargeTotal
     */
    public BigDecimal getChargeableRateSurchargeTotal() {
        return chargeableRateInfo.getSurchargeTotal();
    }

    /**
     * Returns the chargeableRateTotal for the RateInfo
     *
     * @return BigDecimal for the chargeableRateTotal
     */
    public BigDecimal getChargeableRateTotal() {
        return chargeableRateInfo.getTotal();
    }

    /**
     * Returns the nightly Rate total for the RateInfo
     *
     * @return BigDecimal for the nightlyRateTotal
     */
    public BigDecimal getNightlyRateTotal() {
        return chargeableRateInfo.getNightlyRateTotal();
    }

    /**
     * Returns the single night max rate for the RateInfo.
     *
     * @return BigDecimal for the max nightly rate.
     */
    public BigDecimal getMaxNightlyRate() {
        return chargeableRateInfo.getMaxNightlyRate();
    }

    /**
     * Checks if the rate info has rateType DIRECT_AGENCY
     *
     * @return true if the rate info has rateType DIRECT_AGENCY
     */
    public boolean isDirectAgency() {
        return DIRECT_AGENCY.equals(rateType);
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public boolean isDepositRequired() {
        return depositRequired;
    }
}

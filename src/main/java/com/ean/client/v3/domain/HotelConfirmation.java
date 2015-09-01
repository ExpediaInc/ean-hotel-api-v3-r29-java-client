package com.ean.client.v3.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.ean.client.v3.domain.ValueAdds;
import com.ean.client.v3.domain.CouponInformation;
import com.ean.client.v3.domain.RateInfo;
import com.ean.client.v3.domain.RateInfos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Contains details of the hotel room confirmation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelConfirmation implements Serializable {

    private final static Log LOG = LogFactory.getLog(HotelConfirmation.class);

    @JsonProperty("RateInfos")
    private RateInfos rateInfos = new RateInfos();

    @JsonProperty("Hotel")
    private List<Hotel> hotels;

    private Hotel hotel;

    @JsonProperty("ReservationGuest")
    private ReservationGuest reservationGuest;

    @JsonProperty("CouponInformation")
    private CouponInformation couponInformation;

    @JsonProperty("ConfirmationExtras")
    private ConfirmationExtras confirmationExtras = new ConfirmationExtras();

    @JsonProperty("status")
    private String status;

    private Locale locale;

    @JsonProperty("ValueAdds")
    private ValueAdds valueAdds = new ValueAdds();

    private int supplierId;
    private String chainCode;
    private String confirmationNumber;
    private String cancellationNumber;
    private int numberOfAdults;
    private int numberOfChildren;
    private int nights;
    private String smokingPreference;
    private String roomDescription;
    private String roomTypeCode;

    /**
     * Returns the special request made for the booking.
     *
     * @return a <code>String</code> with the special request if there was one, null if there is not.
     */
    public String getSpecialRequest() {
        return confirmationExtras.getSpecialRequestConfirmationExtra().getValue();
    }

    /**
     * Returns the affiliate membership number for the booking.
     *
     * @return a <code>String</code> with the loyalty label affiliate membership number if there was one, null otherwise.
     */
    public String getAffiliateMembershipNumber() {
        return confirmationExtras.getAffiliateMembershipNumberExtra().getValue();
    }

    /**
     * Returns the locale the confirmation was booked in.
     *
     * @return a <code>Locale</code> for the language the confirmation was booked in.
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Returns any applied coupon information
     *
     * @return a <code>CouponInformation</code> with the coupon information
     */
    public CouponInformation getCouponInformation() {
        return couponInformation;
    }

    /**
     * Returns the nonRefundable for this confirmation.
     *
     * @return boolean for the nonRefundable
     */
    public boolean isNonRefundable() {
        return getRateInfos().getRateInfos().get(0).isNonRefundable();
    }

    /**
     * Returns the status for this confirmation.
     *
     * @return BookingStatus for the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Returns the cancellation policy for this confirmation.
     *
     * @return the cancellation policy as a <code>String</code>.
     */
    public String getCancellationPolicy() {
        return getRateInfos().getRateInfos().get(0).getCancellationPolicy();
    }

    /**
     * Returns the rates for this confirmation.
     *
     * @return <code>RateInfos</code> for the rates for this confirmation.
     */
    public RateInfos getRateInfos() {
        return rateInfos;
    }

    /**
     * Returns the supplierId for this confirmation.
     *
     * @return long for the supplier ID.
     */
    public long getSupplierId() {
        return supplierId;
    }

    /**
     * Returns the chainCode for this confirmation.
     *
     * @return String for the chain code.
     */
    public String getChainCode() {
        return chainCode;
    }

    /**
     * Returns the confirmationNumber for this confirmation.
     *
     * @return String for the confirmation number.
     */
    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    /**
     * Returns the cancellation number for this confirmation if it has been cancelled.
     *
     * @return String for the cancellation number.
     */
    public String getCancellationNumber() {
        return cancellationNumber;
    }

    /**
     * Returns the hotel for this confirmation.
     *
     * @return Hotel for the hotel confirmation
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Returns the numberOfAdults for this confirmation.
     *
     * @return int for the numberOfAdults
     */
    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    /**
     * Returns the numberOfChildren for this confirmation.
     *
     * @return int for the numberOfChildren
     */
    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    /**
     * Returns the smokingPreference for this confirmation.
     *
     * @return String for the smokingPreference
     */
    public String getSmokingPreference() {
        return smokingPreference;
    }

    /**
     * Returns the roomDescription for this confirmation.
     *
     * @return String for the roomDescription
     */
    public String getRoomDescription() {
        return roomDescription;
    }

    /**
     * Returns the nights for this confirmation.
     *
     * @return int for the nights
     */
    public int getNights() {
        return nights;
    }

    /**
     * Returns the roomTypeCode for this confirmation.
     *
     * @return long for the roomTypeCode
     */
    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    /**
     * Returns the reservationGuest for this confirmation.
     *
     * @return ReservationGuest for the reservationGuest
     */
    public ReservationGuest getReservationGuest() {
        return reservationGuest;
    }

    /**
     * Returns the currencyCode for this confirmation.
     *
     * @return String for the currencyCode
     */
    public String getCurrencyCode() {
        return rateInfos.getRateInfos().get(0).getChargeableRateInfo().getCurrencyCode();
    }

    /**
     * Returns the canceled for this confirmation.
     *
     * @return boolean for the canceled
     */
    public boolean isCanceled() {
        return "CX".equalsIgnoreCase(status);
    }

    /**
     * Returns the pending for this confirmation.
     *
     * @return boolean for the pending
     */
    public boolean isPending() {
        return "PS".equalsIgnoreCase(status);
    }

    /**
     * Returns the confirmed for this confirmation.
     *
     * @return boolean for the confirmed
     */
    public boolean isConfirmed() {
        return "CF".equalsIgnoreCase(status);
    }

    public boolean isValidStatus() {
        return isConfirmed() || isCanceled() || isPending();
    }

    /**
     * Returns the total charges for the room if a price break down is provide or the nightly rate times the number
     * of nights.
     *
     * @return BigDecimal with calculated value.
     */
    public BigDecimal getTotalCharges() {
        RateInfo rateInfo = rateInfos.getRateInfos().get(0);

        if (rateInfo.isPriceBreakdown()) {
            return rateInfo.getChargeableRateTotal();
        } else {
            return getBaseNightlyRateTotal(rateInfo);
        }
    }

    /**
     * Gets the flat nightly rate total.
     *
     * @return BigDecimal with calculated value.
     */
    public BigDecimal getNightlyRateTotalValue() {
        RateInfo rateInfo = rateInfos.getRateInfos().get(0);

        if (rateInfo.isPriceBreakdown()) {
            return rateInfo.getNightlyRateTotal();
        } else {
            return getBaseNightlyRateTotal(rateInfo);
        }
    }

    private BigDecimal getBaseNightlyRateTotal(RateInfo rateInfo) {
        return rateInfo.getMaxNightlyRate().multiply(new BigDecimal(nights));
    }

    /**
     * To Return the coupon value applied in the transaction
     *
     * @return BigDecimal Coupon Value
     */

    public BigDecimal getCouponAmount() {
        BigDecimal couponAmount = BigDecimal.ZERO;
        if (getCouponInformation() != null && getCouponInformation().getCouponDiscount() != null) {
            int subStringChar = getCouponInformation().getCouponDiscount().indexOf("|");
            couponAmount = new BigDecimal(getCouponInformation().getCouponDiscount().substring(subStringChar + 1));
        }
        return couponAmount;
    }

    /**
     * Indicates if this is a merchant property.
     * 
     * @return true if this is a merchant property.
     */
    public boolean isMerchantProperty() {
        return supplierId == 13;
    }

    /**
     * Indicates if the booked type of room is different the DirectAgency
     * and is a Merchant property.
     * This rateType is available only for merchant hotels and it means that the rate is pre payed.
     *
     * @return true if rateType is different then DirectAgency and is a Merchant property
     */
    public boolean isMerchantPrePay() {
        return isMerchantProperty() && !isDirectAgency();
    }

    /**
     * Indicates if the booked type of room has <rateType>DirectAgency</rateType> and is a Merchant property.
     * This rateType is available only for merchant hotels and it means that the rate is post payed.
     *
     * @return true if rateType is DirectAgency
     */
    public boolean isMerchantPostPay() {
        return isMerchantProperty() && isDirectAgency();
    }

    /**
     * Indicates if the booked type of room is merchant post pay and has deposit.
     *
     * @return true if merchant post pay and deposit required
     */
    public boolean isMerchantPostPayWithDeposit() {
        return isMerchantPostPay() & isDepositRequired();
    }

    /**
     * Indicates if the booked type of room is merchant post pay and is not having deposit.
     *
     * @return true if merchant post pay and is not having deposit
     */
    public boolean isMerchantPostPayWithoutDeposit() {
        return isMerchantPostPay() & !isDepositRequired();
    }

    /**
     * Indicates if the booked type of room has <rateType>DirectAgency</rateType>
     * This rateType is available only for merchant hotels and it means that the rate is post paid
     *
     * @return true if rateType is DirectAgency
     */
    private boolean isDirectAgency() {
        if (CollectionUtils.isEmpty(rateInfos.getRateInfos())) {
            return false;
        }
        return rateInfos.getRateInfos().get(0).isDirectAgency();
    }

    /**
     * Sets the single hotel for this confirmation by pulling the <code>Hotel</code> stored in this.hotels by the
     * passed in index;
     * <p/>
     * This was implemented when it was discovered that there are valid production scenarios where an itinerary had
     * two hotel confirmations, one canceled with one hotel, and the other confirmed with a different hotel. In this
     * case both HotelConfirmations got two hotels, one for the canceled and one for the confirmed. The hotel order
     * matched the order of the hotel confirmation returned in the JSON and XML. So when we read in the hotel
     * confirmations, we iterate through them and set the hotel on each by passing in the index that the hotel
     * confirmation came in with from the json/xml.
     * <p/>
     * If there is only one hotel in the HotelConfirmation we simply set that as the target hotel.
     *
     * @param indexOfHotelConfirmationInItinerary Index to retrieve the hotel from.
     */
    public void setHotelByIndexOfHotelConfirmationInItinerary(int indexOfHotelConfirmationInItinerary) {
        hotel = hotels.size() > 1 && hotels.size() > indexOfHotelConfirmationInItinerary ?
                hotels.get(indexOfHotelConfirmationInItinerary) :
                hotels.get(0);
    }

    /**
     * Returns value adds for this confirmation.
     *
     * @return <code>ValueAdds</code> for this confirmation.
     */
    public ValueAdds getValueAdds() {
        return valueAdds;
    }

    /**
     * Indicates if the booked room requires a deposit.
     *
     * @return true if deposit is required
     */
    public boolean isDepositRequired() {
        return rateInfos.getRateInfos().get(0).isDepositRequired();
    }

    /**
     * Returns deposit amount.
     *
     * @return BigDecimal deposit amount value.
     */
    public BigDecimal getDepositAmount() {
        if (CollectionUtils.isNotEmpty(rateInfos.getRateInfos()) && null != rateInfos.getRateInfos().get(0)
                .getDeposit()) {
            return rateInfos.getRateInfos().get(0).getDeposit().getAmount();
        }

        return BigDecimal.ZERO;
    }
}

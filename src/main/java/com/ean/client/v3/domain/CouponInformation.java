package com.ean.client.v3.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Contains details about applied coupon discounts
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CouponInformation implements Serializable {

    private String couponCode;
    private String couponDiscount;
    private String couponEmail;

    /**
     * Returns the coupon code.
     * @return a String with the coupon code.
     */
    public String getCouponCode() {
        return couponCode;
    }

    /**
     * Returns the coupon discount code.
     * @return a String with the discount code.
     */
    public String getCouponDiscount() {
        return couponDiscount;
    }

    /**
     * Returns the associated coupon email address.
     * @return a String with the email address.
     */
    public String getCouponEmail() {
        return couponEmail;
    }

}

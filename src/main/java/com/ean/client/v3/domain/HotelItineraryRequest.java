package com.ean.client.v3.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Java class for HotelItineraryRequest complex type.
 * 
 */
public class HotelItineraryRequest extends BaseRequest {

    protected Long itineraryId;
    protected String lastName;
    protected String email;
    protected String affiliateConfirmationId;
    protected String affiliateCustomerId;
    protected List<String> confirmationExtras;

    /**
     * Gets the value of the itineraryId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItineraryId() {
        return itineraryId;
    }

    /**
     * Sets the value of the itineraryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItineraryId(Long value) {
        this.itineraryId = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the affiliateConfirmationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAffiliateConfirmationId() {
        return affiliateConfirmationId;
    }

    /**
     * Sets the value of the affiliateConfirmationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAffiliateConfirmationId(String value) {
        this.affiliateConfirmationId = value;
    }

    /**
     * Gets the value of the affiliateCustomerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAffiliateCustomerId() {
        return affiliateCustomerId;
    }

    /**
     * Sets the value of the affiliateCustomerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAffiliateCustomerId(String value) {
        this.affiliateCustomerId = value;
    }

    /**
     * Gets the value of the confirmationExtras property.
     */
    public List<String> getConfirmationExtras() {
        if (confirmationExtras == null) {
            confirmationExtras = new ArrayList<String>();
        }
        return this.confirmationExtras;
    }

}

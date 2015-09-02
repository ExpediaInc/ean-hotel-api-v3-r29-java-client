package com.ean.client.v3.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * BaseResponse complex type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 5267505926715996769L;

    @JsonProperty("EanWsError")
    protected EanWsError eanWsError;

    @JsonProperty("customerSessionId")
    protected String customerSessionId;

    /**
     * Gets the value of the eanWsError property.
     */
    public EanWsError getEanWsError() {
        return eanWsError;
    }

    /**
     * Sets the value of the eanWsError property.
     * 
     */
    public void setEanWsError(EanWsError value) {
        this.eanWsError = value;
    }

    /**
     * Gets the value of the customerSessionId property.
     * 
     */
    public String getCustomerSessionId() {
        return customerSessionId;
    }

    /**
     * Sets the value of the customerSessionId property.
     * 
     * @param value
     */
    public void setCustomerSessionId(String value) {
        this.customerSessionId = value;
    }

}

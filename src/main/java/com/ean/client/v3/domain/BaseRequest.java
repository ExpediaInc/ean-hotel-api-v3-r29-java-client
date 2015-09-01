package com.ean.client.v3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * BaseRequest.
 */
public abstract class BaseRequest {

    protected String apiKey;
    protected long cid;
    protected Integer minorRev;
    protected String customerIpAddress;
    protected String customerSessionId;
    protected String customerUserAgent;
    protected Locale locale;
    protected String currencyCode;
    protected List<MapEntry> additionalData;
    protected String sig;
    protected Boolean debug;
    protected Boolean test;
    protected String apiExperience;
    protected String transactionId;

    /**
     * Gets the value of the minorRev property.
     * 
     * @return minorRev
     */
    public Integer getMinorRev() {
        return minorRev;
    }

    /**
     * Sets the value of the minorRev property.
     * 
     * @param minorRev
     */
    public void setMinorRev(Integer minorRev) {
        this.minorRev = minorRev;
    }

    /**
     * Gets the value of the apiKey property.
     * 
     * @return apiKey
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the value of the apiKey property.
     * 
     * @param apiKey
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Gets the value of the cid property.
     * @return cid 
     */
    public long getCid() {
        return cid;
    }

    /**
     * Sets the value of the cid property.
     * @param cid
     */
    public void setCid(long cid) {
        this.cid = cid;
    }

    /**
     * Gets the value of the customerIpAddress property.
     * 
     * @return customerIpAddress
     */
    public String getCustomerIpAddress() {
        return customerIpAddress;
    }

    /**
     * Sets the value of the customerIpAddress property.
     * 
     * @param customerIpAddress
     */
    public void setCustomerIpAddress(String customerIpAddress) {
        this.customerIpAddress = customerIpAddress;
    }

    /**
     * Gets the value of the customerSessionId property.
     * 
     * @return customerSessionId
     */
    public String getCustomerSessionId() {
        return customerSessionId;
    }

    /**
     * Sets the value of the customerSessionId property.
     * 
     * @param customerSessionId
     */
    public void setCustomerSessionId(String customerSessionId) {
        this.customerSessionId = customerSessionId;
    }

    /**
     * Gets the value of the customerUserAgent property.
     * 
     * @return customerUserAgent
     */
    public String getCustomerUserAgent() {
        return customerUserAgent;
    }

    /**
     * Sets the value of the customerUserAgent property.
     * 
     * @param customerUserAgent
     */
    public void setCustomerUserAgent(String customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
    }

    /**
     * Gets the value of the locale property.
     * 
     * @return locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Sets the value of the locale property.
     * 
     * @param locale
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param currencyCode
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * Gets the value of the additionalData property.
     * @return list of additionalData
     */
    public List<MapEntry> getAdditionalData() {
        if (additionalData == null) {
            additionalData = new ArrayList<MapEntry>();
        }
        return this.additionalData;
    }

    /**
     * Gets the value of the sig property.
     * 
     * @return sig
     */
    public String getSig() {
        return sig;
    }

    /**
     * Sets the value of the sig property.
     * 
     * @param sig
     */
    public void setSig(String sig) {
        this.sig = sig;
    }

    /**
     * Gets the value of the debug property.
     * 
     * @return debug
     */
    public Boolean isDebug() {
        return debug;
    }

    /**
     * Sets the value of the debug property.
     * 
     * @param debug
     */
    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    /**
     * Gets the value of the test property.
     * 
     * @return test
     */
    public Boolean isTest() {
        return test;
    }

    /**
     * Sets the value of the test property.
     * 
     * @param test
     */
    public void setTest(Boolean test) {
        this.test = test;
    }

    /**
     * Gets the apiExperience.
     * @return the apiExperience
     */
    public String getApiExperience() {
        return apiExperience;
    }

    /**
     * Sets the apiExperience.
     * @param apiExperience the apiExperience to set
     */
    public void setApiExperience(String apiExperience) {
        this.apiExperience = apiExperience;
    }

    /**
     * Gets the transactionId.
     * @return the transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the transactionId.
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

}

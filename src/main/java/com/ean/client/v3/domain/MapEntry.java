package com.ean.client.v3.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MapEntry implements Serializable {

    @JsonProperty("key")
    protected String key;

    @JsonProperty("Customer")
    protected String value;

    /**
     * Gets the value of the key property.
     * 
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

}

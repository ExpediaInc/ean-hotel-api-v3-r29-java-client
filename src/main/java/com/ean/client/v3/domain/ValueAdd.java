package com.ean.client.v3.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains value add description for a hotel reservation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueAdd implements Serializable {

    @JsonProperty("description")
    private String description;

    
    /**
     * Description for the ValueAdd.
     *
     * @return Description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the 'description' element value. Description for the Value Add.
     *
     * @param description Description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}

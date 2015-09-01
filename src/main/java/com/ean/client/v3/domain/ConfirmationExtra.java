package com.ean.client.v3.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains room booking confirmation extra details.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfirmationExtra {

    public static final ConfirmationExtra NULL_SPECIAL_REQUEST = new ConfirmationExtra("SPECIAL_REQUESTS", null);
    public static final ConfirmationExtra NULL_AFFILIATE_MEMBERSHIP_NUMBER = new ConfirmationExtra("AFFILIATE_MEMBERSHIP_NUMBER", null);
    public static final ConfirmationExtra NULL_LODGING_SUPPLIER_CANCEL = new ConfirmationExtra("LODGING_SUPPLIER_CANCEL", null);

    @JsonProperty("@name")
    private String name;

    @JsonProperty("@value")
    private String value;

    /**
     * Zero argument constructor for Jackson JSON parsing
     */
    public ConfirmationExtra() {}

    private ConfirmationExtra(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Returns the value value of the extra.
     *
     * @return <code>String</code>
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns the name of the extra.
     *
     * @return <code>String</code>
     */
    public String getName() {
        return name;
    }
}

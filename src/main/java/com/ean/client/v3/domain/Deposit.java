package com.ean.client.v3.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains deposit information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deposit implements Serializable {

    private static final long serialVersionUID = -2850220213051926851L;

    @JsonProperty("@amount")
    private BigDecimal amount = BigDecimal.ZERO;

    /**
     * Returns the amount value.
     *
     * @return BigDecimal as amount value
     */
    public BigDecimal getAmount() {
        return amount;
    }
}

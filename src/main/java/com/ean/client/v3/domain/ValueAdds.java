package com.ean.client.v3.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains all value adds details for a hotel reservation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueAdds implements Serializable {

    @JsonProperty("@size")
    private int size;

    @JsonProperty("ValueAdd")
    private List<ValueAdd> valueAddList = new ArrayList<ValueAdd>();

    /**
     * Returns the size for the valueAdds
     *
     * @return int for the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the value add list for hotel reservation
     *
     * @return List<ValueAdd> for the valueAdds
     */
    public List<ValueAdd> getValueAddList() {
        return valueAddList;
    }

    /**
     * Set value add list
     *
     */
    public void setValueAdds(List<ValueAdd> valueAdd) {
        this.valueAddList = valueAdd;
    }

}

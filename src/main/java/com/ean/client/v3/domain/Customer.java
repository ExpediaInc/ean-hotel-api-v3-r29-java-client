package com.ean.client.v3.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains customer information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer implements Serializable {

    @JsonProperty("email")
    private String email;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("homePhone")
    private String homePhone;

    @JsonProperty("CustomerAddresses")
    private List<CustomerAddress> customerAddresses;


    /**
     * Returns the email for the Customer
     *
     * @return String for the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the firstName for the Customer
     *
     * @return String for the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the lastName for the Customer
     *
     * @return String for the lastName
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Returns the homePhone for the Customer
     *
     * @return String for the homePhone
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * Returns the customerAddresses for the Customer
     *
     * @return CustomerAddresses for the customerAddresses
     */
    public CustomerAddress getPrimaryAddress() {

        for (CustomerAddress customerAddress : customerAddresses) {
            if (customerAddress.isPrimary()) {
                return customerAddress;
            }
        }

        return customerAddresses.get(0);
    }
}

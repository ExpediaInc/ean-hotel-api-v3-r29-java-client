package com.ean.client.v3.domain;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains the confirmation extra. Current implementation will only include a room special request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfirmationExtras {

    @JsonProperty("ConfirmationExtra")
    private List<ConfirmationExtra> confirmationExtras = Collections.emptyList();

    /**
     * Returns the special request confirmation extra.
     * @return a <code>ConfirmationExtra</code> detailing their special request.
     */
    public List<ConfirmationExtra> getConfirmationExtras() {
        return confirmationExtras;
    }

    /**
     * Returns the confirmation extra special request if there is one.
     *
     * @return the <code>ConfirmationExtra</code> or a Null object implementation
     */
    public ConfirmationExtra getSpecialRequestConfirmationExtra() {
        ConfirmationExtra specialRequest = getConfirmationExtra("SPECIAL_REQUESTS");
        return null != specialRequest ? specialRequest : ConfirmationExtra.NULL_SPECIAL_REQUEST;
    }

    /**
     * Returns the confirmation extra loyalty label affiliate membership number if there is one.
     *
     * @return the <code>ConfirmationExtra</code> or a Null object implementation
     */
    public ConfirmationExtra getAffiliateMembershipNumberExtra() {
        ConfirmationExtra affiliateMembershipNumber = getConfirmationExtra("AFFILIATE_MEMBERSHIP_NUMBER");
        return affiliateMembershipNumber != null
            ? affiliateMembershipNumber
            : ConfirmationExtra.NULL_AFFILIATE_MEMBERSHIP_NUMBER;
    }

    /**
     * Returns the confirmation extra lodging supplier cancel if there is one.
     *
     * @return the <code>ConfirmationExtra</code> or a Null object implementation
     */
    public ConfirmationExtra getLodgingSupplierCancelExtra() {
        ConfirmationExtra supplierCancel = getConfirmationExtra("LODGING_SUPPLIER_CANCEL");
        return null != supplierCancel ? supplierCancel : ConfirmationExtra.NULL_LODGING_SUPPLIER_CANCEL;
    }
    
    private ConfirmationExtra getConfirmationExtra(String confirmationExtraName) {
        for (ConfirmationExtra confirmationExtra : confirmationExtras) {
            if (StringUtils.equals(confirmationExtraName, confirmationExtra.getName())) {
                return confirmationExtra;
            }
        }
        return null;
    }
}

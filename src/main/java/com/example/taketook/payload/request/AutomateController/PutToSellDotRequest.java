package com.example.taketook.payload.request.AutomateController;

import com.example.taketook.utils.RentTariff;

public class PutToSellDotRequest {
    private Integer dotId;
    private Integer listingId;
    private RentTariff rentTariff;
    private Long rentTime;

    public Integer getDotId() {
        return dotId;
    }

    public Integer getListingId() {
        return listingId;
    }

    public RentTariff getRentTariff() {
        return rentTariff;
    }

    public Long getRentTime() {
        return rentTime;
    }
}

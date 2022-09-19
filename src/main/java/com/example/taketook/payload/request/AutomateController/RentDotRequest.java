package com.example.taketook.payload.request.AutomateController;

import com.example.taketook.utils.RentTariff;

public class RentDotRequest {
    private Integer dotId;
    // private String automateId;
    private RentTariff rentTariff;
    private Long rentTime;

    public Integer getDotId() {
        return dotId;
    }

    public RentTariff getRentTariff() {
        return rentTariff;
    }

    public Long getRentTime() {
        return rentTime;
    }
}

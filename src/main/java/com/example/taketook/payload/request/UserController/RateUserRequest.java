package com.example.taketook.payload.request.UserController;

public class RateUserRequest {
    private Integer userToRateId;
    private Double rating;

    public Integer getUserToRateId() {
        return userToRateId;
    }

    public Double getRating() {
        return rating;
    }
}

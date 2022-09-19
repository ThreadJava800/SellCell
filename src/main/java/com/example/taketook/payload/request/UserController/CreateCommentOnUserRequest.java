package com.example.taketook.payload.request.UserController;

public class CreateCommentOnUserRequest {
    private Integer userToRateId;
    private String text;
    private Double rating;

    public Integer getUserToRateId() {
        return userToRateId;
    }

    public String getText() {
        return text;
    }

    public Double getRating() {
        return rating;
    }
}

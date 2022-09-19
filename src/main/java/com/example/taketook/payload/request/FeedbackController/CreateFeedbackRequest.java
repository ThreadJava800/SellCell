package com.example.taketook.payload.request.FeedbackController;

public class CreateFeedbackRequest {
    private Integer userId;
    private Integer listingId;
    private Long starCount;
    private String text;

    public Integer getUserId() {
        return userId;
    }

    public Integer getListingId() {
        return listingId;
    }

    public Long getStarCount() {
        return starCount;
    }

    public String getText() {
        return text;
    }
}

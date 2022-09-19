package com.example.taketook.payload.request.ListingController;

public class CreateCommentRequest {
    private Integer listingId;
    private String text;

    public Integer getListingId() {
        return listingId;
    }

    public String getText() {
        return text;
    }
}

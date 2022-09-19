package com.example.taketook.payload.request.ListingController;

import com.example.taketook.utils.Category;
import com.example.taketook.utils.ListingDeliveryStatus;

import java.util.List;
import java.util.Set;

public class CreateListingRequest {
    private String title;
    private String description;
    private String dot;
    private Boolean active;
    private Category category;
    private List<Integer> automateIds;
    private Set<ListingDeliveryStatus> deliveryStatuses;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDot() {
        return dot;
    }

    public Boolean getActive() {
        return active;
    }

    public Category getCategory() {
        return category;
    }

    public List<Integer> getAutomateIds() {
        return automateIds;
    }

    public Set<ListingDeliveryStatus> getDeliveryStatuses() {
        return deliveryStatuses;
    }
}

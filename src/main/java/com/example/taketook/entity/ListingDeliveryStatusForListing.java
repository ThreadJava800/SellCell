package com.example.taketook.entity;

import com.example.taketook.utils.ListingDeliveryStatus;

import javax.persistence.*;

@Entity
@Table(name = "listing_statuses")
public class ListingDeliveryStatusForListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private ListingDeliveryStatus status;

    public ListingDeliveryStatusForListing() {
    }

    public ListingDeliveryStatusForListing(ListingDeliveryStatus status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ListingDeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(ListingDeliveryStatus status) {
        this.status = status;
    }
}

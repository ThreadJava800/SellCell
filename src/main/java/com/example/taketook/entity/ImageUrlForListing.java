package com.example.taketook.entity;

import javax.persistence.*;

@Entity
@Table(name = "url_listings")
public class ImageUrlForListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String listingUrl;

    public ImageUrlForListing() {
    }

    public ImageUrlForListing(String listingUrl) {
        this.listingUrl = listingUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getListingUrl() {
        return listingUrl;
    }

    public void setListingUrl(String listingUrl) {
        this.listingUrl = listingUrl;
    }
}

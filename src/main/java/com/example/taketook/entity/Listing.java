package com.example.taketook.entity;

import com.example.taketook.utils.Category;
import com.example.taketook.utils.ListingDeliveryStatus;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "listings")
public class Listing {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private Integer author;
    private String dot;
    private Boolean active;
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "listing_url_listings",
            joinColumns = @JoinColumn(name = "listing"),
            inverseJoinColumns = @JoinColumn(name = "url_listing"))
    private Set<ImageUrlForListing> imageUrls;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "listing_comments",
            joinColumns = @JoinColumn(name = "listing"),
            inverseJoinColumns = @JoinColumn(name = "comment"))
    private Set<Comment> commentIds;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "listing_automates",
            joinColumns = @JoinColumn(name = "listing"),
            inverseJoinColumns = @JoinColumn(name = "automate"))
    private Set<Automate> wantedAutomates;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "listing_listing_statuses",
            joinColumns = @JoinColumn(name = "listing"),
            inverseJoinColumns = @JoinColumn(name = "listing_status"))
    private Set<ListingDeliveryStatusForListing> deliveryStatuses;

    public Listing() {}

    public Listing(String title, String description, Integer author, String dot, Boolean active, Category category, Set<ImageUrlForListing> imageUrls, Set<Comment> commentIds, Set<Automate> wantedAutomates, Set<ListingDeliveryStatusForListing> deliveryStatuses) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.dot = dot;
        this.active = active;
        this.category = category;
        this.imageUrls = imageUrls;
        this.commentIds = commentIds;
        this.wantedAutomates = wantedAutomates;
        this.deliveryStatuses = deliveryStatuses;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDot() {
        return dot;
    }

    public void setDot(String dot) {
        this.dot = dot;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    public Set<Comment> getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(Set<Comment> commentIds) {
        this.commentIds = commentIds;
    }

    public Set<ImageUrlForListing> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(Set<ImageUrlForListing> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Set<ListingDeliveryStatusForListing> getDeliveryStatuses() {
        return deliveryStatuses;
    }

    public void setDeliveryStatuses(Set<ListingDeliveryStatusForListing> deliveryStatuses) {
        this.deliveryStatuses = deliveryStatuses;
    }

    public Set<Automate> getWantedAutomates() {
        return wantedAutomates;
    }

    public void setWantedAutomates(Set<Automate> wantedAutomates) {
        this.wantedAutomates = wantedAutomates;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

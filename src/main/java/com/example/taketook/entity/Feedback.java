package com.example.taketook.entity;


import javax.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private Integer listingId;
    private Long starCount;
    private String text;

    public Feedback() {}

    public Feedback(Integer userId, Integer listingId, Long starCount, String text) {
        this.userId = userId;
        this.listingId = listingId;
        this.starCount = starCount;
        this.text = text;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(Integer listingId) {
        this.listingId = listingId;
    }

    public Long getStarCount() {
        return starCount;
    }

    public void setStarCount(Long starCount) {
        this.starCount = starCount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }
}

package com.example.taketook.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String password;
    private String avaUrl;
    private Double rating;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "user_feedbacks",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "feedback"))
    private Set<Feedback> userRatings = new HashSet<>(); // amount of people who left ratings

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "user_comments",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "comment"))
    private Set<Comment> commentIds = new HashSet<>();

    private String verifyCode;
    private Long verifyExpireDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "role"))
    private Set<Role> roles = new HashSet<>();

    public User() {}

    public User(String name, String surname, String email, String phone, String address, String city, String password, String avaUrl, Double rating, Set<Feedback> userRatings, Set<Comment> commentIds, String verifyCode, Long verifyExpireDate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.password = password;
        this.avaUrl = avaUrl;
        this.rating = rating;
        this.userRatings = userRatings;
        this.commentIds = commentIds;
        this.verifyCode = verifyCode;
        this.verifyExpireDate = verifyExpireDate;
    }

//    private Feedback checkIfNotOccupied(List<Feedback> userFeedbacks) {
//        for (Feedback f: userFeedbacks) {
//            if ()
//        }
//    }
//
//    public boolean rate(Double rating, List<Feedback> userId) {
//        if((rating > 0) && (rating <= 5) && !this.userRatings.contains(userId) && (!Objects.equals(this.id, userId.getUserId()))) {
//            this.userRatings.add(userId);
//            this.rating = (rating + this.rating) / this.userRatings.size();
//            return true;
//        }
//        return false;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvaUrl() {
        return avaUrl;
    }

    public void setAvaUrl(String avaUrl) {
        this.avaUrl = avaUrl;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Set<Feedback> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(Set<Feedback> userRatings) {
        this.userRatings = userRatings;
    }

    public Set<Comment> getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(Set<Comment> commentIds) {
        this.commentIds = commentIds;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Long getVerifyExpireDate() {
        return verifyExpireDate;
    }

    public void setVerifyExpireDate(Long verifyExpireDate) {
        this.verifyExpireDate = verifyExpireDate;
    }
}

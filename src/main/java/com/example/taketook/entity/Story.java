package com.example.taketook.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String iconUrl;
    private String infoIconUrl;

    public Story() {}

    public Story(String iconUrl, String infoIconUrl) {
        this.iconUrl = iconUrl;
        this.infoIconUrl = infoIconUrl;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getInfoIconUrl() {
        return infoIconUrl;
    }

    public void setInfoIconUrl(String infoIconUrl) {
        this.infoIconUrl = infoIconUrl;
    }
}

package com.demo.fukiapi.home.po;

public class HomeNew {
    private Integer id;

    private String imagePath;

    private String location;

    private Boolean isLive;

    private String livePath;

    private String languages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Boolean getIsLive() {
        return isLive;
    }

    public void setIsLive(Boolean isLive) {
        this.isLive = isLive;
    }

    public String getLivePath() {
        return livePath;
    }

    public void setLivePath(String livePath) {
        this.livePath = livePath == null ? null : livePath.trim();
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages == null ? null : languages.trim();
    }

    @Override
    public String toString() {
        return "HomeNew{" +
                "id=" + id +
                ", imagePath='" + imagePath + '\'' +
                ", location='" + location + '\'' +
                ", isLive=" + isLive +
                ", livePath='" + livePath + '\'' +
                ", languages='" + languages + '\'' +
                '}';
    }
}
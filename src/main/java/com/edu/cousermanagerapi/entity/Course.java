package com.edu.cousermanagerapi.entity;

import lombok.ToString;

import java.math.BigDecimal;

@ToString
public class Course {
    private Integer id;
    private String name;
    private String releaseDate;
    private String description;
    private BigDecimal duration;
    private String code;
    private BigDecimal rating;
    private BigDecimal price;
    private String imageUrl;

    public Course() {
    }

    public Course(Integer id, String name, String releaseDate, String description, Integer duration, String code, Double rating, Double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.description = description;
        this.duration = BigDecimal.valueOf(duration);
        this.code = code;
        this.rating = BigDecimal.valueOf(rating);
        this.price = BigDecimal.valueOf(price);
        this.imageUrl = imageUrl;
    }

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

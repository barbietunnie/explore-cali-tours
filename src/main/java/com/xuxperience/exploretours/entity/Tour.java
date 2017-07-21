package com.xuxperience.exploretours.entity;

import com.xuxperience.exploretours.data.Difficulty;
import com.xuxperience.exploretours.data.Region;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The Tour contains all attributes of an Explore California Tour.
 */
@Entity
@Table(name = "TOURS")
public class Tour implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @Column(length = 2000)
    private String description;
    @Column(length = 2000)
    private String blurb;
    private Integer price;
    private String duration;
    @Column(length = 2000)
    private String bullets;
    private String keywords;
    @ManyToOne
    private TourPackage tourPackage;
    private Difficulty difficulty;
    private Region region;

    protected Tour() {}

    public Tour(String title, String description, String blurb, Integer price,
                String duration, String bullets, String keywords, TourPackage tourPackage,
                Difficulty difficulty, Region region) {
        this.title = title;
        this.description = description;
        this.blurb = blurb;
        this.price = price;
        this.duration = duration;
        this.bullets = bullets;
        this.keywords = keywords;
        this.tourPackage = tourPackage;
        this.difficulty = difficulty;
        this.region = region;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBullets() {
        return bullets;
    }

    public void setBullets(String bullets) {
        this.bullets = bullets;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", blurb='" + blurb + '\'' +
                ", price=" + price +
                ", duration='" + duration + '\'' +
                ", bullets='" + bullets + '\'' +
                ", keywords='" + keywords + '\'' +
                ", tourPackage=" + tourPackage +
                ", difficulty=" + difficulty +
                ", region=" + region +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (!id.equals(tour.id)) return false;
        if (!title.equals(tour.title)) return false;
        if (!description.equals(tour.description)) return false;
        if (!blurb.equals(tour.blurb)) return false;
        if (!price.equals(tour.price)) return false;
        if (!duration.equals(tour.duration)) return false;
        if (!bullets.equals(tour.bullets)) return false;
        if (!keywords.equals(tour.keywords)) return false;
        if (!tourPackage.equals(tour.tourPackage)) return false;
        if (difficulty != tour.difficulty) return false;
        return region == tour.region;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + blurb.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + duration.hashCode();
        result = 31 * result + bullets.hashCode();
        result = 31 * result + keywords.hashCode();
        result = 31 * result + tourPackage.hashCode();
        result = 31 * result + difficulty.hashCode();
        result = 31 * result + region.hashCode();
        return result;
    }
}

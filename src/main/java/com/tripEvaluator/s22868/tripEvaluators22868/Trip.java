package com.tripEvaluator.s22868.tripEvaluators22868;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String destination;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviewList;
    //dodać własne

    public Trip() {}

    public Trip(Integer id, String title, String destination, List<Review> reviewList) {
        this.id = id;
        this.title = title;
        this.destination = destination;
        this.reviewList = reviewList;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public void addReviewToList(Review review){
        this.reviewList.add(review);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", destination='" + destination + '\'' +
                ", reviewList=" + reviewList +
                '}';
    }
//    dodać tu se własne pola
}

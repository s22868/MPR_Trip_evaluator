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
    //własne pola
    private int price;


    public Trip() {}

    public Trip(Integer id, String title, String destination, List<Review> reviewList, int price) {
        this.id = id;
        this.title = title;
        this.destination = destination;
        this.reviewList = reviewList;
        this.price = price;
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
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", destination='" + destination + '\'' +
                ", reviewList=" + reviewList +
                ", price=" + price +
                '}';
    }
}

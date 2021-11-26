package com.tripEvaluator.s22868.tripEvaluators22868;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    //dodać własne pola


    public Review() {}

    public Review(Integer id, String content, User user) {
        this.id = id;
        this.content = content;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author=" + user +
                '}';
    }
}

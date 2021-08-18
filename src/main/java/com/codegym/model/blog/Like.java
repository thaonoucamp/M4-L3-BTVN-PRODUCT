package com.codegym.model.blog;

import javax.persistence.*;

@Entity
@Table
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User userId;

    private int quantityLike = 0;
    private boolean status = false;

    public Like() {
    }

    public Like(int id, User userId, int quantityLike, boolean status) {
        this.id = id;
        this.userId = userId;
        this.quantityLike = quantityLike;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public int getQuantityLike() {
        return quantityLike;
    }

    public void setQuantityLike(int quantityLike) {
        this.quantityLike = quantityLike;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

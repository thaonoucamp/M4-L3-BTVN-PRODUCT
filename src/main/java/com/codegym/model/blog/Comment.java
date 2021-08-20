package com.codegym.model.blog;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User userId;

    @ManyToOne
    private Like likeId;

    @Column(columnDefinition = "TEXT")
    private String content;
    private int countComment = 0;
    private long date = System.currentTimeMillis();

    public Comment() {
    }

    public Comment(int id, User userId, Like likeId, long date, String content, int countComment) {
        this.id = id;
        this.userId = userId;
        this.likeId = likeId;
        this.date = date;
        this.content = content;
        this.countComment = countComment;
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

    public Like getLikeId() {
        return likeId;
    }

    public void setLikeId(Like likeId) {
        this.likeId = likeId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCountComment() {
        return countComment;
    }

    public void setCountComment(int countComment) {
        this.countComment = countComment;
    }
}

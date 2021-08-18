package com.codegym.model.blog;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue
    private int id;
    private String tittle;
    private String content;
    private long date = System.currentTimeMillis();
    private boolean status = true;

    @ManyToOne
    private User author;

    @ManyToOne
    private Comment commentId;

    @ManyToOne
    private Like likeId;

    public Blog() {
    }

    public Blog(int id, String tittle, String content, long date, boolean status, User author, Comment commentId, Like likeId) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
        this.date = date;
        this.status = status;
        this.author = author;
        this.commentId = commentId;
        this.likeId = likeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Comment getCommentId() {
        return commentId;
    }

    public void setCommentId(Comment commentId) {
        this.commentId = commentId;
    }

    public Like getLikeId() {
        return likeId;
    }

    public void setLikeId(Like likeId) {
        this.likeId = likeId;
    }
}

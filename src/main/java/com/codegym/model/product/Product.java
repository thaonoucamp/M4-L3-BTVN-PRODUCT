package com.codegym.model.product;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private int id;
    private String name;
    private Singer singer;
    private Category category;
    private String fileMusic;

    public Product() {
    }

    public Product(int id, String name, Singer singer, Category category, String fileMusic) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
        this.fileMusic = fileMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getFileMusic() {
        return fileMusic;
    }

    public void setFileMusic(String fileMusic) {
        this.fileMusic = fileMusic;
    }
}
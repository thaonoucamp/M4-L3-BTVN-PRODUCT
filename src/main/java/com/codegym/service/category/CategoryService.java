package com.codegym.service.category;

import com.codegym.model.product.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategory {
    static private List<Category> categories;

    static {
        categories = new ArrayList<>();
        categories.add(new Category(1, "VinFast"));
        categories.add(new Category(2, "Lexus"));
        categories.add(new Category(3, "Mercedes"));
        categories.add(new Category(4, "Toyota"));
    }

    public String findById(int id) {
        String name = "";
        for (Category c : categories) {
            if (id == c.getId()) {
                name = c.getName();
                return name;
            }
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public void save(Category category) {
    }

    @Override
    public void update(int id, Category category) {

    }

    @Override
    public void remove(int id) {

    }
}

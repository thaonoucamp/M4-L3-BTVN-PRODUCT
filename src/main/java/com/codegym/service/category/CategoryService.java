package com.codegym.service.category;

import com.codegym.model.product.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategory {
    private List<Category> categories;

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

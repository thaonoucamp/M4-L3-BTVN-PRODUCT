package com.codegym.service.blog;

import com.codegym.model.blog.Blog;
import com.codegym.model.product.Product;
import com.codegym.repository.blog.IRepoBlog;
import com.codegym.repository.product.IRepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService implements IPostService {
    @Autowired
    IRepoBlog repoProduct;

    List<Blog> products = new ArrayList<>();

    @Override
    public List<Blog> findAll() {
        products = repoProduct.findAll();
        return products;
    }

    @Override
    public void save(Blog product) {
        repoProduct.save(product);
    }

    @Override
    public Blog findById(int id) {
        return repoProduct.findById(id);
    }

    @Override
    public void update(int id, Blog product) {
        repoProduct.update(id, product);
    }

    @Override
    public void remove(int id) {
        repoProduct.remove(id);
    }

    @Override
    public List<Blog> findByName(String name) {
        List<Blog> blogs = repoProduct.findAll();
        for (Blog s : blogs) {
            if (s.getTittle().equalsIgnoreCase(name)) {
                blogs.add(s);
            }
            return blogs;
        }
        return null;
    }
}

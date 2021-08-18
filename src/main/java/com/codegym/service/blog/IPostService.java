package com.codegym.service.blog;

import com.codegym.GeneralCRUD;
import com.codegym.model.blog.Blog;
import com.codegym.model.product.Product;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.List;

@Service
public interface IPostService extends GeneralCRUD<Blog> {
    public List<Blog> findByName(String name);

    public Blog findById(int id);
}

package com.codegym.service.blog;

import com.codegym.model.blog.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPostService extends GeneralCRUD<Blog> {
    public List<Blog> findByName(String name);

    public Blog findById(int id);
}

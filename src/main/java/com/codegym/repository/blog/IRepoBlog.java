package com.codegym.repository.blog;

import com.codegym.model.blog.Blog;

public interface IRepoBlog extends GeneralCRUD<Blog> {
    public Blog findById(int id);
    }

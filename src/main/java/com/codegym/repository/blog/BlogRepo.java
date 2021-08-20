package com.codegym.repository.blog;

import com.codegym.model.blog.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BlogRepo implements IRepoBlog {
    @Qualifier("entityManager")
    @Autowired
    EntityManager manager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = manager.createQuery("select c from Blog as c", Blog.class);
        return query.getResultList();
    }

    @Override
    public void save(Blog blog) {
        manager.getTransaction().begin();
        if (blog.getId() != -1) {
            manager.merge(blog);
            manager.getTransaction().commit();
        } else {
            manager.getTransaction().rollback();
        }
    }

    @Override
    public void update(int id, Blog blog) {
        manager.getTransaction().begin();
        blog.setId(id);
        manager.merge(blog);
        manager.getTransaction().commit();
    }

    @Override
    public void remove(int id) {
        Blog blog = findById(id);
        manager.getTransaction().begin();
        if (blog.getId() != -1) {
            manager.remove(blog);
            manager.getTransaction().commit();
        }
    }

    @Override
    public Blog findById(int id) {
        TypedQuery<Blog> query = manager.createQuery("select c from Blog c where c.id=:id", Blog.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}

package com.codegym.repository.product;

import com.codegym.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductRepo implements IRepoProduct {
    @Autowired
    EntityManager entityManager;

    EntityTransaction transaction;

    @Override
    public List<Product> findAll() {
        String query = "select p from Product as p";
        TypedQuery<Product> excutedResult = entityManager.createQuery(query, Product.class);
        return excutedResult.getResultList();
    }

    @Override
    public void save(Product product) {
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public void update(int id, Product product) {
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(product);
        transaction.commit();
    }

    @Override
    public void remove(int id) {
        List<Product> products = findAll();
        Product product = null;
        for (Product p : products) {
            if (id == product.getId()) {
                product = p;
            }
        }
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(product.getId());
        transaction.commit();
    }
}

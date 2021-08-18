package com.codegym.service.product;

import com.codegym.model.product.Product;
import com.codegym.repository.product.IRepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IRepoProduct repoProduct;

    List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        products = repoProduct.findAll();
        return products;
    }

    @Override
    public void save(Product product) {
       repoProduct.save(product);
    }

    public Product findById(int id) {
        for (Product s : products) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
      repoProduct.update(id, product);
    }

    @Override
    public void remove(int id) {
        repoProduct.remove(id);
    }


    public List<Product> findByName(String name) {
        List<Product> students = new ArrayList<>();
        for (Product s : products) {
            if (s.getName().equalsIgnoreCase(name)) {
                students.add(s);
            }
            return students;
        }
        return null;
    }
}

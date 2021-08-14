package com.codegym.service.product;

import com.codegym.model.Student;
import com.codegym.model.product.Product;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "VinFast President", 1000, 1));
        products.add(new Product(2, "LX 350", 1000, 2));
        products.add(new Product(3, "Maybach S600", 1000, 3));
        products.add(new Product(4, "Land Cruiser 2020", 1000, 4));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
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
        product.setId(id);
        products.add(product);
    }

    @Override
    public void remove(int id) {
        products.remove(findById(id));
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

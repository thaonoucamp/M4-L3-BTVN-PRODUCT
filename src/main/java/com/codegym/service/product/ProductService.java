package com.codegym.service.product;

import com.codegym.model.Student;
import com.codegym.model.product.Category;
import com.codegym.model.product.Product;
import com.codegym.model.product.Singer;
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
        products.add(new Product(1, "Nguoi ra di vi dau", new Singer(1, "Pham Khanh Hung"), new Category(1, "Nhac tre"),"file/music/nhactre/nguoiradividau"));
        products.add(new Product(2, "Chim trang mo coi", new Singer(2, "Dan truong"), new Category(2, "Nhac tru tinh"),"file/music/nhactrutinh/chimtrangmocoi"));
        products.add(new Product(3, "Em se la nguoi ra di", new Singer(3, "Cam ly"), new Category(3, "Nhac tru tinh"),"file/music/nhactrutinh/emselanguoiradi"));
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

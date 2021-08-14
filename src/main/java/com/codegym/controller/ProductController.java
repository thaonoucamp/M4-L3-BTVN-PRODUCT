package com.codegym.controller;

import com.codegym.model.product.Product;
import com.codegym.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("/product/index");
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 100));
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @PutMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/products";
    }

    @GetMapping("/delete?{id}")
    public ModelAndView showFormDelete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/product/delete");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @DeleteMapping("/delete")
    public String delete(Product product) {
        productService.remove(product.getId());
        return "redirect:/products";
    }

    @GetMapping("/search/{name}")
    public ModelAndView findByName(@PathVariable String name) {
        List<Product> products = productService.findByName("%" + name + "%");
        ModelAndView modelAndView = new ModelAndView("/product/index");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/product/view");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
}

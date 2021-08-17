package com.codegym.controller;

import com.codegym.model.product.Category;
import com.codegym.model.product.Product;
import com.codegym.model.product.Singer;
import com.codegym.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private Category categoryService;

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
    public String save(@ModelAttribute Product product,
                             @RequestParam MultipartFile fileMusic1,
                             @RequestParam String singerName,
                             @RequestParam int idCategory) {
        String fileName = fileMusic1.getOriginalFilename();
        try {
            FileCopyUtils.copy(fileMusic1.getBytes(), new File("/Users/thaodangxuan/M4-L3-THYMELEAF-THUC-HANH/src/main/webapp/music" + fileName));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        String urlMusic = "/fileMusic/music" + fileName;

        Singer singer = new Singer();
        singer.setId((int) (Math.random() * 100));
        singer.setName(singerName);

        Category category = new Category();
        category.setId(idCategory);


        product.setId((int) (Math.random() * 100));
        product.setFileMusic(urlMusic);
        product.setSinger(singer);
        product.setCategory(category);

        productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@RequestParam Product product,
                         @RequestParam MultipartFile fileMusic,
                         @RequestParam String singerName,
                         @RequestParam String categoryName) {
        String fileName = fileMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(fileMusic.getBytes(), new File("/Users/thaodangxuan/M4-L3-THYMELEAF-THUC-HANH/src/main/webapp/music" + fileName));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        String urlMusic = "/fileMusic/music" + fileName;

        Singer singer = new Singer();
        singer.setId(product.getSinger().getId());
        singer.setName(singerName);

        Category category = new Category();
        category.setId(product.getCategory().getId());
        category.setName(categoryName);

        product.setId((product.getId()));
        product.setId((singer.getId()));
        product.setId((category.getId()));
        product.setFileMusic(urlMusic);
        productService.update(product.getId(), product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/product/delete");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(Product product, Model model) {
        productService.remove(product.getId());
        model.addAttribute("success", "Da xoa thanh cong 1 product");
        return "redirect:/products";
    }

    @GetMapping("/search")
    public ModelAndView findByName(@RequestParam("inputSearch") String name) {
        List<Product> products = productService.findByName(name);
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

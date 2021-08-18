package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.blog.Blog;
import com.codegym.service.blog.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IPostService postService;


    @GetMapping("")
    public ModelAndView index() {
        List<Blog> blogs = postService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog) {
        postService.save(blog);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", postService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@RequestParam int id,@ModelAttribute Blog blog) {
        postService.update(id, blog);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        modelAndView.addObject("blog", postService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Blog blog, RedirectAttributes redirect) {
        postService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/blog/view");
        modelAndView.addObject("blog", postService.findById(id));
        return modelAndView;
    }
}

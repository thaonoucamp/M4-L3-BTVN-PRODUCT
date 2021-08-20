package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ModelAndView index(Page page) {
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        modelAndView.addObject("customers", customerService.findAll(page));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@RequestParam Long id,@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/customer/delete");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirect) {
        customerService.remove(id);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/customer/view");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }
}
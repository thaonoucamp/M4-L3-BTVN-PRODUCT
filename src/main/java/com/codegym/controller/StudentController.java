package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.student.IStudentService;
import com.codegym.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public ModelAndView showAll(){
        List<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/student/index");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Student student){
        student.setId((int) (Math.random() * 100));
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/student/edit");
        modelAndView.addObject("student", studentService.findById(id));
        return modelAndView;
    }

    @PutMapping("/update")
    public String update(Student student){
        studentService.update(student.getId(), student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showFormDelete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/student/delete");
        modelAndView.addObject("student", studentService.findById(id));
        return modelAndView;
    }

    @DeleteMapping("/delete")
    public String delete(Student student){
        studentService.remove(student.getId());
        return "redirect:/students";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/student/view");
        modelAndView.addObject("student", studentService.findById(id));
        return modelAndView;
    }

    @GetMapping("/{name}/search")
    public ModelAndView findByName(@PathVariable String name){
       List<Student> students = studentService.findByName("%" + name + "%");
        ModelAndView modelAndView = new ModelAndView("/student/index");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
}

package com.codegym.service.student;

import com.codegym.model.Student;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    static List<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student(1, "a", Date.valueOf(LocalDate.of(1990,06,26)), "hn", "098999888", "a@gmail.com", "C04"));
//        students.add(new Student(2, "b", Date.valueOf("1990/26/06"), "hn", "097999888", "b@gmail.com", "C04"));
//        students.add(new Student(3, "c", Date.valueOf("1990/26/06"), "hn", "096999888", "c@gmail.com", "C04"));
//        students.add(new Student(4, "d", Date.valueOf("1990/26/06"), "hn", "091999888", "d@gmail.com", "C04"));
//        students.add(new Student(5, "3", Date.valueOf("1990/26/06"), "hn", "094999888", "e@gmail.com", "C04"));
    }

    @Override
    public List<Student> findAll() {
        return StudentService.students;
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Student student) {
        student.setId(id);
        students.add(student);
    }

    @Override
    public void remove(int id) {
        students.remove(findById(id));
    }

    public List<Student> findByName(String name) {
        List<Student> students = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                students.add(s);
            }
            return students;
        }
        return null;
    }
}

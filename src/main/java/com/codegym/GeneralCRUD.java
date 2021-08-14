package com.codegym;

import com.codegym.model.Student;

import java.util.List;

public interface GeneralCRUD <T>{
    List<T> findAll();

    void save(T t);

    void update(int id, T t);

    void remove(int id);
}

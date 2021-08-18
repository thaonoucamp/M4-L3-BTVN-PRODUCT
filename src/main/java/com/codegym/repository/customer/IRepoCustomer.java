package com.codegym.repository.customer;

import com.codegym.GeneralCRUD;
import com.codegym.model.Customer;

public interface IRepoCustomer extends GeneralCRUD<Customer> {
    public Customer findById(int id);
    }

package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.repository.customer.IRepoCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private IRepoCustomer repoCustomer;

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(repoCustomer.findAll());
    }

    @Override
    public void save(Customer customer) {
        repoCustomer.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return repoCustomer.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        repoCustomer.update(id, customer);
    }

    @Override
    public void remove(int id) {
        repoCustomer.remove(id);
    }

}
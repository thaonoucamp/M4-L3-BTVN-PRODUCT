package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.Province;
import com.codegym.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(Page page) {
        return customerRepository.findAll((Pageable) page);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findAllByName(name);
    }
}
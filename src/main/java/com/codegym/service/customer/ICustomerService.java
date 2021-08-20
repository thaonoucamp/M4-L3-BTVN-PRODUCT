package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.Province;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll(Page page);

}

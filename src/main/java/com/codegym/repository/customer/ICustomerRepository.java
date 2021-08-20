package com.codegym.repository.customer;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.Province;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    @Query(value = "select c from Customer c where c.name like concat('%',:name,'%')")
    List<Customer> findAllByName(@Param("name") String name);
}
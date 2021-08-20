package com.codegym.repository.customer;

import com.codegym.model.customer.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}

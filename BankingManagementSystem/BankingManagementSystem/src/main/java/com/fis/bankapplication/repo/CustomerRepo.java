package com.fis.bankapplication.repo;

import org.springframework.data.repository.CrudRepository;

import com.fis.bankapplication.model.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {

}

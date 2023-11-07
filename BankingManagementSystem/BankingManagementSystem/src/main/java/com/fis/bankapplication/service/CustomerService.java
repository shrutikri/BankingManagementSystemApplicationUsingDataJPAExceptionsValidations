package com.fis.bankapplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankapplication.exception.CustomerNotFound;
import com.fis.bankapplication.model.Customer;
import com.fis.bankapplication.repo.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;

	public String createCustomer(Customer customer) {
		customerRepo.save(customer);
		return "Customer Saved Successfully";
	}

	public Customer getCustomerInfo(int accNo) throws CustomerNotFound {
		Optional<Customer> optional = customerRepo.findById(accNo);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new CustomerNotFound("Account Number is invalid!!!");
		}
		//return customerRepo.findById(accNo).orElse(null);
	}

	public String deleteCustomer(int accNo) {
		customerRepo.deleteById(accNo);
		return "Customer Deleted Successfully!!!";
	}

}

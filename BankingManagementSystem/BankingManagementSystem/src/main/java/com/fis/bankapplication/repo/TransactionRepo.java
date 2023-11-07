package com.fis.bankapplication.repo;

import org.springframework.data.repository.CrudRepository;

import com.fis.bankapplication.model.Transaction;

public interface TransactionRepo extends CrudRepository<Transaction, Integer> {

}

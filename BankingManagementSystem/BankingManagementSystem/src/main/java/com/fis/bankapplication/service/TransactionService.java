package com.fis.bankapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankapplication.model.Transaction;
import com.fis.bankapplication.repo.TransactionRepo;

@Service
public class TransactionService {
	@Autowired
	TransactionRepo transactionRepo;

	public void addTransactions(Transaction transaction) {
		transactionRepo.save(transaction);
	}

	public Transaction showTransactions(int accNo) {
		return transactionRepo.findById(accNo).orElse(null);
	}

	public void deleteTransactions(int accNo) {
		transactionRepo.deleteById(accNo);
	}
}

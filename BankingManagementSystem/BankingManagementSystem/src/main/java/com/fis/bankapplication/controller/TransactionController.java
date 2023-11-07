package com.fis.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankapplication.exception.CustomerNotFound;
import com.fis.bankapplication.model.Transaction;
import com.fis.bankapplication.service.TransactionService;

/*
 * RestController: Use to create restful WebServices and also takes care of mapping request data 
 * to the defined request handler method. 
 */
@RestController

//RequestMapping: Used to map HTTP requests to handler methods
@RequestMapping("/account")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;

	// this method is used to add Transactions
	public void addTransactions(Transaction transaction) {
		transactionService.addTransactions(transaction);
	}

	// this method is used to show single Transaction
	// http://localhost:8080/account/202300001/Transactions
	@GetMapping("/{accNo}/Transactions")
	public Transaction showTransactions(@PathVariable int accNo) {
		return transactionService.showTransactions(accNo);
	}

	// this method is used to delete Transactions
	// http://localhost:8080/account/deleteTransactions/202300001/Transactions
	@DeleteMapping("/deleteTransactions/{accNo}/Transactions")
	public void deleteTransactions(int accNo) throws CustomerNotFound {
		transactionService.deleteTransactions(accNo);
	}
}

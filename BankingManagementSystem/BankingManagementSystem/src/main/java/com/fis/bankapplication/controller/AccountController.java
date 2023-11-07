package com.fis.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankapplication.exception.CustomerNotFound;
import com.fis.bankapplication.exception.NotEnoughBalance;
import com.fis.bankapplication.model.Accounts;
import com.fis.bankapplication.model.Transaction;
import com.fis.bankapplication.service.AccountService;

/*
 * RestController: Use to create restful WebServices and also takes care of mapping request data 
 * to the defined request handler method. 
 */
@RestController
//RequestMapping: Used to map HTTP requests to handler methods
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionController transactionController;

	// createAccount happens upon createCustomer
	public void createAccount(@RequestBody @Validated int accNo, int balance, String acctStatus) {
		Accounts acct = new Accounts(accNo, balance, acctStatus);
		accountService.createAccount(acct);
	}

	// this method is used for checking the Balance
	// http://localhost:8080/account/202300001/balance
	@GetMapping("/{accNo}/balance")
	public int getBalance(@PathVariable int accNo) throws CustomerNotFound {
		return accountService.getBalance(accNo);
	}

	// this method is used for depositing Amount
	// http://localhost:8080/account/202300001/deposit/90000
	@PutMapping("/{accNo}/deposit/{amount}")
	public String depositAmount(@PathVariable int accNo, @PathVariable int amount) throws CustomerNotFound {
		int initBal = getBalance(accNo);
		accountService.depositAmount(accNo, amount);
		Transaction transaction = new Transaction(accNo, "Deposited", "Success", initBal, initBal + amount);
		transactionController.addTransactions(transaction);
		return "Account deposited with entered amount successfully";
	}

	// this method is used for withdrawing Amount
	// http://localhost:8080/account/202300001/withdraw/10000
	@PutMapping("/{accNo}/withdraw/{amount}")
	public String withdrawAmount(@PathVariable int accNo, @PathVariable int amount)
			throws CustomerNotFound, NotEnoughBalance {
		int initBal = getBalance(accNo);
		accountService.withdrawAmount(accNo, amount);
		Transaction transaction = new Transaction(accNo, "Withdrawn", "Success", initBal, initBal - amount);
		transactionController.addTransactions(transaction);
		return "Account withdrawn with entered amount successfully";
	}

	// this method is used for transferring Amount
	// http://localhost:8080/account/202300001/transfer/202300002/10000
	@PutMapping("/{accNo}/transfer/{destAccNo}/{amount}")
	public String transferAmount(@PathVariable int accNo, @PathVariable int destAccNo, @PathVariable int amount)
			throws CustomerNotFound, NotEnoughBalance {
		int initBalSender = getBalance(accNo);
		int initBalReceiver = getBalance(destAccNo);
		accountService.transferAmount(accNo, destAccNo, amount);
		Transaction moneySender = new Transaction(accNo, "Transferred", "Success", initBalSender,
				initBalSender - amount);
		transactionController.addTransactions(moneySender);
		Transaction moneyReceiver = new Transaction(destAccNo, "Received", "Success", initBalReceiver,
				initBalReceiver + amount);
		transactionController.addTransactions(moneyReceiver);
		return "Amount transferred Successfully!!";
	}

	// this method is used for deleting the Account
	// http://localhost:8080/account/deleteAccount/202300003
	@DeleteMapping("/deleteAccount/{accNo}")
	public String deleteAccount(@PathVariable int accNo) throws CustomerNotFound {
		accountService.deleteAccount(accNo);
		transactionController.deleteTransactions(accNo);
		return "Account deleted successfully";
	}

	// this method is used for getting AccountInfo
	// http://localhost:8080/account/getAccountInfo/202300001
	@GetMapping("/getAccountInfo/{accNo}")
	public Accounts getAccountInfo(@PathVariable int accNo) throws CustomerNotFound {
		try {
			return accountService.getAccountInfo(accNo);
		} catch (CustomerNotFound e) {
			// TODO Auto-generated catch block
			throw new CustomerNotFound("Invalid Account number!!!");

		}
	}

}

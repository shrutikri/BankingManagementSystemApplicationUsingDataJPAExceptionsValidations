package com.fis.bankapplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankapplication.exception.CustomerNotFound;
import com.fis.bankapplication.exception.NotEnoughBalance;
import com.fis.bankapplication.model.Accounts;
import com.fis.bankapplication.repo.AccountsRepo;
@Service
public class AccountService {
	@Autowired
	private AccountsRepo accountRepository;

	public void createAccount(Accounts acct) {
		accountRepository.save(acct);
	}

	public Accounts getAccountInfo(int accNo) throws CustomerNotFound {
		Optional<Accounts> optional = accountRepository.findById(accNo);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new CustomerNotFound("Account Number is invalid !");
		}
	}

	public void deleteAccount(int accNo) {
		accountRepository.deleteById(accNo);
	}

	public int getBalance(int accNo) {
		return accountRepository.findBalanceByAccNo(accNo);
	}

	public void depositAmount(int accNo, int amount) {
		accountRepository.saveBalanceByAccNo(accNo, amount);
	}

	public void withdrawAmount(int accNo, int amount) throws NotEnoughBalance{
		accountRepository.withdrawAmountByAccNo(accNo, amount);
	}

	public void transferAmount(int accNo, int destAccNo, int amount) throws NotEnoughBalance {
		accountRepository.withdrawAmountByAccNo(accNo, amount);
		accountRepository.saveBalanceByAccNo(destAccNo, amount);
	}

}

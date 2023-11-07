package com.fis.bankapplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accounts {
	@Id
	//@Min(value = 6, message = "Account Number Cannot be less than 6")
	//@Max(value = 10, message = "Account Number cannot be greater than 10") // MANVE
	private int accNo;
	private int balance;
	private String acctStatus;

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAcctStatus() {
		return acctStatus;
	}

	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
	}

	@Override
	public String toString() {
		return "Accounts [accNo=" + accNo + ", balance=" + balance + ", acctStatus=" + acctStatus + "]";
	}

	public Accounts(int accNo, int balance, String acctStatus) {
		super();
		this.accNo = accNo;
		this.balance = balance;
		this.acctStatus = acctStatus;
	}

	public Accounts() {
	}

}

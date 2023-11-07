package com.fis.bankapplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	// @Min(value = 6, message = "Account Number Cannot be less than 6")
	// @Max(value = 10, message = "Account Number cannot be greater than 10") //--MANVE
	private int accNo;
	private String transacType;
	private String transacStatus;
	private int initBal;
	private int finalBal;

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getTransacType() {
		return transacType;
	}

	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}

	public String getTransacStatus() {
		return transacStatus;
	}

	public void setTransacStatus(String transacStatus) {
		this.transacStatus = transacStatus;
	}

	public int getInitBal() {
		return initBal;
	}

	public void setInitBal(int initBal) {
		this.initBal = initBal;
	}

	public int getFinalBal() {
		return finalBal;
	}

	public void setFinalBal(int finalBal) {
		this.finalBal = finalBal;
	}

	@Override
	public String toString() {
		return "Transaction [accNo=" + accNo + ", transacType=" + transacType + ", transacStatus=" + transacStatus
				+ ", initBal=" + initBal + ", finalBal=" + finalBal + "]";
	}

	public Transaction(int accNo, String transacType, String transacStatus, int initBal, int finalBal) {
		super();
		this.accNo = accNo;
		this.transacType = transacType;
		this.transacStatus = transacStatus;
		this.initBal = initBal;
		this.finalBal = finalBal;
	}

	public Transaction() {

	}

}

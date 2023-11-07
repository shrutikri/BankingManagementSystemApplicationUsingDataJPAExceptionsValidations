package com.fis.bankapplication.exception;

@SuppressWarnings("serial")
public class NotEnoughBalance extends Exception {
	public NotEnoughBalance(String message) {
		super(message);
	}

}

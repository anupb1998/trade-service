package com.db.trade.exception;

public class StaleTradeException extends Exception {
	private static final long serialVersionUID = 1L;

	public StaleTradeException(String message) {
		super(message);
	}

}

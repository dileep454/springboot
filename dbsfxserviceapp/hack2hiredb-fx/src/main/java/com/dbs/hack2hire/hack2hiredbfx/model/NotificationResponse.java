package com.dbs.hack2hire.hack2hiredbfx.model;

public class NotificationResponse {

	private int userId;
	private String fromCurrency;
	private String toCurrency;
	private Double exchangeValue;
	private String accountNumber;
    
	
	public NotificationResponse(int userId,String fromCurrency, String toCurrency, Double exchangeValue, String accountNumber) {
		super();
		this.userId=userId;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.exchangeValue = exchangeValue;
		this.accountNumber = accountNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public Double getExchangeValue() {
		return exchangeValue;
	}

	public void setExchangeValue(Double exchangeValue) {
		this.exchangeValue = exchangeValue;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}

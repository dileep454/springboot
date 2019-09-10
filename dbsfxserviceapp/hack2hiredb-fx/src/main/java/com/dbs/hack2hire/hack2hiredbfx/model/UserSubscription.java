package com.dbs.hack2hire.hack2hiredbfx.model;

import java.util.Date;

public class UserSubscription {

	private Integer id;
	private Date fromDate;
	private Date toDate;
	private String toCurrency; //currency
	private Double configValue; //currency_rate
	private String toAccountNumber;
	private String fromCurrency;
	private Double amountTobeTransfer;// amount_transferred
	
	private Integer subscriptionNumber;
	private String source;
	
	
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public UserSubscription(Integer id, Date fromDate, Date toDate, String toCurrency, Double configValue,
			String toAccountNumber, Double amountTobeTransfer, Integer subscriptionNumber) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.toCurrency = toCurrency;
		this.configValue = configValue;
		this.toAccountNumber = toAccountNumber;
		this.amountTobeTransfer = amountTobeTransfer;
		this.subscriptionNumber = subscriptionNumber;
	}
	public Integer getSubscriptionNumber() {
		return subscriptionNumber;
	}
	public void setSubscriptionNumber(Integer subscriptionNumber) {
		this.subscriptionNumber = subscriptionNumber;
	}
	public String getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	public Double getAmountTobeTransfer() {
		return amountTobeTransfer;
	}
	public void setAmountTobeTransfer(Double amountTobeTransfer) {
		this.amountTobeTransfer = amountTobeTransfer;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Double getConfigValue() {
		return configValue;
	}
	public void setConfigValue(Double configValue) {
		this.configValue = configValue;
	}
	
}

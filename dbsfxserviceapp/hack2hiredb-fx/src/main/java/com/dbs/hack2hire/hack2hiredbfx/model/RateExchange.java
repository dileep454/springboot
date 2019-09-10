package com.dbs.hack2hire.hack2hiredbfx.model;

public class RateExchange {

	private String Id;
	private String fromCurrency;
	private String toCurrency;
	private Double exchangeValue;
	private String fromDate;
	private String toDate;
	private String source;
	
	
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
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
	
	
}

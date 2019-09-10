package com.dbs.hack2hire.hack2hiredbfx.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.hack2hire.hack2hiredbfx.model.RateExchange;
import com.dbs.hack2hire.hack2hiredbfx.model.UserSubscription;
import com.dbs.hack2hire.hack2hiredbfx.repo.FxRepository;

@Service
public class FxService  {

	@Autowired
	private FxRepository fxRepository;
	
	public List<String> getCurrency() {

		return fxRepository.getCurrency();
	}

	public Double calulateFxRate(String toCurrency, Double amount) {
		
		Double rate=fxRepository.getRateForCurrency(toCurrency);
		return amount*rate;
		
		
	}

	public boolean addSubScribe(UserSubscription userSubscription) {
		fxRepository.addSubScribe(userSubscription);
		return true;
	}

	public List<UserSubscription> getUserSubscriptions(String userId) {
		return fxRepository.getUserSubscriptions(userId);
	}

	public boolean deleteSubScription(Integer subScriptionId) {
		return fxRepository.deleteSubScription(subScriptionId);
	}

	public List<RateExchange> getRTXDate(String fromCurrency, String toCurrency, String fromDate, String toDate) throws ClassNotFoundException, SQLException, ParseException {
		return fxRepository.getRTXDate(fromCurrency,toCurrency,fromDate,toDate);
	}

}

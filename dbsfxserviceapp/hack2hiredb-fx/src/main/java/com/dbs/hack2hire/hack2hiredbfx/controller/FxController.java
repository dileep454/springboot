package com.dbs.hack2hire.hack2hiredbfx.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dbs.hack2hire.hack2hiredbfx.model.RateExchange;
import com.dbs.hack2hire.hack2hiredbfx.model.UserSubscription;
import com.dbs.hack2hire.hack2hiredbfx.service.FxService;

@CrossOrigin
@RestController
public class FxController {

	@Autowired
	private FxService fxService;

	@GetMapping("/getCurrencies")
	public List<String> getCurrency() {
		return fxService.getCurrency();
	}

	@GetMapping("/calculate/{fromCurrency}/{toCurrency}/{amount}")
	public Double calculate(@PathVariable("fromCurrency") String fromCurrency,
			@PathVariable("toCurrency") String toCurrency, @PathVariable("amount") Double amount) {
		RestTemplate rest = new RestTemplate();
		Double result = null;
		String tempFromToCurr = fromCurrency + "_" + toCurrency;
		Map response = rest.getForObject("https://free.currconv.com/api/v7/convert?q=" + tempFromToCurr
				+ "&compact=ultra&apiKey=68a2f269bbd615d34c8f", Map.class);
		result = (Double) response.get(tempFromToCurr);
		result*=amount;

		return result;
	}

	@GetMapping("/calculate/{toCurrency}/{amountToCalculate}")
	public Double calulateFxRate(@PathVariable("toCurrency") String toCurrency,
			@PathVariable("amountToCalculate") Double amount) {
		Double result = 0.0;
		if (!toCurrency.isEmpty() && amount > 0) {
			result = fxService.calulateFxRate(toCurrency, amount);
		}

		return result;
	}
	
	@PostMapping("/addsubscribe")
	public String addSubScribe(@RequestBody UserSubscription userSubscription) {
		String responseMsg="";
		if(null!=userSubscription) {
			boolean res=fxService.addSubScribe(userSubscription);
			if(res) {				
				responseMsg="The SubScription added successfully!";
			}
			else {			
				responseMsg="Failed to add the subscription!";
			}
		}else {			
			responseMsg="Failed to add the subscription!";
		}
		return responseMsg;
	}
	
	@GetMapping("/getSubScriptions")
	public List<UserSubscription> getSubScription(@RequestParam("userId") String userId){
		return fxService.getUserSubscriptions(userId);
		
	}
	
	@DeleteMapping("deleteSubscription/{subScriptionId}")
	public String deleteSubScription(@PathVariable("subScriptionId") Integer subScriptionId) {
		boolean res=fxService.deleteSubScription(subScriptionId);
		String response="";
		if(res) {
			response="The subscrpition is Deleted Successfully!!";
		}else {
			response="Error occured while deleting the subscription.";
		}
		return response;
	}
	
	@PutMapping("/getRTXSearch")
	public List<RateExchange> getRTXDate(@RequestBody RateExchange ratexchange) {
		try {
			return fxService.getRTXDate(ratexchange.getFromCurrency(),ratexchange.getToCurrency(),ratexchange.getFromDate(),ratexchange.getToDate());
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			e.getLocalizedMessage();
		}
		return null;
	}
	
}

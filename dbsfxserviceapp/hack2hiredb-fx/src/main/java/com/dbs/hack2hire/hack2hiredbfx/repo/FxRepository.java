package com.dbs.hack2hire.hack2hiredbfx.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.dbs.hack2hire.hack2hiredbfx.MyConnection;
import com.dbs.hack2hire.hack2hiredbfx.model.RateExchange;
import com.dbs.hack2hire.hack2hiredbfx.model.UserSubscription;

@Repository
public class FxRepository {

	List<UserSubscription> userSubscriptions=new ArrayList<>();
	Map<Integer, UserSubscription> userSubscriptionMap=new HashMap<>();
	Integer num=new Integer(1000);
	private static final String SQL_GET_RTX_DATA="select  Rate,From_currency,To_currency,Source,concat(date_month,\"/\",date_day,\"/\",year(current_date)) as date_id  from fx_data.fact_predict_data1 where From_currency=? and To_currency=? and (date_month>=? and date_month<=?) and (date_day>=? and date_day<=?)  order by Rate desc limit 10";
	AtomicInteger atomicInteger=new AtomicInteger();
	public List<String> getCurrency() {
			List<String> result=new ArrayList<>();
			result.add("AED");
			result.add("AUD");
			result.add("CAD");
			result.add("CZK");
			result.add("EUR");
			result.add("GBP");
			result.add("HKD");
			result.add("JPY");
			result.add("MXN");
			result.add("NOK");
			result.add("NZD");
			result.add("SGD");
			result.add("THB");
			result.add("USD");
		return result;
		
	}

	public Double getRateForCurrency(String toCurrency) {
			return 60.0;
		
	}

	public boolean addSubScribe(UserSubscription userSubscription) {
		userSubscription.setSubscriptionNumber(atomicInteger.addAndGet(100));
		userSubscriptionMap.put(userSubscription.getSubscriptionNumber(), userSubscription);
		return true;
		
	}
	
	public List<UserSubscription> getUserSubscriptions(String userId){
		userSubscriptionMap.keySet().forEach(e->{
			userSubscriptions.add(userSubscriptionMap.get(e));
		});
		return userSubscriptions;
	}

	public boolean deleteSubScription(Integer subScriptionId) {
		if(userSubscriptionMap.containsKey(subScriptionId)) {			
			userSubscriptionMap.remove(subScriptionId);
			userSubscriptions.clear();
			userSubscriptionMap.keySet().forEach(e->{
				
				userSubscriptions.add(userSubscriptionMap.get(e));
			});
			return true;
		}else {			
			return false;
		}
	}

	public List<RateExchange> getRTXDate(String fromCurrency, String toCurrency, String fromDate, String toDate) throws ClassNotFoundException, SQLException, ParseException {
		String[] fromDateTokens=null;
		String[]  toDateTokens=null;
		if(!fromDate.isEmpty()) {
			fromDateTokens=fromDate.split("/");
		}
		if(!toDate.isEmpty()) {
			toDateTokens=toDate.split("/");
		}
		return getRTXDataFromDB(fromCurrency,toCurrency,fromDateTokens,toDateTokens);
		
	}

	private List<RateExchange> getRTXDataFromDB(String fromCurrency, String toCurrency, String[] fromDateTokens,
			String[] toDateTokens) throws ClassNotFoundException, ParseException {
		Connection con = null;
		List<RateExchange> rateExchanges = new ArrayList<>();
		try {
			con = MyConnection.getInstance();
			ResultSet rs = null;
			PreparedStatement statement = con.prepareStatement(SQL_GET_RTX_DATA);

			statement.setString(1, fromCurrency);
			statement.setString(2, toCurrency);
			statement.setInt(3, Integer.parseInt(fromDateTokens[0]));
			statement.setInt(4, Integer.parseInt(toDateTokens[0]));
			statement.setInt(5, Integer.parseInt(fromDateTokens[1]));
			statement.setInt(6, Integer.parseInt(toDateTokens[1]));
			rs = statement.executeQuery();
			while (rs.next()) {
				RateExchange rateExchange = new RateExchange();
				rateExchange.setExchangeValue(rs.getDouble(1));
				rateExchange.setFromCurrency(rs.getString(2));
				rateExchange.setToCurrency(rs.getString(3));
				rateExchange.setSource(rs.getString(4));
				rateExchange.setToDate(rs.getString(5));
				rateExchanges.add(rateExchange);
			}

		} catch (SQLException e) {
			e.getLocalizedMessage();
		} finally {
			try {
				if(con!=null )
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rateExchanges;
		}
	}

	
}

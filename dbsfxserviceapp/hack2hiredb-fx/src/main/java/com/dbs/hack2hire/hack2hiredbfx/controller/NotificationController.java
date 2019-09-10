package com.dbs.hack2hire.hack2hiredbfx.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dbs.hack2hire.hack2hiredbfx.model.NotificationRequest;
import com.dbs.hack2hire.hack2hiredbfx.model.NotificationResponse;
import com.dbs.hack2hire.hack2hiredbfx.repo.DeviceRepository;
import com.mysql.cj.xdevapi.JsonArray;

@CrossOrigin
@RestController
public class NotificationController {
	
	
	@Autowired
	private DeviceRepository deviceRepository;

	@GetMapping("/notify/{userId}")
	public Map<String, List<NotificationResponse>> notify(@PathVariable("userId") int user) {

		Random rand = new Random();
//		int number = rand.nextInt(9);
//		if (number % 2 == 0)
//			return null;
//		else {
			DecimalFormat dff = new DecimalFormat("0.00");
			HashMap<String, List<NotificationResponse>> response = new HashMap<>();
			int runtime = rand.nextInt(4);
			List<NotificationResponse> np = new ArrayList<NotificationResponse>();
			String toCurrency[] = { "AED", "AUD", "CAD", "CZK", "USD" };
			for (int i = 0; i <= runtime; i++) {
				NotificationResponse subscription = new NotificationResponse(user, "INR", toCurrency[rand.nextInt(4)],
						Double.parseDouble(dff.format(rand.nextDouble() * 10000)), String.valueOf(UUID.randomUUID()));
				np.add(subscription);
			}

			response.put("notification", np);
			return response;
//		}
	}
	
	
	
	@PostMapping("/notify")
	@Scheduled(fixedRate = 30000)
	public String notifyMobile(){
		System.out.println("Schedule Started");
		RestTemplate restTemplate = new RestTemplate();
	    String key = deviceRepository.findById(1).get().getDeviceKey();
	    
	    
	    NotificationRequest req=new NotificationRequest();
	    req.setTo(key);
	   
	    HashMap<String, String> map=new HashMap<>();
	    map.put("title", "Notification from Fx by DBS");
	   map.put("body", "Your subscriptions has been met!! Check it out in our app");
	   req.setData(map);

		MultiValueMap<String, String> requestHeaders = new LinkedMultiValueMap<String, String>();
		requestHeaders.add("Authorization", "key=AAAAVtIvDuk:APA91bGmXpzMzlhq5DSQvRIYpw3BNVyfjZ2U5Tw7ufcoACUz2SC7hAAL9xSXaHIMXhCctjTa43s-ADBCVJrEBPzOv7Cxg6PuIXMiokS7gA8_RGBArWUhjNNNb93BtGvFko9EeAlBQc18");
		requestHeaders.add("Content-Type", "application/json");
		
		HttpEntity<?> httpEntity = new HttpEntity<Object>(req, requestHeaders);
		ResponseEntity<String> model=null;
        try {
		 model = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, httpEntity, String.class);
        }
        catch(Exception ex) {
        	System.out.println(ex);
        }
        System.out.println("Schedule Ended");
        return model.getBody().toString(); 
	}
	
	
	
}

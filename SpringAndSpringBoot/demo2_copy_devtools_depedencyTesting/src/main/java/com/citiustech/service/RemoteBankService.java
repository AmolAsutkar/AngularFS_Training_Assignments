package com.citiustech.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citiustech.entity.Trade;

@Service
@ConfigurationProperties(prefix = "bank-api")
public class RemoteBankService {

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	public void communicate(Trade trade) {
		
		RestTemplate rt=new RestTemplate();
		//String url="http://localhost:8080/tradeNewPayment";
		String respobseFromBank=rt.postForObject(url, trade, String.class);
	}
}

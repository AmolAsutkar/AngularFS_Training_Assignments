package com.citiustech.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citiustech.entity.Trade;

@Service
public class RemoteBankService {

	public void communicate(Trade trade) {
		
		RestTemplate rt=new RestTemplate();
		String url="http://localhost:8080/tradeNewPayment";
		String respobseFromBank=rt.postForObject(url, trade, String.class);
	}
}

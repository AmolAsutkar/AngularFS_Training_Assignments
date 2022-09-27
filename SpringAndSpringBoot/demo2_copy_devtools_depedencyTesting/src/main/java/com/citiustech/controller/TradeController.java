package com.citiustech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.entity.Trade;
import com.citiustech.service.RemoteBankService;
import com.citiustech.service.TradeService;

// running on server A
@RestController
public class TradeController {
	
	@Autowired
	TradeService tradeservice;
	
	@Autowired
	RemoteBankService remotebankservice;
	
	@PostMapping("/newTrade")
	public String postNewTrade(@RequestBody Trade trade) {
		tradeservice.process(trade);
		remotebankservice.communicate(trade);
		return "new trade posted success";
		
	}

}

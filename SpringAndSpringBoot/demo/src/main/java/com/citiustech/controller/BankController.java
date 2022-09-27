package com.citiustech.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.citiustech.entity.Trade;

//running on server B
public class BankController {

	@PostMapping("/newTradePayment")
	public String postNewTrade(@RequestBody Trade trade) {
		
		return "payment done for new trade posted ";
		
	}
}

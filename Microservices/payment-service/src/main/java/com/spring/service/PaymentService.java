package com.spring.service;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.model.Payment;
import com.spring.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	Logger logger=LoggerFactory.getLogger(PaymentService.class);
	
	public Payment doPayment(Payment payment) throws JsonProcessingException
	{
		//call to the payment gateway
		payment.setPaymentStatus(paymentProcess());
		payment.setTransactionId(UUID.randomUUID().toString());
		
		logger.info("PAYMENT-SERVICE Request :", new ObjectMapper().writeValueAsString(payment));
		return paymentRepository.save(payment);
		
		
	}
	
	public String paymentProcess()
	{
		// giving call to the paymeny gateway(Paypal,paytm..)
		return new Random().nextBoolean()?"success":"false";
	}
}

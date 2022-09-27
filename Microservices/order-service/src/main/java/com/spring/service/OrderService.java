package com.spring.service;

import java.util.UUID;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.model.Order;
import com.spring.model.Payment;
import com.spring.repository.OrderRepository;


@Service
@RefreshScope
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	
	//log implementation
	
	Logger logger=LoggerFactory.getLogger(OrderService.class);
	
	
	//@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	//String ENDPOINT_URL;

	public TransactionResponse addOrder(TransactionRequest request) throws JsonProcessingException
	{
		String response=null;
		Order order=request.getOrder();
		Payment payment=request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		//rest call
		
		logger.info("ORDER_SERVICE Request: {}", new ObjectMapper().writeValueAsString(request));
		
		Payment paymentResponse=restTemplate.postForObject("http://localhost:8282/payment/doPayment", payment, Payment.class);
		//Payment paymentResponse=restTemplate.postForObject(ENDPOINT_URL, payment, Payment.class);
		
		response=paymentResponse.getPaymentStatus().equals("success") ? "payment done Successfull and order placed": "there is failure in payment order added back to the cart";
		
		logger.info("ORDER-SERVICE getting Response from PAYMENT-SERVICE ", new ObjectMapper().writeValueAsString(paymentResponse));
		
		 orderRepository.save(order);
		 
		 return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
		 
	}
	
}

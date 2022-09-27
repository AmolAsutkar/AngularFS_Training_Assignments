package com.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
	
	
	@RequestMapping("/orderFallback")
	public Mono<String> orderServiceFallBack() {
		
		return Mono.just("Order service is taking too much time to response.Please wait ");
		
	}

	
	@RequestMapping("/paymentFallback")
	public Mono<String> paymentServiceFallBack() {
		
		return Mono.just("Payment service is taking too much time to respond please wait");
	}

}

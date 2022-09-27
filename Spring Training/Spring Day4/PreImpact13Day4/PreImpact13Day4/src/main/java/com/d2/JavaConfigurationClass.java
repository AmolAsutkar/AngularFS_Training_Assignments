package com.d2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.d2")
public class JavaConfigurationClass {
	
	
	@Bean
	public Product getProduct() {
		Product prod = new Product();
		prod.setProd_desc(getDesc());
		return prod;
	}
	
	@Bean
	public ProductDesc getDesc() {
		ProductDesc desc = new ProductDesc();
		return desc;
	}

}

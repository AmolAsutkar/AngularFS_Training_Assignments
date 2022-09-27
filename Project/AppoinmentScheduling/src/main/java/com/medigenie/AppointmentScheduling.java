package com.medigenie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class AppointmentScheduling {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentScheduling.class, args);
	}

}
//(exclude = {DataSourceAutoConfiguration.class })
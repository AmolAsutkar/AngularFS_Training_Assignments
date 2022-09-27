package com.citiustech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello everyone";
	}
	
	//http://localhost:8080/hello2?name=amol
	@GetMapping("/hello2")
	public String hello2(@RequestParam("name") String name) {
		return "Hello everyone"+name.toUpperCase();
	}
	
	//http://localhost:8080/hello3;name=amol

	@GetMapping("/hello3")
	public String hello3(@MatrixVariable("name") String name) {
		return "Hello everyone"+name.toUpperCase();
	}
	
	//http://localhost:8080/hello4/amol

	@GetMapping("/hello4/{name}")
	public String hello4(@PathVariable("name") String name) {
		return "Hello everyone"+name.toUpperCase();
	}
	
}

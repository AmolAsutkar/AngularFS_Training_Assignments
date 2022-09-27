package com.citiustech.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.dto.CustomerInfo;
import com.citiustech.dto.RegisterStatus;
import com.citiustech.entity.Customer;
import com.citiustech.exception.CustomerServiceException;
import com.citiustech.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("set of end points for registring and fetching customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerservice;
	
/*	@PostMapping("/register")
	public ResponseEntity<RegisterStatus> register(@RequestBody Customer customer) {
		try {
		int id =customerservice.register(customer);
     RegisterStatus status=new RegisterStatus();
     status.setStatus(true);
     status.setMessageIfAny("Registration done");
     status.setRegisteredCustomerId(id);
     return new ResponseEntity<>(status,HttpStatus.OK);
	}
		catch(CustomerServiceException e) {
			RegisterStatus status=new RegisterStatus();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
		     return new ResponseEntity<>(status,HttpStatus.BAD_REQUEST);
		}
	}
	*/
	
	@PostMapping(path ="/register",consumes ="application/json",produces = "application/xml")

	//@PostMapping("/register")
	@ApiOperation("Api for adding new customer")
	@ApiResponses({
		@ApiResponse(code=400,message="customer already exists"),
		@ApiResponse(code=200,message="customer registered")
	})
	
	public RegisterStatus register(@ApiParam ("data to be added") @RequestBody Customer customer) {
		int id =customerservice.register(customer);
     RegisterStatus status=new RegisterStatus();
     status.setStatus(true);
     status.setMessageIfAny("Registration done");
     status.setRegisteredCustomerId(id);
	
		return status;
	}
	

  @GetMapping("/allcustomer")
  public List<Customer> getAll(){
	  return customerservice.fetchAll();
  }
  
	@GetMapping(path ="/singlecustomer",produces = {"application/xml","application/json"})

  //@GetMapping("/singlecustomer")
  public CustomerInfo getOneCustomer(@RequestParam("id")int id){
	  Customer customer =customerservice.fetchOneCustomer(id);
	  CustomerInfo cinfo=new CustomerInfo();
		/*
		 * cinfo.setId(customer.getCustId()); cinfo.setCustName(customer.getCustName());
		 * cinfo.setCity(customer.getAddress().getCity());
		 * cinfo.setDateofbirth(customer.getDateofbirth());
		 * cinfo.setEmail(customer.getEmail());
		 * cinfo.setPincode(customer.getAddress().getPincode());
		 * cinfo.setState(customer.getAddress().getState());
		 */
	  
	  BeanUtils.copyProperties(customer, cinfo);
	  BeanUtils.copyProperties(customer.getAddress(), cinfo);
	  return cinfo;
	  
	  
  }
}

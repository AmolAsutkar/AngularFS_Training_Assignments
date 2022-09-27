package com.citiustech.service;

import com.citiustech.entity.Customer;
import com.citiustech.repository.CustomerRepository;

public class CustomerService {
	
	CustomerRepository customerrepository;
	EmailNotificationService emailNotificationService;
	
	//public CustomerService(CustomerRepository customerrepository) {
	//	this.customerrepository = customerrepository;
	//}

	public CustomerService(CustomerRepository customerrepository,EmailNotificationService emailNotificationService) {
		this.customerrepository = customerrepository;
		this.emailNotificationService = emailNotificationService;
	}

	//public Status registerCustomer(Customer customer) {
	//	if(customerrepository.isCustomerPresent(customer.getEmail()))
	//			return Status.FAILURE;
	//	else {
		//	     	int id =customerrepository.saveCustomer(customer);
	//		     	emailNotificationService.sendEmail(customer);
	//				return Status.SUCCESS;
	//		}
	//	}
	
// assumption developer has done mistake instead of throwing exception he has returning status  object in case of failure
// developer has done one more mistake
// he is calling save method multiple times	
	
	/*public Status registerCustomer(Customer customer) {
	if(customerrepository.isCustomerPresent(customer.getEmail()))
			return Status.FAILURE;
	else {
		try {
			int id =customerrepository.saveCustomer(customer);
		}
		catch(Exception e) {
			//did something here we are not suppose to call save method twice
			try {
				int id =customerrepository.saveCustomer(customer);
			}
			catch(Exception e2) {
				//did something here we are not suppose to call save method twice
				int id =customerrepository.saveCustomer(customer);

				e2.printStackTrace();
			}

			e.printStackTrace();
		}
		return Status.SUCCESS;
	}
	*/
//}
	
	public Status registerCustomer(Customer customer) {
		if(customerrepository.isCustomerPresent(customer.getEmail()))
				return Status.FAILURE;
		else {
		//	try {
				int id =customerrepository.saveCustomer(customer);
			//}
			//catch(Exception e) {
				
			//	e.printStackTrace();
			//}
			return Status.SUCCESS;
		}
	}
		
public static enum Status{
	SUCCESS,FAILURE
}
}

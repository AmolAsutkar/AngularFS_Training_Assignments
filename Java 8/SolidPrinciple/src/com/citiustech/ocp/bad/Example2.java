package com.citiustech.ocp.bad;


public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class OrderService{
	 
	Status orderStatus(int OrderId) {
		NotificationService notificationservice = new NotificationService();
		
		notificationservice.notifyCustomer();
		return null;
	}
}

 class Status{
	
}

// but what if we want to support multiple ways of notifying user eg email,sms,push
// writing if conditions below would be a bad idea
class NotificationService{
	public void notifyCustomer() {
		// code for sending notification through email
	}
}

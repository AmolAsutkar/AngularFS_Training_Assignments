package com.citiustech.ocp.good;


public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class OrderService{
	 
	Status orderStatus(int OrderId) {
		NotificationService notificationservice = new Push();
		
		notificationservice.notifyCustomer();
		return null;
	}
}

class Status{
	
}

interface NotificationService{
	public void notifyCustomer() ;
}

class sms implements NotificationService{

	@Override
	public void notifyCustomer() {
		// TODO Auto-generated method stub
		
	}
	
}
class Push implements NotificationService{

	@Override
	public void notifyCustomer() {
		// TODO Auto-generated method stub
		
	}
	
	class Email implements NotificationService{

		@Override
		public void notifyCustomer() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
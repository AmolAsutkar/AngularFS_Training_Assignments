package com.citiustech.interfacesegrigation.good;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	}

}
interface Register {
	public void register();
	public void updateProfile();


}
interface Login {
	public void login();
	public void logout();


}


interface suscribe {
	public void suscribe();

}
interface placeOrder {
	void placeOrder();
	public void cancelOrder();

}

	
class CustomerService implements Login,Register{

	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}
	
}
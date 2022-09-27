package com.citius;

import java.util.Scanner;

public class ValidAdmin {
	String[] Admincreditianls= {"admin","admin"};
	
	public  void isValidAdmin() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Your Username");
		String uname = input.next();
		System.out.println("Enter Your Password");
		String password = input.next();
		
		  if(uname.equals(Admincreditianls[0])&&password.equals(Admincreditianls[1])) {
		  System.out.println("you are a Valid Admin");
		  }
		  else {
			  System.out.println("you are not a valid admin");
		  }
}

	 
}

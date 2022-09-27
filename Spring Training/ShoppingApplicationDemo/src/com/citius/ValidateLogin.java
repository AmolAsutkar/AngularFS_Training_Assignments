package com.citius;


import java.util.Scanner;



public class ValidateLogin {

	
	
	 String[] Customercreditianls= {"amol","asutkar"};
	
	 
	
	public  void isValidCustomer() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Your Username");
		String uname = input.next();
		System.out.println("Enter Your Password");
		String password = input.next();
		
		   if(uname.equals(Customercreditianls[0])&&password.equals(Customercreditianls[ 1])){ 
			  System.out.println("you are a Valid customer");
			  
			  int item = 0;
				do {

					System.out.println("-----------------------Menu--------------------------");
					System.out.println("1. Phone");
					System.out.println("2. Laptop");
					System.out.println("3. Furniture");
					System.out.println("0. Exit");
					System.out.println("Please Enter your Choice");
					item = input.nextInt();
					if (item == 1) {
						ShowPhone p = new ShowPhone();
						p.showPhone();
					} else if (item == 2) {
						ShowLaptop l = new ShowLaptop();
						l.showLaptop();
					}
					else if(item==3)
					{
						ShowFurniture f=new ShowFurniture();
						f.showFurniture();
					}

				} while (item != 0);

			  }
		  else 
		  {
		  System.out.println("you are not  Authenticated.");
		  }
		

	}

}

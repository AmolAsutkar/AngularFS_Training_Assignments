package com.citius;



public class MainClass {

	static ValidateLogin vlogin=new ValidateLogin();
	static MenuDetails menudetail = new MenuDetails();
	static ValidAdmin vladmin =new ValidAdmin();
	
	
	public static void main(String[] args) {
		
		int choose=0;
   do {
	   
	   int choice=menudetail.ShopingMenu();
           switch(choice)
			{
			case  1: vladmin.isValidAdmin();
			         break;
			         
			case  2: vlogin.isValidCustomer();;
	                 break; 

		   default:
				if (choice == 0) {
					System.out.println("Thanks for Exit");
					break;
				} else {
					System.out.println("You selected wrong choice.. ");
					
				}
				
			}
  	
		} while (choose >= 0);
      
		
	}

}

package com.citius;

import java.util.Scanner;

public class ShowPhone {
	
	public void showPhone(){
		Scanner sc=new Scanner(System.in);
		System.out.println("--------------Phones-----------------");
		
		
		int item1=0;
		do{
		
			System.out.println("1.Iphone12");
			System.out.println("2.Iphone13");
			System.out.println("3.Samsung");
			System.out.println("0. Exit");
			System.out.println("Enter the item");
			int item=sc.nextInt();
			System.out.println("Enter Quantity");
			int quantity=sc.nextInt();
			
			if(item==1)
			{
				int bill=quantity*10000;
				System.out.println("your Bill for Iphone 12 is"+ " "+ bill);
			}
			else if(item==2)
			{
				int bill=quantity*30000;
				System.out.println("your Bill for Iphone13 is"+ " "+ bill);
			}
			else if(item==3)
			{
				int bill=quantity*23000;
				System.out.println("your Bill for Samsung is"+ " "+ bill);
			}
			else if(item==0)
			{
				System.out.println("thank you for exit");
			}
			else {
				System.out.println("please enter the valid choice");
			}
			
				
			
		} while (item1 != 0);
		
	}

}

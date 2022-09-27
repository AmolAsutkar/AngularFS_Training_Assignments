package com.citius;

import java.util.Scanner;

public class ShowFurniture {

	public void showFurniture() {
		Scanner sc=new Scanner(System.in);
		System.out.println("--------------Furnitures-----------------");
		
		
		int item1=0;
		do{
		
			System.out.println("1.Sofa");
			System.out.println("2.Table");
			System.out.println("3.Couch");
			System.out.println("0. Exit");
			System.out.println("Enter the item");
			int item=sc.nextInt();
			System.out.println("Enter Quantity");
			int quantity=sc.nextInt();
			
			if(item==1)
			{
				int bill=quantity*25000;
				System.out.println("your Bill for Sofa is"+ " "+ bill);
			}
			else if(item==2)
			{
				int bill=quantity*10000;
				System.out.println("your Bill for Table is"+ " "+ bill);
			}
			else if(item==3)
			{
				int bill=quantity*45000;
				System.out.println("your Bill for couch  is"+ " "+ bill);
			}
		} while (item1 != 0);
	}

}

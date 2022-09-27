package com.citius;

import java.util.Scanner;

public class MenuDetails {
	Scanner sc=new Scanner(System.in);
public void message() {
		
		System.out.println("welcome to Shopping Application");
	}
	
	
	public	int ShopingMenu(){
		
		System.out.println("\n ----Menu-------");
		System.out.println("1. Admin");
		System.out.println("2. Customer");
		System.out.println("3. Guest");
		System.out.println("0. Exit");
		System.out.println("Enter Your Choice");
		int choice= sc.nextInt();
		
		return choice;
	
        }


}

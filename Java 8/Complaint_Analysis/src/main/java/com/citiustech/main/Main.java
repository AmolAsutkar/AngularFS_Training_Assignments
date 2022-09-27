package com.citiustech.main;

import java.util.Scanner;

import com.citiustech.Service.ComplaintServices;
import com.citiustech.Service.ServicesComplaint;

public class Main {

	public static void main(String[] args) {

		ServicesComplaint service= new ServicesComplaint();
		
		boolean isValid=true;
		Scanner sc=new Scanner(System.in);
		while (isValid) {
			
	    System.out.println("Menu : ");
        System.out.println("Type any number between 1 and 5");
        System.out.println("1)Fetch complaint based on complaint id");
        System.out.println("2)Fetch all the complaints based on year");
        System.out.println("3)Fetch complaints based on the bank name");
        System.out.println("4)Fetch time taken by the bank to close any complaint");
        System.out.println("5)Exit");
		System.out.println("enter your choice");

        int choice = sc.nextInt(); 
        
        if(choice==1) {
        	System.out.println("please enter the valid complaint id");
        	int cmpid=sc.nextInt();
        	System.out.println(service.fetchComplaintById(cmpid));
        }
        else if (choice==2) {
        	System.out.println("please enter valid year");

		}
        else if (choice==3) {
        	System.out.println("please enter valid bank name");

		}
        else if (choice==4) {
        	System.out.println("enter id of ");

		}
        else if (choice==5) {
          System.out.println("Thanks for exist");
          isValid=false;
          }
        else {
			System.out.println("please enter valid choice");
		}
	}
}
}
package com.citiustech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Operation opn = new Operation();

		Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("\nPlease enter your choice : ");
			System.out.println("1. Fetch Complaint by Complaint ID");
			System.out.println("2. Fetch Complaint by Year");
			System.out.println("3. Fetch Complaint by Bank Name");
			System.out.println("4. Fetch Complant Clousre Duration");
			System.out.println("0. Exit");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1: {
				System.out.println("Enter Complaint ID");
				int id = sc.nextInt();
				System.out.println(opn.getComplaintById(id));
				break;
			}
			
			case 2 : {
				System.out.println("Enter Year of raising complaint");
				int year = sc.nextInt();
				opn.getComplaintByYear(year).forEach(System.out::println);
				break;
			}
			
			case 3: {
				System.out.println("Enter Bank Name");
				String bankName = bf.readLine();
				opn.getComplaintByBankName(bankName).forEach(System.out::println);
				break;
			}
			
			case 4 : {
				System.out.println("Enter Complaint ID to check complaint clousre duration");
				int id = sc.nextInt();
				System.out.println("Days required to close the complaint "+opn.getComplaintResolutionPeriod(id));
				break;
			}
			
			case 0: System.exit(0);
			break;
			
			
			}
		}
		
		}

	}



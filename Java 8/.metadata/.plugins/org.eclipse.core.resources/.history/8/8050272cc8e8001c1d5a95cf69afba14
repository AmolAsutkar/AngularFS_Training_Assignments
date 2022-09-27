package com.assign1.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.assign1.entity.Complaints;
import com.assign1.repo.Repo;
import com.assign1.service.Service;

public class App {

	public static void main(String[] args) throws IOException {
		
		Service service = new Service();
		
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
				System.out.println(service.getComplaintById(id));
				break;
			}
			
			case 2 : {
				System.out.println("Enter Complaint Raised Year");
				int year = sc.nextInt();
				service.getComplaintByYear(year).forEach(System.out::println);
				break;
			}
			
			case 3: {
				System.out.println("Enter Bank/Company Name");
				String bankName = bf.readLine();
				service.getComplaintByBankName(bankName).forEach(System.out::println);
				break;
			}
			
			case 4 : {
				System.out.println("Enter Complaint ID to check complaint clousre duration");
				int id = sc.nextInt();
				System.out.println("Days required to close the complaint "+service.getComplaintResolutionPeriod(id));
				break;
			}
			
			case 0: System.exit(0);
			break;
			
			
			}
		}
		
		}

}



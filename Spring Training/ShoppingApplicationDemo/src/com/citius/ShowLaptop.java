package com.citius;

import java.util.Scanner;

public class ShowLaptop {

public void showLaptop() {
		
		int item1=0;
		do {

			System.out.println("--------------Laptop-----------------");
			System.out.println("1.HP");
			System.out.println("2.Lenovo");
			System.out.println("3.Thinkipad");
			System.out.println("0. Exit");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the item");
			int item = sc.nextInt();
			System.out.println("Enter Quantity");
			int quantity = sc.nextInt();
			if (item == 1) {
				int bill = quantity * 90000;
				System.out.println("your Bill for HP Laptop is" + " " + bill);
			} else if (item == 2) {
				int bill = quantity * 80000;
				System.out.println("your Bill for Lenovo Laptop is" + " " + bill);

			} else if (item == 3) {
				int bill = quantity * 50000;
				System.out.println("your Bill for Thinkipad is" + " " + bill);

			}

		} while (item1 != 0);

	}

}

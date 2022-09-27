package com.citius.dateandtime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateTimeDemo {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your DOJ yy--mm-dd");
		String doj=sc.nextLine();
		
		LocalDate dateofjoining=LocalDate.parse(doj);//yy--mm-dd
		System.out.println(dateofjoining);
		
		// modify above code to take date from user in some other format eg dd-mm-yy
		/*
		 * System.out.println("Enter your DOJ dd-MM-yyy"); String doj1=sc.nextLine();
		 * DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy"); LocalDate
		 * date_ofjoining=LocalDate.parse(doj1,dtf);//yy--mm-dd
		 * System.out.println(date_ofjoining);
		 */
		
		LocalDate todaysdate=LocalDate.now();
		System.out.println(todaysdate);
		
		//write a code to find out how many years/months/days employee has spent in company
		Period period= Period.between(dateofjoining, todaysdate);
		System.out.println("employee has spent " +period.getMonths()+ "  months in company");
		
		Long Days=ChronoUnit.DAYS.between(dateofjoining, todaysdate);
		System.out.println("employee has spent " +Days+ "  days in company");

		
		//write a code to validate credicard exipery date, creditcard is valid if expdate >= todays date
		LocalDate creditcardexiperydate=LocalDate.of(2022, 10, 9);
		if(creditcardexiperydate.isAfter(todaysdate) || creditcardexiperydate.equals(todaysdate)) 
			System.out.println("credit card is valid");
		else 
			System.out.println("card is invalid");
		
		LocalTime time = LocalTime.now();
		if(time.getHour()>=16 && time.getHour()<=21)
			System.out.println("Good evening");
		
		
		// write a code to display current time in newyork
		LocalTime time1=LocalTime.now(ZoneId.of("America/New_York"));
		System.out.println(time1);
	}

}

package com.citiustec.dip.bad;

import java.time.LocalTime;

public class Example1 {

	public static void main(String[] args) {
Greeting g = new Greeting();
g.greet();
	}

}
class Greeting{
	void greet() {
		LocalTime time=LocalTime.now();
		int hrs=time.getHour();
		
if(hrs>5 && hrs<12)
	System.out.println("good morning");

else if(hrs>12 && hrs<16)
	System.out.println("good afternoon");

else if(hrs>16 && hrs<21)
	System.out.println("good Evening");

else
	System.out.println("Good night");
		}
	
}
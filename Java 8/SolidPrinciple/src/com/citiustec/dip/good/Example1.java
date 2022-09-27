package com.citiustec.dip.good;

import java.time.LocalTime;


public class Example1 {

	public static void main(String[] args) {
		LocalTime time=LocalTime.now();

		Greeting g = new Greeting(time);
		g.greet();
	}

}

class Greeting{
	
	LocalTime time;
	
	Greeting(LocalTime time){
		this.time=time;
	}
	void greet() {
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
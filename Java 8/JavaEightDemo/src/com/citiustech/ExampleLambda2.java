package com.citiustech;

interface math{
	
	int calculate(int x,int y);
}


public class ExampleLambda2 {

	public static void main(String[] args) {

		
		  //anonymous inner class implementing math interface

		math m1=new math() {
			
			@Override
			public  int calculate(int x, int y) {
				// TODO Auto-generated method stub
				
				return x+y;
			}
		};
		System.out.println(m1.calculate(6, 5));
		
		// lamda expression
		math m2 = (x,y)-> x - y;
		
		System.out.println(m2.calculate(8, 5));
	}

}

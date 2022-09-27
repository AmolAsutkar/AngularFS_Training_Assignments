package com.citiustech;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ExampleLamda4 {
	public static void main(String[] args) {
		
		Function<String, Integer> f =Integer::parseInt;
		Integer i=f.apply("100");
		System.out.println(i);
		
		Function<String, Integer> f2 =(stre)-> Integer.parseInt(stre);
		Integer i2=f2.apply("1000");
		System.out.println(i2);
		
		ToIntFunction<String> f3 =Integer::parseInt;
		Integer i3=f3.applyAsInt("89");
		System.out.println(i3);
        
		List<String> list = Arrays.asList("java","Python","oracle");
		list.forEach(System.out::println);
		
		//Regular
		String str = "Amol";
		str.toUpperCase();
		
//Identify which functional interface you will use for calling string class toUpperCase Method
		
		Supplier<String> s=()-> str.toUpperCase();
		String s1 = s.get();
		System.out.println(s1);
		
		Supplier<String> s2 = str::toUpperCase;
		String s3=s2.get();
		System.out.println(s3);
		
		
		
		//using the right functional interface execute the add method of Calculator class
		Calculator c=new Calculator();
		IntBinaryOperator ibo=c::add;
		int result=ibo.applyAsInt(20, 40);
		System.out.println(result);
		
		
	}

}

class Calculator{
	
	int add(int x,int y) {
		return x+y;
	}
}

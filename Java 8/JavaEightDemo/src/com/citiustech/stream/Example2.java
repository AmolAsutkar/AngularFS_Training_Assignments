package com.citiustech.stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<String> s= Stream.of("java","javascript","python","plsql");
		s.forEach(System.out::println);
		
		IntStream nos=IntStream.rangeClosed(1, 10);
        
		Stream<String> s1= Stream.of("java","javascript","python","plsql");

		boolean found = s1.anyMatch(str->str.equals("scala"));
		System.out.println(found);
		
		Stream<String> s2= Stream.of("java","javascript","python","plsql");

		found=s2.allMatch(str-> str.contains("a"));
		System.out.println(found);
		
		Stream
		.generate(() -> new Random().nextInt(100))
		.limit(10)
		.forEach(System.out::println);

	}

}

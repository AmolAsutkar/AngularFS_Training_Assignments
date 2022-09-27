package com.citius.optional;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Optional<String> op =Optional.empty();
		System.out.println(op.isPresent());
		//System.out.println(op.get());
		
		
		Optional<String> op1 =Optional.of(args[0]);
		System.out.println(op1.isPresent());
		System.out.println(op1.get());
		
		String str=null;
		//String str1="Asutkar";
		//Optional<String> op2 =Optional.of(str); //of method require a not null value
		Optional<String> op3 =Optional.ofNullable(str);
		System.out.println(op3.isPresent());
		//System.out.println(op3.get());
		System.out.println(op3.orElse("Amol"));
		//op3.orElseThrow(()-> new myownException("no data available"));
	   //op3.orElseThrow(myownException::new);
		
         System.out.println("------------");
         // String s=null;
          String s="Asutkar";
		Optional<String> op4 =Optional.ofNullable(s);
		System.out.println(op4.orElse(GetData()));//hit database every time
		
		
		Optional<String> op5 =Optional.ofNullable(s);
        System.out.println(op4.orElseGet(()->GetData()));	// lasy loading dont hit database everytime	


}
	static String GetData() {
		System.out.println(" inside get data");
		return "Amol";
	}

}


class myownException extends RuntimeException{
	
	public myownException () {
		
	}
	
	public myownException (String msg) {
		super(msg);
		
	}
	
}

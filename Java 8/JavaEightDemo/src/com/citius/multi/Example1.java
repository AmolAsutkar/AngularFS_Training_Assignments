package com.citius.multi;

public class Example1 {

	public static void main(String[] args) {

		MobileApp map = new Mygame();
		map.start();
		map.stop();
		map.cleanUp();
		MobileApp.metadata();
		
	}

}

class Mygame implements MobileApp{

	@Override
	public void start() {
System.out.println("my game loading");		
	}

	@Override
	public void stop() {
System.out.println("my game stoppinng");		
	}
	
}
interface MobileApp{
	
	 void start();
	 void stop();
	
	default void cleanUp() {
		System.out.println("some cleanup code");
	}
	
	static void metadata() {
		System.out.println("some metadata code");
	}
}

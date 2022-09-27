package com.citiustech;

@FunctionalInterface
interface Printer{
	void print(String document);
}

//regular class
class DotMatrixPrinter implements Printer{
	
	@Override
	public void print(String document) {
		System.out.println("dotmatrix printer printing  "+document);
	}

}
public class ExampleLamda {

	
	  public static void main(String[] args) {
		  
		  // inner class implementing interface
		  class InkjetPrinter implements Printer{
			  
			  @Override
			  public void print(String document) {
					System.out.println("InkjetPrinter printer printing  "+document);
				}

		  }
		  
		  Printer p1=new DotMatrixPrinter();
		  p1.print("abc.txt");
		  
		  Printer p2=new InkjetPrinter();
		  p2.print("abc.txt");
		 
		  
		  //anonymous inner class implementing printer interface
		  Printer p3=new Printer() {
			
			@Override
			public void print(String document) {
				// TODO Auto-generated method stub
				System.out.println("deskjetprinter printer printing  "+document);
			}
		};
	   p3.print("abc.txt");
	   
	   
	   // lamda expression
	   
	   Printer p4=(document) -> {
			System.out.println("laserprinter printing " +document);
			
			};
			p4.print("abc.txt");
	  }
	 
	

}

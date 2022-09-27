package com.citius.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example2Collection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phonebook1 pnb = new Phonebook1();
		pnb.add(new Contact1("amol","575","pune"));
		pnb.add(new Contact1("raina", "575757","nagpur"));
		pnb.add(new Contact1("asutkar", "0997","chandrapur"));
		
		
		
		pnb
		.contactsearch("Amol")
		//.ifPresentOrElse(System.out::println,()-> System.out.print("no records found"));
		.ifPresentOrElse(c->System.out.println(c),()-> System.out.print("no records found"));
		
		
		System.out.println("--------city--------");
		pnb
		.Searchbycity("nagpur")
		.forEach(System.out::println);
		
		System.out.println("--------name--------");

		List<String> names=
		pnb
		.Searchbycity("chandrapur")
		.stream()
		.map(Contact1::getName)
		.collect(Collectors.toList());
      names.forEach(System.out::println);

		System.out.println("--------number--------");

      String pno=pnb
    		  .contactsearch("raina")
    		  .map(Contact1::getMobilenumber)
    		  .orElse("");
      
      System.out.println(pno);
	}

}

class Phonebook1 {
	List<Contact1> contacts = new ArrayList<>();

	void add(Contact1 c) {
		contacts.add(c);
	}

	Optional<Contact1> contactsearch(String name) {
		return contacts
				.stream()
				.filter(s-> s.name.equals(name))
				.findAny();//returns empty optional object if data not present
		}
	
	List<Contact1> Searchbycity(String city) {
		return contacts
				.stream()
				.filter(s-> s.city.equals(city))
				.collect(Collectors.toList()); //if data not present returns empty list so no need to use optional return type
		}
}

class Contact1 {
	String name;
	String Mobilenumber;
	String city;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobilenumber() {
		return Mobilenumber;
	}


	public void setMobilenumber(String mobilenumber) {
		Mobilenumber = mobilenumber;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	

	@Override
	public String toString() {
		return "name=" + name + ", Mobilenumber=" + Mobilenumber + ",city "+ city;
	}


	public Contact1(String name, String mobilenumber,String city) {
		super();
		this.name = name;
		Mobilenumber = mobilenumber;
		this.city=city;
	}
}
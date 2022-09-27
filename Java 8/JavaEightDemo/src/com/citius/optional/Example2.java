package com.citius.optional;

import java.util.Optional;

public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Phonebook pnb = new Phonebook();
		pnb.add(new Contact("Amol", "575757"));
		pnb.add(new Contact("asutkar", "0997"));
		pnb.add(new Contact("pooja", "08797"));
		pnb.add(new Contact("akshay", "799"));
		pnb.add(new Contact("raina", "8686"));

		/*
		 * Optional<Contact> op=pnb.contactsearch("Amol");
		 *  if(op.isPresent())
		 *   { Contact
		 * c=op.get();
		 *  System.out.println(c.name+"  "+c.Mobilenumber);
		 *   }
		 */
		
		pnb
		.contactsearch("Amol")
		//.ifPresentOrElse(System.out::println,()-> System.out.print("no records found"));
		.ifPresentOrElse(c->System.out.println(c),()-> System.out.print("no records found"));

		//OR
		
		

	}

}

class Phonebook {
	Contact[] contacts = new Contact[999];
	int index;

	void add(Contact c) {
		contacts[index++] = c;
	}

	Optional<Contact> contactsearch(String name) {
		for (int i = 0; i < index; i++) {
			if (contacts[i].name.equals(name))
				return Optional.of(contacts[i]);
		}
		return Optional.empty();

	}
}

class Contact {
	String name;
	String Mobilenumber;

	@Override
	public String toString() {
		return "name=" + name + ", Mobilenumber=" + Mobilenumber;
	}


	public Contact(String name, String mobilenumber) {
		super();
		this.name = name;
		Mobilenumber = mobilenumber;
	}
}

package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.GenericDao;
import com.citiustech.entity.v1.BankAccount;
import com.citiustech.entity.v1.CreditCard;

class InheritanceTest {

	@Test
	public void testinheritance() {
		
	BankAccount b=new BankAccount(); 
	b.setBankname("hdfc");
	b.setName("asutkar");
	b.setNumber(9000);

CreditCard c=new CreditCard();
c.setName("asutkar credit card");
c.setNumber(7979797L);
c.setExpiry("12/3");
c.setType("visa");

GenericDao gdao=new GenericDao();
gdao.save(b);
gdao.save(c);


}

}

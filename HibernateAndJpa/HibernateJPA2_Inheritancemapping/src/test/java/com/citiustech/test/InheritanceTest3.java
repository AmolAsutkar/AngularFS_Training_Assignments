package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.GenericDao;
import com.citiustech.entity.v3.BankAccount;
import com.citiustech.entity.v3.CreditCard;



class InheritanceTest3 {

	@Test
	public void testinheritance() {
	BankAccount b=new BankAccount(); 
	b.setBankname("Icici");
	b.setName("Amol");
	b.setNumber(9000);

CreditCard c=new CreditCard();
c.setName("Amol");
c.setNumber(68886766L);
c.setExpiry("12/3");
c.setType("visa");

GenericDao gdao=new GenericDao();
gdao.save(b);
gdao.save(c);


}

}

package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.GenericDao;
import com.citiustech.entity.v2.BankAccount;
import com.citiustech.entity.v2.CreditCard;


class InheritanceTest2 {

	@Test
	public void testinheritance() {
	BankAccount b=new BankAccount(); 
	b.setBankname("standard");
	b.setName("santosh");
	b.setNumber(5000);

CreditCard c=new CreditCard();
c.setName("piyush");
c.setNumber(7000);
c.setExpiry("no ecpiray");
c.setType("mastro");

GenericDao gdao=new GenericDao();
gdao.save(b);
gdao.save(c);


}

}

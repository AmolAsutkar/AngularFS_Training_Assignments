package com.citiustech.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.citiustech.entity.Subscripition;
import com.citiustech.entity.User;

class UserandSubscriptionTest {

	@Test
	public void testAddUser() {
		GenericDao gdao=new GenericDao();
    User user=new User();
    user.setCity("delhi");
    user.setEmail("delhoi@gmail");

	gdao.save(user);
	}
	
	@Test
	public void testAddSubscription() {
		GenericDao gdao=new GenericDao();
Subscripition subs=new Subscripition();
subs.setCost(3000);
subs.setDuration(5);
subs.setType("jioTV");
		

	gdao.save(subs);
	}
	
	@Test
	public void subscribe() {
		GenericDao gdao=new GenericDao();
      User user=gdao.findById(User.class, 2);
      Subscripition subs=gdao.findById(Subscripition.class, 2);
      
      user.getSubscription().add(subs);
      gdao.save(user);
      
     
	}

}

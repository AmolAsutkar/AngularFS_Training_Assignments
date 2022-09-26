package com.citiustech.entity.alternativetoManytoMany;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.GenericDao;

class UserandSubscriptionTest {

	@Test
	public void testAddUser() {
		GenericDao gdao=new GenericDao();
    User user=new User();
    user.setCity("wanoja");
    user.setEmail("wnj@gmail");
gdao.save(user);
}
	
	@Test
	public void testAddSubscription() {
		GenericDao gdao=new GenericDao();
Subscription subs=new Subscription();
subs.setCost(1000);
subs.setDuration(3);
subs.setType("BstarU");
		

	gdao.save(subs);
	}
	
	@Test
	public void subscribe() {
		GenericDao gdao=new GenericDao();
      User user=gdao.findById(User.class, 2);
      Subscription subs=gdao.findById(Subscription.class, 1);
      UserSubscriptionLink uslink=new  UserSubscriptionLink();
      uslink.setUser(user);
      uslink.setSubscription(subs);
      uslink.setSubscriptionDate(LocalDate.now());
      gdao.save(uslink);
      
     
	}
	
	@Test
	public void subscribe1() {
		GenericDao gdao=new GenericDao();
      User user=gdao.findById(User.class, 2);
      Subscription subs=gdao.findById(Subscription.class, 1);
      UserSubscriptionLink2 uslink=new  UserSubscriptionLink2();
      uslink.setUser(user);
      uslink.setSubscription(subs);
      uslink.setSubscriptionDate(LocalDate.now());
      gdao.save(uslink);
      
     
	}

}

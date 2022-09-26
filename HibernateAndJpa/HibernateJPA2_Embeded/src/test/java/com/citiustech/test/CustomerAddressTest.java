package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.GenericDao;
import com.citiustech.entity.AddressDetails;
import com.citiustech.entity.CustomerDetails;

class CustomerAddressTest {

@Test
public void addCustomer() {

CustomerDetails c=new CustomerDetails();
c.setName("Amol");
c.setEmail("amol@gmail");

AddressDetails a=new AddressDetails();
a.setCity("mumbai");
a.setPincode(7887);
a.setState("maha");

AddressDetails a1=new AddressDetails();
a1.setCity("pune");
a1.setPincode(7887);
a1.setState("maha");

c.setBillingAddress(a);
c.setShippingAddress(a1);

List<String> hobbies = new ArrayList<>();
hobbies.add("Singing");
hobbies.add("Cooking");
c.setHobbies(hobbies);

GenericDao gdao=new GenericDao();
gdao.save(c);

	}


}

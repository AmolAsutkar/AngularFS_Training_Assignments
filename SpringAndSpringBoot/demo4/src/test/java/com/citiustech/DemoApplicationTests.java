package com.citiustech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import com.citiustech.entity.User;
import com.citiustech.repository.UserRepository;
import org.springframework.data.domain.Sort;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserRepository userrepo;
	
	@Test
	public void addUser() {
		User user=new User();
		user.setEmail("amol@123");
		user.setName("Amol");
		
		userrepo.save(user);

	}
	
	@Test
	void addUser1() {
		for(int i=1; i<=20; i++) {
			User user = new User();
			user.setName("Majrul" + i);
			user.setEmail("majrul@gmail" + i);
			
			userrepo.save(user);
		}
	}
	
	@Test
	void fetchUsersByEmailWithPagination() {
		long count = userrepo.count();
		int pageSize = 5;
		long pages = count / pageSize;
		
		for(int i=0; i<pages; i++) {
			Iterable<User> users = userrepo.findByEmailOf("gmail", 
									PageRequest.of(i, pageSize, Sort.by("name").ascending()));
			for(User user : users)
				System.out.println(user);
			
		}
	}
	@Test
	public void findByEmail() {
		Iterable<User> users =userrepo.findByEmail("@123");
		for(User user:users) {
			System.out.println(user);
		}

	}

}

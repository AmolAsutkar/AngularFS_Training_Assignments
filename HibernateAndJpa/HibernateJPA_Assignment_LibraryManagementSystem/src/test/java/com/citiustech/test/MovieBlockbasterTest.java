package com.citiustech.test;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.GenericDao;
import com.citiustech.entity.Customer;
import com.citiustech.entity.Movie;
import com.citiustech.entity.MovieIssued;
import com.citiustech.entity.MovieShopLink;
import com.citiustech.entity.Shop;
import com.citiustech.entity.Staff;
import com.citiustech.service.BlockBusterService;



public class MovieBlockbasterTest {

	
		@Test
		public void addShop() {
			GenericDao dao =  new GenericDao();
			Shop shop = new Shop();
			shop.setShop_address("Thane");
			shop.setManager("Samwise");
			shop.setFirstShiftStaff("Frodo");
			shop.setSecondShiftStaff("Smeagull");
			dao.save(shop);
		}
		
		@Test
		public void addStaff() {
			GenericDao dao =  new GenericDao();
			Staff s = new Staff();
			s.setStaff_name("Makky");
			s.setShifttype("morning shift");
			dao.save(s);
		}
		
		@Test
		public void linkStaffWithShop() {
			GenericDao dao = new GenericDao();
			
			Shop shop = dao.findById(Shop.class, 1);
			Staff s = dao.findById(Staff.class, 1);
			shop.setStaff(s);
			dao.save(shop);
		}
		
		
		@Test
		public void addMovie() {
			GenericDao dao =  new GenericDao();
			Movie movie = new Movie();
			movie.setMovie_name("Lord of the rings");
			movie.setMovie_genre("Fantasy");
			movie.setCertificate("PG-13");
			movie.setMovie_id(4);
			dao.save(movie);
		}
		
		@Test
		public void assignsMovieToShop() {
			GenericDao dao =  new GenericDao();
			Shop shop = dao.findById(Shop.class, 1);
			Movie movie = dao.findById(Movie.class, 1);
			MovieShopLink link = new MovieShopLink();
			link.setMovie(movie);
			link.setShop(shop);
			link.setCopies(25);
			link.setAssignedOn(LocalDate.of(2013, 6, 11));
			dao.save(link);
		}
		
		@Test
		public void registerCustomer() {
			GenericDao dao =  new GenericDao();
			Customer c = new Customer();
			c.setCustomer_name("Gandalf");
			c.setCustomer_dob(LocalDate.of(2010, 2, 10));
			c.setCustomer_age(120);
			c.setAddress("Middle Earth");
			c.setMembership("Platinum");
			dao.save(c);
		}
		
		@Test
		public void movieIssue() {
			GenericDao dao =  new GenericDao();
			Movie movie = dao.findById(Movie.class, 3);
			Customer customer = dao.findById(Customer.class, 3);
			MovieIssued issue = new MovieIssued();
			issue.setCustomer(customer);
			issue.setMovie(movie);
			issue.setIssueDate(LocalDate.of(2013, 9, 7));
			issue.setReturnDate(LocalDate.of(2013, 9, 8));
			issue.setDurationInDays(1);
			issue.setRentCost(200);
			dao.save(issue);
		}
		
		@Test
		public void withdraw() {
			BlockBusterService service = new BlockBusterService();
			service.withdraw(3, 3);
		}
		
		@Test
		public void returned() {
			BlockBusterService service = new BlockBusterService();
			service.returned(3, 3);
		}
		
		@Test
		public void fetchStaffDetail() {
			BlockBusterService service = new BlockBusterService();
			Shop shop = new Shop();
			List<Staff> list = service.fetchStaffDetail(1);
			list.forEach(System.out::println);
		}
		
		@Test
		public void fetchAllMovies() {
			BlockBusterService service = new BlockBusterService();
			List<String> list = service.fetchAllMovies();
			list.forEach(System.out::println);
		}
		
		
		
		
}

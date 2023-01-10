package com.lithan.AbcCar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lithan.AbcCar.entity.Booking;
import com.lithan.AbcCar.entity.Car;
import com.lithan.AbcCar.entity.CarBidding;
import com.lithan.AbcCar.entity.UserAccount;
import com.lithan.AbcCar.repository.BidRepository;
import com.lithan.AbcCar.repository.BookingRepository;
import com.lithan.AbcCar.repository.CarRepository;
import com.lithan.AbcCar.repository.UserRepository;
import com.lithan.AbcCar.services.BidService;
import com.lithan.AbcCar.services.BookingService;
import com.lithan.AbcCar.services.CarService;
import com.lithan.AbcCar.services.UserService;

@SpringBootTest
class AbcCarApplicationTests {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	
	@Autowired
	CarRepository carRepository;
	@Autowired
	CarService carService;
	
	@Autowired
	BidRepository carbidRepository;
	@Autowired
	BidService carbidService;
	
	@Autowired
	BookingRepository carbookRepository;
	@Autowired
	BookingService carbookService;
	@Test
	void contextLoads() {
	}
	@Test
	void testRegister() {
		int random = (int)(Math.random() * 10000) +1;
		String username = "testuser" + random ;
		UserAccount user = new UserAccount();
		user.setEmail("unit@email.com");
		user.setUsername("testuser"+ random );
		user.setName("Full Name");
		user.setPassword("test123");
		
		UserAccount saveduser = userService.save(user);
		
		assertEquals(username, saveduser.getUsername());
		
	}
	@Test
	void testAddCar() {
		int random = (int)(Math.random() * 10000) +1;
		String regnum = "SGD" + random +"A" ;
		Car regdb = carService.findCarRegistration(regnum);
		UserAccount userid=userService.get((long) 4);
		
		Car c = new Car();
		c.setUserId(userid);
		c.setMake("Honda");
		c.setModel("Test model");
		c.setPrice("20000");
		c.setRegistration(regnum);
		c.setStatus("1");
		carService.saveCar(c);;
		
		Car savedcar = carService.saveCar(c);
		
		assertEquals(regnum, savedcar.getRegistration());
		
	}
	@Test
	void testAddBid() {
		int random = (int)(Math.random() * 10000) +100;
		String bid = " "+random;
		Car car = carService.get((long)5);
		UserAccount user=userService.get((long)4);
		Date cur_time=new Date();
		   

	       CarBidding carBitInfo = new CarBidding();
	       carBitInfo.setBidderName(user.getUsername());
	       carBitInfo.setBidderPrice(bid);
	       carBitInfo.setCar(car);
	       carBitInfo.setUser(user);
	       carBitInfo.setBid_date_time(cur_time);
	       
	       CarBidding savedCar = carbidService.save(carBitInfo);

		assertEquals(bid, savedCar.getBidderPrice());
		
	}
	@Test
	void testAddBooking() {
		int dd = (int)(Math.random()*(31-1+1)+1);
		int mm = (int)(Math.random()*(12-1+1)+1);
		int yyyy = 2022;
		String bookDate = dd +"/"+mm+"/"+yyyy;
		Car car = carService.get((long)5);
		UserAccount user=userService.get((long)4);
		   
	       Booking carBookInfo = new Booking();
	       carBookInfo.setDate(bookDate);
	       carBookInfo.setCar(car);
	       carBookInfo.setUser(user);

	    Booking savedBook = carbookService.save(carBookInfo);
		assertEquals(bookDate, savedBook.getDate());
		
	}
	
}

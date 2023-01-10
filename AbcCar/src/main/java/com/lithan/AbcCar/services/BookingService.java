package com.lithan.AbcCar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lithan.AbcCar.repository.BookingRepository;
import com.lithan.AbcCar.entity.Booking;
import com.lithan.AbcCar.entity.Car;
import com.lithan.AbcCar.entity.CarBidding;


@Service
@Transactional
public class BookingService {
	
	@Autowired
	BookingRepository repo;
	
	public Booking save(Booking book) {
		return repo.save(book);
	}
	public List<Booking> listBookInfo(Car car) {
		return (List<Booking>) repo.findByCarid(car);
	}

}

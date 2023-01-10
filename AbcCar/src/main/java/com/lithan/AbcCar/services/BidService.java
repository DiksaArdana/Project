package com.lithan.AbcCar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lithan.AbcCar.repository.BidRepository;
import com.lithan.AbcCar.entity.Car;
import com.lithan.AbcCar.entity.CarBidding;

@Service
@Transactional
public class BidService {
	
	@Autowired
	BidRepository repo;
	
	@Autowired
	private BidRepository bidRepository;
	
	public CarBidding save(CarBidding carBidding) {
		return repo.save(carBidding);
	}
	
	public List<CarBidding> listAll() {
		return (List<CarBidding>) repo.findAll();
	}
	
	public List<CarBidding> listBidInfo(Car car) {
		return (List<CarBidding>) repo.findByCarid(car);
	}
	
	public CarBidding get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}

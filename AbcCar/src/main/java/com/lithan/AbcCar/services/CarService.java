package com.lithan.AbcCar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lithan.AbcCar.controllers.PublicController;
import com.lithan.AbcCar.repository.CarRepository;
import com.lithan.AbcCar.entity.Car;
import com.lithan.AbcCar.entity.Booking;

@Service
@Transactional
public class CarService {
	
	private static final Logger logger = LoggerFactory.getLogger(PublicController.class);
	
	@Autowired
	private CarRepository carRepository;
	
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}
	
	public Optional<Car> findCarByModel(String Model) {
		return carRepository.findByModel(Model);
	}
	public Car findCarRegistration(String regis) {
		return carRepository.findByRegistration(regis);
	}
	public Car saveCar(Car car) {
		return carRepository.save(car);
		
	}
	public void UpdateaddCar(Car us) {
		// TODO Auto-generated method stub
		Car newCar = get(us.getId());
		newCar.setUserId(us.getUserId());
		newCar.setMake(us.getMake());
		newCar.setModel(us.getModel());
		newCar.setPrice(us.getPrice());
		newCar.setRegistration(us.getRegistration());
		newCar.setFilePath(us.getFilePath());
		newCar.setFileSize(us.getFileSize());
		newCar.setFileType(us.getFileType());
		newCar.setImage(us.getImage());
		newCar.setStatus("1");
		carRepository.save(newCar);
			
	}
	public void UpdateStatus(Car car) {
		Car newCar = get(car.getId());
		newCar.setStatus("2");
		carRepository.save(newCar);
	}
	public Car get(Long id) {
		return carRepository.findById(id).get();
	}
	
	
	public void delete(Long id) {
		carRepository.deleteById(id);
	}
	public List<Car> listUserCar(long id) {
		List<Car> listCar = carRepository.findByUserId(id);
		return listCar;
	}
	public List<Car> listUserCarByStatus() {
		List<Car> listCar = carRepository.findByStatus();
		return listCar;
	}
	
	public List<Car> search(String keyword) {
		return carRepository.search(keyword);
	}
	
	public List<Car> getAllBid() {
		return carRepository.findAll();
	}
	

}

package com.lithan.AbcCar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lithan.AbcCar.entity.Booking;
import com.lithan.AbcCar.entity.Car;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	@Query("select b from Booking b where b.car in :carid")
	List<Booking> findByCarid(@Param("carid") Car car);
}

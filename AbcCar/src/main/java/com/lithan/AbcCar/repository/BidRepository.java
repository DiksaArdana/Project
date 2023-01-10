package com.lithan.AbcCar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lithan.AbcCar.entity.Car;
import com.lithan.AbcCar.entity.CarBidding;

@Repository
public interface BidRepository extends JpaRepository<CarBidding, Long> {
	
	@Query("select b from CarBidding b where b.car in :carid")
	List<CarBidding> findByCarid(@Param("carid") Car car);

}

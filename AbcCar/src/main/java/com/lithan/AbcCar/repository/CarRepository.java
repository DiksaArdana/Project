package com.lithan.AbcCar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lithan.AbcCar.entity.Car;


@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
	
	Optional<Car> findByModel(String model);
	
	@Query(value = "SELECT c FROM Car c WHERE c.make LIKE '%' || :keyword || '%'"
			+ " OR c.model LIKE '%' || :keyword || '%'"
			+ " OR c.price LIKE '%' || :keyword || '%'")
	public List<Car> search(@Param("keyword") String keyword);
	public Car findByRegistration(String registration);
	@Query(value = "SELECT * FROM car WHERE userid = :id", nativeQuery = true)
	public List<Car> findByUserId(@Param("id")long id);
	@Query(value = "SELECT * FROM car WHERE status = 1", nativeQuery = true)
	public List<Car> findByStatus();
}

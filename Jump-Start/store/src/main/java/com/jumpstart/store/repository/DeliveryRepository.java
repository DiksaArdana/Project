package com.jumpstart.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jumpstart.store.entity.Delivery;
import com.jumpstart.store.entity.Products;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

	@Query(value = "SELECT * FROM delivery_tb WHERE status = 'request' AND rider_id = :uid ", nativeQuery = true)
	public List<Delivery> findByRequestRider(@Param("uid") Long uid);
}

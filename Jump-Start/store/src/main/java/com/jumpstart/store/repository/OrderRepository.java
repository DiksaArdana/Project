package com.jumpstart.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jumpstart.store.entity.Order;
import com.jumpstart.store.entity.Products;
import com.jumpstart.store.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query(value = "SELECT * FROM order_tb WHERE status = 'pending'", nativeQuery = true)
	public List<Order> findPendingOrder();
}

package com.jumpstart.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumpstart.store.entity.Order;
import com.jumpstart.store.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	public Order SaveOrder(Order dta) {
		
		return orderRepo.save(dta);
	}
	public Order getOrderId(Long id) {
		return orderRepo.findById(id).get();
	}
	public List<Order> listOrderByStatus() {
		List<Order> list = orderRepo.findPendingOrder();
		return list;
	}
	public Order editStatusOrder(long id) {
		Order dta = getOrderId(id);
		dta.setStatus("delivered");
		return orderRepo.save(dta);
	}

}

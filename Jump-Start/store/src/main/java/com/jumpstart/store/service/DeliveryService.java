package com.jumpstart.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.jumpstart.store.entity.Delivery;
import com.jumpstart.store.repository.DeliveryRepository;

@Service
public class DeliveryService {
	@Autowired
	private DeliveryRepository deliveryRepo;
	
	public Delivery SaveDelivery(Delivery dta) {
	
		return deliveryRepo.save(dta);
	}
	public Delivery editStatusDelivery(long id) {
		Delivery dta = getDeliveryId(id);
		dta.setStatus("complete");
		return deliveryRepo.save(dta);
	}
	public Delivery getDeliveryId(Long id) {
		return deliveryRepo.findById(id).get();
	}
	public List<Delivery> listDeliveryRequest(long uid) {
		List<Delivery> list = deliveryRepo.findByRequestRider(uid);
		return list;
	}
	public List<Delivery> listAllDelivery() {
		List<Delivery> list = deliveryRepo.findAll();
		return list;
	}

}

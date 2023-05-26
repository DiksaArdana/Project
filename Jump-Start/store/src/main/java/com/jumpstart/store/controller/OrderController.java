package com.jumpstart.store.controller;

import com.jumpstart.store.dto.ChartDto;
import com.jumpstart.store.entity.Chart;
import com.jumpstart.store.entity.Delivery;
import com.jumpstart.store.entity.Order;
import com.jumpstart.store.entity.Products;
import com.jumpstart.store.entity.User;
import com.jumpstart.store.repository.UserRepository;
import com.jumpstart.store.service.ChartService;
import com.jumpstart.store.service.DeliveryService;
import com.jumpstart.store.service.OrderService;
import com.jumpstart.store.service.ProductsService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private  ChartService chartService;
    @Autowired
    private  OrderService orderService;
    @Autowired
    private  DeliveryService deliveryService;
    @Autowired
    private  ProductsService productService;
    @Autowired
    private  UserRepository userRepo;
    

    @GetMapping("/order-list")
	public List<Order> OrderList() {
		List<Order> result = orderService.listOrderByStatus();
		return result;		
	}

    @PostMapping(value = "/post-order")
	public ResponseEntity<String> postOrder(@RequestParam("cid") long cid) {
    	Chart chart = chartService.getChartId(cid);
    	Date date_time = new Date();
		Order nw = new Order();
		nw.setChart(chart);
		nw.setDate(date_time);
		nw.setStatus("pending");
		orderService.SaveOrder(nw);
		return new ResponseEntity<>("Post Order Successful! ",HttpStatus.OK);
		
	}
  //============================= Delivery
    @PostMapping(value = "/post-delivery")
	public ResponseEntity<String> postDelivery(@RequestParam("orderid") long oid, @RequestParam("riderid") long uid ) {
    	Order ordid = orderService.getOrderId(oid);
    	User user = userRepo.findById(uid).get();
    	Date date_time = new Date();
    	orderService.editStatusOrder(oid);
		Delivery nw = new Delivery();
		nw.setUser(user);
		nw.setOrder(ordid);
		nw.setDate(date_time);
		nw.setStatus("request");
		deliveryService.SaveDelivery(nw);
		return new ResponseEntity<>("Post Delivery Successful! ",HttpStatus.OK);
		
	}
    @PostMapping(value = "/edit-delivery")
    public ResponseEntity<String> EditDelivery(@RequestParam("did") long did) {
		deliveryService.editStatusDelivery(did);
		return new ResponseEntity<>("Post Edit Chart Successful! ",HttpStatus.OK);
		
	}
    @GetMapping("/my-delivery/{uid}")
	public List<Delivery> ListDelivery(@PathVariable("uid") Long uid) {
		List<Delivery> result =  deliveryService.listDeliveryRequest(uid);
		return result;		
	}
}

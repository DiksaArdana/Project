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
@RequestMapping("/api/chart")
public class ChartController {

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
    
    @PostMapping(value = "/post-chart")
	public ResponseEntity<String> postChart(@RequestParam("uid") long uid,@RequestParam("pid") long pid, 
			@RequestParam("qty") long qty, @RequestParam("subtotal") long subtotal ) {
    	Products product = productService.getProductId(pid);
    	User user = userRepo.findById(uid).get();
		Chart nw = new Chart();
		nw.setProduct(product);
		nw.setUser(user);
		nw.setQty(qty);
		nw.setTotal(subtotal);
		nw.setStatus("enable");
		chartService.SaveChart(nw);
		return new ResponseEntity<>("Post Chart Successful! ",HttpStatus.OK);
		
	}
    @PostMapping(value = "/edit-chart")
    public ResponseEntity<String> EditChart(@RequestParam("cid") long cid) {
		chartService.editStatusChart(cid);
		return new ResponseEntity<>("Post Edit Chart Successful! ",HttpStatus.OK);
		
	}
    @GetMapping("/chart-list")
	public List<Chart> ChartList() {
		List<Chart> result = chartService.listAllChart();
		return result;		
	}
    @GetMapping("/my-chart/{uid}")
	public List<Chart> Chart(@PathVariable("uid") Long uid) {
		List<Chart> result =  chartService.listChartByStatus(uid);
		return result;		
	}
}

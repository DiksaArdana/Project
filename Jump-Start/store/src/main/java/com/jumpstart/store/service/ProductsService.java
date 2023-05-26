package com.jumpstart.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jumpstart.store.entity.Category;
import com.jumpstart.store.entity.Products;
import com.jumpstart.store.repository.CategoryRepository;
import com.jumpstart.store.repository.ProductsRepository;


@Service
public class ProductsService {
	@Autowired
	private ProductsRepository productRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	
	public Products SaveProduct(Products dta) {
	
		return productRepo.save(dta);
	}
	public Products getProductId(Long id) {
		return productRepo.findById(id).get();
	}
	public List<Products> listProductsByStatus() {
		List<Products> list = productRepo.findAvailableProduct();
		return list;
	}
	public List<Products> listProductsByPromo() {
		List<Products> list = productRepo.findPromoProduct();
		return list;
	}
	public List<Products> SearchProducts(String keyword) {
		List<Products> list = productRepo.searchProduct(keyword);
		return list;
	}

	public List<Products> listAllProducts() {
		List<Products> list = productRepo.findAll();
		return list;
	}
// ================= Category =================
	public Category SaveCategory(Category dta) {
		return categoryRepo.save(dta);
	}
	public Category getCategoryId(Long id) {
		return categoryRepo.findById(id).get();
	}
	public List<Category> listAllCategory() {
		List<Category> list = categoryRepo.findAll();
		return list;
	}
}

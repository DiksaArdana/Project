package com.jumpstart.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jumpstart.store.entity.Products;



@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	@Query(value = "SELECT c FROM Products c WHERE c.status = 'available' AND (c.name LIKE '%' || :keyword || '%'"
			+ " OR c.category LIKE '%' || :keyword || '%')")
	public List<Products> searchProduct(@Param("keyword") String keyword);
	
	@Query(value = "SELECT * FROM products_tb WHERE status = 'available'", nativeQuery = true)
	public List<Products> findAvailableProduct();
	
	@Query(value = "SELECT * FROM products_tb WHERE status = 'available' and event = 'promo'", nativeQuery = true)
	public List<Products> findPromoProduct();
}

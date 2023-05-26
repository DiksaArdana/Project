package com.jumpstart.store.controller;

import com.jumpstart.store.entity.Category;
import com.jumpstart.store.entity.Products;
import com.jumpstart.store.service.FileStorageService;
import com.jumpstart.store.service.ProductsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private  ProductsService productService;
    @Autowired
	private FileStorageService fileService;

    @PostMapping(value = "/post-product")
	public ResponseEntity<String> postCampaign(@RequestParam("name") String name, @RequestParam("price") long price,
			@RequestParam("image") MultipartFile image, @RequestParam("category") long category,
			@RequestParam("event") String event, @RequestParam("status") String status,@RequestParam("descr") String descr) {
    	String imageName = fileService.storeFile(image);
        String imageDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/file/downloadFile/")
            .path(imageName).toUriString();
        Category catnum = productService.getCategoryId(category);
		Products nw = new Products();
		nw.setName(name);
		nw.setImage(imageDownloadUri);
		nw.setCategory(catnum);
		nw.setPrice(price);
		nw.setDesc(descr);
		nw.setEvent(event);
		nw.setStatus(status);
		productService.SaveProduct(nw);
		return new ResponseEntity<>("Post Product Successful! ",HttpStatus.OK);
		
	}
    @PostMapping(value = "/edit-product")
	public ResponseEntity<String> postCampaign(@RequestParam("name") String name, @RequestParam("price") long price,
			@RequestParam("image") MultipartFile image, @RequestParam("category") long category,@RequestParam("pid") long pid,
			@RequestParam("event") String event, @RequestParam("status") String status,@RequestParam("descr") String descr) {
    	String imageName = fileService.storeFile(image);
        String imageDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/file/downloadFile/")
            .path(imageName).toUriString();
        Category catnum = productService.getCategoryId(category);
		Products nw = productService.getProductId(pid);
		nw.setId(pid);
		nw.setName(name);
		nw.setImage(imageDownloadUri);
		nw.setCategory(catnum);
		nw.setPrice(price);
		nw.setDesc(descr);
		nw.setEvent(event);
		nw.setStatus(status);
		productService.SaveProduct(nw);
		return new ResponseEntity<>("Post Product Successful! ",HttpStatus.OK);
		
	}
    @GetMapping("/product-detail")
    public Products ProductDetail(@RequestParam("pid")long pid) {
    	Products result = productService.getProductId(pid);
    	return result;
    }
    @GetMapping("/products-list")
	public List<Products> Productlist() {
		List<Products> result = productService.listAllProducts();
		return result;		
	}
    @GetMapping("/products-available")
	public List<Products> ProductAvailable() {
		List<Products> result = productService.listProductsByStatus();
		return result;		
	}
    @GetMapping("/products-promo")
	public List<Products> ProductPromo() {
		List<Products> result = productService.listProductsByPromo();
		return result;		
	}
    @GetMapping("/products-search")
	public List<Products> SearchProduct(@RequestParam("keyword") String keyword) {
		List<Products> result = productService.SearchProducts(keyword);
		return result;		
	}
    
// ======= Category =======
    @PostMapping(value = "/post-category")
   	public ResponseEntity<String> postCampaign(@RequestParam("name") String name, @RequestParam("image") MultipartFile image) {
       	String imageName = fileService.storeFile(image);
        String imageDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/file/downloadFile/")
               .path(imageName).toUriString();
   		Category nw = new Category();
   		nw.setName(name);
   		nw.setImage(imageDownloadUri);
   		
   		productService.SaveCategory(nw);
   		return new ResponseEntity<>("Post Product Successful! ",HttpStatus.OK);
   		
   	}
    @GetMapping("/category-list")
	public List<Category> Categorylist() {
		List<Category> result = productService.listAllCategory();
		return result;		
	}
}

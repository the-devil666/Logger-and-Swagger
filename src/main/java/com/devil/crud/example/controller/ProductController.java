package com.devil.crud.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devil.crud.example.entity.Product;
import com.devil.crud.example.service.ProductService;

@RestController
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
    	logger.info("From class name: {}, user accesing addProduct method to Save a product", 
    			this.getClass().getSimpleName() );
        return service.saveProduct(product);   
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
    	logger.info("From class name: {}, user accesing addProducts method to Save a products", 
    			this.getClass().getSimpleName() );
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
    	logger.info("From class name: {}, user accesing getProducts method to get all products", 
    			this.getClass().getSimpleName() );
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
    	logger.info("From class name: {}, user accesing getProducts method to get a product by id", 
    			this.getClass().getSimpleName() );
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
    	logger.info("From class name: {}, user accesing getProducts method to get a product by name", 
    			this.getClass().getSimpleName() );
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
    	logger.info("From class name: {}, user accesing putProducts method to update a product", 
    			this.getClass().getSimpleName() );
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
    	logger.info("From class name: {}, user accesing deleteProducts method to delete a product by id", 
    			this.getClass().getSimpleName() );
        return service.deleteProduct(id);
    }
}

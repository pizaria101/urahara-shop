package dev.schulte.controllers;

import dev.schulte.entities.Product;
import dev.schulte.services.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    Logger logger = LogManager.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        logger.info("Request to GET /products");
        return this.productService.getAllProducts();
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product savedProduct = this.productService.addProduct(product);
        return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable String productId){
        int id = Integer.parseInt(productId);
        return this.productService.getProductById(id);
    }
}

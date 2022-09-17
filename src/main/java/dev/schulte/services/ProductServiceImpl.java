package dev.schulte.services;

import dev.schulte.entities.Product;
import dev.schulte.exceptions.ProductNotFoundException;
import dev.schulte.repos.ProductRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepo productRepo;

    @Override
    public Product addProduct(Product product) {
        return this.productRepo.save(product);
    }

    @Override
    public Product getProductById(int productId) {
        Optional<Product> possibleProduct = this.productRepo.findById(productId);
        if(possibleProduct.isPresent()){
            return possibleProduct.get();
        }else{
            this.logger.error("A product could not be found with id " + productId);
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }
}

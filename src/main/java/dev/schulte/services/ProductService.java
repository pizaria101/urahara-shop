package dev.schulte.services;

import dev.schulte.entities.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    Product getProductById(int productId);

    List<Product> getAllProducts();
}

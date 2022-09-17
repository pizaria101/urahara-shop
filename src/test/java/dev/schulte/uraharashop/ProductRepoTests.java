package dev.schulte.uraharashop;

import dev.schulte.entities.Product;
import dev.schulte.repos.ProductRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
public class ProductRepoTests {

    @Autowired
    ProductRepo productRepo;

    @Test
    public void create_product_test(){
        Product product = new Product(0,5,"Hollow bait",25.0,"Used to attract hollows");
        Product savedProduct = this.productRepo.save(product);
        System.out.println(savedProduct);
        Assertions.assertNotEquals(0, savedProduct.getProductId());
    }

    @Test
    public void get_product_by_id_test(){
        Product product = new Product(0,5,"Hollow bait",25.0,"Used to attract hollows");
        Product savedProduct = this.productRepo.save(product);
        Product foundProduct = this.productRepo.findById(savedProduct.getProductId()).get();
        System.out.println(foundProduct);
    }

    @Test
    public void get_all_products_test(){

    }

    @Test
    public void get_nonexistent_product_test(){
        Optional<Product> possibleProduct = this.productRepo.findById(0);
        if(possibleProduct.isPresent()){
            Product product = possibleProduct.get();
        }else{
            System.out.println("No product found");
        }
    }
}

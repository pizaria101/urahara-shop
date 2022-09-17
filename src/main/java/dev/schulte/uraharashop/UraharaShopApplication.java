package dev.schulte.uraharashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.schulte"})
@EntityScan(basePackages = {"dev.schulte.entities"})
@EnableJpaRepositories(basePackages = {"dev.schulte.repos"})
public class UraharaShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(UraharaShopApplication.class, args);
	}

}

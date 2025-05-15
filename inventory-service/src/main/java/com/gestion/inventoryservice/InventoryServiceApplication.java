package com.gestion.inventoryservice;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.gestion.inventoryservice.entities.Product;
import com.gestion.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product
                    .builder()
                            .id(UUID.randomUUID().toString())
                            .name("computer")
                            .price(3200)
                            .quantity(11)
                    .build());
            productRepository.save(Product
                    .builder()
                    .id(UUID.randomUUID().toString())
                    .name("printer")
                    .price(4000)
                    .quantity(23)
                    .build());

            productRepository.save(Product
                    .builder()
                    .id(UUID.randomUUID().toString())
                    .name("Smartphone")
                    .price(5000)
                    .quantity(28)
                    .build());
            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });


        };
    }
}

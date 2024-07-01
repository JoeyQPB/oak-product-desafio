package com.oak.product.components;

import com.oak.product.model.dto.ProductDto;
import com.oak.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ola");
        productService.save(new ProductDto("IPHONE", "MAKE CALLS", BigDecimal.valueOf(1500.0), "YES"));
        productService.save(new ProductDto("COMPUTER", "MAKE STUFFS", BigDecimal.valueOf(2500.0), "YES"));
        productService.save(new ProductDto("MY MUG", "CARRY COFFEE", BigDecimal.valueOf(99999.9), "NO"));

        productService.save(new ProductDto("DOG FOOD", "PREMIUM DRY DOG FOOD", BigDecimal.valueOf(50.0), "YES"));
        productService.save(new ProductDto("CAT LITTER", "CLUMPING CAT LITTER", BigDecimal.valueOf(15.00), "YES"));
        productService.save(new ProductDto("BIRD CAGE", "SPACIOUS BIRD CAGE", BigDecimal.valueOf(99.9), "NO"));
    }
}
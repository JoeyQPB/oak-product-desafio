package com.oak.product.controller;

import com.oak.product.model.ProductModel;
import com.oak.product.model.dto.ProductDto;
import com.oak.product.model.dto.ProductModelList;
import com.oak.product.service.ProductService;
import com.oak.product.service.ServiceResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductModel> create (@RequestBody @Valid ProductDto data) {
        ServiceResponse<ProductModel> serviceResponse = this.productService.save(data);
        return ResponseEntity.status(serviceResponse.httpStatus()).body(serviceResponse.body());
    }

    @GetMapping
    public ResponseEntity<Set<ProductModelList>> getAll () {
        ServiceResponse<Set<ProductModelList>> serviceResponse = this.productService.getAll();
        return ResponseEntity.status(serviceResponse.httpStatus()).body(serviceResponse.body());
    }

    @GetMapping("/sortByPrice")
    public ResponseEntity<Iterable<ProductModel>> getAllSorted2 () {
        ServiceResponse<Iterable<ProductModel>> serviceResponse = this.productService.getAllShortingByPrice();
        return ResponseEntity.status(serviceResponse.httpStatus()).body(serviceResponse.body());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable @Valid Long id) {
        ServiceResponse<Boolean> serviceResponse = this.productService.delete(id);
        return ResponseEntity.status(serviceResponse.httpStatus()).body(serviceResponse.body());
    }
}

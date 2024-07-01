package com.oak.product.service;

import com.oak.product.exceptions.EntityNotFoundException;
import com.oak.product.model.ProductModel;
import com.oak.product.model.dto.ProductDto;
import com.oak.product.model.dto.ProductModelList;
import com.oak.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    private final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Transactional
    public ServiceResponse<ProductModel> save (ProductDto productDto) {
        ProductModel productModel = new ProductModel(productDto);
        ProductModel productCreated = this.repository.save(productModel);

        LOGGER.info("Product Created: {}!", productCreated);
        return new ServiceResponse<>(HttpStatus.CREATED, productCreated);
    }

    public ServiceResponse<Set<ProductModelList>> getAll () {

        Iterable<ProductModel> products = this.repository.findAll();

        HashSet<ProductModelList> productList = new HashSet<>();
        products.forEach((prod -> {
            ProductModelList prodElement = new ProductModelList(prod.getName(), prod.getPrice());
            productList.add(prodElement);
        }));

        LOGGER.info("All Products found!");
        return new ServiceResponse<>(HttpStatus.OK, productList);
    }

    public ServiceResponse<Iterable<ProductModel>> getAllShortingByPrice () {
        Sort sort = Sort.by("price").ascending();
        Iterable<ProductModel> products = this.repository.findAll(sort);

        LOGGER.info("All Products found shorted by price!");
        return new ServiceResponse<>(HttpStatus.OK, products);
    }

    @Transactional
    public ServiceResponse<Boolean> delete (Long id) {

        ProductModel productModel = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found for: " + id));

        this.repository.delete(productModel);
        LOGGER.info("Product deleted: {}!", productModel.getId());

        return new ServiceResponse<>(HttpStatus.CREATED, true);
    }
}

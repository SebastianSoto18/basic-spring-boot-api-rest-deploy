package com.basic.apirest.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.apirest.apirest.Entities.Product;
import com.basic.apirest.apirest.Repositories.Interfaces.IProductRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductRepository _productRepository;

    @GetMapping()
    public List<Product> getProducts() {
        return _productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id) {
        return _productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product entity) {
        return _productRepository.save(entity);
    }

    @PutMapping("/{id}")
    public Product putMethodName(@PathVariable long id, @RequestBody Product entity) {
        Product product = _productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProductName(entity.getProductName());
        product.setProductPrice(entity.getProductPrice());
        return  _productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable long id) {
        Product product = _productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        _productRepository.delete(product);
        return "Product deleted";
    }
    
}

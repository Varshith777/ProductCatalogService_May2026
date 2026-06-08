package org.example.productcatalogservice_may2026.controllers;

import org.example.productcatalogservice_may2026.dtos.ProductDto;
import org.example.productcatalogservice_may2026.models.Category;
import org.example.productcatalogservice_may2026.models.Product;
import org.example.productcatalogservice_may2026.services.IProductService;
import org.example.productcatalogservice_may2026.services.ProductService;
import org.example.productcatalogservice_may2026.services.StorageProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//ToDo 8/6 -: Add PUT,PATCH and DELETE API
//ToDo 8/6 -: Read about RestTemplate

@RestController
public class ProductController {
    //APIs

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return null;
    }

    @GetMapping("/products/{ID}")
    public ProductDto getProductById(@PathVariable("ID") Long productId) {
       return null;
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto input) {
        return input;
    }



//    @GetMapping("/products/{catId}/{prodId}")
//    public Product getProduct(@PathVariable("catId") Long categoryId,
//                              @PathVariable("prodId") Long productId) {
//        Product product =new Product();
//        Category category = new Category();
//        category.setId(categoryId);
//        product.setCategory(category);
//        product.setId(productId);
//        return product;
//    }


}

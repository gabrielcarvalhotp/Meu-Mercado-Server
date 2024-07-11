package com.gabrielcarvalhotp.api.meumercado.controllers;

import com.gabrielcarvalhotp.api.meumercado.domains.ProductCategory;
import com.gabrielcarvalhotp.api.meumercado.dtos.ProductCategoryDTO;
import com.gabrielcarvalhotp.api.meumercado.helpers.URIHelpers;
import com.gabrielcarvalhotp.api.meumercado.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product-categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = productCategoryService.createProductCategory(productCategoryDTO);
        URI uri = URIHelpers.servletUri("/product-categories/{id}", productCategory.getId());
        return ResponseEntity.created(uri).body(productCategory);
    }

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAllProductCategories() {
        return ResponseEntity.ok().body(productCategoryService.getAllProductCategories());
    }

}

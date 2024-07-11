package com.gabrielcarvalhotp.api.meumercado.controllers;

import com.gabrielcarvalhotp.api.meumercado.domains.Product;
import com.gabrielcarvalhotp.api.meumercado.dtos.ProductDTO;
import com.gabrielcarvalhotp.api.meumercado.helpers.URIHelpers;
import com.gabrielcarvalhotp.api.meumercado.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = productService.createProduct(productDTO);
        URI uri = URIHelpers.servletUri("/products/{id}", product.getId());
        return ResponseEntity.created(uri).body(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getByEstablishmentId(@RequestParam UUID establishmentId) {
        List<Product> products = productService.getByEstablishmentId(establishmentId);
        return ResponseEntity.ok().body(products);
    }
}

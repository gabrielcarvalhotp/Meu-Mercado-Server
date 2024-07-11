package com.gabrielcarvalhotp.api.meumercado.services;

import com.gabrielcarvalhotp.api.meumercado.domains.Product;
import com.gabrielcarvalhotp.api.meumercado.dtos.ProductDTO;
import com.gabrielcarvalhotp.api.meumercado.repositories.ProductRepository;
import com.gabrielcarvalhotp.api.meumercado.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EstablishmentService establishmentService;

    @Autowired
    private ProductCategoryService productCategoryService;

    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO);
        product.setEstablishment(establishmentService.getEstablishmentById(productDTO.establishmentsId()));
        product.setProductCategory(productCategoryService.getProductCategoryById(productDTO.productCategoryId()));
        return productRepository.save(product);
    }

    public List<Product> getByEstablishmentId(UUID establishmentId) {
        return productRepository.findByEstablishmentId(establishmentId);
    }

    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
}

package com.gabrielcarvalhotp.api.meumercado.services;

import com.gabrielcarvalhotp.api.meumercado.domains.ProductCategory;
import com.gabrielcarvalhotp.api.meumercado.dtos.ProductCategoryDTO;
import com.gabrielcarvalhotp.api.meumercado.repositories.ProductCategoryRepository;
import com.gabrielcarvalhotp.api.meumercado.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategory createProductCategory(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = new ProductCategory(productCategoryDTO);
        return productCategoryRepository.save(productCategory);
    }

    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAllOrdered();
    }

    public ProductCategory getProductCategoryById(UUID id) {
        return productCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductCategory not found"));
    }
}

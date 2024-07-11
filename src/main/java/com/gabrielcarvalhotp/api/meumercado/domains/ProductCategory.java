package com.gabrielcarvalhotp.api.meumercado.domains;

import com.gabrielcarvalhotp.api.meumercado.dtos.ProductCategoryDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "product_category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private Integer ordernation;

    public ProductCategory(ProductCategoryDTO productCategoryDTO) {
        this.description = productCategoryDTO.description();
        this.ordernation = productCategoryDTO.ordernation();
    }

}

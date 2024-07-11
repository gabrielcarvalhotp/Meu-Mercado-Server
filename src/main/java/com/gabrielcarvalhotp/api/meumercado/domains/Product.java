package com.gabrielcarvalhotp.api.meumercado.domains;

import com.gabrielcarvalhotp.api.meumercado.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String unit;
    @Column(nullable = false)
    private Double weight;
    @Column(nullable = false)
    private Double price;
    @Column(name = "url_image")
    private String urlImage;

    @ManyToOne
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    public Product(ProductDTO productDTO) {
        this.name = productDTO.name();
        this.description = productDTO.description();
        this.unit = productDTO.unit();
        this.weight = productDTO.weight();
        this.price = productDTO.price();
        this.urlImage = productDTO.urlImage();
    }
}

package com.gabrielcarvalhotp.api.meumercado.domains;

import com.gabrielcarvalhotp.api.meumercado.domains.enuns.EstablishmentDeliveryType;
import com.gabrielcarvalhotp.api.meumercado.dtos.EstablishmentDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "establishments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String district;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String cep;
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
    @Column(name = "delivery_tax", nullable = false)
    private Double deliveryTax;
    @Column(name = "minimum_purchase", nullable = false)
    private Double minimumPurchase;
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "delivery_type")
    private EstablishmentDeliveryType deliveryType;

    public Establishment(EstablishmentDTO establishmentDTO) {
        this.name = establishmentDTO.name();
        this.address = establishmentDTO.address();
        this.district = establishmentDTO.district();
        this.city = establishmentDTO.city();
        this.state = establishmentDTO.state();
        this.cep = establishmentDTO.cep();
        this.creationDate = LocalDateTime.now();
        this.deliveryTax = establishmentDTO.deliveryTax();
        this.minimumPurchase = establishmentDTO.minimumPurchase();
        this.deliveryType = EstablishmentDeliveryType.valueOf(establishmentDTO.deliveryType());
    }
}

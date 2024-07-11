package com.gabrielcarvalhotp.api.meumercado.domains;

import com.gabrielcarvalhotp.api.meumercado.dtos.OrderDTO;
import com.gabrielcarvalhotp.api.meumercado.dtos.OrderItemDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private LocalDateTime date;
    @Column(nullable = false)
    private Double subtotal;
    @Column(name = "delivery_tax", nullable = false)
    private Double deliveryTax;
    @Column(nullable = false)
    private Double total;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(OrderDTO orderDTO) {
        this.date = LocalDateTime.now();
        this.subtotal = orderDTO.subtotal();
        this.deliveryTax = orderDTO.deliveryTax();
        this.total = orderDTO.total();
        this.address = orderDTO.address();
        this.district = orderDTO.district();
        this.city = orderDTO.city();
        this.state = orderDTO.state();
        this.cep = orderDTO.cep();
    }
}

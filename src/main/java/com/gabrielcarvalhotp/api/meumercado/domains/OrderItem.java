package com.gabrielcarvalhotp.api.meumercado.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabrielcarvalhotp.api.meumercado.dtos.OrderItemDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    public OrderItem(OrderItemDTO orderItemDTO) {
        this.price = orderItemDTO.price();
        this.quantity = orderItemDTO.quantity();
    }
}

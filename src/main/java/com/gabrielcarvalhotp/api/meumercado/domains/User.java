package com.gabrielcarvalhotp.api.meumercado.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabrielcarvalhotp.api.meumercado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
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

    public User(UserDTO userDTO) {
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.address = userDTO.address();
        this.district = userDTO.district();
        this.city = userDTO.city();
        this.state = userDTO.state();
        this.cep = userDTO.cep();
        this.creationDate = LocalDateTime.now();
    }

    public void update(UserDTO userDTO) {
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.address = userDTO.address();
        this.district = userDTO.district();
        this.city = userDTO.city();
        this.state = userDTO.state();
        this.cep = userDTO.cep();
    }
}

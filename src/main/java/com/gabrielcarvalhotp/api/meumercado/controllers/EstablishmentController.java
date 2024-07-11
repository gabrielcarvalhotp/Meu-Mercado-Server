package com.gabrielcarvalhotp.api.meumercado.controllers;

import com.gabrielcarvalhotp.api.meumercado.domains.Establishment;
import com.gabrielcarvalhotp.api.meumercado.domains.User;
import com.gabrielcarvalhotp.api.meumercado.dtos.EstablishmentDTO;
import com.gabrielcarvalhotp.api.meumercado.helpers.URIHelpers;
import com.gabrielcarvalhotp.api.meumercado.services.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/establishments")
public class EstablishmentController {
    @Autowired
    private EstablishmentService establishmentService;

    @PostMapping
    public ResponseEntity<Establishment> createEstablishment(@RequestBody EstablishmentDTO establishmentDTO) {
        Establishment establishment = establishmentService.createEstablishment(establishmentDTO);
        URI uri = URIHelpers.servletUri("/establishments/{id}", establishment.getId());
        return ResponseEntity.created(uri).body(establishment);
    }

    @GetMapping
    public ResponseEntity<List<Establishment>> getAllEstablishments() {
        return ResponseEntity.ok().body(establishmentService.getAllEstablishments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Establishment> getEstablishmentById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(establishmentService.getEstablishmentById(id));
    }
}

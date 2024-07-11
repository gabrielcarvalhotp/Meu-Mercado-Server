package com.gabrielcarvalhotp.api.meumercado.services;

import com.gabrielcarvalhotp.api.meumercado.domains.Establishment;
import com.gabrielcarvalhotp.api.meumercado.dtos.EstablishmentDTO;
import com.gabrielcarvalhotp.api.meumercado.repositories.EstablishmentRepository;
import com.gabrielcarvalhotp.api.meumercado.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EstablishmentService {
    @Autowired
    private EstablishmentRepository establishmentRepository;

    public Establishment createEstablishment(EstablishmentDTO establishmentDTO) {
        Establishment establishment = new Establishment(establishmentDTO);
        establishmentRepository.save(establishment);
        return establishment;
    }

    public List<Establishment> getAllEstablishments() {
        return establishmentRepository.findAll();
    }

    public Establishment getEstablishmentById(UUID id) {
        return establishmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Establishment not found"));
    }

    public void updateEstablishment(Establishment establishment) {
        establishmentRepository.save(establishment);
    }

    public void deleteEstablishment(UUID id) {
        establishmentRepository.deleteById(id);
    }
}

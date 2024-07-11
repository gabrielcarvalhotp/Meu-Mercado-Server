package com.gabrielcarvalhotp.api.meumercado.repositories;

import com.gabrielcarvalhotp.api.meumercado.domains.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, UUID> {
}

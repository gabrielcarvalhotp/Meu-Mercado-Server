package com.gabrielcarvalhotp.api.meumercado.repositories;

import com.gabrielcarvalhotp.api.meumercado.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByEmailAndPassword(String email, String password);
}

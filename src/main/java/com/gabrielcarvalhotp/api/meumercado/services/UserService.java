package com.gabrielcarvalhotp.api.meumercado.services;

import com.gabrielcarvalhotp.api.meumercado.domains.User;
import com.gabrielcarvalhotp.api.meumercado.dtos.LoginDTO;
import com.gabrielcarvalhotp.api.meumercado.dtos.UserDTO;
import com.gabrielcarvalhotp.api.meumercado.repositories.UserRepository;
import com.gabrielcarvalhotp.api.meumercado.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);
        return user;
    }

    public User login(LoginDTO loginDTO) {
        return userRepository.findByEmailAndPassword(loginDTO.email(), loginDTO.password())
                .orElseThrow(() -> new ResourceNotFoundException("Email ou senha inválidos"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    public void updateUser(UUID id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        user.update(userDTO);
        userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

}

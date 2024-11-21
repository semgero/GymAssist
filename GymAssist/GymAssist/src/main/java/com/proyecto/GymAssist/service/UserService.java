package com.proyecto.GymAssist.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.GymAssist.model.User;
import com.proyecto.GymAssist.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public Optional<User> login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password)); // **Usa hash para comparar**
    }

    // Método para encontrar un usuario por su correo electrónico
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    // Método para actualizar el usuario
    public void updateUser(User user) {
        userRepository.save(user);
    }
}

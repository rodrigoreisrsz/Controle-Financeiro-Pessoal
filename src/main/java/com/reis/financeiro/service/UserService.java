package com.reis.financeiro.service;

import com.reis.financeiro.entities.User;
import com.reis.financeiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RegistroService registroService;

    @Autowired

    public UserService(UserRepository userRepository, RegistroService registroService) {
        this.userRepository = userRepository;
        this.registroService = registroService;
    }

    public User cadastrar(Long id, String name, String password){
        User user = new User(id, name, password);
        return userRepository.save(user);
    }

}

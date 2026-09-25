package com.reis.financeiro.service;

import com.reis.financeiro.dto.response.UserResponse;
import com.reis.financeiro.entities.User;
import com.reis.financeiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RegistroService registroService;

    @Autowired

    public UserService(UserRepository userRepository, RegistroService registroService) {
        this.userRepository = userRepository;
        this.registroService = registroService;
    }

    public UserResponse cadastrar(String name, String password){
        User user = new User(name, password);
        User userSalvo = userRepository.save(user);
        return new UserResponse(userSalvo);
    }
    public UserResponse login(String name, String password){
        User user = userRepository.findByName(name);
        if(user == null){
            throw new RuntimeException("Usuário inexistente.");
        }
        if(!password.equals(user.getPassword())){
            throw new RuntimeException("Senha inválida");
        }
        return new UserResponse(user);
    }

}

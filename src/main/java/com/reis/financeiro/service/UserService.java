package com.reis.financeiro.service;

import com.reis.financeiro.dto.response.UserResponse;
import com.reis.financeiro.entities.User;
import com.reis.financeiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public UserResponse cadastrar(String name, String email, String password){
        User user = new User(name, email, password);
        User userSalvo = userRepository.save(user);
        return new UserResponse(userSalvo);
    }
    public UserResponse login(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new RuntimeException("Usuário inexistente.");
        }
        if(!password.equals(user.getPassword())){
            throw new RuntimeException("Senha inválida");
        }
        return new UserResponse(user);
    }

}

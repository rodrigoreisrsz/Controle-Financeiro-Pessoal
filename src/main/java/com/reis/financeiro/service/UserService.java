package com.reis.financeiro.service;

import com.reis.financeiro.dto.response.UserResponse;
import com.reis.financeiro.entities.User;
import com.reis.financeiro.repository.UserRepository;
import com.reis.financeiro.security.UserJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;

    }

    public UserResponse cadastrar(User user){
        String password = passwordEncoder.encode(user.getPassword());
        String name = user.getName();
        String email = user.getEmail();
        new User(name, email, password);
        User userSalvo = userRepository.save(user);
        return new UserResponse(userSalvo);
    }
    public UserResponse login(String email, String password){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authentication =  authenticationManager.authenticate(token);

        UserJWT userJWT = (UserJWT) authentication.getPrincipal();
        User user = userJWT.getUser();
        return new UserResponse(user);


    }

}

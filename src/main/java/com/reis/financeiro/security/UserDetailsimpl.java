package com.reis.financeiro.security;

import com.reis.financeiro.entities.User;
import com.reis.financeiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsimpl implements UserDetailsService {

    @Autowired
    private final UserRepository repository;

    public UserDetailsimpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("Usuario nao encontrado");
        }
        return new UserJWT(user);
    }
}

package com.reis.financeiro.controllers;

import com.reis.financeiro.dto.UserCreateDTO;
import com.reis.financeiro.entities.User;
import com.reis.financeiro.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public User cadastrar(@RequestBody @Valid UserCreateDTO userCreate){
        return userService.cadastrar(userCreate.getName(), userCreate.getPassword());
    }
}

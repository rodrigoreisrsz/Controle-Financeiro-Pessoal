package com.reis.financeiro.controllers;

import com.reis.financeiro.dto.UserCreateDTO;
import com.reis.financeiro.entities.User;
import com.reis.financeiro.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/login")
    public User login(@RequestBody UserCreateDTO userCreateDTO){
        return userService.login(userCreateDTO.getName(), userCreateDTO.getPassword());
    }
}

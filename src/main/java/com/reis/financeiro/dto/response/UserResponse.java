package com.reis.financeiro.dto.response;

import com.reis.financeiro.entities.User;

public class UserResponse {
    private Long id;
    private String name;
    private String password;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}

package com.reis.financeiro.dto.response;

import com.reis.financeiro.entities.User;

public class UserResponse {

    private String name;


    public UserResponse(User user) {
        this.name = user.getName();
    }

    public String getName() {
        return name;
    }


}

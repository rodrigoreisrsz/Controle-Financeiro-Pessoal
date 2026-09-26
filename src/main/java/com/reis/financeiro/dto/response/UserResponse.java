package com.reis.financeiro.dto.response;

import com.reis.financeiro.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public class UserResponse {

    private Long id;
    private String name;


    public UserResponse(User user) {
        this.name = user.getName();
        this.id = user.getId();;
    }

    public UserResponse() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}

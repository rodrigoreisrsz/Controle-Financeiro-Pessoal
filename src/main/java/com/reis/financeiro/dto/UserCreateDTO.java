package com.reis.financeiro.dto;

import jakarta.validation.constraints.NotBlank;

public class UserCreateDTO {
    @NotBlank
    private Long id;
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String ge4() {
    }
}

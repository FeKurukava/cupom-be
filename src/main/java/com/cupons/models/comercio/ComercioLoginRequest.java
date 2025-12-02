package com.cupons.models.comercio;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ComercioLoginRequest {

    @NotBlank(message = "E-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    private String email;

    @NotBlank(message = "Senha é obrigatória.")
    private String senha;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}

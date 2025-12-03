package com.cupons.models.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RecuperarSenhaAssociadoRequest {

    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String cpf;

    @NotBlank
    @Size(min = 6)
    private String novaSenha;

    public RecuperarSenhaAssociadoRequest() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
}

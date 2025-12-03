package com.cupons.models.comercio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RecuperarSenhaComercioRequest {

    @NotBlank
    @Pattern(regexp = "\\d{14}")
    private String cnpj;

    @NotBlank
    @Size(min = 6)
    private String novaSenha;

    public RecuperarSenhaComercioRequest() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
}

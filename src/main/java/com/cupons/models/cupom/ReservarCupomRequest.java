package com.cupons.models.cupom;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ReservarCupomRequest {

    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String cpfAssociado;

    @NotBlank
    private String numCupom;

    public ReservarCupomRequest() {
    }

    public String getCpfAssociado() {
        return cpfAssociado;
    }

    public void setCpfAssociado(String cpfAssociado) {
        this.cpfAssociado = cpfAssociado;
    }

    public String getNumCupom() {
        return numCupom;
    }

    public void setNumCupom(String numCupom) {
        this.numCupom = numCupom;
    }
}

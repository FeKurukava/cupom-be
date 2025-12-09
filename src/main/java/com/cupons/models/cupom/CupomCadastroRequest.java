package com.cupons.models.cupom;

import java.time.LocalDate;

public class CupomCadastroRequest {

    private String titulo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Integer percentualDesconto;
    private Integer quantidade;
    private String cnpjComercio;

    public CupomCadastroRequest() {}

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getPercentualDesconto() {
        return percentualDesconto;
    }
    public void setPercentualDesconto(Integer percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCnpjComercio() {
        return cnpjComercio;
    }
    public void setCnpjComercio(String cnpjComercio) {
        this.cnpjComercio = cnpjComercio;
    }
}

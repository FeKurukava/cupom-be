package com.cupons.models.cupom;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;

public class CupomRequestBody {

    @NotBlank(message = "O título da promoção é obrigatório.")
    @NotNull(message = "O título da promoção é obrigatório.")
    private String tituloPromo;

    @NotNull(message = "A data de início é obrigatória.")
    private Date dataValidadeInicio;

    @NotNull(message = "A data de fim é obrigatória.")
    private Date dataValidadeFim;

    @NotNull(message = "O desconto é obrigatório.")
    @DecimalMax(value = "100.00", message = "O desconto não pode ultrapassar 100%.")
    @DecimalMin(value = "0.01", message = "O desconto deve ser maior que zero.")
    private BigDecimal descontoPromo;

    @NotNull(message = "A quantidade de cupons é obrigatória.")
    @Min(value = 1, message = "A quantidade mínima de cupons é 1.")
    private Integer qntCupom;

    @NotBlank(message = "O cnpj é obrigatório.")
    private String cnpjComercio;

    public CupomRequestBody(){

    }

    public CupomRequestBody(String tituloPromo, Date dataValidadeInicio, Date dataValidadeFim, BigDecimal descontoPromo, Integer qntCupom, String cnpjComercio) {
        this.tituloPromo = tituloPromo;
        this.dataValidadeInicio = dataValidadeInicio;
        this.dataValidadeFim = dataValidadeFim;
        this.descontoPromo = descontoPromo;
        this.qntCupom = qntCupom;
        this.cnpjComercio = cnpjComercio;
    }

    public String getTituloPromo() {
        return tituloPromo;
    }

    public void setTituloPromo(String tituloPromo) {
        this.tituloPromo = tituloPromo;
    }

    public Date getDataValidadeInicio() {
        return dataValidadeInicio;
    }

    public void setDataValidadeInicio(Date dataValidadeInicio) {
        this.dataValidadeInicio = dataValidadeInicio;
    }

    public Date getDataValidadeFim() {
        return dataValidadeFim;
    }

    public void setDataValidadeFim(Date dataValidadeFim) {
        this.dataValidadeFim = dataValidadeFim;
    }

    public BigDecimal getDescontoPromo() {
        return descontoPromo;
    }

    public void setDescontoPromo(BigDecimal descontoPromo) {
        this.descontoPromo = descontoPromo;
    }

    public Integer getQntCupom() {
        return qntCupom;
    }

    public void setQntCupom(Integer qntCupom) {
        this.qntCupom = qntCupom;
    }

    public String getCnpjComercio() {
        return cnpjComercio;
    }
    public void setCnpjComercio(String cnpjComercio) {
        this.cnpjComercio = cnpjComercio;
    }

}

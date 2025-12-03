package com.cupons.models.cupom;

import java.math.BigDecimal;
import java.util.Date;

public class CupomResponse {
    private String numCupom;
    private String tituloCupom;
    private Date dtaEmissaoCupom;
    private Date dtaInicioCupom;
    private Date dtaTerminoCupom;
    private BigDecimal perDescCupom;
    private Integer qntCupom;

    public CupomResponse() {
    }

    public String getNumCupom() {
        return numCupom;
    }

    public void setNumCupom(String numCupom) {
        this.numCupom = numCupom;
    }

    public String getTituloCupom() {
        return tituloCupom;
    }

    public void setTituloCupom(String tituloCupom) {
        this.tituloCupom = tituloCupom;
    }

    public Date getDtaEmissaoCupom() {
        return dtaEmissaoCupom;
    }

    public void setDtaEmissaoCupom(Date dtaEmissaoCupom) {
        this.dtaEmissaoCupom = dtaEmissaoCupom;
    }

    public Date getDtaInicioCupom() {
        return dtaInicioCupom;
    }

    public void setDtaInicioCupom(Date dtaInicioCupom) {
        this.dtaInicioCupom = dtaInicioCupom;
    }

    public Date getDtaTerminoCupom() {
        return dtaTerminoCupom;
    }

    public void setDtaTerminoCupom(Date dtaTerminoCupom) {
        this.dtaTerminoCupom = dtaTerminoCupom;
    }

    public BigDecimal getPerDescCupom() {
        return perDescCupom;
    }

    public void setPerDescCupom(BigDecimal perDescCupom) {
        this.perDescCupom = perDescCupom;
    }

    public Integer getQntCupom() {
        return qntCupom;
    }

    public void setQntCupom(Integer qntCupom) {
        this.qntCupom = qntCupom;
    }
}

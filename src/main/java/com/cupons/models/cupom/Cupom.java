package com.cupons.models.cupom;

import com.cupons.models.comercio.Comercio;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cupom")
public class Cupom {

    @Id
    @Column(name = "num_cupom", length = 12)
    private String numCupom;

    @OneToMany(mappedBy = "cupom", fetch = FetchType.LAZY)
    private List<CupomAssociado> cupomAssociados;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cnpj_comercio", nullable = false)
    private Comercio comercio;

    @Column(name = "tit_cupom", length = 25)
    private String tituloCupom;

    @Column(name = "dta_emissao_cupom")
    private Date dtaEmissaoCupom;

    @Column(name = "dta_inicio_cupom")
    private Date dtaInicioCupom;

    @Column(name = "dta_termino_cupom")
    private Date dtaTerminoCupom;

    @Column(name = "per_desc_cupom")
    private BigDecimal perDescCupom;

    public Cupom(){
    }

    public Cupom(String numCupom, List<CupomAssociado>cupomAssociados, String tituloCupom, Date dtaEmissaoCupom, Date dtaInicioCupom, Date dtaTerminoCupom, BigDecimal perDescCupom) {
        this.numCupom = numCupom;
        this.cupomAssociados = cupomAssociados;
        this.tituloCupom = tituloCupom;
        this.dtaEmissaoCupom = dtaEmissaoCupom;
        this.dtaInicioCupom = dtaInicioCupom;
        this.dtaTerminoCupom = dtaTerminoCupom;
        this.perDescCupom = perDescCupom;
    }

    public String getNumCupom() {
        return numCupom;
    }
    public void setNumCupom(String numCupom) {
        this.numCupom = numCupom;
    }

    public List<CupomAssociado> getCupomAssociados() {
        return cupomAssociados;
    }
    public void setCupomAssociados(List<CupomAssociado> cupomAssociados) {
        this.cupomAssociados = cupomAssociados;
    }

    public String getTituloCupom(){
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

    public Number getPerDescCupom() {
        return perDescCupom;
    }
    public void setPerDescCupom(BigDecimal perDescCupom) {
        this.perDescCupom = perDescCupom;
    }

}


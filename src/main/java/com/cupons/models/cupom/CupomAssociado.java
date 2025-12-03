package com.cupons.models.cupom;

import com.cupons.models.associado.Associado;
import jakarta.persistence.*;

import java.util.Date;

@Table(name = "cupom_associado")
@Entity
public class CupomAssociado {

    @Id
    @Column(name = "id_cupom_associado")
    private Integer idCupomAssociado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_associado", nullable = false)
    private Associado associado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "num_cupom", nullable = false)
    private Cupom cupom;

    @Column(name = "dta_cupom_associado")
    private Date dtaCupomAssociado;

    @Column(name = "dta_uso_cupom")
    private Date dtaUsoCupomAssociado;

    public CupomAssociado() {
    }

    public CupomAssociado(Integer idCupomAssociado, Date dtaCupomAssociado, Date dtaUsoCupomAssociado) {
        this.idCupomAssociado = idCupomAssociado;
        this.dtaCupomAssociado = dtaCupomAssociado;
        this.dtaUsoCupomAssociado = dtaUsoCupomAssociado;
    }

    public Integer getIdCupomAssociado() {
        return idCupomAssociado;
    }

    public void setIdCupomAssociado(Integer idCupomAssociado) {
        this.idCupomAssociado = idCupomAssociado;
    }

    public Date getDtaCupomAssociado() {
        return dtaCupomAssociado;
    }

    public void setDtaCupomAssociado(Date dtaCupomAssociado) {
        this.dtaCupomAssociado = dtaCupomAssociado;
    }

    public Date getDtaUsoCupomAssociado() {
        return dtaUsoCupomAssociado;
    }

    public void setDtaUsoCupomAssociado(Date dtaUsoCupomAssociado) {
        this.dtaUsoCupomAssociado = dtaUsoCupomAssociado;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }
}

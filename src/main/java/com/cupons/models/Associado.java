package com.cupons.models;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table(name = "associado")
@Entity
public class Associado {

    @Id
    @Column(name = "cpf_associado")
    private Integer cpfAssociado;

    @OneToMany(mappedBy = "associado", fetch = FetchType.LAZY)
    private List<CupomAssociado> cupomAssociados;

    @Column(name = "nom_associado", length = 40)
    private String nomAssociado;

    @Column(name = "dtn_associado")
    private Date dtnAssociado;

    @Column(name = "end_associado", length = 40)
    private String endAssociado;

    @Column(name = "bai_associado", length = 30)
    private String baiAssociado;

    @Column(name = "cep_associado", length = 8)
    private String cepAssociado;

    @Column(name = "cid_associado", length = 40)
    private String cidAssociado;

    @Column(name = "uf_associado", length = 2)
    private String ufAssociado;

    @Column(name = "cel_associado", length = 15)
    private String celAssociado;

    @Column(name = "email_associado", length = 50)
    private String emailAssociado;

    @Column(name = "sen_associado", length = 20)
    private String senAssociado;

    public Associado(){
    }
    public Associado(Integer cpfAssociado,List<CupomAssociado>cupomAssociados, String nomAssociado, Date dtnAssociado, String endAssociado, String baiAssociado, String cepAssociado, String cidAssociado, String ufAssociado, String celAssociado, String emailAssociado, String senAssociado) {
        this.cpfAssociado = cpfAssociado;
        this.cupomAssociados = cupomAssociados;
        this.nomAssociado = nomAssociado;
        this.dtnAssociado = dtnAssociado;
        this.endAssociado = endAssociado;
        this.baiAssociado = baiAssociado;
        this.cepAssociado = cepAssociado;
        this.cidAssociado = cidAssociado;
        this.ufAssociado = ufAssociado;
        this.celAssociado = celAssociado;
        this.emailAssociado = emailAssociado;
        this.senAssociado = senAssociado;
    }
    public Integer getCpfAssociado() {
        return cpfAssociado;
    }
    public void setCpfAssociado(Integer cpfAssociado) {
        this.cpfAssociado = cpfAssociado;
    }

    public List<CupomAssociado> getCupomAssociados() {
        return cupomAssociados;
    }
    public void setCupomAssociados(List<CupomAssociado> cupomAssociados) {
        this.cupomAssociados = cupomAssociados;
    }

    public String getNomAssociado() {
        return nomAssociado;
    }
    public void setNomAssociado(String nomAssociado) {
        this.nomAssociado = nomAssociado;
    }

    public Date getDtnAssociado() {
        return dtnAssociado;
    }

    public void setDtnAssociado(Date dtnAssociado) {
        this.dtnAssociado = dtnAssociado;
    }

    public String getEndAssociado() {
        return endAssociado;
    }

    public void setEndAssociado(String endAssociado) {
        this.endAssociado = endAssociado;
    }

    public String getBaiAssociado() {
        return baiAssociado;
    }

    public void setBaiAssociado(String baiAssociado) {
        this.baiAssociado = baiAssociado;
    }

    public String getCepAssociado() {
        return cepAssociado;
    }

    public void setCepAssociado(String cepAssociado) {
        this.cepAssociado = cepAssociado;
    }

    public String getCidAssociado() {
        return cidAssociado;
    }

    public void setCidAssociado(String cidAssociado) {
        this.cidAssociado = cidAssociado;
    }

    public String getUfAssociado() {
        return ufAssociado;
    }

    public void setUfAssociado(String ufAssociado) {
        this.ufAssociado = ufAssociado;
    }

    public String getCelAssociado() {
        return celAssociado;
    }

    public void setCelAssociado(String celAssociado) {
        this.celAssociado = celAssociado;
    }

    public String getEmailAssociado() {
        return emailAssociado;
    }

    public void setEmailAssociado(String emailAssociado) {
        this.emailAssociado = emailAssociado;
    }

    public String getSenAssociado() {
        return senAssociado;
    }

    public void setSenAssociado(String senAssociado) {
        this.senAssociado = senAssociado;
    }
}

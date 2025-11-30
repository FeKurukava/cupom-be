package com.cupons.models.comercio;

import com.cupons.models.categoria.Categoria;
import jakarta.persistence.*;

@Entity
@Table(name = "comercio")
public class Comercio {

    @Id
    @Column(name = "cnpj_comercio")
    private Integer cnpjComercio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "raz_social_comercio", length = 50)
    private String razSocialComercio;

    @Column(name = "nom_fantasia_comercio", length = 30)
    private String nomFantasiaComercio;

    @Column(name = "end_comercio", length = 40)
    private String endComercio;

    @Column(name = "bai_comercio", length = 30)
    private String baiComercio;

    @Column(name = "cep_comercio", length = 8)
    private String cepComercio;

    @Column(name = "cid_comercio", length = 40)
    private String cidComercio;

    @Column(name = "uf_comercio", length = 2)
    private String ufComercio;

    @Column(name = "con_comercio", length = 15)
    private String conComercio;

    @Column(name = "email_comercio", length = 15)
    private String emailComercio;

    @Column(name = "sen_comercio", length = 20)
    private String senComercio;

    public Comercio(){
    }

    public Comercio(Integer cnpjComercio, String razSocialComercio, String nomFantasiaComercio, String endComercio, String baiComercio, String cepComercio, String cidComercio, String ufComercio, String conComercio, String emailComercio, String senComercio){
        this.cnpjComercio = cnpjComercio;
        this.razSocialComercio = razSocialComercio;
        this.nomFantasiaComercio = nomFantasiaComercio;
        this.endComercio = endComercio;
        this.baiComercio = baiComercio;
        this.cepComercio = cepComercio;
        this.cidComercio = cidComercio;
        this.ufComercio = ufComercio;
        this.conComercio = conComercio;
        this.emailComercio = emailComercio;
        this.senComercio = senComercio;
    }

    public Integer getCnpjComercio() {
        return cnpjComercio;
    }
    public void setCnpjComercio(Integer cnpjComercio) {
        this.cnpjComercio = cnpjComercio;
    }

    public String getRazSocialComercio() {
        return razSocialComercio;
    }
    public void setRazSocialComercio(String razSocialComercio) {
        this.razSocialComercio = razSocialComercio;
    }

    public String getNomFantasiaComercio() {
        return nomFantasiaComercio;
    }
    public void setNomFantasiaComercio(String nomFantasiaComercio) {
        this.nomFantasiaComercio = nomFantasiaComercio;
    }

    public String getEndComercio() {
        return endComercio;
    }
    public void setEndComercio(String endComercio) {
        this.endComercio = endComercio;
    }

    public String getBaiComercio() {
        return baiComercio;
    }
    public void setBaiComercio(String baiComercio) {
        this.baiComercio = baiComercio;
    }

    public String getCepComercio() {
        return cepComercio;
    }
    public void setCepComercio(String cepComercio) {
        this.cepComercio = cepComercio;
    }

    public String getCidComercio() {
        return cidComercio;
    }
    public void setCidComercio(String cidComercio) {
        this.cidComercio = cidComercio;
    }

    public String getUfComercio() {
        return ufComercio;
    }
    public void setUfComercio(String ufComercio) {
        this.ufComercio = ufComercio;
    }

    public String getConComercio() {
        return conComercio;
    }
    public void setConComercio(String conComercio) {
        this.conComercio = conComercio;
    }

    public String getEmailComercio() {
        return emailComercio;
    }
    public void setEmailComercio(String emailComercio) {
        this.emailComercio = emailComercio;
    }

    public String getSenComercio() {
        return senComercio;
    }
    public void setSenComercio(String senComercio) {
        this.senComercio = senComercio;
    }
}

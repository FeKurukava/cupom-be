package com.cupons.models.comercio;

public class ComercioResponse {
    private String cnpjComercio;
    private String razSocialComercio;
    private String nomFantasiaComercio;
    private String cidComercio;
    private String ufComercio;

    public ComercioResponse() {
    }

    public String getCnpjComercio() {
        return cnpjComercio;
    }

    public void setCnpjComercio(String cnpjComercio) {
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
}

package com.cupons.models.comercio;

import jakarta.validation.constraints.*;

public class ComercioRequestBody {

    @NotBlank(message = "O CNPJ é obrigatório.")
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter 14 dígitos numéricos.")
    private String cnpjComercio;

    @NotNull(message = "A categoria do comércio é obrigatória.")
    private Integer idCategoria;

    @NotBlank(message = "A razão social é obrigatória.")
    @Size(max = 60)
    private String razSocialComercio;

    @NotBlank(message = "O nome fantasia é obrigatório.")
    @Size(max = 60)
    private String nomFantasiaComercio;

    @NotBlank(message = "O endereço é obrigatório.")
    @Size(max = 80)
    private String endComercio;

    @NotBlank(message = "O bairro é obrigatório.")
    @Size(max = 40)
    private String baiComercio;

    @NotBlank(message = "O CEP é obrigatório.")
    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos numéricos.")
    private String cepComercio;

    @NotBlank(message = "A cidade é obrigatória.")
    @Size(max = 40)
    private String cidComercio;

    @NotBlank(message = "A UF é obrigatória.")
    @Pattern(regexp = "^[A-Z]{2}$", message = "A UF deve ter duas letras maiúsculas.")
    private String ufComercio;

    @NotBlank(message = "O contato é obrigatório.")
    @Size(max = 15)
    private String conComercio;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    private String emailComercio;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
    private String senComercio;

    public String getCnpjComercio() {
        return cnpjComercio;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public String getRazSocialComercio() {
        return razSocialComercio;
    }

    public String getNomFantasiaComercio() {
        return nomFantasiaComercio;
    }

    public String getEndComercio() {
        return endComercio;
    }

    public String getBaiComercio() {
        return baiComercio;
    }

    public String getCepComercio() {
        return cepComercio;
    }

    public String getCidComercio() {
        return cidComercio;
    }

    public String getUfComercio() {
        return ufComercio;
    }

    public String getConComercio() {
        return conComercio;
    }

    public String getEmailComercio() {
        return emailComercio;
    }

    public String getSenComercio() {
        return senComercio;
    }

    public void setCnpjComercio(String cnpjComercio) {
        this.cnpjComercio = cnpjComercio;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setRazSocialComercio(@NotBlank(message = "A razão social é obrigatória.") @Size(max = 60) String razSocialComercio) {
        this.razSocialComercio = razSocialComercio;
    }

    public void setNomFantasiaComercio(@NotBlank(message = "O nome fantasia é obrigatório.") @Size(max = 60) String nomFantasiaComercio) {
        this.nomFantasiaComercio = nomFantasiaComercio;
    }

    public void setEndComercio(@NotBlank(message = "O endereço é obrigatório.") @Size(max = 80) String endComercio) {
        this.endComercio = endComercio;
    }

    public void setBaiComercio(@NotBlank(message = "O bairro é obrigatório.") @Size(max = 40) String baiComercio) {
        this.baiComercio = baiComercio;
    }

    public void setCepComercio(@NotBlank(message = "O CEP é obrigatório.") @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos numéricos.") String cepComercio) {
        this.cepComercio = cepComercio;
    }

    public void setCidComercio(@NotBlank(message = "A cidade é obrigatória.") @Size(max = 40) String cidComercio) {
        this.cidComercio = cidComercio;
    }

    public void setUfComercio(@NotBlank(message = "A UF é obrigatória.") @Pattern(regexp = "^[A-Z]{2}$", message = "A UF deve ter duas letras maiúsculas.") String ufComercio) {
        this.ufComercio = ufComercio;
    }

    public void setConComercio(@NotBlank(message = "O contato é obrigatório.") @Size(max = 15) String conComercio) {
        this.conComercio = conComercio;
    }

    public void setEmailComercio(@NotBlank(message = "O e-mail é obrigatório.") @Email(message = "E-mail inválido.") String emailComercio) {
        this.emailComercio = emailComercio;
    }

    public void setSenComercio(@NotBlank(message = "A senha é obrigatória.") @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.") String senComercio) {
        this.senComercio = senComercio;
    }
}

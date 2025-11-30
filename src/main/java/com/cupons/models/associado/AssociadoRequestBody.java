package com.cupons.models.associado;

import jakarta.validation.constraints.*;

import java.util.Date;

public class AssociadoRequestBody {

    @NotBlank(message = "O CPF é obrigatório.")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos numéricos.")
    private String cpfAssociado;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 40, message = "O nome pode ter no máximo 40 caracteres.")
    private String nomAssociado;

    @NotNull(message = "A data de nascimento é obrigatória.")
    private Date dtnAssociado;

    @NotBlank(message = "O endereço é obrigatório.")
    @Size(max = 40)
    private String endAssociado;

    @NotBlank(message = "O bairro é obrigatório.")
    @Size(max = 30)
    private String baiAssociado;

    @NotBlank(message = "O CEP é obrigatório.")
    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos numéricos.")
    private String cepAssociado;

    @NotBlank(message = "A cidade é obrigatória.")
    @Size(max = 40)
    private String cidAssociado;

    @NotBlank(message = "A UF é obrigatória.")
    @Pattern(regexp = "^[A-Z]{2}$", message = "A UF deve conter duas letras maiúsculas.")
    private String ufAssociado;

    @NotBlank(message = "O telefone é obrigatório.")
    @Size(max = 15)
    private String celAssociado;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    @Size(max = 50)
    private String emailAssociado;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
    private String senAssociado;

    public AssociadoRequestBody(){
    }
    public AssociadoRequestBody(String cpfAssociado, String nomAssociado, Date dtnAssociado, String endAssociado, String baiAssociado, String cepAssociado, String cidAssociado, String ufAssociado, String celAssociado, String emailAssociado, String senAssociado) {
        this.cpfAssociado = cpfAssociado;
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
    public String getCpfAssociado() {
        return cpfAssociado;
    }
    public void setCpfAssociado(String cpfAssociado) {
        this.cpfAssociado = cpfAssociado;
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


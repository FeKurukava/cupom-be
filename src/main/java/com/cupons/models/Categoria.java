package com.cupons.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nom_categoria", length = 25)
    private String nomeCategoria;

    public Categoria() {
    }

    public Categoria(Integer idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria){
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria(){
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria){
        this.nomeCategoria = nomeCategoria;
    }
}


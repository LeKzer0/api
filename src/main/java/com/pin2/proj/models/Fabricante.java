package com.pin2.proj.models;
import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "fabricante")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Size(min = 2, max = 32, message = "Fabricante deve ter entre 2 e 32 caracteres")
    @NotNull
    @Column(unique = true)
    private String nome;
    
    @Column(unique = true)
    @NotNull
    @CNPJ
    private String cnpj;
    
    private boolean ativo;

    public Fabricante() {
    }

    public Fabricante(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nome='" + getNome() + "'" +
                ", cnpj='" + getCnpj() + "'" +
                ", ativo='" + isAtivo() + "'" +
                "}";
    }

}

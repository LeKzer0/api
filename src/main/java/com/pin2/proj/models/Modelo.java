package com.pin2.proj.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 32, message = "Modelo deve ter entre 3 a 32v caracteres")
    @NotNull
    @Column(unique = true)
    private String nome;

    @Column(unique = true)
    private String imageuri;

    @ManyToOne
    private Fabricante fabricante;

    @ManyToOne
    private Tipo tipo;

    private boolean ativo;

    public Modelo() {
    }

    public Modelo(String nome) {
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

    public boolean isAtivo() {
        return this.ativo;
    }

    public boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getImageuri() {
        return this.imageuri;
    }

    public void setImageuri(String imageuri) {
        this.imageuri = imageuri;
    }

    public Fabricante getFabricante() {
        return this.fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nome='" + getNome() + "'" +
                ", imageuri='" + getImageuri() + "'" +
                ", fabricante='" + getFabricante().getNome() + "'" +
                ", tipo='" + getTipo().getNome() + "'" +
                ", ativo='" + isAtivo() + "'" +
                "}";
    }

}

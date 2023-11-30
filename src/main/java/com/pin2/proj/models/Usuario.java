package com.pin2.proj.models;

import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.websocket.OnError;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 8, max = 64, message = "Nome deve ter entre 8 a 64 caracteres")
    @NotNull
    private String nome;

    @Column(unique = true)
    @NotNull
    @CPF
    private String cpf;

    @Size(min = 4, max = 20, message = "Nome de usuário deve ter entre 4 a 20 caracteres")
    @NotNull
    @Column(unique = true)
    private String username;

    @Size(min = 6, max = 24, message = "Senha deve ter entre 6 a 24 caracteres")
    @NotNull
    private String pass;

    private boolean adm;

    private boolean ativo;

    Usuario() {
    }

    public Usuario(Long id, String nome, String cpf, String username, String pass, boolean adm, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.username = username;
        this.pass = pass;
        this.adm = adm;
        this.ativo = ativo;
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

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isAdm() {
        return this.adm;
    }

    public boolean getAdm() {
        return this.adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
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
        return "Usuario(" +
                " id='" + getId() + "'" +
                ", nome='" + getNome() + "'" +
                ", cpf='" + getCpf() + "'" +
                ", username='" + getUsername() + "'" +
                ", adm='" + isAdm() + "'" +
                ", ativo='" + isAtivo() + "'" +
                ")";
    }

}
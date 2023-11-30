package com.pin2.proj.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "situacao")
public class Situacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 4, max = 32, message = "Situacao deve ter entre 4 a 32 caracteres")
    @NotNull
    @Column(unique = true)
    private String nome;
    
    private boolean ativo;

    Situacao() {
    }

    public Situacao(String nome) {
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

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nome='" + getNome() + "'" +
                ", ativo='" + isAtivo() + "'" +
                "}";
    }
}

package com.pin2.proj.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "item", uniqueConstraints = @UniqueConstraint(columnNames = {
        "patrimonio" }, name = "patrimonio_constraint")

)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 24, message = "patrimonio deve ter no maximo 24 caracteres")
    private String patrimonio;

    @Size(max = 24)
    private String serial;

    @ManyToOne
    private Modelo modelo;

    @JsonManagedReference
    @OneToMany(mappedBy = "item", cascade = { CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REMOVE }, orphanRemoval = false)
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Historico> historicos;

    public Item() {
    }

    public Item(String patrimonio) {
        this.patrimonio = patrimonio;

    }

    public String getPatrimonio() {
        return this.patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Modelo getModelo() {
        return this.modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<Historico> getHistoricos() {

        Collections.reverse(historicos);
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +

                ", patrimonio='" + getPatrimonio() + "'" +
                ", serial='" + getSerial() + "'" +
                " modelo='" + getModelo() + "'" +
                "}";
    }

}

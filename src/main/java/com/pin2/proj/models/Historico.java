package com.pin2.proj.models;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "historico")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Setor setor;

    @JsonBackReference
    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    private Situacao situacao;

    private String observacao;

    private String dtAlteracao;

    private String local;

    Historico() {
    }

    public Historico(String observacao) {
        this.observacao = observacao;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Setor getSetor() {
        return this.setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Situacao getSituacao() {
        return this.situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public String getDtAlteracao() {
        return this.dtAlteracao;
    }

    public void setDtAlteracao(String dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", usuario='" + getUsuario().getNome() + "'" +
                ", setor='" + getSetor() + "'" +
                ", item='" + getItem() + "'" +
                ", situacao='" + getSituacao() + "'" +
                ", observacao='" + getObservacao() + "'" +
                ", dtAlteracao='" + getDtAlteracao() + "'" +
                ", local='" + getLocal() + "'" +
                "}";
    }

}

package com.pin2.proj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pin2.proj.models.Situacao;

public interface SituacaoRepository extends JpaRepository<Situacao, Long>{

    List <Situacao> findByNomeContainingIgnoreCase(String nome);
    
}

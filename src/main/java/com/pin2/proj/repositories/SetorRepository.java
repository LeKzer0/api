package com.pin2.proj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pin2.proj.models.Setor;


public interface SetorRepository extends JpaRepository<Setor, Long>{

    List <Setor> findByNomeContainingIgnoreCase(String nome);
    
}

package com.pin2.proj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pin2.proj.models.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long>{
    
    List <Tipo> findByNomeContainingIgnoreCase(String nome);
    
}

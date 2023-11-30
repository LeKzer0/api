package com.pin2.proj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pin2.proj.models.Fabricante;


public interface FabricanteRepository extends JpaRepository<Fabricante, Long>{

    @Query(value = "SELECT id, nome, cnpj, ativo from fabricante where nome ilike %:nome% and cnpj ilike %:cnpj%", nativeQuery = true)
    List <Fabricante> nomeCnpj(String nome, String cnpj);
}

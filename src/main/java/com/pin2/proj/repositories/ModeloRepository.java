package com.pin2.proj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pin2.proj.models.Modelo;
import com.pin2.proj.models.Usuario;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    List<Modelo> findByNomeContainingIgnoreCase(String nome);

    List<Modelo> findByFabricante_idAndTipo_id(Long fabricante_id, Long tipo_id);

}

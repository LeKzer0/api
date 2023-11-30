package com.pin2.proj.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import com.pin2.proj.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    

    @Query(value = "SELECT * from usuario where nome ilike %:nome% and cpf ilike %:cpf%", nativeQuery = true)
    List <Usuario> nomeCpf(String nome, String cpf);

    Optional<Usuario> findByUsername(String username);

    Usuario findByUsernameAndPass(String username, String pass);
    
}

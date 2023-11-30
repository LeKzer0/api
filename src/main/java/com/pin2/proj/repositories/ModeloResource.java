package com.pin2.proj.repositories;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;
import com.pin2.proj.models.Modelo;

@RestController
public class ModeloResource {

    private ModeloRepository repository;

    private ModeloResource(ModeloRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/modelos")
    public ResponseEntity<Modelo> createModelo(@Valid @RequestBody Modelo modelo) throws Exception {
        Modelo savedModelo = repository.save(modelo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(savedModelo.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/modelos")
    public List<Modelo> allUsers() {
        return repository.findAll();
    }

    @GetMapping("modelos/{id}")
    public Modelo getModelo(@PathVariable Long id) throws Exception {
        Optional<Modelo> modelo = repository.findById(id);
        if (modelo.isEmpty()) {
            throw new Exception("Erro: id do usuário não encontrado: " + id);
        }
        return modelo.get();
    }

    @GetMapping("modelos/nome/{nome}")
    public List<Modelo> getModelo(@PathVariable String nome) throws Exception {
        List<Modelo> modelos = repository.findByNomeContainingIgnoreCase(nome);

        if (modelos == null) {
            throw new Exception("Erro: situação não encontrado: " + nome);
        }
        return modelos;
    }

    @GetMapping("/modeloitem/{fabricante_id}&{tipo_id}")
    public List<Modelo> getModelo(@PathVariable Long fabricante_id, @PathVariable Long tipo_id) throws Exception {
        List<Modelo> modelos = repository.findByFabricante_idAndTipo_id(fabricante_id, tipo_id);

        if (modelos == null) {
            throw new Exception("Erro: modelo não encontrado");
        }
        return modelos;
    }

    @DeleteMapping("/modelos/{id}")
    public void deleteModelo(@PathVariable long id) {
        repository.deleteById(id);
    }

}

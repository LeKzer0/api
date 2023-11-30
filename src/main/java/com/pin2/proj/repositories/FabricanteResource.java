package com.pin2.proj.repositories;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;
import com.pin2.proj.exceptions.FabricanteNotFoundException;
import com.pin2.proj.models.Fabricante;

@RestController
public class FabricanteResource {

    private FabricanteRepository repository;

    private FabricanteResource(FabricanteRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/fabricantes")
    public ResponseEntity<Fabricante> createFabricante(@Valid @RequestBody Fabricante fabricante){
        Fabricante savedFabricante = repository.save(fabricante);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(savedFabricante.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/fabricantes")
    public List<Fabricante> allFabricantes() {
        return repository.findAll();
    }

    @GetMapping("fabricantes/{id}")
    public Fabricante getFabricante(@PathVariable Long id) {
        Fabricante fabricante = repository.findById(id)
        .orElseThrow(() -> new FabricanteNotFoundException(id));
        
        return fabricante;
    }

    @DeleteMapping("/fabricantes/{id}")
    public void deleteFabricante(@PathVariable long id) {
        repository.deleteById(id);
    }

    @GetMapping("/fabricantefind/{nome}&{cnpj}")
    List <Fabricante> getFabricante(@PathVariable String nome, @PathVariable String cnpj)  {
        List <Fabricante> fabricantes = repository.nomeCnpj(nome, cnpj);
       
        return fabricantes;
    }

}

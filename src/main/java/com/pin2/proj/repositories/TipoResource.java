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
import com.pin2.proj.models.Tipo;



@RestController
public class TipoResource {
    
    private TipoRepository repository;

    private TipoResource(TipoRepository repository){
        this.repository= repository;
    }
    
    @PostMapping("/tipos")
     public ResponseEntity<Tipo> createTipo(@Valid @RequestBody Tipo tipo) throws Exception{
        Tipo savedTipo = repository.save(tipo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/id").buildAndExpand(savedTipo.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/tipos")
    public List<Tipo> allUsers() {
        return repository.findAll();
    }

    @GetMapping("tipos/{id}")
    public Tipo getTipo(@PathVariable Long id) throws Exception {
        Optional<Tipo> tipo = repository.findById(id);
        if (tipo.isEmpty()) {
            throw new Exception("Erro: id do usuário não encontrado: " + id);
        }
        return tipo.get();
    }

     @GetMapping("tipos/nome/{nome}")
    public List <Tipo> getTipo(@PathVariable String nome) throws Exception {
        List <Tipo> tipos = repository.findByNomeContainingIgnoreCase(nome);
        
        if (tipos == null) {
            throw new Exception("Erro: situação não encontrado: " + nome);
        }
        return tipos;
    }

    @DeleteMapping("/tipos/{id}")
    public void deleteTipo(@PathVariable long id) {
        repository.deleteById(id);
    }

}

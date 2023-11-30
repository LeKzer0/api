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
import com.pin2.proj.models.Setor;

@RestController
public class SetorResource {
    
    private SetorRepository repository;

    private SetorResource(SetorRepository repository){
        this.repository= repository;
    }
    
    @PostMapping("/setores")
     public ResponseEntity<Setor> createSetor(@Valid @RequestBody Setor setor) throws Exception{
        Setor savedSetor = repository.save(setor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/id").buildAndExpand(savedSetor.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/setores")
    public List<Setor> allUsers() {
        return repository.findAll();
    }

    @GetMapping("setores/{id}")
    public Setor getSetor(@PathVariable Long id) throws Exception {
        Optional<Setor> setor = repository.findById(id);
        if (setor.isEmpty()) {
            throw new Exception("Erro: id do usuário não encontrado: " + id);
        }
        return setor.get();
    }

    @GetMapping("setores/nome/{nome}")
    public List <Setor> getSetor(@PathVariable String nome) throws Exception {
        List <Setor> setores = repository.findByNomeContainingIgnoreCase(nome);
        
        if (setores == null) {
            throw new Exception("Erro: situação não encontrado: " + nome);
        }
        return setores;
    }

    @DeleteMapping("/setores/{id}")
    public void deleteSetor(@PathVariable long id) {
        repository.deleteById(id);
    }

}

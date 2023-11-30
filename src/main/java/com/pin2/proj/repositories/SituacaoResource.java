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

import com.pin2.proj.models.Item;
import com.pin2.proj.models.Situacao;

@RestController
public class SituacaoResource {
    
    private SituacaoRepository repository;

    private SituacaoResource(SituacaoRepository repository){
        this.repository= repository;
    }
    
    @PostMapping("/situacoes")
     public ResponseEntity<Situacao> createSituacao(@Valid @RequestBody Situacao situacao) throws Exception {
        Situacao savedSituacao = repository.save(situacao);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/id").buildAndExpand(savedSituacao.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/situacoes")
    public List<Situacao> allUsers() {
        return repository.findAll();
    }

    @GetMapping("situacoes/{id}")
    public Situacao getSituacao(@PathVariable Long id) throws Exception {
        Optional<Situacao> situacao = repository.findById(id);
        if (situacao.isEmpty()) {
            throw new Exception("Erro: id do usuário não encontrado: " + id);
        }
        return situacao.get();
    }

    @GetMapping("situacoes/nome/{nome}")
    public List <Situacao> getSituacao(@PathVariable String nome) throws Exception {
        List <Situacao> situacoes = repository.findByNomeContainingIgnoreCase(nome);
        if (situacoes == null) {
            throw new Exception("Erro: situação não encontrado: " + nome);
        }
        return situacoes;
    }

    @DeleteMapping("/situacoes/{id}")
    public void deleteSituacao(@PathVariable long id) {
        repository.deleteById(id);
    }

}

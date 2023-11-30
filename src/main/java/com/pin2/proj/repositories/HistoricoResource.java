package com.pin2.proj.repositories;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;
import com.pin2.proj.models.Historico;
import com.pin2.proj.models.Usuario;

@RestController
public class HistoricoResource {

    private HistoricoRepository repository;

    private HistoricoResource(HistoricoRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/historicos")
    public ResponseEntity<Historico> createHistorico(@Valid @RequestBody Historico historico) throws Exception {
        Historico savedHistorico = repository.save(historico);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(savedHistorico.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/historicos")
    public List<Historico> allUsers() {
        return repository.findAll();
    }

    @GetMapping("historicos/{id}")
    public Historico getHistorico(@PathVariable Long id) throws Exception {
        Optional<Historico> historico = repository.findById(id);
        if (historico.isEmpty()) {
            throw new Exception("Erro: id do usuário não encontrado: " + id);
        }
        return historico.get();
    }

    @GetMapping("historicos/item/{item_id}")
    public List<Historico> getHistoricoItem(@PathVariable Long item_id) throws Exception {

        List<Historico> historicos = repository.findByItem_id(item_id);
        if (historicos.isEmpty()) {
            throw new Exception("Erro: id do usuário não encontrado: " + item_id);
        }
        return historicos;
    }

    @DeleteMapping("/historicos/{id}")
    public void deleteHistorico(@PathVariable long id) {
        repository.deleteById(id);
    }

    @GetMapping("historicos/setsit/{setor_id}&{situacao_id}")
    List<Historico> getHistoricos(@PathVariable long setor_id, @PathVariable Long situacao_id) throws Exception {
        List<Historico> historicos = repository.findBySetor_idAndSituacao_id(setor_id, situacao_id);

        if (historicos == null) {
            throw new Exception("Erro: historico não encontrado: ");
        }

        return historicos;
    }

}

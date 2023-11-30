package com.pin2.proj.repositories;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import com.pin2.proj.exceptions.ItemAlreadyExistsException;
import com.pin2.proj.exceptions.ItemNotFoundException;
import com.pin2.proj.models.Historico;
import com.pin2.proj.models.Item;
import com.pin2.proj.models.Situacao;

@RestController
public class ItemResource {

    private ItemRepository repository;

    private HistoricoRepository historicoRepository;

    public ItemResource(ItemRepository repository, HistoricoRepository historicoRepository) {
        this.repository = repository;
        this.historicoRepository = historicoRepository;
    }

    @PostMapping("/itens")
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) throws Exception{
        URI location = null;
        try {
            Item savedItem = repository.save(item);
            location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/id").buildAndExpand(savedItem.getPatrimonio()).toUri();
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("patrimonio_constraint")) {
                throw new ItemAlreadyExistsException(item.getPatrimonio());
            }
        }finally{}
        
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/itens")
    public ResponseEntity<Item> updateItem(@PathVariable long id, @RequestBody Item item) {
        Item updateItem = repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
        updateItem.setSerial(item.getSerial());
        updateItem.setModelo(item.getModelo());
        updateItem.setHistoricos(item.getHistoricos());
        repository.save(item);

        return ResponseEntity.ok(updateItem);

    }

    @GetMapping("/itens")
    public List<Item> allUsers() {
        return repository.findAll();
    }

    @GetMapping("itens/{id}")
    public Item getItem(@PathVariable Long id) throws Exception {
        Optional<Item> item = repository.findById(id);
        if (item.isEmpty()) {
            throw new Exception("Erro: id do itemo não encontrado: " + id);
        }
        return item.get();
    }

    @GetMapping("itens/patrimonio/{patrimonio}")
    public List<Item> getItem(@PathVariable String patrimonio) throws Exception {
        List<Item> itens = repository.findByPatrimonioContainingIgnoreCase(patrimonio);
        if (itens == null) {
            throw new Exception("Erro: patrimonio não encontrado: " + patrimonio);
        }
        return itens;
    }

    @GetMapping("/itens/relatorio/{patrimonio}&{fabricante_id}&{tipo_id}&{modelo_id}&{setor_id}&{situacao_id}")
    public List<Item> getItem(@PathVariable String patrimonio, @PathVariable Long fabricante_id,
            @PathVariable Long tipo_id,
            @PathVariable Long modelo_id, @PathVariable Long setor_id, @PathVariable Long situacao_id)
            throws Exception {
        List<Item> itens = repository.itemRelatorio(patrimonio, fabricante_id, tipo_id, modelo_id, setor_id,
                situacao_id);
        if (itens == null) {
            throw new Exception("Erro: patrimonio não encontrado: " + patrimonio);
        }
        return itens;
    }

    @DeleteMapping("/itens/{id}")
    public void deleteItem(@PathVariable long id) {
        repository.deleteById(id);
    }

}

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
import com.pin2.proj.models.Usuario;


@RestController
public class UsuarioResource {

    private UsuarioRepository repository;

    private UsuarioResource(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario) throws Exception{
        
        Usuario savedUsuario = repository.save(usuario);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(savedUsuario.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/usuarios")
    public List<Usuario> allUsers() {
        return repository.findAll();
    }

    @GetMapping("usuarios/{id}")
    public Usuario getUsuario(@PathVariable Long id) throws Exception {
        Optional<Usuario> usuario = repository.findById(id);
        if (usuario.isEmpty()) {
            throw new Exception("Erro: id do usuário não encontrado: " + id);
        }
        return usuario.get();
    }

    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable long id) {
        repository.deleteById(id);
    }

    @PostMapping("/autenticar")
    public Usuario autenticar(@RequestBody Usuario usuarioAuth) {
        Usuario usuario = repository.findByUsernameAndPass(usuarioAuth.getUsername(), usuarioAuth.getPass());
       
        usuario.setPass(null);
            
       
       return usuario;
    }

    @GetMapping("/usuariofind/{nome}&{cpf}")
    List <Usuario> getUsuario(@PathVariable String nome, @PathVariable String cpf) throws Exception {
        List <Usuario> usuarios = repository.nomeCpf(nome, cpf);
       
        if (usuarios == null) {
            throw new Exception("Erro: usuário não encontrado: " + nome);
        }
        return usuarios;
    }
}

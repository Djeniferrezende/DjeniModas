package com.djeniModas.Modas.Resource;

import com.djeniModas.Modas.model.Usuario;
import com.djeniModas.Modas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UsuarioResource {

    @Autowired
    UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
    List<Usuario> user = service.findAll();
    return ResponseEntity.ok().body(user);
}
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario user = service.finById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario){
        usuario = service.insert(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        usuario = service.update(id, usuario);
        return ResponseEntity.ok().body(usuario);
    }


}

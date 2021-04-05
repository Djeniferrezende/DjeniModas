package com.djeniModas.Modas.Resource;

import com.djeniModas.Modas.model.Usuario;
import com.djeniModas.Modas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

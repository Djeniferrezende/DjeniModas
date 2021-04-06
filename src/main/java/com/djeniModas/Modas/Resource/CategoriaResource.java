package com.djeniModas.Modas.Resource;

import com.djeniModas.Modas.model.Categoria;
import com.djeniModas.Modas.model.Pedido;
import com.djeniModas.Modas.service.CategoriaService;
import com.djeniModas.Modas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {

    @Autowired
    CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
    List<Categoria> categoria = service.findAll();
    return ResponseEntity.ok().body(categoria);
}
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria categoria = service.finById(id);
        return ResponseEntity.ok().body(categoria);
    }


}

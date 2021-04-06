package com.djeniModas.Modas.Resource;

import com.djeniModas.Modas.model.Categoria;
import com.djeniModas.Modas.model.Produto;
import com.djeniModas.Modas.service.CategoriaService;
import com.djeniModas.Modas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
    List<Produto> produto = service.findAll();
    return ResponseEntity.ok().body(produto);
}
    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto produto = service.finById(id);
        return ResponseEntity.ok().body(produto);
    }


}

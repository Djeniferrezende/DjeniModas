package com.djeniModas.Modas.Resource;

import com.djeniModas.Modas.model.Categoria;
import com.djeniModas.Modas.model.Pedido;
import com.djeniModas.Modas.service.CategoriaService;
import com.djeniModas.Modas.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    //implementação de logs
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaResource.class);

    @Autowired
    CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
    List<Categoria> categoria = service.findAll();
    LOGGER.info("busca de categoria finalizada");
    return ResponseEntity.ok().body(categoria);
}
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria categoria = service.finById(id);
        LOGGER.info("busca por categoria  popr id finalizada");
        return ResponseEntity.ok().body(categoria);
    }


}

package com.djeniModas.Modas.Resource;

import com.djeniModas.Modas.model.Pedido;
import com.djeniModas.Modas.model.Usuario;
import com.djeniModas.Modas.service.PedidoService;
import com.djeniModas.Modas.service.UsuarioService;
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
@RequestMapping(value = "/pedido")
public class PedidoResource {

    //implementação de logs
    private static final Logger LOGGER = LoggerFactory.getLogger(PedidoResource.class);

    @Autowired
    PedidoService service;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
    List<Pedido> pedido = service.findAll();
    LOGGER.info("lista de pedidos finalizada");
    return ResponseEntity.ok().body(pedido);
}
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Pedido pedido = service.finById(id);
        LOGGER.info("lista de pedidos por id finalizada");
        return ResponseEntity.ok().body(pedido);
    }


}

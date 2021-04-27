package com.djeniModas.Modas.service;

import com.djeniModas.Modas.Resource.ProdutoResource;
import com.djeniModas.Modas.model.Pedido;
import com.djeniModas.Modas.model.Usuario;
import com.djeniModas.Modas.repository.PedidoRepository;
import com.djeniModas.Modas.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    //implementação de logs
    private static final Logger LOGGER = LoggerFactory.getLogger(PedidoService.class);

    @Autowired
    PedidoRepository repository;


    public List<Pedido> findAll(){
        LOGGER.info("Buscando todos os pedidos");
        return repository.findAll();
    }

    public Pedido finById(Long id){
        LOGGER.info("Buscando pedido por id");
        Optional<Pedido> user = repository.findById(id);
       return user.get();

    }


}

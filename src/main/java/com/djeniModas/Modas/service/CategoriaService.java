package com.djeniModas.Modas.service;

import com.djeniModas.Modas.Resource.PedidoResource;
import com.djeniModas.Modas.model.Categoria;
import com.djeniModas.Modas.model.Pedido;
import com.djeniModas.Modas.repository.CategoriaRepository;
import com.djeniModas.Modas.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    //implementação de logs
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaService.class);

    @Autowired
    CategoriaRepository repository;


    public List<Categoria> findAll(){
        LOGGER.info("busca por todas categorias");
        return repository.findAll();
    }

    public Categoria finById(Long id){
        LOGGER.info("pesquisando categoria por id");
        Optional<Categoria> cat = repository.findById(id);
       return cat.get();

    }


}

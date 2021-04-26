package com.djeniModas.Modas.service;

import com.djeniModas.Modas.model.Categoria;
import com.djeniModas.Modas.model.Produto;
import com.djeniModas.Modas.repository.CategoriaRepository;
import com.djeniModas.Modas.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    //implementação de logs
    private static final Logger LOGGER = LoggerFactory.getLogger(ProdutoService.class);


    @Autowired
    ProdutoRepository repository;


    public List<Produto> findAll(){
        LOGGER.info("listando produtos");
        return repository.findAll();
    }

    public Produto finById(Long id){
        Optional<Produto> cat = repository.findById(id);
        LOGGER.info("bucando produtos por id");
       return cat.get();

    }


}

package com.djeniModas.Modas.service;

import com.djeniModas.Modas.model.Categoria;
import com.djeniModas.Modas.model.Produto;
import com.djeniModas.Modas.repository.CategoriaRepository;
import com.djeniModas.Modas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;


    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto finById(Long id){
        Optional<Produto> cat = repository.findById(id);
       return cat.get();

    }


}

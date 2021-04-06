package com.djeniModas.Modas.service;

import com.djeniModas.Modas.model.Categoria;
import com.djeniModas.Modas.model.Pedido;
import com.djeniModas.Modas.repository.CategoriaRepository;
import com.djeniModas.Modas.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;


    public List<Categoria> findAll(){

        return repository.findAll();
    }

    public Categoria finById(Long id){
        Optional<Categoria> cat = repository.findById(id);
       return cat.get();

    }


}

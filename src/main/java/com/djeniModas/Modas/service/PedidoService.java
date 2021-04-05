package com.djeniModas.Modas.service;

import com.djeniModas.Modas.model.Pedido;
import com.djeniModas.Modas.model.Usuario;
import com.djeniModas.Modas.repository.PedidoRepository;
import com.djeniModas.Modas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;


    public List<Pedido> findAll(){
        return repository.findAll();
    }

    public Pedido finById(Long id){
        Optional<Pedido> user = repository.findById(id);
       return user.get();

    }


}

package com.djeniModas.Modas.service;

import com.djeniModas.Modas.model.Usuario;
import com.djeniModas.Modas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;


    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario finById(Long id){
        Optional<Usuario> user = repository.findById(id);
       return user.get();

    }


}

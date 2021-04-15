package com.djeniModas.Modas.service;

import com.djeniModas.Modas.model.Usuario;
import com.djeniModas.Modas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    //add novo usuario
    public Usuario insert(Usuario usuario){
        return repository.save(usuario);
    }

    //excluir usuario
    public void deletar(Long id){
         repository.deleteById(id);
    }

    public Usuario update(Long id, Usuario user){
        //getone faz não ir direto pro banco de dados
        Usuario obj = repository.getOne(id);
        updateData(obj,user);
        return repository.save(obj);
    }
    //sao os 3 dados que eu posso alterar na atualização
    private void updateData(Usuario obj, Usuario user) {
        obj.setNome(user.getNome());
        obj.setEmail(user.getEmail());
        obj.setTelefone(user.getTelefone());
    }


}

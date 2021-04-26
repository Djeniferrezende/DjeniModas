package com.djeniModas.Modas.service;

import com.djeniModas.Modas.ModasApplication;
import com.djeniModas.Modas.model.Usuario;
import com.djeniModas.Modas.repository.UsuarioRepository;
import com.djeniModas.Modas.service.exceptions.DatabaseException;
import com.djeniModas.Modas.service.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    //implementação de logs
    private static final Logger LOGGER = LoggerFactory.getLogger( UsuarioService.class);

    @Autowired
    UsuarioRepository repository;


    public List<Usuario> findAll(){
        return repository.findAll();
    }


    //busca todos os usuarios
    public Usuario finById(Long id){
        try{
            LOGGER.info("bucando todos usuarios");
            Optional<Usuario> user = repository.findById(id);
            return user.orElseThrow(()-> new ResourceNotFoundException(id));
        }catch (RuntimeException e ){
            throw new RuntimeException(e);
        }


    }

    //add novo usuario
    public Usuario insert(Usuario usuario){
        LOGGER.info("criando novo usuario");
        return repository.save(usuario);
    }

    //excluir usuario
    public void deletar(Long id){
        try{
            LOGGER.info("Usuario Deletado");
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            LOGGER.error("erro ao deletar usuario - EmptyResultDataAccessException");
            throw new ResourceNotFoundException(e);
        }catch (DataIntegrityViolationException e ){
            LOGGER.error("erro ao deletar usuario - DataIntegrityViolationException");
            throw new DatabaseException(e.getMessage());
        }
    }

    public Usuario update(Long id, Usuario user){
        //getone faz não ir direto pro banco de dados
       try {
           Usuario obj = repository.getOne(id);
           updateData(obj, user);
           return repository.save(obj);
       }catch (EntityNotFoundException e){
           throw new ResourceNotFoundException(e);

       }
    }
    //sao os 3 dados que eu posso alterar na atualização
    private void updateData(Usuario obj, Usuario user) {
        obj.setNome(user.getNome());
        obj.setEmail(user.getEmail());
        obj.setTelefone(user.getTelefone());
    }


}

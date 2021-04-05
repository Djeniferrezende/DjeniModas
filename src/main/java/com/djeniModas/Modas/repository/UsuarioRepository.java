package com.djeniModas.Modas.repository;

import com.djeniModas.Modas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

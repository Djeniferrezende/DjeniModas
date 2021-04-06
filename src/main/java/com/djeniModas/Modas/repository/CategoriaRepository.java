package com.djeniModas.Modas.repository;

import com.djeniModas.Modas.model.Categoria;
import com.djeniModas.Modas.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

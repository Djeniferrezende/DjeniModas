package com.djeniModas.Modas.repository;

import com.djeniModas.Modas.model.Categoria;
import com.djeniModas.Modas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

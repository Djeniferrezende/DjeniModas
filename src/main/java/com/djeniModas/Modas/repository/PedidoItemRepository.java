package com.djeniModas.Modas.repository;

import com.djeniModas.Modas.model.Categoria;
import com.djeniModas.Modas.model.PedidoItem;
import com.djeniModas.Modas.model.Pk.PedidoItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
}

package com.djeniModas.Modas.model.Pk;

import com.djeniModas.Modas.model.Pedido;
import com.djeniModas.Modas.model.Produto;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PedidoItemPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "Produto_id")
    private Produto produto;


    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoItemPk that = (PedidoItemPk) o;
        return pedido.equals(that.pedido) &&
                produto.equals(that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido, produto);
    }
}

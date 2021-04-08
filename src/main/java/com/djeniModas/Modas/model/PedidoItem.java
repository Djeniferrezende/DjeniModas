package com.djeniModas.Modas.model;

import com.djeniModas.Modas.model.Pk.PedidoItemPk;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PedidoItem  {

    @EmbeddedId
    private PedidoItemPk id;

    private int quantidade;

    private Double preco;

    public PedidoItem(){

    }

    public PedidoItem(Pedido pedido, Produto produto, int quantidade, Double preco) {
        this.quantidade = quantidade;
        id.setPedido(pedido);
        id.setProduto(produto);
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido(){
        return id.getPedido();
    }

    public void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}

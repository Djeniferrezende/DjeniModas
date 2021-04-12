package com.djeniModas.Modas.model;

import com.djeniModas.Modas.model.Pk.PedidoItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class PedidoItem  {

    @EmbeddedId
    private PedidoItemPk id = new PedidoItemPk();

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
    @JsonIgnore
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoItem that = (PedidoItem) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

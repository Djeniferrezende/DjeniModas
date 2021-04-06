package com.djeniModas.Modas.model;

import com.djeniModas.Modas.model.emum.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant momento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    private Integer pedidoStatus;

    public Pedido(){

    }

    public Pedido(Long id, Instant momento, Usuario cliente, PedidoStatus pedidoStatus) {
        Id = id;
        this.momento = momento;
        this.cliente = cliente;
        setPedidoStatus(pedidoStatus);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public PedidoStatus getPedidoStatus() throws IllegalAccessException {
        return PedidoStatus.valueOf(pedidoStatus);
    }
    //tenho um pedido status porem preciso guardar como inteiro
    //validar se o codigo é nulo
    public void setPedidoStatus(PedidoStatus pedidoStatus) {
        if(pedidoStatus != null) {
            this.pedidoStatus = pedidoStatus.getCodigo();
        }
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Id.equals(pedido.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

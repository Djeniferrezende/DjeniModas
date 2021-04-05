package com.djeniModas.Modas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Instant momento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    public Pedido(){

    }

    public Pedido(Long id, Instant momento, Usuario cliente) {
        Id = id;
        this.momento = momento;
        this.cliente = cliente;
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

package com.djeniModas.Modas.model.emum;

public enum PedidoStatus {
    AGUARDADO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int codigo;

    private PedidoStatus(int codigo){
        this.codigo = codigo;
    }

    //para ficar visivel
    public int getCodigo(){
        return codigo;
    }

    //para metodo statico transformando o Pedido status em inteiro

    public static PedidoStatus valueOf(int codigo) throws IllegalAccessException {
        for(PedidoStatus order : PedidoStatus.values()){
            if(order.getCodigo() == codigo){
                return order;
            }
        }
        throw new IllegalAccessException("codigo invalido");
    }




}

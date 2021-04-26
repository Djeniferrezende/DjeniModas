package com.djeniModas.Modas.config;


import com.djeniModas.Modas.model.*;
import com.djeniModas.Modas.model.emum.PedidoStatus;
import com.djeniModas.Modas.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    UsuarioRepository Usuariorepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PedidoItemRepository pedidoItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new  Categoria (null, "Electronics");
        Categoria  cat2 = new  Categoria (null, "Books");
        Categoria  cat3 = new  Categoria (null, "Computers");

        Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        p1.getCategoriaSet().add(cat2);
        p2.getCategoriaSet().add(cat1);
        p2.getCategoriaSet().add(cat3);
        p3.getCategoriaSet().add(cat3);
        p4.getCategoriaSet().add(cat3);
        p4.getCategoriaSet().add(cat2);

        produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));


        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");


        Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, PedidoStatus.PAGO);
        Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2,PedidoStatus.AGUARDADO_PAGAMENTO);
        Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1, PedidoStatus.AGUARDADO_PAGAMENTO);



        Usuariorepository.saveAll(Arrays.asList(u1,u2));
       pedidoRepository.saveAll(Arrays.asList(o1,o2,o3));

        PedidoItem oi1 = new PedidoItem(o1, p1, 2, p1.getPreco());
        PedidoItem oi2 = new PedidoItem(o1, p3, 1, p3.getPreco());
        PedidoItem oi3 = new  PedidoItem(o2, p3, 2, p3.getPreco());
        PedidoItem oi4 = new  PedidoItem(o3, p5, 2, p5.getPreco());

      pedidoItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

      Pagamento pag1 = new Pagamento(null,Instant.parse("2019-06-20T21:53:07Z"),o1 );

      o1.setPagamento(pag1);

      pedidoRepository.save(o1);



    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.entity.Mesa;
import com.example.demo.entity.Pedidos;
import com.example.demo.entity.Usuario;
import com.example.demo.model.cliente.MUsuarioCliente;
import com.example.demo.model.mesa.MMesaRegistro;
import com.example.demo.model.pedidos.MPedidoRegistro;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 *
 * @author User
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IPedidoDaoTest {
    @Autowired
    private IPedidosDao pedidoDao;
    
    @Test
    void testGuardarEmpleado(){
        //given - dado o condición previo o configuración
        MPedidoRegistro mPedido = new MPedidoRegistro(1l, 1);
        MMesaRegistro mMesa = new MMesaRegistro(1, 4);
        Pedidos pedido = new Pedidos(mPedido,new Mesa(mMesa));
        
        //when - accion o el comportamiento que vamos a probar
        Pedidos pedidoGuardado = pedidoDao.save(pedido);
        //then - verificar la salida
        assertThat(pedidoGuardado).isNotNull();
        assertThat(pedidoGuardado.getPedidosId()).isGreaterThan(1);
        assertThat(pedidoGuardado).isEqualTo(pedido);
    }
}

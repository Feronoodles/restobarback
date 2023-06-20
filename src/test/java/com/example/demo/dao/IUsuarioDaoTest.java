/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.entity.Usuario;
import com.example.demo.model.cliente.MUsuarioCliente;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
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
public class IUsuarioDaoTest {
    @Autowired
    private IUsuarioDao usuarioDao;
    
    @Test
    void testGuardarEmpleado(){
        //given - dado o condición previo o configuración
        
        MUsuarioCliente cliente = new MUsuarioCliente("arges 127", null, "fernando urlich", "ferourlich@gmail.com", "Facil123", "sad", "sadas", 2l);
        Usuario usuario = new Usuario(cliente);
        System.out.println("llega aqui?");
        //when - accion o el comportamiento que vamos a probar
        Usuario usuarioGuardado = usuarioDao.save(usuario);
        //then - verificar la salida
        assertThat(usuarioGuardado).isNotNull();
        assertThat(usuarioGuardado.getid()).isGreaterThan(1);
        assertThat(usuarioGuardado).isEqualTo(usuario);
    }
}

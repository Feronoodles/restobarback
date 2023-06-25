/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.entity.TipoUsuario;
import com.example.demo.entity.Usuario;
import com.example.demo.model.cliente.MUsuarioCliente;
import com.example.demo.model.tipo_usuario.MTipoUsuarioRegistro;
import com.example.demo.model.tipo_usuario.MTipoUsuarioVista;
import java.util.List;
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
public class ITipoUsuarioDaoTest {
     @Autowired
    private ITipoUsuarioDao tipoUsuarioDao;
    
    @Test
    void testGuardarEmpleado(){
        //given - dado o condición previo o configuración
        MTipoUsuarioRegistro usuarioRegistro = new MTipoUsuarioRegistro("trabajador");
        TipoUsuario tipoUsuario = new TipoUsuario(usuarioRegistro);
        
        //when - accion o el comportamiento que vamos a probar
        TipoUsuario tipoUsuarioGuardado = tipoUsuarioDao.save(tipoUsuario);
       // List<MTipoUsuarioVista> tipoUsuarioVista = tipoUsuarioDao.findDetails();
       // System.out.println(tipoUsuarioVista);
        //then - verificar la salida
      //  assertThat(tipoUsuarioVista).isNotNull();
        assertThat(tipoUsuarioGuardado).isEqualTo(tipoUsuario);
       
        
    }
}

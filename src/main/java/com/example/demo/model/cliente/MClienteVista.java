/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.cliente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.TipoUsuario;
import com.example.demo.model.tipo_usuario.MTipoUsuarioVista;

import java.util.Date;
/**
 *
 * @author User
 */
public record MClienteVista(
         Long idCliente,
         String direccion,
         String telefono,
         String name,
        
         Long idUsuario,
         String correo,
         int activo,
         MTipoUsuarioVista tipoUsuario
        ) {
    public MClienteVista(Cliente cliente){
        this(cliente.getClienteId(),cliente.getDireccion(),cliente.getTelefono(),cliente.getName(),cliente.getUsuario().getid(),cliente.getUsuario().getCorreo(),cliente.getUsuario().getActivo()
        , new MTipoUsuarioVista(cliente.getUsuario().getTipoUsuario()));
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.cliente;
import com.example.demo.entity.Cliente;
import java.util.Date;
/**
 *
 * @author User
 */
public record MClienteVista(
         Long idCliente,
         String direccion,
         Date fechaNacimiento,
         String name,
        
         Long idUsuario,
         String correo,
         int activo,
         Long tipoUsuarioId
        ) {
    public MClienteVista(Cliente cliente){
        this(cliente.getClienteId(),cliente.getDireccion(),cliente.getFechaNacimiento(),cliente.getName(),cliente.getUsuario().getid(),cliente.getUsuario().getCorreo(),cliente.getUsuario().getActivo()
        , cliente.getUsuario().getTipoUsuarioId());
    }
    
}

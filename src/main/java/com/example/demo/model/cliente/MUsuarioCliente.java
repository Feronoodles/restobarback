/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.cliente;

import com.example.demo.entity.Usuario;
import com.example.demo.entity.Cliente;
import java.util.Date;

/**
 *
 * @author User
 */
public record MUsuarioCliente(
        
        String direccion,
         Date fechaNacimiento,
         String name,
        
         String correo,
         String contraseña,
         int activo,
         String token,
         String tokenCelular,
         Long tipoUsuarioId) {
        

        
   
    
}

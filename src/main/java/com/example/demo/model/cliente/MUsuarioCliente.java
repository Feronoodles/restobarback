/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.cliente;

import com.example.demo.entity.TipoUsuario;
import com.example.demo.entity.Usuario;
import com.example.demo.entity.Cliente;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
public record MUsuarioCliente(

        String direccion,
        @NotNull
        String telefono,
        @NotBlank 
        String name,
        @NotBlank
        @Email
        String correo,
        @NotBlank 
        String contraseña,
        @NotBlank 
        String token,
        String tokenCelular
     ) {
        

        
   
    
}

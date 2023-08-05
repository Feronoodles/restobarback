/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.trabajador;
import com.example.demo.entity.TipoUsuario;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
/**
 *
 * @author User
 */
public record MUsuarioTrabajador(
        @NotBlank
        String nombre,
        @NotBlank
        String direccion,
        @NotNull
        Date fechaNacimiento,
        @NotNull
        Date fechaInicioTrabajo,
        @NotNull
        double salario,
        @NotNull
        Long tipoTrabajadorId,
        
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

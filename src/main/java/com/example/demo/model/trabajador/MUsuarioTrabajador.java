/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.trabajador;
import java.util.Date;
/**
 *
 * @author User
 */
public record MUsuarioTrabajador(
        String nombre,
        String direccion,
        Date fechaNacimiento,
        Date fechaInicioTrabajo,
        double salario,
        Long tipoTrabajadorId,
        
        String correo,
        String contraseña,
        int activo,
        String token,
        String tokenCelular,
        Long tipoUsuarioId
        ) {
    
}

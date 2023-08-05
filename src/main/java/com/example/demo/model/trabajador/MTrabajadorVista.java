/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.trabajador;

import com.example.demo.entity.TipoUsuario;
import com.example.demo.entity.Trabajador;
import com.example.demo.entity.Usuario;
import com.example.demo.model.tipo_usuario.MTipoUsuarioVista;

import java.util.Date;

/**
 *
 * @author User
 */
public record MTrabajadorVista(
        Long trabajadorId,
        String nombre,
        String direccion,
        Date fechaNacimiento,
        Date fechaInicioTrabajo,
        double salario,
        Long tipoTrabajadorId,
        
        Long usuarioId,
        String correo,
        int activo,
        MTipoUsuarioVista tipoUsuario
        ) {
    public MTrabajadorVista(Trabajador trabajador){
        this(trabajador.getTrabajadorId(), trabajador.getNombre(),trabajador.getDireccion(),trabajador.getFechaNacimiento(),trabajador.getFechaInicioTrabajo(),trabajador.getSalario(),
        trabajador.getTipoTrabajadorId(), trabajador.getUsuario().getid(),trabajador.getUsuario().getCorreo(), trabajador.getUsuario().getActivo(),new MTipoUsuarioVista(trabajador.getUsuario().getTipoUsuario()));
        
    }
}

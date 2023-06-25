/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.example.demo.model.tipo_usuario;

import com.example.demo.entity.TipoUsuario;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
public record MTipoUsuarioVista(
        
        Long tipoUsuarioId,
        
        String nombre
        ) {
    public MTipoUsuarioVista(TipoUsuario tipoUsuario)
    {
        this(tipoUsuario.getTipoUsuarioId(),tipoUsuario.getNombre());
    }
    
    
}

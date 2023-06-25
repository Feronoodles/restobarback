/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.example.demo.model.tipo_trabajador;

import com.example.demo.entity.TipoTrabajador;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
public record MTipoTrabajadorVista(
       
        Long tipoTrabajadorId,
       
        String nombre
        
        ) {
    public MTipoTrabajadorVista(TipoTrabajador tipoTrabajador)
    {
        this(tipoTrabajador.getTipoTrabajadorId(),tipoTrabajador.getNombre());
    }
}

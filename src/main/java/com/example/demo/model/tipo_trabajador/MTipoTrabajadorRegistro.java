/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.example.demo.model.tipo_trabajador;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author User
 */
public record MTipoTrabajadorRegistro(
        @NotBlank
        String nombre
        ) {

}

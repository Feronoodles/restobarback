/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.example.demo.model.mesa;

import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
public record MMesaRegistro(
        @NotNull
        int numeroMesa,
        @NotNull
        int sillas
        ) {

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.platos;

import com.example.demo.entity.Platos;

/**
 *
 * @author User
 */
public record MPlatosVista(
        Long platoId,
        String nombre,
        double precio
        ) {
    public MPlatosVista(Platos plato)
    {
        this(plato.getPlatosId(),plato.getNombre(),plato.getPrecio());
    }
}

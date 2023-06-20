/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.mesa;

import com.example.demo.entity.Mesa;

/**
 *
 * @author User
 */
public record MMesaVista(
        Long mesaId,
        int numeroMesa,
        int sillas,
        boolean activo
        ) {
    public MMesaVista(Mesa mesa)
    {
        this(mesa.getMesaId(),mesa.getNumero(),mesa.getSillas(),mesa.isActivo());
    }
}

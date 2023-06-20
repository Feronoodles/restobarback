/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.example.demo.model.pedidos;

/**
 *
 * @author User
 */
public record MPedidoActualizar(
        Long pedidoId,
        Long usuarioId,
        double gastoTotal,
        int numeroMesa
        ) {

}

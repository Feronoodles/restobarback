/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.pedidos_detalle;

import com.example.demo.entity.Bebidas;
import com.example.demo.entity.PedidoDetalle;
import com.example.demo.entity.Platos;
import com.example.demo.model.bebidas.MBebidasVista;
import com.example.demo.model.platos.MPlatosVista;

/**
 *
 * @author User
 */
public record MPedidoDetalleVista(
       Long pedidoDetalleId,
       MPlatosVista platos,
       int cantidadPlatos,
       MBebidasVista bebidas,
       int cantidadBebidas,
       Long pedidoId
        ) {
    public MPedidoDetalleVista(PedidoDetalle pedidoDetalle)
    {
        this(pedidoDetalle.getPedidoDetalleId(),new MPlatosVista(pedidoDetalle.getPlato()),pedidoDetalle.getCantidadPlatos(),new MBebidasVista(pedidoDetalle.getBebida()),pedidoDetalle.getCantidadBebidas()
        ,pedidoDetalle.getpedidoId()
        );
    }
}

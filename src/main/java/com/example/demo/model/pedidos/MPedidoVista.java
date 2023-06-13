/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.pedidos;

import com.example.demo.entity.PedidoDetalle;
import com.example.demo.entity.Pedidos;
import com.example.demo.model.pedidos_detalle.MPedidoDetalleVista;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public record MPedidoVista(
    Long pedidosId,
    
    Long usuarioId,
    
    double gastoTotal,
    
    List<PedidoDetalle> pedidoDetalle,
    
    Date createAt
        ) {
    public MPedidoVista(Pedidos pedido)
    {
        this(pedido.getPedidosId(),pedido.getUsuarioId(),pedido.getGastoTotal(),pedido.getPedidoDetalle(),pedido.getCreateAt());
    }
    
}

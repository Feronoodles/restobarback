/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.PedidoDetalle;
import com.example.demo.model.pedidos_detalle.MPedidoDetalleRegistro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author User
 */
public interface IPedidosDetalleService {
    public Page<PedidoDetalle> buscarPedidosDetalle(Pageable paginacion);
    
    public PedidoDetalle save(MPedidoDetalleRegistro pedidoDetalleRegistro);

    public PedidoDetalle mostrarPedidoDetalle(Long pedidoDetalleId);


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Pedidos;
import com.example.demo.model.pedidos.MPedidoActualizar;
import com.example.demo.model.pedidos.MPedidoRegistro;
import com.example.demo.model.pedidos.MPedidoVista;
import com.example.demo.model.pedidos_detalle.MPedidoDetalleRegistro;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author User
 */
public interface IPedidosService {
    
    public List<Pedidos> findAll();
    
    public Page<Pedidos> findAll(Pageable paginacion);
    
    public Pedidos savePedidos(MPedidoRegistro pe);
    
    public MPedidoVista actualizarPedido(MPedidoActualizar pedidoActualizar);
    
    public Page<Pedidos> getPedidosUsuarios(Pageable paginacion,String encode);
    
    public Pedidos getPedidoBySQL(Long pedidosId);


}

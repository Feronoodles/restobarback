/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.IMesaDao;
import com.example.demo.dao.IPedidosDao;
import com.example.demo.entity.Mesa;
import com.example.demo.entity.Pedidos;
import com.example.demo.model.pedidos.MPedidoActualizar;
import com.example.demo.model.pedidos.MPedidoRegistro;
import com.example.demo.model.pedidos.MPedidoVista;
import com.example.demo.model.pedidos_detalle.MPedidoDetalleVista;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
public class IPedidosServiceImpl implements IPedidosService{

   
    private IPedidosDao pedao;
    private IMesaDao mesaDao;
    public IPedidosServiceImpl(IPedidosDao pedao,IMesaDao mesaDao)
    {
        this.pedao = pedao;
        this.mesaDao = mesaDao;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Pedidos> findAll() {
        return (List<Pedidos>) pedao.findAll();
    }

    @Override
    public Pedidos savePedidos(MPedidoRegistro pe) {
        Mesa numeroMesa = mesaDao.findByNumero(pe.numeroMesa());
        Pedidos pedido = new Pedidos(pe,numeroMesa);
        
        return pedao.save(pedido);
    }

    @Override
    public List<Pedidos> getPedidosUsuarios(Long id) {
        return (List<Pedidos>) pedao.findByUsuarioId(id);
    }

    @Override
    public Pedidos getPedidoBySQL(Long pedidosId) {
        return (Pedidos) pedao.findPedidoBySQL(pedidosId);
    }

    @Override
    public Page<Pedidos> findAll(Pageable paginacion) {
        
        return (Page<Pedidos>) pedao.findAll(paginacion);
    }

    @Override
    @Transactional
    public MPedidoVista actualizarPedido(MPedidoActualizar pedidoActualizar) {
        Pedidos pedido = pedao.getReferenceById(pedidoActualizar.pedidoId());
        Mesa mesa = mesaDao.findByNumero(pedidoActualizar.numeroMesa());
        
        pedido.actualizarPedidos(pedidoActualizar, mesa);
        return new MPedidoVista(pedido);
    }
    
}

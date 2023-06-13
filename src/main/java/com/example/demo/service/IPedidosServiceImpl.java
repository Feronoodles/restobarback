/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.IPedidosDao;
import com.example.demo.entity.Pedidos;
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
    
    public IPedidosServiceImpl(IPedidosDao pedao)
    {
        this.pedao = pedao;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Pedidos> findAll() {
        return (List<Pedidos>) pedao.findAll();
    }

    @Override
    public void savePedidos(Pedidos pe) {
        pedao.save(pe);
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
    
}

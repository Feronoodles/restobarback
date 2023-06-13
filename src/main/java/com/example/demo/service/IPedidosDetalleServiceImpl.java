/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.IBebidasDao;
import com.example.demo.dao.IPedidoDetalleDao;
import com.example.demo.dao.IPlatosDao;
import com.example.demo.entity.Bebidas;
import com.example.demo.entity.PedidoDetalle;
import com.example.demo.entity.Platos;
import com.example.demo.model.pedidos_detalle.MPedidoDetalleRegistro;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class IPedidosDetalleServiceImpl implements IPedidosDetalleService{

    private IPedidoDetalleDao pedidoDetalleDao;
    private IPlatosDao platoDao;
    private IBebidasDao bebidasDao;
    
    
    public IPedidosDetalleServiceImpl(IPedidoDetalleDao pedidoDetalleDao,IPlatosDao platosDao,IBebidasDao bebidasDao)
    {
        this.pedidoDetalleDao = pedidoDetalleDao;
        this.platoDao = platosDao;
        this.bebidasDao = bebidasDao;
    }
    
    @Override
    public Page<PedidoDetalle> buscarPedidosDetalle(Pageable paginacion) {
        return (Page<PedidoDetalle>) pedidoDetalleDao.findAll(paginacion);
    }

    @Override
    public void save(MPedidoDetalleRegistro pedidoDetalleRegistro) {
        Platos plato = platoDao.findByIdSQL(pedidoDetalleRegistro.platosId());
        Bebidas bebida = bebidasDao.getReferenceById(pedidoDetalleRegistro.bebidasId());
        
        PedidoDetalle pedidoDetalle = new PedidoDetalle(pedidoDetalleRegistro,plato,bebida);
        
        pedidoDetalleDao.save(pedidoDetalle);
        
    }
    
}

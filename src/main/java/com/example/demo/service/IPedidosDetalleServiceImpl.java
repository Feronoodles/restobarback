/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.IBebidasDao;
import com.example.demo.dao.IPedidoDetalleDao;
import com.example.demo.dao.IPedidosDao;
import com.example.demo.dao.IPlatosDao;
import com.example.demo.entity.Bebidas;
import com.example.demo.entity.PedidoDetalle;
import com.example.demo.entity.Pedidos;
import com.example.demo.entity.Platos;
import com.example.demo.model.pedidos.MPedidoActualizar;
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
    
     private IPedidosService pedidoService;
    
    public IPedidosDetalleServiceImpl(IPedidoDetalleDao pedidoDetalleDao,IPlatosDao platosDao,IBebidasDao bebidasDao,IPedidosService pedidoService)
    {
        this.pedidoDetalleDao = pedidoDetalleDao;
        this.platoDao = platosDao;
        this.bebidasDao = bebidasDao;
        this.pedidoService = pedidoService;
    }
    
    @Override
    public Page<PedidoDetalle> buscarPedidosDetalle(Pageable paginacion) {
        return (Page<PedidoDetalle>) pedidoDetalleDao.findAll(paginacion);
    }

    @Override
    public PedidoDetalle save(MPedidoDetalleRegistro pedidoDetalleRegistro) {
        
        double gastoTotal = 0;
       
        Platos plato = platoDao.findByIdSQL(pedidoDetalleRegistro.platosId());
        Bebidas bebida = bebidasDao.getReferenceById(pedidoDetalleRegistro.bebidasId());
        
        System.out.println("platos "+plato);
        System.out.println("bebidas "+bebida);
        if(plato != null && bebida !=null)
        {
            if(pedidoDetalleRegistro.cantidadPlatos()>0  )
                gastoTotal += plato.getPrecio()*pedidoDetalleRegistro.cantidadPlatos();
            if(pedidoDetalleRegistro.cantidadBebidas()>0 )
                gastoTotal += bebida.getPrecio() * pedidoDetalleRegistro.cantidadBebidas();
        }
        
        
        MPedidoActualizar pedidoActualizar = new MPedidoActualizar(pedidoDetalleRegistro.pedidoId(),null,gastoTotal,-1);
        
        
        PedidoDetalle pedidoDetalle = new PedidoDetalle(pedidoDetalleRegistro,plato,bebida);
        pedidoService.actualizarPedido(pedidoActualizar);
        return pedidoDetalleDao.save(pedidoDetalle);
        
        
        
    }

    @Override
    public PedidoDetalle mostrarPedidoDetalle(Long pedidoDetalleId) {
        return pedidoDetalleDao.getReferenceById(pedidoDetalleId);
    }

}

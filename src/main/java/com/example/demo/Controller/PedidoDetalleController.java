/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.PedidoDetalle;
import com.example.demo.model.pedidos_detalle.MPedidoDetalleRegistro;
import com.example.demo.model.pedidos_detalle.MPedidoDetalleVista;
import com.example.demo.service.IPedidosDetalleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api")
public class PedidoDetalleController {
    
    private IPedidosDetalleService pedidoDetalleService;
    
    public PedidoDetalleController(IPedidosDetalleService pedidoDetalleService)
    {
        this.pedidoDetalleService = pedidoDetalleService;
    }
    
    @GetMapping("/ver_pedido_detalle")
    public ResponseEntity<Page<MPedidoDetalleVista>> mostrarPedidoDetalle(@PageableDefault(size = 10) Pageable paginacion )
    {
        return ResponseEntity.ok(pedidoDetalleService.buscarPedidosDetalle(paginacion).map(MPedidoDetalleVista::new));
    }
    
    @PostMapping("/crear_pedido_detalle")
    public ResponseEntity<Void> crearPedidoDetalle(@RequestBody MPedidoDetalleRegistro pedidoDetalleRegistro)
    {
        System.out.println("ver "+pedidoDetalleRegistro);
        pedidoDetalleService.save(pedidoDetalleRegistro);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
}

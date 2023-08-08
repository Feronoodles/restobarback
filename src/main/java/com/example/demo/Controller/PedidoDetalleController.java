/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.PedidoDetalle;

import com.example.demo.model.pedidos_detalle.MPedidoDetalleRegistro;
import com.example.demo.model.pedidos_detalle.MPedidoDetalleVista;

import com.example.demo.service.IPedidosDetalleService;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearer-key")
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
    public ResponseEntity<MPedidoDetalleVista> crearPedidoDetalle(@RequestBody @Valid MPedidoDetalleRegistro pedidoDetalleRegistro, UriComponentsBuilder uriComponentsBuilder)
    {
        PedidoDetalle pedidoDetalle = pedidoDetalleService.save(pedidoDetalleRegistro);

        MPedidoDetalleVista mPedidoDetalleVista = new MPedidoDetalleVista(pedidoDetalle);

        URI url = uriComponentsBuilder.path("/api/ver_pedido_detalle/{idPedidoDetalle}").buildAndExpand(pedidoDetalle.getPedidoDetalleId()).toUri();

        return ResponseEntity.created(url).body(mPedidoDetalleVista);

    }

    @GetMapping("/ver_pedido_detalle/{idPedidoDetalle}")
    public ResponseEntity<MPedidoDetalleVista> mostrarPedidoDetalle(@PathVariable Long idPedidoDetalle)
    {
        PedidoDetalle pedidoDetalle = pedidoDetalleService.mostrarPedidoDetalle(idPedidoDetalle);

        MPedidoDetalleVista pedidoDetalleVista = new MPedidoDetalleVista(pedidoDetalle);

        return ResponseEntity.ok(pedidoDetalleVista);
    }
    
}

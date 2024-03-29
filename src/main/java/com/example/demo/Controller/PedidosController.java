/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Pedidos;
import com.example.demo.entity.Platos;
import com.example.demo.model.pedidos.MPedidoRegistro;
import com.example.demo.model.pedidos.MPedidoVista;
import com.example.demo.model.platos.MPlatosVista;
import com.example.demo.service.IPedidosService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearer-key")
public class PedidosController {
    
  
    private IPedidosService pedidosService;

    public PedidosController( IPedidosService pedidosService)
    {
        this.pedidosService = pedidosService;

    }
    @GetMapping("/ver_pedidos")
    public ResponseEntity<Page<MPedidoVista>> mostrarPedidos(@PageableDefault(size = 10) Pageable paginacion)
    {
        return ResponseEntity.ok(pedidosService.findAll(paginacion).map(MPedidoVista::new));
    }
    
    @GetMapping("ver_pedidos_usuarios")
    public ResponseEntity<Page<MPedidoVista>> mostrarPedido(@PageableDefault(size = 10) Pageable paginacion,@RequestHeader(value = "Authorization",required = false) String encoding)
    {

        return ResponseEntity.ok(pedidosService.getPedidosUsuarios(paginacion,encoding).map(MPedidoVista::new));
    }
    
    @PostMapping("/crear_pedidos")
    public ResponseEntity<MPedidoVista> agregarPedidos(@RequestBody @Valid MPedidoRegistro pedidosRegistro, UriComponentsBuilder uriComponentsBuilder)
    {
        Pedidos pedido = pedidosService.savePedidos(pedidosRegistro);
        MPedidoVista pedidoVista = new MPedidoVista(pedido);
        
        URI url = uriComponentsBuilder.path("/api/ver_pedidos/{idPedido}").buildAndExpand(pedido.getPedidosId()).toUri();
        return ResponseEntity.created(url).body(pedidoVista);
    }
    @GetMapping("/ver_pedido/{idPedido}")
    public ResponseEntity<MPedidoVista> mostrarPedido(@PathVariable Long idPedido)
    {
        Pedidos pedido = pedidosService.getPedidoBySQL(idPedido);

        MPedidoVista platoVista = new MPedidoVista(pedido);

        return ResponseEntity.ok(platoVista);
    }
}

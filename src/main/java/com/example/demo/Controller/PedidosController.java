/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Pedidos;
import com.example.demo.model.pedidos.MPedidoRegistro;
import com.example.demo.model.pedidos.MPedidoVista;
import com.example.demo.service.IPedidosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    

    
    @PostMapping("/crear_pedidos")
    public ResponseEntity<Void> agregarPedidos(@RequestBody MPedidoRegistro pedidos)
    {
        pedidosService.savePedidos(pedidos);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @PostMapping("/pedidos_usuarios")
    public ResponseEntity<?> verPedidos(@RequestBody Pedidos pedidos)
    {
        List<Pedidos> listaPedidos = pedidosService.getPedidosUsuarios(pedidos.getUsuarioId());
        
        if(listaPedidos!=null)
        {
            if(listaPedidos.size()!=0)
            {
                return new ResponseEntity<>(listaPedidos,HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        }
            else
            {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }    
    }
    
}

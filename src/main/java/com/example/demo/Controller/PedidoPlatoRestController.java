/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Pedidos;
import com.example.demo.entity.Platos;
import com.example.demo.model.MPedidoPlatos;
import com.example.demo.service.IPedidosService;
import com.example.demo.service.IPlatosService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class PedidoPlatoRestController {
    
    @Autowired
    private IPedidosService pedidoservice;
    
    @Autowired
    private IPlatosService platoService;
    
    @PostMapping("/pedido_platos")
    public ResponseEntity<?> listaPedidoPlatos(@RequestBody Pedidos pedidos)
    {
        Pedidos pedidoDB = pedidoservice.getPedidoBySQL(pedidos.getPedidosId());
        if(pedidoDB != null){
            Collection<Platos> listaPlatos = pedidoDB.getPlatos();
            if(listaPlatos != null){
                return new ResponseEntity<>(listaPlatos,HttpStatus.OK);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/save_pedido_platos")
    public ResponseEntity<?> savePedidoPlatos(@RequestBody MPedidoPlatos mpedidoplatos)
    {
        Pedidos pedidosDB = pedidoservice.getPedidoBySQL(mpedidoplatos.getPedidos().getPedidosId());
        if( pedidosDB != null)
        {
            Platos platoDB = platoService.findPlatosByID(mpedidoplatos.getPlatos().getPlatosId());
            pedidosDB.addPedidosPlatos(platoDB);
            pedidoservice.savePedidos(pedidosDB);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    
}

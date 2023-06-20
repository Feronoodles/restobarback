/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Mesa;
import com.example.demo.model.mesa.MMesaRegistro;
import com.example.demo.model.mesa.MMesaVista;
import com.example.demo.service.IMesaService;
import java.net.URI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api")
public class MesaController {
    
    private IMesaService mesaService;
    
    public MesaController(IMesaService mesaService)
    {
        this.mesaService = mesaService;
    }
    
    @GetMapping("/ver_mesas")
    public ResponseEntity<Page<MMesaVista>> mostrarMesas(@PageableDefault(size=10)Pageable paginacion)
    {
        return ResponseEntity.ok(mesaService.mostrarMesas(paginacion).map(MMesaVista::new));
    }
    @GetMapping("/ver_mesa/{mesaId}")
    public ResponseEntity<MMesaVista> mostrarMesa(@PathVariable Long mesaId)
    {
        Mesa mesa = mesaService.mostrarMesaPorId(mesaId);
        
        MMesaVista mesaVista = new MMesaVista(mesa);
        return ResponseEntity.ok(mesaVista);
    }
    
    @PostMapping("/guardar_mesas")
    public ResponseEntity<MMesaVista> guardarMesas(@RequestBody MMesaRegistro mesaRegistro,UriComponentsBuilder uriComponentsBuilder)
    {
        Mesa mesa = mesaService.guardarMesa(mesaRegistro);
        
        MMesaVista mesaRespuesta = new MMesaVista(mesa);
        
        URI url = uriComponentsBuilder.path("/api/ver_mesa/{id}").buildAndExpand(mesa.getMesaId()).toUri();
        
        
        return ResponseEntity.created(url).body(mesaRespuesta);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Bebidas;
import com.example.demo.model.bebidas.MBebidasRegistro;
import com.example.demo.model.bebidas.MBebidasVista;
import com.example.demo.service.IBebidasService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class BebidasController {
    
    private IBebidasService bebidasServices;
    
    public BebidasController(IBebidasService bebidasServices)
    {
        this.bebidasServices = bebidasServices;
    }
    @GetMapping("/ver_bebidas")
    public ResponseEntity<Page<MBebidasVista>> mostrarBebidas(@PageableDefault(size = 10)Pageable pagination)
    {
        return ResponseEntity.ok(bebidasServices.findAll(pagination).map(MBebidasVista:: new));
    }
    @PostMapping("crear_bebida")
    @PreAuthorize("hasRole('TRABAJADOR')")
    public ResponseEntity<MBebidasVista> guardarBebida(@RequestBody MBebidasRegistro bebidaRegistro, UriComponentsBuilder uriComponentsBuilder)
    {
        Bebidas bebidas = bebidasServices.guardarBebidas(bebidaRegistro);

        MBebidasVista mBebidasVista = new MBebidasVista(bebidas);

        URI url = uriComponentsBuilder.path("/api/ver_bebida/{idBebida}").buildAndExpand(bebidas.getBebidaId()).toUri();

        return ResponseEntity.created(url).body(mBebidasVista);
    }

    @GetMapping("/ver_bebida/{idBebida}")
    public ResponseEntity<MBebidasVista> mostrarBebida(@PathVariable Long idBebida){
        Bebidas bebidas = bebidasServices.mostrarBebida(idBebida);

        MBebidasVista mBebidasVista = new MBebidasVista(bebidas);

        return ResponseEntity.ok(mBebidasVista);
    }
}

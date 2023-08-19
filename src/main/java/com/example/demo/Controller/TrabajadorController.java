/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Trabajador;
import com.example.demo.infra.security.DecodeToken;
import com.example.demo.model.trabajador.MTrabajadorVista;
import com.example.demo.model.trabajador.MUsuarioTrabajador;
import com.example.demo.service.ITrabajadorService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api")
public class TrabajadorController {
    
    
    private ITrabajadorService trabajadorService;

    
    public TrabajadorController(ITrabajadorService trabajadorService)
    {
        this.trabajadorService = trabajadorService;


    }
    
     @GetMapping("/ver_trabajadores")
     @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Page<MTrabajadorVista>> verTrabajadores(@PageableDefault( size = 10 )Pageable paginacion)
    {
        return ResponseEntity.ok(trabajadorService.findAll(paginacion).map(MTrabajadorVista::new));
    }
    @GetMapping("/ver_trabajador")
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("hasRole('TRABAJADOR')")
    public ResponseEntity<MTrabajadorVista> verTrabajador(@RequestHeader(value = "Authorization",required = false) String encoding)
    {

        Trabajador trabajador = trabajadorService.buscarTrabajador(encoding);
        MTrabajadorVista vistaTrabajador = new MTrabajadorVista(trabajador);

        return ResponseEntity.ok(vistaTrabajador);
    }
            
            
    @PostMapping("/crear_trabajador")
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("hasRole('TRABAJADOR')")
    public ResponseEntity<MTrabajadorVista> crearTrabajador(@RequestBody @Valid MUsuarioTrabajador muTrabajador,UriComponentsBuilder uriComponentsBuilder)
    {
        Trabajador trabajador = trabajadorService.save(muTrabajador);
        
        MTrabajadorVista trabajadorVista = new MTrabajadorVista(trabajador);
       
        URI url = uriComponentsBuilder.path("/api/ver_trabajador/{idTrabajador}").buildAndExpand(trabajador.getTrabajadorId()).toUri();
        
        return ResponseEntity.created(url).body(trabajadorVista);
    }
}

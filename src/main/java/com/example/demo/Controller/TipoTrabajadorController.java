/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.TipoTrabajador;
import com.example.demo.entity.TipoUsuario;
import com.example.demo.model.tipo_trabajador.MTipoTrabajadorRegistro;
import com.example.demo.model.tipo_trabajador.MTipoTrabajadorVista;
import com.example.demo.service.ITipoTrabajadorService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@SecurityRequirement(name = "bearer-key")
public class TipoTrabajadorController {
    @Autowired 
    private ITipoTrabajadorService tipoTrabajadorService;
    
    @GetMapping("/tipo_trabajador")
    @PreAuthorize("hasRole('TRABAJADOR')")
    public ResponseEntity<List<MTipoTrabajadorVista>> listaTipoTrabajador()
    {
        List<TipoTrabajador> listaTipoTrabajador = tipoTrabajadorService.findAll();
        
        return ResponseEntity.ok(listaTipoTrabajador.stream().map(MTipoTrabajadorVista::new).collect(Collectors.toList()));
    }
    
    @GetMapping("/ver_tipo_trabajador/{tipoTrabajadorId}")
    @PreAuthorize("hasRole('TRABAJADOR')")
    public ResponseEntity<MTipoTrabajadorVista> mostrarTipoTrabajador(@PathVariable Long tipoTrabajadorId)
    {
        TipoTrabajador tipoTrabajador = tipoTrabajadorService.findByTipoTrabajadorId(tipoTrabajadorId);
        
        MTipoTrabajadorVista mTipoTrabajadorVista = new MTipoTrabajadorVista(tipoTrabajador);
        return ResponseEntity.ok(mTipoTrabajadorVista);
    }
    
    @PostMapping("/crear_tipo_trabajador")
    @PreAuthorize("hasRole('TRABAJADOR')")
    public ResponseEntity<MTipoTrabajadorVista> crearTipoTrabajador(@RequestBody MTipoTrabajadorRegistro tipoTrabajadorRegistro,UriComponentsBuilder uriComponentsBuilder)
    {   
        TipoTrabajador tipoTrabajador = tipoTrabajadorService.save(tipoTrabajadorRegistro);

        MTipoTrabajadorVista tipoTrabajadorVista = new MTipoTrabajadorVista(tipoTrabajador);
        
        URI url = uriComponentsBuilder.path("/api/ver_tipo_trabajador/{id}").buildAndExpand(tipoTrabajador.getTipoTrabajadorId()).toUri();
        
        return ResponseEntity.created(url).body(tipoTrabajadorVista);
    }
}

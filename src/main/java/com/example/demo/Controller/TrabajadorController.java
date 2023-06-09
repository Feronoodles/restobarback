/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Trabajador;
import com.example.demo.model.trabajador.MTrabajadorVista;
import com.example.demo.model.trabajador.MUsuarioTrabajador;
import com.example.demo.service.ITrabajadorService;
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
public class TrabajadorController {
    
    
    private ITrabajadorService trabajadorService;
    
    public TrabajadorController(ITrabajadorService trabajadorService)
    {
        this.trabajadorService = trabajadorService;
    }
    
     @GetMapping("/ver_trabajadores")
    public ResponseEntity<Page<MTrabajadorVista>> verTrabajador(@PageableDefault( size = 10 )Pageable paginacion)
    {
        return ResponseEntity.ok(trabajadorService.findAll(paginacion).map(MTrabajadorVista::new));
    }
    
    @PostMapping("/crear_trabajador")
    public ResponseEntity<Void> crearTrabajador(@RequestBody MUsuarioTrabajador muTrabajador)
    {
        trabajadorService.save(muTrabajador);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Bebidas;
import com.example.demo.model.bebidas.MBebidasRegistro;
import com.example.demo.model.bebidas.MBebidasVista;
import com.example.demo.service.IBebidasService;
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
    public ResponseEntity<Void> guardarBebida(@RequestBody MBebidasRegistro bebidaRegistro)
    {
        bebidasServices.guardarBebidas(bebidaRegistro);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}

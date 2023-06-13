/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import java.util.List;

import com.example.demo.service.IPlatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Platos;
import com.example.demo.model.platos.MPlatosRegistro;
import com.example.demo.model.platos.MPlatosVista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api")
public class PlatosRestController {
    
    
    private IPlatosService platoService;
    
    public PlatosRestController(IPlatosService platoService)
    {
        this.platoService= platoService;
    }
    
    
    @GetMapping("/ver_platos")
    public ResponseEntity<Page<MPlatosVista>> mostrarPlatos(@PageableDefault (size = 10) Pageable paginacion)
    {
        return ResponseEntity.ok(platoService.findAll(paginacion).map(MPlatosVista::new));
    }
    
    
    @GetMapping("/platos/{index}/{size}")
    public ResponseEntity<?> listaPlatos(@PathVariable (value="index")int index,@PathVariable (value="size")int size )
    {
        System.out.println("hola fer"+index+"hola: "+size);
        List<Platos> platos = platoService.findAll(index, size);
        if(platos!=null)
        {
            if(platos.size()!=0)
            {
                return new ResponseEntity<>(platos,HttpStatus.OK);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    
    
    @PostMapping("/crear_plato")
    public ResponseEntity<?> agregarPlato(@RequestBody MPlatosRegistro platoRegistro)
    {
        
        platoService.savePlatos(platoRegistro);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    
}

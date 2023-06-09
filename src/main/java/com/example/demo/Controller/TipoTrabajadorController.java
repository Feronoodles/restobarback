/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.TipoTrabajador;
import com.example.demo.entity.TipoUsuario;
import com.example.demo.service.ITipoTrabajadorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TipoTrabajadorController {
    @Autowired 
    private ITipoTrabajadorService tipoTrabajadorService;
    
    @GetMapping("/tipo_trabajador")
    public ResponseEntity<?> listaTipoTrabajador()
    {
        List<TipoTrabajador> listaTipoTrabajador = tipoTrabajadorService.findAll();
        
        if(listaTipoTrabajador!=null)
        {
            if(listaTipoTrabajador.size()!=0)
            {
                return new ResponseEntity<>(listaTipoTrabajador,HttpStatus.OK);
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
    
    @PostMapping("/crear_tipo_trabajador")
    public ResponseEntity<Void> crearTipoTrabajador(@RequestBody TipoTrabajador tipoTrabajador)
    {
        tipoTrabajadorService.save(tipoTrabajador);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}

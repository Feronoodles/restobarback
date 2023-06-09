/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.TipoUsuario;
import com.example.demo.service.ITipoUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api")
public class TipoUsuarioController {
    @Autowired
    private ITipoUsuarioService tipoUsuarioService;
    
    @GetMapping("/tipo_usuario")
    public ResponseEntity<?> listaTipoUsuario()
    {
        List<TipoUsuario> listaTipoUsuario = tipoUsuarioService.findAll();
        
        if(listaTipoUsuario!=null)
        {
            if(listaTipoUsuario.size()!=0)
            {
                return new ResponseEntity<>(listaTipoUsuario,HttpStatus.OK);
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
    @PostMapping("/crear_tipo_usuario")
    public ResponseEntity<Void> agregarTipoUsuario(@RequestBody TipoUsuario tipousu)
    {
        tipoUsuarioService.saveTipoUsuario(tipousu);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @PostMapping("/usuarios_tipousuarios")
    public ResponseEntity<?> verUsuariosTipo(@RequestBody TipoUsuario tipoUsuario)
    {
        List<TipoUsuario> listaTipoUsuario = tipoUsuarioService.getTipoUsuarios(tipoUsuario.getTipoUsuarioId());
        
        if(listaTipoUsuario!=null)
        {
            if(listaTipoUsuario.size()!=0)
            {
                return new ResponseEntity<>(listaTipoUsuario,HttpStatus.OK);
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
    
    @PutMapping("update_tipo_usuario")
    public ResponseEntity<?> updateTipoUsuario(@RequestBody TipoUsuario tipousu)
    {
        TipoUsuario tipou = null; 
        tipou = tipoUsuarioService.findByIdTipoUsuario(tipousu.getTipoUsuarioId());
        if(tipou != null)
        {
            tipou.setNombre(tipousu.getNombre());
            tipoUsuarioService.updateTipoUsuario(tipou);
            return new ResponseEntity<>(tipou,HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
        }
        
        
    }
}

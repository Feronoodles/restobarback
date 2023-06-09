/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Usuario;
import com.example.demo.mapper.Mapper;
import com.example.demo.model.MUsuario;
import com.example.demo.service.IUsuarioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api")
public class UsuarioRestController {
    
    private IUsuarioService usuarioService;
    
  public UsuarioRestController(IUsuarioService usuarioService)
  {
      this.usuarioService = usuarioService;
  }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario)
    {
        Usuario usuariodb = usuarioService.checkUsuarioLogin(usuario);
        if(usuariodb!=null)
        {
            //Lista por que en el mapper se creo una lista 
            List<Usuario> usuarios = new ArrayList<>();
            usuarios.add(usuariodb);
            List<MUsuario> musuarios = new ArrayList<>();
            musuarios = Mapper.convertirLista(usuarios);
                    
            return new ResponseEntity<>(musuarios,HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

     @PutMapping("/update_sql")
    public ResponseEntity<?> updateUsuarioSql(@RequestBody Usuario usuario)
    {
        Usuario usudb =null;
        usudb = usuarioService.findByIdSQL(usuario.getid());
        if(usudb != null){
            usudb.setCorreo(usuario.getCorreo());
            usudb.setContraseña(usuario.getContraseña());
            usudb.setActivo(usuario.getActivo());
            usuarioService.updateUsuario(usudb);
            return new ResponseEntity<>(usudb, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        
        
    }
    
    @PutMapping("/update_activo")
    public ResponseEntity<?> updateUsuarioEstado(@RequestBody Usuario usuario)
    {
        Usuario usudb = null;
        usudb = usuarioService.findById(usuario.getid());
        if(usudb != null)
        {
            usudb.setActivo(usuario.getActivo());
            usuarioService.updateUsuario(usudb);
            return new ResponseEntity<>(usudb,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    
    
}

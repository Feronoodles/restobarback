/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.TipoTrabajador;
import com.example.demo.entity.TipoUsuario;
import com.example.demo.model.cliente.MClienteVista;
import com.example.demo.model.tipo_trabajador.MTipoTrabajadorVista;
import com.example.demo.model.tipo_usuario.MTipoUsuarioRegistro;
import com.example.demo.model.tipo_usuario.MTipoUsuarioVista;
import com.example.demo.service.ITipoUsuarioService;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearer-key")
public class TipoUsuarioController {

    private ITipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(ITipoUsuarioService tipoUsuarioService)
    {
        this.tipoUsuarioService = tipoUsuarioService;
    }
    
    @GetMapping("/tipo_usuario")
    public ResponseEntity<Page<MTipoUsuarioVista>> listaTipoUsuario(@PageableDefault(size = 10) Pageable paginacion)
    {
        Page<TipoUsuario> listaTipoUsuario = tipoUsuarioService.findAll(paginacion);
        
        
        return ResponseEntity.ok(listaTipoUsuario.map(MTipoUsuarioVista::new));
        
    }
    @PostMapping("/crear_tipo_usuario")
    public ResponseEntity<MTipoUsuarioVista> agregarTipoUsuario(@RequestBody MTipoUsuarioRegistro tipousu, UriComponentsBuilder uriComponentsBuilder)
    {


        TipoUsuario tipoUsuario = tipoUsuarioService.saveTipoUsuario(tipousu);

        MTipoUsuarioVista mTipoUsuarioVista =new MTipoUsuarioVista(tipoUsuario);
        URI url = uriComponentsBuilder.path("/api_ver_tipo_usuario/{tipoUsuarioId}").buildAndExpand(tipoUsuario.getTipoUsuarioId()).toUri();
        return ResponseEntity.created(url).body(mTipoUsuarioVista);

    }


    @GetMapping("/ver_tipo_usuario/{tipoUsuarioId}")
    public ResponseEntity<MTipoUsuarioVista> mostrarTipoUsuario(@PathVariable Long tipoTrabajadorId)
    {
        TipoUsuario tipoUsuario = tipoUsuarioService.findByIdTipoUsuario(tipoTrabajadorId);

        MTipoUsuarioVista mTipoUsuarioVista = new MTipoUsuarioVista(tipoUsuario);
        return ResponseEntity.ok(mTipoUsuarioVista);
    }
}

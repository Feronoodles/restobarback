/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Usuario;
import com.example.demo.model.cliente.MClienteVista;
import com.example.demo.model.cliente.MUsuarioCliente;
import com.example.demo.service.IClienteService;
import java.util.List;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api")
public class ClienteController {
    
    
    private IClienteService clienteService;
    
    public ClienteController(IClienteService clienteService)
    {
        this.clienteService = clienteService;
    }
    
    @GetMapping("/ver_clientes")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Page<MClienteVista>> verClientes(@PageableDefault( size = 10 )Pageable paginacion)
    {
        return ResponseEntity.ok(clienteService.findAll(paginacion).map(MClienteVista::new));
    }
    
    @PostMapping("/crear_cliente")
    public ResponseEntity<Void> crearCliente(@RequestBody @Valid MUsuarioCliente ucliente)
    {
        
        clienteService.save(ucliente);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/ver_cliente")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<MClienteVista> verCliente(@RequestHeader(value = "Authorization",required = false) String encoding)
    {
        Cliente cliente = clienteService.buscarCliente(encoding);
        MClienteVista mClienteVista = new MClienteVista(cliente);
        return ResponseEntity.ok(mClienteVista);
    }
    
}

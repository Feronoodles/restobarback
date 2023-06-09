/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Usuario;
import com.example.demo.model.cliente.MUsuarioCliente;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author User
 */
public interface IClienteService {
    public List<Cliente> findAll();
    public Page<Cliente> findAll(Pageable paginacion);
    public void save(MUsuarioCliente mucliente);
}

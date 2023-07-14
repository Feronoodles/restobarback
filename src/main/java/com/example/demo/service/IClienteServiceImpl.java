/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.IClienteDao;
import com.example.demo.dao.IUsuarioDao;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Usuario;
import com.example.demo.model.cliente.MUsuarioCliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class IClienteServiceImpl implements IClienteService{
    
    
    private IClienteDao clienteDao;
    private IUsuarioDao usuarioDao;
    private BCryptPasswordEncoder passwordEncoder;
    
    public IClienteServiceImpl(IClienteDao clienteDao,IUsuarioDao usuarioDao,BCryptPasswordEncoder passwordEncoder)
    {
        this.clienteDao = clienteDao;
        this.usuarioDao = usuarioDao;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public List<Cliente> findAll() {
        
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public void save(MUsuarioCliente mucliente) {
        
        Usuario usuario = new Usuario(mucliente, passwordEncoder.encode(mucliente.contraseña()));
        Cliente cliente = new Cliente(mucliente);
        usuarioDao.save(usuario);
        cliente.setUsuario(usuario);
        clienteDao.save(cliente);
    }

    @Override
    public Page<Cliente> findAll(Pageable paginacion) {
        return (Page<Cliente>) clienteDao.findAll(paginacion);
    }

   
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.IClienteDao;
import com.example.demo.dao.ITipoUsuarioDao;
import com.example.demo.dao.IUsuarioDao;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.TipoUsuario;
import com.example.demo.entity.Usuario;
import com.example.demo.infra.security.DecodeToken;
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
    private ITipoUsuarioDao tipoUsuarioDao;
    private BCryptPasswordEncoder passwordEncoder;
    private DecodeToken decodeToken;
    
    public IClienteServiceImpl(IClienteDao clienteDao,IUsuarioDao usuarioDao,BCryptPasswordEncoder passwordEncoder,DecodeToken decodeToken
    ,ITipoUsuarioDao tipoUsuarioDao)
    {
        this.clienteDao = clienteDao;
        this.usuarioDao = usuarioDao;
        this.passwordEncoder = passwordEncoder;
        this.decodeToken = decodeToken;
        this.tipoUsuarioDao = tipoUsuarioDao;
    }
    
    @Override
    public List<Cliente> findAll() {
        
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public void save(MUsuarioCliente mucliente) {
        TipoUsuario tipoUsuario = tipoUsuarioDao.getReferenceById(2l);
        Usuario usuario = new Usuario(mucliente,tipoUsuario, passwordEncoder.encode(mucliente.contraseña()));
        Cliente cliente = new Cliente(mucliente);
        usuarioDao.save(usuario);
        cliente.setUsuario(usuario);
        clienteDao.save(cliente);
    }

    @Override
    public Cliente buscarCliente(String encode) {
        Long usuarioId = Long.parseLong(decodeToken.decodeToken(encode)[0]);
        Usuario usuario = usuarioDao.getReferenceById(usuarioId);
        Cliente cliente = clienteDao.findByUsuario(usuario);
        //Cliente cliente = clienteDao.findByIdSQL(usuarioId);


        return cliente;
    }

    @Override
    public Page<Cliente> findAll(Pageable paginacion) {
        return (Page<Cliente>) clienteDao.findAll(paginacion);
    }

   
    
}

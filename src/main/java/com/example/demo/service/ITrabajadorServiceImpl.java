/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.ITrabajadorDao;
import com.example.demo.dao.IUsuarioDao;
import com.example.demo.entity.Trabajador;
import com.example.demo.entity.Usuario;
import com.example.demo.infra.security.DecodeToken;
import com.example.demo.model.trabajador.MUsuarioTrabajador;
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
public class ITrabajadorServiceImpl implements ITrabajadorService{

    
    private ITrabajadorDao trabajadorDao;
    private IUsuarioDao usuarioDao;
    private BCryptPasswordEncoder passwordEncoder;
    private DecodeToken decodeToken;
    public ITrabajadorServiceImpl(ITrabajadorDao trabajadorDao,IUsuarioDao usuarioDao,BCryptPasswordEncoder passwordEncoder,DecodeToken decodeToken)
    {
        this.trabajadorDao = trabajadorDao;
        this.usuarioDao = usuarioDao;
        this.passwordEncoder = passwordEncoder;
        this.decodeToken = decodeToken;
    }
    
    @Override
    public List<Trabajador> findAll() {
        return (List<Trabajador>) trabajadorDao.findAll();
    }

    @Override
    public Trabajador save(MUsuarioTrabajador muTrabajador) {
        Usuario usuario = new Usuario(muTrabajador, passwordEncoder.encode(muTrabajador.contraseña()));
        Trabajador trabajador = new Trabajador(muTrabajador, usuario);
        trabajadorDao.save(trabajador);
        usuarioDao.save(usuario);
        return trabajador;
        
    }

    @Override
    public Page<Trabajador> findAll(Pageable paginacion) {
        
        return (Page<Trabajador>) trabajadorDao.findAll(paginacion);
    }

    @Override
    public Trabajador buscarTrabajador(String encoding) {
        String buscarId = encoding.replace("Bearer ","");
        Long usuarioId = Long.parseLong(decodeToken.decodeToken(buscarId)[0]);

        return trabajadorDao.findByIdSQL(usuarioId);
    }
    
}

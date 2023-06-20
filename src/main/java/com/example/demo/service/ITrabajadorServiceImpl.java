/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.ITrabajadorDao;
import com.example.demo.dao.IUsuarioDao;
import com.example.demo.entity.Trabajador;
import com.example.demo.entity.Usuario;
import com.example.demo.model.trabajador.MUsuarioTrabajador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class ITrabajadorServiceImpl implements ITrabajadorService{

    
    private ITrabajadorDao trabajadorDao;
    private IUsuarioDao usuarioDao;
    public ITrabajadorServiceImpl(ITrabajadorDao trabajadorDao,IUsuarioDao usuarioDao)
    {
        this.trabajadorDao = trabajadorDao;
        this.usuarioDao = usuarioDao;
    }
    
    @Override
    public List<Trabajador> findAll() {
        return (List<Trabajador>) trabajadorDao.findAll();
    }

    @Override
    public void save(MUsuarioTrabajador muTrabajador) {
        Usuario usuario = new Usuario(muTrabajador);
        Trabajador trabajador = new Trabajador(muTrabajador, usuario);
        trabajadorDao.save(trabajador);
        usuarioDao.save(usuario);
        
    }

    @Override
    public Page<Trabajador> findAll(Pageable paginacion) {
        
        return (Page<Trabajador>) trabajadorDao.findAll(paginacion);
    }
    
}

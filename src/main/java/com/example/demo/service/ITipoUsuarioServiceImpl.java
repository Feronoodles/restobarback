/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.ITipoUsuarioDao;
import com.example.demo.entity.TipoUsuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
public class ITipoUsuarioServiceImpl implements ITipoUsuarioService{

    @Autowired
    private ITipoUsuarioDao tipoUsuarioDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoUsuario> findAll() {
        return (List<TipoUsuario>)tipoUsuarioDao.findAll();
    }

    @Override
    public void saveTipoUsuario(TipoUsuario tusuario) {
        tipoUsuarioDao.save(tusuario);
    }

    @Override
    public List<TipoUsuario> getTipoUsuarios(Long id) {
        
        return (List<TipoUsuario>) tipoUsuarioDao.findByTipoUsuarioId(id);

    }

    @Override
    public TipoUsuario updateTipoUsuario(TipoUsuario tusuario) {
       return (TipoUsuario) tipoUsuarioDao.save(tusuario);
    }

    @Override
    @Transactional(readOnly = true)
    public TipoUsuario findByIdTipoUsuario(Long id) {
        return (TipoUsuario) tipoUsuarioDao.findById(id).orElse(null);
    }
    
}

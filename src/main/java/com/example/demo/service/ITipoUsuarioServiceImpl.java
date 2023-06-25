/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.ITipoUsuarioDao;
import com.example.demo.entity.TipoUsuario;
import com.example.demo.model.tipo_usuario.MTipoUsuarioRegistro;
import com.example.demo.model.tipo_usuario.MTipoUsuarioVista;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<TipoUsuario> findAll( Pageable paginacion) {
        return (Page<TipoUsuario>)tipoUsuarioDao.findAll(paginacion);
    }

    @Override
    public void saveTipoUsuario(MTipoUsuarioRegistro tusuario) {
        TipoUsuario tipoUsuario = new TipoUsuario(tusuario);
        
        tipoUsuarioDao.save(tipoUsuario);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.ITipoTrabajadorDao;
import com.example.demo.entity.TipoTrabajador;
import com.example.demo.model.tipo_trabajador.MTipoTrabajadorRegistro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
public class ITipoTrabajadorServiceImpl implements ITipoTrabajadorService{

    @Autowired
    private ITipoTrabajadorDao tipoTrabajadorDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoTrabajador> findAll() {
        
        return (List<TipoTrabajador>) tipoTrabajadorDao.findAll();
    }

    @Override
    public TipoTrabajador save(MTipoTrabajadorRegistro tipoTrabajadorRegistro) {
        TipoTrabajador tipoTrabajador = new TipoTrabajador(tipoTrabajadorRegistro);
        return tipoTrabajadorDao.save(tipoTrabajador);
    }

    @Override
    public TipoTrabajador findByTipoTrabajadorId(Long tipoTrabajadorId) {
        return tipoTrabajadorDao.getReferenceById(tipoTrabajadorId);
    }
    
}

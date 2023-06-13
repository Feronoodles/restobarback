/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.IPlatosDao;
import com.example.demo.entity.Platos;
import com.example.demo.model.platos.MPlatosRegistro;
import java.util.List;
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
public class IPlatosServiceImpl implements IPlatosService{
    
    @Autowired
    private IPlatosDao platosDao;
    
    public IPlatosServiceImpl(IPlatosDao platosDao)
    {
        this.platosDao = platosDao;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Platos> findAll(int index,int size) {
        return (List<Platos>)platosDao.findPlatosByPagination(index, size);
    }

    @Override
    @Transactional
    public void savePlatos(MPlatosRegistro platosRegistro) {
        Platos plato = new Platos(platosRegistro);
        
        platosDao.save(plato);
    }

    @Override
    public Platos findPlatosByID(Long platosId) {
        return platosDao.findByIdSQL(platosId);
    }

    @Override
    public Page<Platos> findAll(Pageable paginacion) {
        return (Page<Platos>)platosDao.findAll(paginacion);
    }
    
}

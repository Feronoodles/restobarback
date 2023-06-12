/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.IBebidasDao;
import com.example.demo.entity.Bebidas;
import com.example.demo.model.bebidas.MBebidasRegistro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class IBebidasServiceImpl implements IBebidasService{

    public IBebidasDao bebidasDao;
    
    public IBebidasServiceImpl(IBebidasDao bebidasDao) {
        this.bebidasDao = bebidasDao;
    }

    
    
    @Override
    public Page<Bebidas> findAll(Pageable paginacion) {
        
        return (Page<Bebidas>) bebidasDao.findAll(paginacion);
    }

    @Override
    public void guardarBebidas(MBebidasRegistro bebidaRegistro) {
        Bebidas bebida = new Bebidas(bebidaRegistro);
        bebidasDao.save(bebida);
    }
    
    
}

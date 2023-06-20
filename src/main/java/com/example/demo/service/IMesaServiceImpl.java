/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.IMesaDao;
import com.example.demo.entity.Mesa;
import com.example.demo.model.mesa.MMesaRegistro;
import com.example.demo.model.mesa.MMesaVista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class IMesaServiceImpl implements IMesaService{

    private IMesaDao mesaDao;
    
    public IMesaServiceImpl(IMesaDao mesaDao)
    {
        this.mesaDao = mesaDao;
    }
    @Override
    public Mesa buscarMesaPorNumero(int numero) {
        return this.mesaDao.findByNumero(numero);
    }

    @Override
    public Mesa guardarMesa(MMesaRegistro mesa) {
        return this.mesaDao.save(new Mesa(mesa));
    }

    @Override
    public Page<Mesa> mostrarMesas(Pageable paginacion) {
        return (Page<Mesa>)this.mesaDao.findAll(paginacion);
    }

    @Override
    public Mesa mostrarMesaPorId(Long mesaId) {
        return this.mesaDao.getReferenceById(mesaId);
    }
    
}

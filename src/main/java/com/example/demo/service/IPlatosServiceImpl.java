/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.IPlatosDao;
import com.example.demo.entity.Platos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Override
    @Transactional(readOnly = true)
    public List<Platos> findAll(int index,int size) {
        return (List<Platos>)platosDao.findPlatosByPagination(index, size);
    }

    @Override
    @Transactional
    public void savePlatos(Platos platos) {
        platosDao.save(platos);
    }

    @Override
    public Platos findPlatosByID(Long platosId) {
        return platosDao.findByIdSQL(platosId);
    }
    
}

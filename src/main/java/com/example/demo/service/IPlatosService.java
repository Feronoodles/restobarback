/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Platos;
import com.example.demo.model.platos.MPlatosRegistro;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author User
 */
public interface IPlatosService {
    public List<Platos> findAll(int index,int size);
    
    public Page<Platos> findAll(Pageable paginacion);
    
    public void savePlatos(MPlatosRegistro platosRegistro);
    
    public Platos findPlatosByID(Long platosId);
}

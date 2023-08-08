/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Bebidas;
import com.example.demo.model.bebidas.MBebidasRegistro;
import com.example.demo.model.bebidas.MBebidasVista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 *
 * @author User
 */
public interface IBebidasService {
    public Page<Bebidas> findAll(Pageable paginacion);
    
    public Bebidas guardarBebidas(MBebidasRegistro bebida);

    public Bebidas mostrarBebida(Long bebidasId);
}

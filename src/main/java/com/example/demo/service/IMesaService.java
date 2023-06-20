/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Mesa;
import com.example.demo.model.mesa.MMesaRegistro;
import com.example.demo.model.mesa.MMesaVista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author User
 */
public interface IMesaService {
    public Mesa buscarMesaPorNumero(int numero);
    
    public Mesa guardarMesa(MMesaRegistro mesa);
    
    public Page<Mesa> mostrarMesas(Pageable paginacion);
    
    public Mesa mostrarMesaPorId(Long mesaId);
    
}

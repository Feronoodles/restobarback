/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Platos;
import java.util.List;

/**
 *
 * @author User
 */
public interface IPlatosService {
    public List<Platos> findAll(int index,int size);
    
    public void savePlatos(Platos platos);
    
    public Platos findPlatosByID(Long platosId);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface IMesaDao extends JpaRepository<Mesa, Long>{
    public Mesa findByNumero(int numero);
}

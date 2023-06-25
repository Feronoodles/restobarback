/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.entity.Platos;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author User
 */
public interface IPlatosDao extends JpaRepository<Platos, Long>{
    @Query("select p from Platos p where p.platosId=?1")
    public Platos findByIdSQL(Long platosId);
    
    @Procedure("buscar_platos")
    public List<Platos> findPlatosByPagination(@Param("index")int index,@Param("size")int size);
    
    public Page<Platos> findAll(Pageable paginacion);
    
    
}

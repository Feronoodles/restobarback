/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dao.IUsuarioDao;
import com.example.demo.entity.Usuario;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.usuario.MUsuarioActualizar;
import com.example.demo.model.usuario.MUsuarioVista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
public class IUsuarioServiceImpl implements IUsuarioService{

    
    
    private IUsuarioDao usuariodao;

    public IUsuarioServiceImpl(IUsuarioDao usuariodao) {
        this.usuariodao = usuariodao;
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public List<Usuario> findAll() {
        
        return (List<Usuario>) usuariodao.findAll();
    }
 

    @Override
    @Transactional
    public Usuario updateUsuario(Usuario usuario) {
        return (Usuario) usuariodao.save(usuario);
    }

    @Override
    @Transactional
    public MUsuarioVista actualizarUsuario(MUsuarioActualizar actualizarusuario) {
        Usuario usuario = usuariodao.getReferenceById(actualizarusuario.usuarioId());

        usuario.actualizarUsuario(actualizarusuario);

        return new MUsuarioVista(usuario);
    }


    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        
        return usuariodao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByIdSQL(Long id) {
         
      return usuariodao.findByIdSQL(id);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuariodao.save(usuario);
    }

   


    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import com.example.demo.entity.Usuario;

/**
 *
 * @author User
 */
public class MUsuario {
    
    private Long id;
    private String correo;
    private String token;
    private String tokenCelular;
    private Long tipoUsuarioId;

    public MUsuario()
    {
        
    }
    
    public MUsuario(Long id, String email, String token, String tokenCelular, Long tipoUsuarioId) {
        super();
        this.id = id;
        this.correo = email;
        this.token = token;
        this.tokenCelular = tokenCelular;
        this.tipoUsuarioId = tipoUsuarioId;
    }
    public MUsuario(Usuario usuario)
    {
        this.id = usuario.getid();
        this.correo = usuario.getCorreo();
        this.token = usuario.getToken();
        this.tokenCelular = usuario.getTokenCelular();
        this.tipoUsuarioId = usuario.getTipoUsuario().getTipoUsuarioId();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenCelular() {
        return tokenCelular;
    }

    public void setTokenCelular(String tokenCelular) {
        this.tokenCelular = tokenCelular;
    }

    public Long getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Long tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }
    
}

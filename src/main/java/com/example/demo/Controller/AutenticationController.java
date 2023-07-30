/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Usuario;
import com.example.demo.infra.security.DatosJWTToken;
import com.example.demo.infra.security.DecodeToken;
import com.example.demo.infra.security.TokenService;
import com.example.demo.model.usuario.DatosAutenticacionUsuario;
import javax.validation.Valid;

import com.example.demo.model.usuario.MUsuarioActualizar;
import com.example.demo.service.IUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;


@RestController
@RequestMapping("/login")
public class AutenticationController {
    public AuthenticationManager authenticationManager;
    private TokenService tokenService;

    private IUsuarioService usuarioService;
    private DecodeToken decodeToken;


    public AutenticationController(AuthenticationManager authenticationManager,TokenService tokenService,IUsuarioService usuarioService,DecodeToken decodeToken)
    {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.usuarioService = usuarioService;
        this.decodeToken = decodeToken;
    }

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        //revisar de donde  se trae este authentication
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.email(),
                datosAutenticacionUsuario.contraseña());
        authenticationManager.authenticate(authToken);

        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());



        String usuarioId = decodeToken.decodeToken(JWTtoken)[0];

        Usuario usuario = usuarioService.findById(Long.parseLong(usuarioId));

        MUsuarioActualizar mUsuarioActualizar = new MUsuarioActualizar(usuario.getid(),null,null,-1,JWTtoken,null);
        this.usuarioService.actualizarUsuario(mUsuarioActualizar);
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.infra.security;

import com.example.demo.dao.IUsuarioDao;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author User
 */
@Component
public class SecurityFilter extends OncePerRequestFilter{

    private TokenService tokenService;
    private IUsuarioDao usuarioDao;
    
    
    public SecurityFilter(TokenService tokenService,IUsuarioDao usuarioDao){
        this.tokenService = tokenService;
        this.usuarioDao = usuarioDao;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //obtener el token del header
        var authHeader = request.getHeader("Authorization");

        System.out.println("ver verarer "+authHeader);
        if(authHeader!=null){
            var token = authHeader.replace("Bearer ","");
            System.out.println(token);
            System.out.println("sesion "+tokenService.getSubject(token));
            var nombreEmail = tokenService.getSubject(token);
            if(nombreEmail!=null)
            {
                var usuario = usuarioDao.findByCorreo(nombreEmail);
                var authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());//forzamos el inicio de sesion

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request,response);
    }
    
}

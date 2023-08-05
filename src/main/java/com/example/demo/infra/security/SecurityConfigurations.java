/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


 
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurations {
    public SecurityFilter securityFilter;
    
      
    public SecurityConfigurations(SecurityFilter securityFilter)
    {
        this.securityFilter = securityFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        return httpSecurity.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//le indicamos que sea el tipo de session que queremos
                .and().authorizeHttpRequests((requests)->requests
                .requestMatchers(new AntPathRequestMatcher("/login"))
                .permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/crear_cliente"))
                .permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/crear_trabajador"))
                .permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/crear_tipo_usuario"))
                .permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/crear_tipo_trabajador"))
                .permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**"))
                                .permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/**"))
                        .permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/swagger-ui.html"))
                                .permitAll()

                .anyRequest()
                .authenticated()
                .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                )
                
                
                .build();
    }

    private static final String[] AUTH_WHITELIST = {
            "/api/v1/auth/**",
            "/v3/api-docs/**",
            "/v3/api-docs.yaml",
            "/swagger-ui/**",
            "/swagger-ui.html"
    };
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    {
            return authenticationConfiguration.getAuthenticationManager();


    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
}

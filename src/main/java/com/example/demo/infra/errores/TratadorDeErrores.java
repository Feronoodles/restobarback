/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.infra.errores;

import java.sql.SQLIntegrityConstraintViolationException;
import javax.persistence.EntityNotFoundException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author User
 */
@RestControllerAdvice
public class TratadorDeErrores {
     @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratasError404(){ return ResponseEntity.notFound().build(); }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratasError400(MethodArgumentNotValidException e){
        var errores= e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }
    @ExceptionHandler(PropertyReferenceException.class)
    public ResponseEntity errorSort400(PropertyReferenceException e)
    {

        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity prueba(SQLIntegrityConstraintViolationException e)
    {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    private record DatosErrorValidacion(String campo,String error){
        public DatosErrorValidacion(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}

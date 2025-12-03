package com.cupons.handlers;

import com.cupons.models.ErroResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> tratarMethodArgumentNotValid(MethodArgumentNotValidException ex){
        String msg = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse("Requisição inválida.");
        ErroResponse r = new ErroResponse();
        r.setErro(msg);
        return ResponseEntity.status(400).body(r);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErroResponse> tratarConstraintViolation(ConstraintViolationException ex){
        String msg = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .findFirst()
                .orElse("Requisição inválida.");
        ErroResponse r = new ErroResponse();
        r.setErro(msg);
        return ResponseEntity.status(400).body(r);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErroResponse> tratarBind(BindException ex){
        String msg = ex.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse("Requisição inválida.");
        ErroResponse r = new ErroResponse();
        r.setErro(msg);
        return ResponseEntity.status(400).body(r);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResponse> tratarJsonInvalido(HttpMessageNotReadableException ex){
        ErroResponse r = new ErroResponse();
        r.setErro("Requisição inválida.");
        return ResponseEntity.status(400).body(r);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroResponse> tratarRuntime(RuntimeException ex){
        String msg = ex.getMessage() != null ? ex.getMessage() : "Erro";
        ErroResponse r = new ErroResponse();
        r.setErro(msg);
        return ResponseEntity.status(400).body(r);
    }
}

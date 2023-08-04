package com.apicomspringboot.apispringboot.controle;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controle {



    @GetMapping("")
    public String mensagem(){
        return "Hello World";
    }
     @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Seja bem vindo(a) ";
    }
    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja bem vindo(a) " +  nome;
    }
    @GetMapping("/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
  
    
}

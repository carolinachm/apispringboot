package com.apicomspringboot.apispringboot.controle;

import com.apicomspringboot.apispringboot.modelo.Pessoa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa pessoa){
        return pessoa;

    }
    
    
}

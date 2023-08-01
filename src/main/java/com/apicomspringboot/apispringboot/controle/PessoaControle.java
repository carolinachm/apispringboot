package com.apicomspringboot.apispringboot.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apicomspringboot.apispringboot.modelo.Pessoa;
import com.apicomspringboot.apispringboot.repositorio.PessoaRepositorio;

@RestController
public class PessoaControle {

    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    @PostMapping("/api/pessoa")
    public Pessoa cadastraPessoa(@RequestBody Pessoa pessoa){
        return pessoaRepositorio.save(pessoa);
    }
    @GetMapping("/api/pessoa")
    public List<Pessoa> buscarTodasPessoas(){
        return pessoaRepositorio.findAll();
    }
     @GetMapping("/api/{codigo}")
    public Pessoa buscarPessoaCodigo(@PathVariable Long codigo){
        return pessoaRepositorio.findByCodigo(codigo);
    }
    
}

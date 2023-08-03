package com.apicomspringboot.apispringboot.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apicomspringboot.apispringboot.modelo.Pessoa;
import com.apicomspringboot.apispringboot.repositorio.PessoaRepositorio;

@RestController
public class PessoaControle {

    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    @PostMapping("/api/pessoa")
    public Pessoa cadastraPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepositorio.save(pessoa);
    }

    @GetMapping("/api/pessoa")
    public List<Pessoa> buscarTodasPessoas() {
        return pessoaRepositorio.findAll();
    }

    @GetMapping("/api/{codigo}")
    public Pessoa buscarPessoaCodigo(@PathVariable Long codigo) {
        return pessoaRepositorio.findByCodigo(codigo);
    }

    @GetMapping("/api/contador")
    public long contador() {
        return pessoaRepositorio.count();
    }

    @GetMapping("/api/ordenarPorNome")
    public List<Pessoa> ordernarPorNome() {
        return pessoaRepositorio.findByOrderByNome();
    }

    @GetMapping("/api/ordenarPorNomeDesc")
    public List<Pessoa> ordernarPorNomeDesc() {
        return pessoaRepositorio.findByOrderByNomeDesc();
    }

    @GetMapping("/api/nomeContem")
    public List<Pessoa> nomeContem() {
        return pessoaRepositorio.findByNomeContaining("T");
    }

    @GetMapping("/api/iniciaCom")
    public List<Pessoa> iniciaCom() {
        return pessoaRepositorio.findByNomeStartsWith("A");
    }

    @GetMapping("/api/terminaCom")
    public List<Pessoa> terminaCom() {
        return pessoaRepositorio.findByNomeEndsWith("1");
    }
    @GetMapping("/api/somaIdades")
    public int somaIdades(){
        return pessoaRepositorio.somaIdades();
    }

    @GetMapping("/api/idadeMaiorIgual")
    public List<Pessoa> idadeMaiorIgual(){
        return pessoaRepositorio.idadeMaiorIgual(18);
    }
    
    @PutMapping("/api")
    public Pessoa editarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepositorio.save(pessoa);
    }

    @DeleteMapping("/api/{codigo}")
    public void excluirPessoa(@PathVariable Long codigo) {
        Pessoa pessoa = buscarPessoaCodigo(codigo);
        pessoaRepositorio.delete(pessoa);
    }
}

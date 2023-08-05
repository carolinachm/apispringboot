package com.apicomspringboot.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.apicomspringboot.api.modelo.Pessoa;
import com.apicomspringboot.api.repositorio.PessoaRepositorio;
import com.apicomspringboot.api.util.Mensagem;

@Service
public class PessoaServico {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    // Metodo para cadastra pessoa
    public ResponseEntity<?> cadastraPessoa(Pessoa pessoa) {

        if (pessoa.getNome().equals("")) {
            mensagem.setMensagem("O campo nome é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (pessoa.getIdade() < 0) {
            mensagem.setMensagem("Informe uma idade valida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {

            return new ResponseEntity<>(pessoaRepositorio.save(pessoa), HttpStatus.CREATED);
        }
    }

    // Metodo para selecionar pessoas
    public ResponseEntity<?> buscarTodasPessoas() {
        return new ResponseEntity<>(pessoaRepositorio.findAll(), HttpStatus.OK);
    }

    // Metodo para editar pessoa
    public ResponseEntity<?> editarPessoa(Pessoa pessoa) {
        
        if (pessoaRepositorio.countByCodigo(pessoa.getCodigo()) == 0) {
            mensagem.setMensagem("O codigo não exite");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if (pessoa.getNome().equals("")) {
            mensagem.setMensagem("O campo nome é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (pessoa.getIdade() < 0) {
            mensagem.setMensagem("Informe uma idade valida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {

            return new ResponseEntity<>(pessoaRepositorio.save(pessoa), HttpStatus.OK);
        }
    }

    // Metodo para excluir pessoa
    public ResponseEntity<?> excluirPessoa(Long codigo) {
        
        if (pessoaRepositorio.countByCodigo(codigo) == 0) {
            mensagem.setMensagem("O codigo não exite");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else {
            Pessoa pessoa = pessoaRepositorio.findByCodigo(codigo);
            pessoaRepositorio.delete(pessoa);

            mensagem.setMensagem("Pessoa excluida com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}
package com.apicomspringboot.apispringboot.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.apicomspringboot.apispringboot.modelo.Pessoa;

public interface PessoaRepositorio extends CrudRepository<Pessoa, Long>{

    List<Pessoa> findAll();

    Pessoa findByCodigo(Long codigo);
    
}

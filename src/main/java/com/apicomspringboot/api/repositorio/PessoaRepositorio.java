package com.apicomspringboot.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.apicomspringboot.api.modelo.Pessoa;

public interface PessoaRepositorio extends CrudRepository<Pessoa, Long>{

    List<Pessoa> findAll();

    Pessoa findByCodigo(Long codigo);

    @Query("SELECT count(*) from Pessoa where codigo=:codigo")
    Long countByCodigo(@Param("codigo") Long codigo);

    List<Pessoa> findByOrderByNome();

    List<Pessoa> findByOrderByNomeDesc();

    List<Pessoa> findByNomeContaining(String termo);
    
    List<Pessoa> findByNomeStartsWith(String termo);

    List<Pessoa> findByNomeEndsWith(String termo);

    @Query(value = "SELECT SUM(idade) FROM tb_pessoas", nativeQuery = true)
    int somaIdades();

    @Query(value = "SELECT * FROM tb_pessoas WHERE idade >= :idade", nativeQuery =  true)
    List<Pessoa> idadeMaiorIgual(int idade);

    
}

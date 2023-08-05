package com.apicomspringboot.api.util;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data
public class Mensagem {

    private String mensagem;

    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }
    
}

package com.apicomspringboot.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicomspringboot.api.util.Mensagem;

@Service
public class Servico {
    @Autowired
    private Mensagem mensagem;
    
}

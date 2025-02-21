package com.henrique_brendon.cadastro_jogadores.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.henrique_brendon.cadastro_jogadores.services.JogadorService;


@Controller
@RequestMapping("listagem-jogadores")
public class ListarJogadoresController {
    
    private final JogadorService jogadorService;

    public ListarJogadoresController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }
    
    @GetMapping
    public String listagemJogadores(Model model) {
        model.addAttribute("jogadores", jogadorService.listarJogadores());
        return "listagem_jogadores";
    }
    
}

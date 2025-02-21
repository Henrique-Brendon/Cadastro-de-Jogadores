package com.henrique_brendon.cadastro_jogadores.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.henrique_brendon.cadastro_jogadores.entities.Jogador;
import com.henrique_brendon.cadastro_jogadores.entities.enums.GrupoCodinome;
import com.henrique_brendon.cadastro_jogadores.services.JogadorService;


@Controller
@RequestMapping("cadastro-jogador")
public class CadastroJogadorController {
    
    private final JogadorService  jogadorService;

    public CadastroJogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public String paginaCadastroJogador(Model model) {
        model.addAttribute("jogador", new Jogador(null, null, null, null, null));
        model.addAttribute("gruposCodinomes", GrupoCodinome.values());
        return "cadastro_jogador";
    }

    @PostMapping
    public String cadastroJogador(@ModelAttribute Jogador jogador) {
        try {
            jogadorService.registrarJogador(jogador);
            return "redirect:/cadastro-jogador";
        } catch(Exception e) {
            return "redirect:/cadastro-jogador";
        }
    }
}

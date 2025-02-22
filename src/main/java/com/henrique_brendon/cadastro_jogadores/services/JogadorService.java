package com.henrique_brendon.cadastro_jogadores.services;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.henrique_brendon.cadastro_jogadores.entities.Jogador;
import com.henrique_brendon.cadastro_jogadores.entities.enums.GrupoCodinome;
import com.henrique_brendon.cadastro_jogadores.repositories.JogadorRepository;

@Service
public class JogadorService {
    
    private final JogadorRepository jogadorRepository;
    private final CodinomeService codinomeService;

    public JogadorService(JogadorRepository jogadorRepository, CodinomeService codinomeService) {
        this.jogadorRepository = jogadorRepository;
        this.codinomeService = codinomeService;
    }

    @CacheEvict(value = "jogadores", allEntries = true)
    public Jogador registrarJogador(Jogador jogador) throws Exception {
        var codinomesEmUso = listarCodinomesEmUso(jogador.grupoCodinome());
        var novoCodinome = codinomeService.gerarCodinome(jogador.grupoCodinome(), codinomesEmUso);
        
        var novoJogador = new Jogador(jogador.nome(), jogador.email(), jogador.telefone(), novoCodinome, jogador.grupoCodinome());
        return jogadorRepository.salvar(novoJogador);
    }

    @Cacheable(value = "jogadores")
    public List<Jogador> listarJogadores() {
        return jogadorRepository.listarJogadores();
    }

    
    private List<String> listarCodinomesEmUso(GrupoCodinome grupoCodinome) {
        return jogadorRepository.listarCodinomesPorGrupo(grupoCodinome);
    }
    
}

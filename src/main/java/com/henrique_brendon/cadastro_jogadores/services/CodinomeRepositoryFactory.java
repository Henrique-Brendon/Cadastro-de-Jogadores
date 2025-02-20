package com.henrique_brendon.cadastro_jogadores.services;

import org.springframework.stereotype.Component;

import com.henrique_brendon.cadastro_jogadores.entities.enums.GrupoCodinome;
import com.henrique_brendon.cadastro_jogadores.repositories.CodinomeRepository;
import com.henrique_brendon.cadastro_jogadores.repositories.LigaDaJustiçaRepository;
import com.henrique_brendon.cadastro_jogadores.repositories.VingadoresRepository;

@Component
public class CodinomeRepositoryFactory {
    
    private final LigaDaJustiçaRepository ligaDaJustiçaRepository;
    private final VingadoresRepository vingadoresRepository;

    public CodinomeRepositoryFactory(LigaDaJustiçaRepository ligaDaJustiçaRepository,
            VingadoresRepository vingadoresRepository) {
        this.ligaDaJustiçaRepository = ligaDaJustiçaRepository;
        this.vingadoresRepository = vingadoresRepository;
    }

    public CodinomeRepository create(GrupoCodinome grupoCodinome) {
        return switch (grupoCodinome) {
            case LIGA_DA_JUSTICA -> ligaDaJustiçaRepository;
            case VINGADORES -> vingadoresRepository;
        };
    }
    
}

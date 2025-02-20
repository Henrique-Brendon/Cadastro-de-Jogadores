package com.henrique_brendon.cadastro_jogadores.entities;

import com.henrique_brendon.cadastro_jogadores.entities.enums.GrupoCodinome;

public record Jogador(
    String nome,
    String email,
    String telefone,
    String codinome,
    GrupoCodinome grupoCodinome
) {
    
}
